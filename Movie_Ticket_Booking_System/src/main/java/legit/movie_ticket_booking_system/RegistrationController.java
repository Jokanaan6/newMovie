package legit.movie_ticket_booking_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationController {

    public Label wrongLogIn;
    public Button LoginBack;

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
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Password Mismatch");
            alert.setHeaderText(null);
            alert.setContentText("Passwords do not match. Please make sure your passwords match.");
            alert.showAndWait();
        } else {
            Main.registerUser(username, password);
            Main.changeScene("Login.fxml", 350, 450);
        }
    }

    public void goBack(ActionEvent ignoredEvent) {

    }
}
