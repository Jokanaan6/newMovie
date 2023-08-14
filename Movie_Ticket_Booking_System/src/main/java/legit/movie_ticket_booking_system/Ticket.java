package legit.movie_ticket_booking_system;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Ticket {

    @FXML
    public Button Another;

    @FXML
    public Label Date;

    @FXML
    private Button Exit;

    @FXML
    public Label Movie;

    @FXML
    public Label Seat;

    @FXML
    public Label Time;

    @FXML
    public Label Username;
    public void setData(String movie, String day, String month, String year, String hour, String seat) {
        Movie.setText(movie);
        Date.setText(day + " " + month + " " + year);
        Time.setText(hour);
        Seat.setText(seat);
    }
}

