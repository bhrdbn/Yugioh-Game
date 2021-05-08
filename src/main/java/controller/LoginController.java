package controller;
import model.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class LoginController {
    private static LoginController loginController = null;
    private LoginController(){

    }
    public static LoginController getInstance()
    {
        if (loginController == null)
            loginController = new LoginController();

        return loginController;
    }


    public void createNewUser(String userName, String nickName, String password) {
        Player player = new Player(nickName, password, userName);
    }

    public String createUser(String userName, String nickName, String password) {
        if (checkUserName(userName)) {
            if (checkNickName(nickName)) {
                createNewUser(userName, nickName, password);
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
        if (checkUserName(username)) {
            if (checkPassword(Player.getPlayerByUser(username), password)) {
                GlobalVariable.setPlayer(Player.getPlayerByUser(username));
                return ("user logged in successfully!");
            }
            else
                return ("Username and password didn't match!");
        } else return ("Username and password didn't match!");
    }
}
