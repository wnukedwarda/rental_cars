package pl.wnukedwarda.client;

public class Client {
    private int clientId;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String city;
    private String contact;

    public Client(int clientId, String username,String firstName,
                  String lastName, String password, String email, String city, String contact) {
        this.clientId = clientId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.city = city;
        this.contact = contact;
    }

    public String getUsername() { return  username; }

    public int getClientId() { return clientId; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getPassword() { return password; }

    public String getEmail() { return email; }

    public String getCity() { return city; }

    public String getContact() { return contact; }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
