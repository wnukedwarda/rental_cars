package pl.wnukedwarda.client;

import pl.wnukedwarda.db.ConnectionProvider;
import pl.wnukedwarda.db.JdbcService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDisplay extends JdbcService {

    public ClientDisplay(ConnectionProvider connectionProvider) {
        super(connectionProvider);
    }

    public void viewAll() {
        doWtihConnection(connection -> {
            ResultSet rs = connection.createStatement()
                    .executeQuery("SELECT * FROM customers ORDER BY client_id");

            while (rs.next()) {
                printClient(rs);
            }
        });
    }

    public void printClient(ResultSet rs) throws SQLException {
        System.out.println("Client ID: " + rs.getInt(
                1) +
                " Username: " + rs.getString(2) +
                " First Name: " + rs.getString(3) +
                " Last Name: " + rs.getString(4) +
                " Email: " + rs.getString(6) +
                " City: " + rs.getString(7) +
                " Contact: " + rs.getString(8));
    }
}

