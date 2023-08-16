package legit.movie_ticket_booking_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    public Button Regis;

    @FXML
    public Button button;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label wrongLogIn;

    public Main main;

    @FXML
    private void Switchregister(ActionEvent ignoredEvent) throws IOException {
        Main.changeScene("Register.fxml", 320, 500);
    }

    @FXML
    private void userLogIn(ActionEvent ignoredEvent) throws IOException {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (Main.isValidUser(enteredUsername, enteredPassword)) {
            Main.setCurrentUserAccount(new UserAccount(enteredUsername, enteredPassword)); // Save user account
            Main.changeScene("Movie_Selection.fxml", 600, 600);
        } else {
            wrongLogIn.setText("Invalid username or password.");
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
