package tv;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class viewTV extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("maintv.fxml"));
        primaryStage.setTitle("TV");
        primaryStage.setScene(new Scene(root, 900, 900));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
