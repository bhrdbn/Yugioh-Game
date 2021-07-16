package view;


import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Card;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import static javafx.animation.Animation.INDEFINITE;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;
    public static int playerTurn = 1;


    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
   // playMusic();
//        Login.getInstance().run();

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

//        Task task = new Task() {
//            @Override
//            protected Object call() throws Exception {
//                FXMLLoader rootLoader = new FXMLLoader(getClass().getResource(Paths.appFXML));
//                Parent root = rootLoader.load();
//                Scene scene = new Scene(root, Settings.screenWidth, Settings.screenHeight);
//                scene.getStylesheets().add(getClass().getResource(Paths.boardCSS).toExternalForm());
//                stage.setScene(scene);
//                stage.setTitle(Settings.titleName);
//                stage.setResizable(false);
//                stage.show();
//                rootController = rootLoader.getController();
//                BoardController boardController = (BoardController) rootController;
//                GameInfo.addPlayer(1, new PlayerInfo(Settings.player1Name, Settings.player1Color));
//                GameInfo.addPlayer(2, new PlayerInfo(Settings.player2Name, Settings.player2Color));
//                boardController.init();
//                ((BoardController) rootController).startGame();
//                return null;
//            }
//        };
//        Thread thread = new Thread(task);
//        thread.start();

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void playMusic() { //todo install JDK
        final Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                int s = INDEFINITE;
                String musicFile = "D:\\project\\project\\src\\main\\resources\\music\\pain.wav";     // For example
                AudioClip audio = new AudioClip(new File(musicFile).toURI().toString());
                audio.setVolume(0.5f);
                audio.setCycleCount(s);
                audio.play();
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

}