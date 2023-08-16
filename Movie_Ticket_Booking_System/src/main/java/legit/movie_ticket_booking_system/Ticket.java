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
    private Button Another;

    @FXML
    private Label Date;

    @FXML
    public Button Exit;

    @FXML
    private Label Movie;

    @FXML
    private Label Seat;

    @FXML
    private Label Time;

    @FXML
    public Label Username;

    public BookingDetails bookingDetails;

    public void setData(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
        Movie.setText(bookingDetails.selectedMovie());
        Date.setText(bookingDetails.selectedDay() + " " + bookingDetails.selectedMonth() + " " + bookingDetails.selectedYear());
        Time.setText(bookingDetails.selectedHour());
        Seat.setText(bookingDetails.selectedSeat());


        UserAccount user = bookingDetails.user();
        Username.setText(user.getUsername());
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
