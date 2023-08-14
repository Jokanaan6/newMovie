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
    public PasswordField password;

    @FXML
    public TextField username;

    @FXML
    public Label wrongLogIn;

    public Main main;

    @FXML
    void Switchregister(ActionEvent ignoredEvent) throws IOException {
        Main.changeScene("Register.fxml");
    }

    @FXML
    void userLogIn(ActionEvent ignoredEvent) throws IOException {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (Main.isValidUser(enteredUsername, enteredPassword)) {
            Main.changeScene("Movie_Selection.fxml");
        } else {
            wrongLogIn.setText("Invalid username or password.");
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}



