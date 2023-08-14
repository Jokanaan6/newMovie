package legit.movie_ticket_booking_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationController {

    public Label wrongLogIn;
    @FXML
    private TextField regUsername;

    @FXML
    private PasswordField regPassword;

    @FXML
    private PasswordField regConfirmPassword;

    @FXML
    void registerUser(ActionEvent ignoredEvent) throws IOException {
        String username = regUsername.getText();
        String password = regPassword.getText();
        String confirmPassword = regConfirmPassword.getText();

        if (!password.equals(confirmPassword)) {

        } else {
            Main.registerUser(username, password);
            Main.changeScene("Login.fxml");
        }
    }

    public void goBack(ActionEvent ignoredEvent) {
    }
}
