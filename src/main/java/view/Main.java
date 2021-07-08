package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Card;

import java.util.Scanner;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;


    public static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
//        Login.getInstance().run();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Scene scene = new Scene(root);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    xOffset = mouseEvent.getSceneX();
                    yOffset = mouseEvent.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    stage.setX(mouseEvent.getSceneX() - xOffset);
                    stage.setY(mouseEvent.getSceneY() - yOffset);
                }
            });

            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);

            stage.show();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}