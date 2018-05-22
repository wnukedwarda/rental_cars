package pl.wnukedwarda.client;

public class ClientBuilder {

    private int clientId;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String city;
    private String contact;

    public ClientBuilder setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public ClientBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public ClientBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ClientBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public ClientBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ClientBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public ClientBuilder setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public Client build() {
        return new Client(clientId, username, firstName, lastName, password, email, city, contact);
    }

}
