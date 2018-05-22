package pl.wnukedwarda.client;

import pl.wnukedwarda.car.Car;
import pl.wnukedwarda.car.CarBuilder;
import pl.wnukedwarda.db.ConnectionProvider;
import pl.wnukedwarda.db.JdbcService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientReader extends JdbcService {

    private Scanner scanner;
    private ClientBuilder clientBuilder;
    private Client client;
    private boolean tryAgain;

    public ClientReader(ConnectionProvider connectionProvider, Scanner scanner) {
        super(connectionProvider);
        this.scanner = scanner;
    }

    public void addNewClient() {
        do {
            try {
                System.out.println("Enter Client Data:");
                System.out.println("Username:");
                String username = scanner.nextLine();
                System.out.println("First Name:");
                String firstName = scanner.nextLine();
                System.out.println("Last Name:");
                String lastName = scanner.nextLine();
                System.out.println("Password");
                String password = scanner.nextLine();
                System.out.println("Email:");
                String email = scanner.nextLine();
                System.out.println("City");
                String city = scanner.nextLine();
                System.out.println("Contact");
                String contact = scanner.nextLine();
                client = new ClientBuilder()
                        .setClientId(lastClient().getClientId() + 1)
                        .setUsername(username)
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setPassword(password)
                        .setEmail(email)
                        .setCity(city)
                        .setContact(contact)
                        .build();
                saveNewClient(client);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                tryAgain = true;
            }
        } while (tryAgain);
    }

    private void saveNewClient(Client client) {
        doWtihConnection(connection -> {
            String insert = "INSERT INTO customers(client_id, username, first_name, last_name, password, email, city, contact)" +
                    " values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, client.getClientId());
            ps.setString(2, client.getUsername());
            ps.setString(3, client.getFirstName());
            ps.setString(4, client.getLastName());
            ps.setString(5, client.getPassword());
            ps.setString(6, client.getEmail());
            ps.setString(7, client.getCity());
            ps.setString(8, client.getContact());
            ps.executeUpdate();
            connection.close();
        });
    }

    public void delete(int id) {
        doWtihConnection(connection -> {
            String delete = "DELETE FROM customers WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, id);
            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("Error");
            } else {
                System.out.println("Success");
            }
            connection.close();
        });
    }

    public boolean validate(String username, String password) {
        AtomicBoolean result = new AtomicBoolean(false);
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM customers " +
                    "WHERE username =? AND password =?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            result.set(rs.next());
        });
        return result.get();
    }

    private Client lastClient() throws SQLException {
        doWtihConnection(connection -> {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM customers");
            ResultSet rs = ps.executeQuery();

            if (rs.last()) {
                client = new ClientBuilder()
                        .setClientId(rs.getInt(1))
                        .setUsername(rs.getString(2))
                        .setFirstName(rs.getString(3))
                        .setLastName(rs.getString(4))
                        .setPassword(rs.getString(5))
                        .setEmail(rs.getString(6))
                        .setCity(rs.getString(7))
                        .setContact(rs.getString(8))
                        .build();
            }
        });
        return client;
    }

}
