package legit.movie_ticket_booking_system;

public class UserAccount {
    private final String username;
    private final String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

