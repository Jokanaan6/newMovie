package legit.movie_ticket_booking_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private List<UserAccount> userAccounts = new ArrayList<>();

    @FXML
    public Button button;
    @FXML
    private TextField registerUsername;
    @FXML
    private PasswordField registerPassword;
    @FXML
    public Button ComfirmReg;
    @FXML
    public Button LoginBack;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    public Button Regis;
    @FXML
    private Label wrongLogIn;
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;

    @FXML
    private void userLogIn(ActionEvent ignoredEvent) throws IOException {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        UserAccount loggedInUser = findUserAccount(enteredUsername, enteredPassword);

        if (loggedInUser != null) {
            wrongLogIn.setText("Success!");
            Main m= new Main();
            m.changeScene("Movie_Selection.fxml");
        } else {
            wrongLogIn.setText("Wrong username or password!");
        }
    }

    public UserAccount findUserAccount(String enteredUsername, String enteredPassword) {
        for (UserAccount account : userAccounts) {
            if (account.getUsername().equals(enteredUsername) && account.getPassword().equals(enteredPassword)) {
                return account;
            }
        }

        return ;
    }

    @FXML
    void Registeruser(ActionEvent ignoredEvent) throws IOException {
        Main m= new Main();
        m.changeScene("Register.fxml");
    }

    public void userRegister(ActionEvent ignoredEvent) {
        String newUsername = registerUsername.getText();
        String newPassword = registerPassword.getText();
        String confirmedPassword = confirmPassword.getText();

        if (newPassword.equals(confirmedPassword)) {
            UserAccount newAccount = new UserAccount(newUsername, newPassword);
            userAccounts.add(newAccount);
            wrongLogIn.setText("Account registered!");
        } else {
            wrongLogIn.setText("Passwords do not match!");
        }
    }

    public void Return(ActionEvent ignoredEvent) throws IOException {
        Main m= new Main();
        m.changeScene("Login.fxml");
    }
}






