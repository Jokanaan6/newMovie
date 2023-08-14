package legit.movie_ticket_booking_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Movie {

    @FXML
    public Button bookButton;
    @FXML
    public Button logoutButton;

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

    // Initialize method to be called when the FXML is loaded
    @FXML
    private void initialize() {
        // Add options to the choice boxes (you should customize these options)
        dayChoiceBox.getItems().addAll("14","15","16","17","18","19","20","21","22");
        hourChoiceBox.getItems().addAll("9:30 am- 11:50 pm", "1:30 pm-3:45 pm", "4:00 pm- 6:30 pm");

        movieChoiceBox.getItems().addAll("Spider-Man: Across the Spider-Verse", "Barbie", "Oppenheimer");
        seatChoiceBox.getItems().addAll("A1", "A2","A3","B1","B2","B3", "C1","C2","C3");
        yearChoiceBox.getItems().addAll("2023");
        monthChoiceBox.getItems().addAll("July", "August");
    }
    @FXML
   private void Logout(ActionEvent ignoredEvent) throws IOException {
        Main m= new Main();
        m.changeScene("Login.fxml");

    }

    @FXML
    private void onBookButtonClicked() {
        String selectedDay = dayChoiceBox.getValue();
        String selectedHour = hourChoiceBox.getValue();
        String selectedMovie = movieChoiceBox.getValue();
        String selectedSeat = seatChoiceBox.getValue();
        String selectedYear = yearChoiceBox.getValue();
        String selectedMonth = monthChoiceBox.getValue();

        String confirmationMessage = "You have booked a ticket for " + selectedMovie + " on " + selectedDay +
                ", " + selectedMonth + " " + selectedYear + " at " + selectedHour + ":"  +
                ". Your seat is " + selectedSeat + ".";

        // Create an alert to show the confirmation message
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Booking Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(confirmationMessage);

        // Add buttons to the alert
        ButtonType confirmButtonType = new ButtonType("Confirm");
        ButtonType cancelButtonType = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(confirmButtonType, cancelButtonType);

        // Show the alert and wait for the user's response
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == confirmButtonType) {
                try {
                    // Create a bundle of data to pass to the Ticket scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket.fxml"));
                    Parent root;
                    try {
                        root = loader.load();
                        Ticket ticketController = loader.getController();
                        ticketController.setData(selectedMovie, selectedDay, selectedMonth, selectedYear, selectedHour, selectedSeat);

                        // Create a new scene and show it
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
    }}
