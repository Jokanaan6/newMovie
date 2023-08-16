package legit.movie_ticket_booking_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Main extends Application {

    private static Stage stage;
    private static final HashMap<String, UserAccount> users = new HashMap<>();
    private static UserAccount currentUserAccount;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setResizable(true);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();
        loginController.setMain(this);

        primaryStage.setTitle("Movie_Booth");
        primaryStage.setScene(new Scene(root, 350, 450));
        primaryStage.show();
    }

    public static void changeScene(String fxml, int width, int height) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
        stage.setScene(new Scene(pane, width, height));
        stage.setWidth(width);
        stage.setHeight(height);
    }

    public static void registerUser(String username, String password) {
        users.put(username, new UserAccount(username, password));
    }

    public static boolean isValidUser(String username, String password) {
        return users.containsKey(username) && users.get(username).getPassword().equals(password);
    }

    public static void setCurrentUserAccount(UserAccount userAccount) {
        currentUserAccount = userAccount;
    }

    public static BookingDetails createBookingDetails(String selectedDay, String selectedHour,
                                                      String selectedMovie, String selectedSeat,
                                                      String selectedYear, String selectedMonth) {
        return new BookingDetails(currentUserAccount, selectedDay, selectedHour, selectedMovie,
                selectedSeat, selectedYear, selectedMonth);
    }
}
