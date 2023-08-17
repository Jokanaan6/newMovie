package legit.movie_ticket_booking_system;

public record BookingDetails(UserAccount user, String selectedDay, String selectedHour, String selectedMovie,
                             String selectedSeat, String selectedYear, String selectedMonth, int moviePrice) {
}

