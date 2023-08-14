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
    private static Stage stg;
    private static final HashMap<String, String> users = new HashMap<>(); // Store registered users
    public static String currentUsername;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(true);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();
        loginController.setMain(this); // Provide the Main instance to the controller

        primaryStage.setTitle("Movie_Booth");
        primaryStage.setScene(new Scene(root, 320, 240));
        primaryStage.show();
    }

    // Method to change scenes
    public static void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    // Method to register a new user
    public static void registerUser(String username, String password) {
        users.put(username, password);
    }

    // Method to check if user credentials are valid
    public static boolean isValidUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

