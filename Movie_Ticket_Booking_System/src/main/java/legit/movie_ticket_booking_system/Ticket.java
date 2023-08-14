package legit.movie_ticket_booking_system;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Ticket {

    @FXML
    public Button Another;

    @FXML
    public Label Date;

    @FXML
    public Button Exit;

    @FXML
    public Label Movie;

    @FXML
    public Label Seat;

    @FXML
    public Label Time;

    @FXML
    public Label Username;

    public void initialize() {
        // Get the stored username from Main class
        String username = Main.currentUsername;

        // Update the label with the username
        Username.setText(username);
    }

    public void setData(String movie, String day, String month, String year, String hour, String seat) {
        Movie.setText(movie);
        Date.setText(day + " " + month + " " + year);
        Time.setText(hour);
        Seat.setText(seat);
    }

    public void Back(ActionEvent ignoredEvent) throws IOException {
        Main.changeScene("Movie_Selection.fxml", 600, 600);
        Platform.runLater(() -> {
            Stage stage = (Stage) Another.getScene().getWindow();
            stage.close();
        });
    }

    public void Close(ActionEvent ignoredEvent) {
        Platform.exit();
    }
}
