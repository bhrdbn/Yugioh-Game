package Graphic.view;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.channels.NetworkChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.regex.*;

import controller.*;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Player;
import view.Main;

public class Login  extends Application {

    private static Login login = null;

    public Login() {
    }

    public static Login getInstance() {
        if (login == null)
            login = new Login();

        return login;
    }


    private static Stage mainStage;


    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getMainStage() {
        return mainStage;
    }


    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        final Group group = new Group();
        Group group1 = new Group();
        Scene login = new Scene(group1, 400, 400);
        Label label = new Label();
        label.setText("welcome to yugioh");
        label.setLayoutX(170);
        label.setScaleX(2);
        label.setScaleY(2);
        label.setScaleZ(0.5);
        label.setTextFill(Color.LAWNGREEN);
        login.setFill(new ImagePattern(new Image(getClass().getResource("/Graphic/view/ds.jpg").toExternalForm())));
        Button button = new Button();
        button.setLayoutX(20);
        button.setLayoutY(355);
        button.setTextFill(Color.PINK);
        BackgroundFill background_fill = new BackgroundFill(Color.CRIMSON,
                CornerRadii.EMPTY, Insets.EMPTY);
        button.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, new CornerRadii(1.0), BorderStroke.MEDIUM)));
        button.setText("create new account");
        button.setBackground(new Background(background_fill));
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setCursor(Cursor.HAND);
                button.setEffect(new DropShadow(20, Color.WHITE));
            }
        });
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setEffect(null);
            }
        });
        Button button1 = new Button();
        group1.getChildren().addAll(label, button, button1);
        button1.setLayoutX(300);
        button1.setLayoutY(355);
        button1.setTextFill(Color.PINK);
        button1.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, new CornerRadii(1.0), BorderStroke.MEDIUM)));
        button1.setText("login");
        button1.setMinWidth(50);
        button1.setBackground(new Background(background_fill));
        button1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button1.setCursor(Cursor.HAND);
                button1.setEffect(new DropShadow(20, Color.WHITE));
            }
        });
        button1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button1.setEffect(null);
            }
        });
        button1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Group login = new Group();
                Scene loginAccount = new Scene(login, 400, 400);
                loginAccount.setFill(new ImagePattern(new Image(getClass().getResource("/Test/hi.jpg").toExternalForm())));
                Label getName = new Label("enter your name");
                getName.setLayoutY(10);
                getName.setTextFill(Color.WHITE);
                TextField textField = new TextField();
                textField.setLayoutY(30);
                Label getPass = new Label("enter your password");
                getPass.setLayoutY(70);
                getPass.setTextFill(Color.WHITE);
                TextField textField1 = new TextField();
                textField1.setLayoutY(90);
                Button button2 = new Button("login and play!");
                button2.setTextFill(Color.WHITE);
                button2.setBackground(new Background(new BackgroundFill(Color.RED,
                        CornerRadii.EMPTY, Insets.EMPTY)));
                button2.setCursor(Cursor.HAND);
                button2.setLayoutX(20);
                button2.setLayoutY(130);
                stage.setScene(loginAccount);
                login.getChildren().addAll(getName, textField, getPass, textField1, button2);
                button2.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        if (textField.getText().equals("") || textField1.getText().equals("")) {
                            Label label1 = new Label("fill the blanks");
                            label1.setLayoutY(0);
                            label1.setTextFill(Color.PINK);
                            Popup popup = new Popup();
                            popup.getContent().add(label1);
                            PauseTransition delay = new PauseTransition(Duration.seconds(2));
                            delay.setOnFinished(e -> popup.hide());
                            popup.show(stage);
                            delay.play();
                        } else {

                            Label label1 = new Label(LoginController.getInstance().loginUser(
                                    textField.getText(), textField1.getText()));
                            label1.setLayoutY(0);
                            label1.setTextFill(Color.PINK);
                            textField.setText("");
                            textField1.setText("");
                            Popup popup = new Popup();
                            popup.getContent().add(label1);
                            PauseTransition delay = new PauseTransition(Duration.seconds(2));
                            delay.setOnFinished(e -> popup.hide());
                            popup.show(stage);
                            delay.play();

                        }

                    }


                });
            }
        });
        // button.setOnMousePressed(new EventHandler<MouseEvent>() {
        //     @Override
        //     public void handle(MouseEvent mouseEvent) {
        //         Group create = new Group();
        //         Scene createAccount = new Scene(create, 400, 400);
        //         createAccount.setFill(new ImagePattern(new Image(getClass().getResource("/Test/10.png").toExternalForm())));
        //         Label getName = new Label("set your name");
        //         getName.setLayoutY(10);
        //         TextField textField = new TextField();
        //         textField.setLayoutY(30);
        //         Label getPass = new Label("set your password");
        //         getPass.setLayoutY(70);
        //         TextField textField1 = new TextField();
        //         textField1.setLayoutY(90);
        //         Button button2 = new Button("submit");
        //         button2.setLayoutX(20);
        //         button2.setLayoutY(130);
        //         stage.setScene(createAccount);
        //         create.getChildren().addAll(getName, textField, getPass, textField1, button2);
        //     button2.setOnMousePressed(new EventHandler<MouseEvent>() {
        //  @Override
        //             public void handle(MouseEvent mouseEvent) {
//
        //                     if (textField.getText().equals("") || textField1.getText().equals("")) {
        //                         Label label1 = new Label("fill the blanks");
        //                         label1.setTextFill(Color.RED);
        //                         Popup popup = new Popup();
        //                         popup.getContent().add(label1);
        //                         PauseTransition delay = new PauseTransition(Duration.seconds(2));
        //                         delay.setOnFinished(e -> popup.hide());
        //                         popup.show(stage);
        //                         delay.play();
        //                     } else if (new CreateAccount().makeAccount(textField.getText(), textField1.getText()) == 1) {
        //                         Label label1 = new Label("your account is ready!");
        //                         label1.setTextFill(Color.LIGHTGREEN);
        //                         label1.setLayoutY(10);
        //                         label1.setLayoutX(10);
        //                         stage.setScene(welcome);
        //                         Popup popup = new Popup();
        //                         popup.getContent().add(label1);
        //                         PauseTransition delay = new PauseTransition(Duration.seconds(2));
        //                         delay.setOnFinished(e -> popup.hide());
        //                         popup.show(stage);
        //                         delay.play();
//
        //                     } else {
        //                         Label label1 = new Label("this username already exists");
        //                         label1.setTextFill(Color.RED);
        //                         textField.setText("");
        //                         textField1.setText("");
        //                         Popup popup = new Popup();
        //                         popup.getContent().add(label1);
        //                         PauseTransition delay = new PauseTransition(Duration.seconds(2));
        //                         delay.setOnFinished(e -> popup.hide());
        //                         popup.show(stage);
        //                         delay.play();
//
        //                     }
//
        //                 }
//
//
        //             });
//
//
        //         }
        //     });
        //  stage.setTitle("pacman game");
        // stage.setScene(login);
        // stage.show();

        //  }

    }
}



