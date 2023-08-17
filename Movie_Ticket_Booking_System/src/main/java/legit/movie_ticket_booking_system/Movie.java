package legit.movie_ticket_booking_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Movie {

    @FXML
    public Button bookButton;

    @FXML
    public Button logoutButton;
    public Label price;

    @FXML
    private ChoiceBox<String> dayChoiceBox;

    @FXML
    private ChoiceBox<String> hourChoiceBox;

    @FXML
    private ChoiceBox<String> movieChoiceBox;

    @FXML
    private ChoiceBox<String> seatChoiceBox;

    @FXML
    private ChoiceBox<String> yearChoiceBox;

    @FXML
    private ChoiceBox<String> monthChoiceBox;

    @FXML
    private void initialize() {
        dayChoiceBox.getItems().addAll("14", "15", "16", "17", "18", "19", "20", "21", "22");
        hourChoiceBox.getItems().addAll("09:30 am - 11:50 pm", "01:30 pm - 03:45 pm", "04:00 pm - 06:30 pm");
        movieChoiceBox.getItems().addAll("Spider-Man: Across the Spider-Verse", "Barbie", "Oppenheimer", "La La Land");
        seatChoiceBox.getItems().addAll("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3");
        yearChoiceBox.getItems().addAll("2023");
        monthChoiceBox.getItems().addAll("August");
        movieChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int moviePrice = calculateMoviePrice(newValue);
                price.setText("Price: " + moviePrice);
            }
        });
    }


    private BookingDetails selectedBooking;

    @FXML
    private void onBookButtonClicked() {
        String selectedDay = dayChoiceBox.getValue();
        String selectedHour = hourChoiceBox.getValue();
        String selectedMovie = movieChoiceBox.getValue();
        String selectedSeat = seatChoiceBox.getValue();
        String selectedYear = yearChoiceBox.getValue();
        String selectedMonth = monthChoiceBox.getValue();
        int moviePrice = calculateMoviePrice(selectedMovie);

        if (selectedDay == null || selectedHour == null || selectedSeat == null || selectedYear == null || selectedMonth == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Booking");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all the fields before booking.");
            alert.showAndWait();
            return;
        }


        selectedBooking = Main.createBookingDetails(selectedDay, selectedHour, selectedMovie,
                selectedSeat, selectedYear, selectedMonth, moviePrice);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Booking Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("You have selected:\n" +
                "Movie: " + selectedBooking.selectedMovie() + "\n" +
                "Date: " + selectedBooking.selectedDay() + " " + selectedBooking.selectedMonth() + " " + selectedBooking.selectedYear() + "\n" +
                "Time: " + selectedBooking.selectedHour() + "\n" +
                "Seat: " + selectedBooking.selectedSeat() + "\n" +
                "Price: "+ selectedBooking.moviePrice()+ "\n" +
                "Confirm your booking?");

        ButtonType confirmButtonType = new ButtonType("Confirm");
        ButtonType cancelButtonType = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(confirmButtonType, cancelButtonType);


        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == confirmButtonType) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket.fxml"));
                    Parent root;
                    try {
                        root = loader.load();
                        Ticket ticketController = loader.getController();
                        ticketController.setData(selectedBooking);
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private int calculateMoviePrice(String selectedMovie) {
        return switch (selectedMovie) {
            case "Spider-Man: Across the Spider-Verse" -> 200;
            case "Barbie" -> 230;
            case "Oppenheimer" -> 190;
            case "La La Land" -> 250;
            default -> 0;
        };
    }

    @FXML
    private void Logout(ActionEvent ignoredEvent) throws IOException {
        Main.changeScene("Login.fxml", 350, 450);
    }
}
