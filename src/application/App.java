package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View.fxml"));
            Parent parent = loader.load();

            Scene mainScene = new Scene(parent);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Calculadora");
            primaryStage.setWidth(323);
            primaryStage.setHeight(387);
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/gui/icons/calculator.png")));
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
}}
