package Graphic.view;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/java/Graphic/view/login.fxml").toURI().toURL();
        stage = primaryStage;
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 1000, 760));
        primaryStage.show();
    }


    public static Scanner scanner=new Scanner(System.in);

   public static void main(String[] args) {
        launch(args);
    }
}
