package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.stream.Collectors;


import view.*;

import javax.swing.text.html.ImageView;


public class LoginController implements Initializable {
    @FXML
    private Label lblErrors;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnSignin;
    @FXML
    private Label warnLabel;
    @FXML
    private TextField txtNickname;

    @FXML
    private Button btnSave;
    @FXML
    private Button btnHome;

    public static LoginController loginController = null;

    @FXML
    private void HandleEvents(javafx.scene.input.MouseEvent event) {
        //check if not empty
        if (txtNickname.getText().isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            warnLabel.setVisible(true);
            warnLabel.setStyle("-fx-text-fill: white;-fx-background-color: #FF6978;-fx-padding: 10 10 10 10;");
            warnLabel.setText("fill the blanks");
        } else {
            warnLabel.setVisible(true);
            warnLabel.setStyle("-fx-text-fill: white;-fx-background-color: #FF6978;-fx-padding: 10 10 10 10;");
            warnLabel.setText(createUser(txtUsername.getText(), txtNickname.getText(), txtPassword.getText()));
        }
    }

    @FXML
    public void HandleEventsHome(javafx.scene.input.MouseEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    public void handleButtonAction(javafx.scene.input.MouseEvent event) {
        if (event.getSource() == btnSignin) {
            try {
                String username = txtUsername.getText();
                String password = txtPassword.getText();

                if (loginUser(username, password).equals("user logged in successfully!")) {
                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    stage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("/view/OnBoard.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    warnLabel.setVisible(true);
                    warnLabel.setStyle("-fx-text-fill: white;-fx-background-color: #FF6978;-fx-padding: 10 10 10 10;");
                    warnLabel.setText("Invalid username or password");
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }


    }

    @FXML
    public void handleButtonActionSignup(javafx.scene.input.MouseEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/Signup.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }


    public static LoginController getInstance() {
        if (loginController == null)
            loginController = new LoginController();

        return loginController;
    }


    public void createNewUser(String nickName, String password, String userName) {
        Player player = new Player(nickName, password, userName);
    }

    public String createUser(String userName, String nickName, String password) {
        if (checkUserName(userName)) {
            if (checkNickName(nickName)) {
                createNewUser(nickName, password, userName);
                return ("user created successfully!");
            } else
                return ("user with nickname " + nickName + " already exists");
        } else
            return ("user with username " + userName + " already exists");

    }


    public boolean checkUserName(String username) {
        for (Player player : Player.getAllPlayers()) {
            if (player.getUsername().equals(username))
                return false;
        }
        return true;
    }


    public boolean checkNickName(String nickName) {
        for (Player player : Player.getAllPlayers()) {
            if (player.getNickname().equals(nickName))
                return false;
        }
        return true;
    }


    public boolean checkPassword(Player player, String password) {

        if (player.getPassword().equals(password)) return true;
        return false;
    }


    public String loginUser(String username, String password) {
        if (Player.getPlayerByUser(username) != null) {
            if (checkPassword(Player.getPlayerByUser(username), password)) {
                GlobalVariable.setPlayer(Player.getPlayerByUser(username));
                return ("user logged in successfully!");
            } else
                return ("Username and password didn't match!");
        } else return ("Username and password didn't match!");
    }

    public void textFieldMouseClicked() {

    }

    public void warnLableCloseMouseClicked() {
    }

    public void warnLableCloseMouseEntered() {
    }

    public void closeBtnMouseEntered() {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}