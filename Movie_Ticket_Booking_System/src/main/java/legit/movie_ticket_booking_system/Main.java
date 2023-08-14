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
    private static final HashMap<String, String> users = new HashMap<>();
    public static String currentUsername;

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
        users.put(username, password);
    }

    public static boolean isValidUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

