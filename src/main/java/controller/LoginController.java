package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.stream.Collectors;


import view.*;


public class LoginController {

    private static LoginController loginController = null;

    private LoginController() {

    }
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;


    @FXML
    public void signupTapped(ActionEvent actionEvent) {
        String nickname = txtUsername.getText();
        String username = txtUsername.getText(), password = txtPassword.getText();
        createNewUser(nickname, password, username);
        Alert alert = new Alert(Alert.AlertType.ERROR);
      String message = createUser(username, nickname, password);
        alert.setTitle(message);
        alert.setHeaderText(message);
        alert.show();
    }

    @FXML
    public void loginTapped(ActionEvent actionEvent) {
        String nickname = txtUsername.getText();
        String username = txtUsername.getText(), password = txtPassword.getText();
        loginUser(username, password);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String message = loginUser(username, password);
        alert.setTitle(message);
        alert.setHeaderText(message);
        alert.show();
    }
    public void removeAccountTapped(ActionEvent actionEvent) {
        String username = txtUsername.getText(), password = txtPassword.getText();
        Player user = Player.getPlayerByUser(username);
        if (user == null) return;
        Player.getAllPlayers().remove(user);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successfully removed account");
        alert.setHeaderText("Successfully removed account");
        alert.show();
    }

    public void changePasswordTapped(ActionEvent actionEvent) {
        String username = txtUsername.getText();
        Player user = Player.getPlayerByUser(username);
        if (user == null) return;
        TextInputDialog textInputDialog = new TextInputDialog("");
        textInputDialog.setHeaderText("Enter your new password");
        textInputDialog.showAndWait();
        String newPassword = textInputDialog.getEditor().getText();
        user.setPassword(newPassword);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successfully changed password");
        alert.setHeaderText("Successfully changed password");
        alert.show();
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
}
