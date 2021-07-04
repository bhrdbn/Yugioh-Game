package Graphic.view;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.*;
import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group1 = new Group();
        Scene welcome = new Scene(group1, 400, 400);
        primaryStage.setScene(welcome);
        primaryStage.show();
    }

    public static Scanner scanner=new Scanner(System.in);

   public static void main(String[] args) {
        launch(args);
    }
}
