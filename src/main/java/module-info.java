module legit.movie_ticket_booking_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens legit.movie_ticket_booking_system to javafx.fxml;
    exports legit.movie_ticket_booking_system;
}