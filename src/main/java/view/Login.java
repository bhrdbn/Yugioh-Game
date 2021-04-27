package view;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class Login {
    /*
    public void run(String input){
        while (true){
            Matcher matcher1 = getCommand(input, "user create --username(\\w+) --nickname(\\w+) --password(\\w+)");
            Matcher matcher1_1 = getCommand(input, "user create --nickname(\\w+) --username(\\w+) --password(\\w+)");
            Matcher matcher1_2 = getCommand(input, "user create --username(\\w+) --password(\\w+) --nickname(\\w+)");
            Matcher matcher1_3 = getCommand(input, "user create --nickname(\\w+) --password(\\w+) --username(\\w+)");
            Matcher matcher1_4 = getCommand(input, "user create --password(\\w+) --username(\\w+) --nickname(\\w+)");
            Matcher matcher1_5 = getCommand(input, "user create --password(\\w+) --nickname(\\w+) --username(\\w+)");
            Matcher matcher2 = getCommand(input, "user login --username (\\w+) --password (\\w+)");
            Matcher matcher2_1 = getCommand(input, "user login --password (\\w+) --username (\\w+)");
            Matcher matcher3 = getCommand(input, "user logout");
            Matcher matcher4 = getCommand(input, "scoreboard show");
            Matcher matcher5 = getCommand(input, "menu show-current");
            if(matcher1.find())
                createUser(matcher1, 0);
            else if(matcher1_1.find())
                createUser(matcher1_1, 1);
            else if(matcher1_2.find())
                createUser(matcher1_2, 2);
            else if(matcher1_3.find())
                createUser(matcher1_3, 3);
            else if(matcher1_4.find())
                createUser(matcher1_4, 4);
            else if(matcher1_5.find())
                createUser(matcher1_5, 5);
            else if(matcher2.find())
                loginUser(matcher2, 0);
            else if(matcher2_1.find())
                loginUser(matcher2_1, 1);
            else if(matcher3.find())
                logoutUser(matcher3);
            else if(matcher4.find())
                showScoreboard();
            else if(matcher5.find())
                System.out.println("Login Menu");
            else
                System.out.println("invalid command");
        }

    }

    public void showScoreboard() {
        LoginController loginController = new LoginController();
        System.out.println(loginController.showScoreboard().toString());
    }

    public void logoutUser(Matcher matcher3) {
        LoginController loginController = new LoginController();
        loginController.logoutUser(matcher3);
        System.out.println("user logged out successfully!");
    }

    public void loginUser(Matcher matcher, int flag) {
        LoginController loginController = new LoginController();
        if(flag == 0){
            if(!loginController.checkUserName(matcher.group(1)) && loginController.checkPassword(matcher.group(2))) {
                loginController.loginUser(matcher);
                System.out.println("user logged in successfully!");
            }
            else
                System.out.println("Username and password didn't match!");
        }
        if(flag == 1){
            if(!loginController.checkUserName(matcher.group(2)) && loginController.checkPassword(matcher.group(1))) {
                loginController.loginUser(matcher);
                System.out.println("user logged in successfully!");
            }
            else
                System.out.println("Username and password didn't match!");
        }

    }

    public void createUser(Matcher matcher, int flag) {
        LoginController loginController = new LoginController();
        if(flag == 0) {
            if (loginController.checkUserName(matcher.group(1)))
                if (loginController.checkNickName(matcher.group(2))) {
                    loginController.createUser(matcher.group(1), matcher.group(2), matcher.group(3));
                    System.out.println("user created successfully!");
                }
                else
                    System.out.println("user with nickname " + matcher.group(2) +" already exists");
            else
                System.out.println("user with username " + matcher.group(1) + " already exists");
        }
        else if(flag == 1) {
            if(loginController.checkUserName(matcher.group(2)))
                if(loginController.checkNickName(matcher.group(1))) {
                    loginController.createUser(matcher.group(2), matcher.group(1), matcher.group(3));
                    System.out.println("user created successfully!");
                }
                else
                    System.out.println("user with nickname " + matcher.group(1) + " already exists");
            else
                System.out.println("user with username " + matcher.group(2) + " already exists");
        }
        else if(flag == 2) {
            if(loginController.checkUserName(matcher.group(1)))
                if(loginController.checkNickName(matcher.group(3))) {
                    loginController.createUser(matcher.group(1), matcher.group(3), matcher.group(2));
                    System.out.println("user created successfully!");
                }
                else
                    System.out.println("user with nickname " + matcher.group(3) + " already exists");
            else
                System.out.println("user with username " + matcher.group(1) + " already exists");
        }
        else if(flag == 3) {
            if(loginController.checkUserName(matcher.group(3)))
                if(loginController.checkNickName(matcher.group(1))) {
                    loginController.createUser(matcher.group(3), matcher.group(1), matcher.group(2));
                    System.out.println("user created successfully!");
                }
                else
                    System.out.println("user with nickname " + matcher.group(1) + " already exists");
            else
                System.out.println("user with username " + matcher.group(3) + " already exists");
        }
        else if(flag ==4) {
            if(loginController.checkUserName(matcher.group(2)))
                if(loginController.checkNickName(matcher.group(3))) {
                    loginController.createUser(matcher.group(2), matcher.group(3), matcher.group(1));
                    System.out.println("user created successfully!");
                }
                else
                    System.out.println("user with nickname " + matcher.group(3) + " already exists");
            else
                System.out.println("user with username " + matcher.group(2) + " already exists");
        }
        else if(flag == 5) {
            if(loginController.checkUserName(matcher.group(3)))
                if(loginController.checkNickName(matcher.group(2))) {
                    loginController.createUser(matcher.group(3), matcher.group(2), matcher.group(1));
                    System.out.println("user created successfully!");
                }
                else
                    System.out.println("user with nickname " + matcher.group(2) + " already exists");
            else
                System.out.println("user with username " + matcher.group(3) + " already exists");
        }
    }

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    */

}
