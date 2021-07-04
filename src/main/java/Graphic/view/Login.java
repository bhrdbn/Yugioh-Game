package Graphic.view;


import java.util.regex.*;

import controller.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import model.Player;
import view.Main;

public class Login  {
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;

    private static Login login = null;

    public Login() {
    }

    public static Login getInstance() {
        if (login == null)
            login = new Login();

        return login;
    }

    public static int b;
    public void run(){}
    public void loginTapped(){}
    public void signupTapped(){}
    public void removeAccountTapped(){}
    public void changePasswordTapped(){}



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

    public void loginUser(Matcher matcher, int flag) {
        if (flag == 0) {
            System.out.println(LoginController.getInstance().loginUser(matcher.group(1), matcher.group(2)));
            if(LoginController.getInstance().loginUser(matcher.group(1), matcher.group(2)).equals("user logged in successfully!")){
                MenuHandler.runNextLogin();
            }
            b = 8;
        } else {
            System.out.println(LoginController.getInstance().loginUser(matcher.group(2), matcher.group(1)));
            if(LoginController.getInstance().loginUser(matcher.group(2), matcher.group(1)).equals("user logged in successfully!")){
                MenuHandler.runNextLogin();
            }
        }
    }

    public void createUser(Matcher matcher, int flag) {
        if (flag == 0) {
            System.out.println(LoginController.getInstance().createUser(matcher.group(1), matcher.group(2), matcher.group(3)));
            b = 6;
        } else if (flag == 1) {
            System.out.println(LoginController.getInstance().createUser(matcher.group(2), matcher.group(1), matcher.group(3)));
        } else if (flag == 2) {
            System.out.println(LoginController.getInstance().createUser(matcher.group(1), matcher.group(3), matcher.group(2)));
        } else if (flag == 3) {
            System.out.println(LoginController.getInstance().createUser(matcher.group(3), matcher.group(1), matcher.group(2)));
        } else if (flag == 4) {
            System.out.println(LoginController.getInstance().createUser(matcher.group(2), matcher.group(3), matcher.group(1)));
        } else if (flag == 5) {
            System.out.println(LoginController.getInstance().createUser(matcher.group(3), matcher.group(2), matcher.group(1)));
        }
    }

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }


}
