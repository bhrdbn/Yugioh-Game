package Graphic.view;


import java.util.regex.*;

import controller.*;
import javafx.event.ActionEvent;
import view.Main;

public class Login  {
    private static Login login = null;

    private Login() {
    }

    public static Login getInstance() {
        if (login == null)
            login = new Login();

        return login;
    }

    public static int b;




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
