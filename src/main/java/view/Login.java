package view;
import java.util.regex.*;
import controller.*;
public class Login {
    LoginController loginController = new LoginController();
public static int b;
    public void run(String input) {
        while (true) {
            Matcher matcher1 = getCommand(input, "user create --username(\\w+) --nickname(\\w+) --password(\\w+)");
            Matcher matcher1_1 = getCommand(input, "user create --nickname(\\w+) --username(\\w+) --password(\\w+)");
            Matcher matcher1_2 = getCommand(input, "user create --username(\\w+) --password(\\w+) --nickname(\\w+)");
            Matcher matcher1_3 = getCommand(input, "user create --nickname(\\w+) --password(\\w+) --username(\\w+)");
            Matcher matcher1_4 = getCommand(input, "user create --password(\\w+) --username(\\w+) --nickname(\\w+)");
            Matcher matcher1_5 = getCommand(input, "user create --password(\\w+) --nickname(\\w+) --username(\\w+)");
            Matcher matcher2 = getCommand(input, "user login --username (\\w+) --password (\\w+)");
            Matcher matcher2_1 = getCommand(input, "user login --password (\\w+) --username (\\w+)");
            Matcher matcher5 = getCommand(input, "menu show-current");
            if (matcher1.find())
            { createUser(matcher1, 0);
             b=9;
            }
            else if (matcher1_1.find())
                createUser(matcher1_1, 1);
            else if (matcher1_2.find())
                createUser(matcher1_2, 2);
            else if (matcher1_3.find())
                createUser(matcher1_3, 3);
            else if (matcher1_4.find())
                createUser(matcher1_4, 4);
            else if (matcher1_5.find())
                createUser(matcher1_5, 5);
            else if (matcher2.find())
                loginUser(matcher2, 0);
            else if (matcher2_1.find())
                loginUser(matcher2_1, 1);

            else if (matcher5.find())
                System.out.println("Login Menu");
            else
                System.out.println("invalid command");
        }

    }


    public void loginUser(Matcher matcher, int flag) {
        if (flag == 0) {
            System.out.println(loginController.loginUser(matcher.group(1), matcher.group(2)));
            b=8;
        } else {
            System.out.println(loginController.loginUser(matcher.group(2), matcher.group(1)));
        }
    }

    public void createUser(Matcher matcher, int flag) {
        if (flag == 0) {
            System.out.println(loginController.createUser(matcher.group(1), matcher.group(2), matcher.group(3)));
            b=6;
        } else if (flag == 1) {
            System.out.println(loginController.createUser(matcher.group(2), matcher.group(1), matcher.group(3)));
        } else if (flag == 2) {
            System.out.println(loginController.createUser(matcher.group(1), matcher.group(3), matcher.group(2)));
        } else if (flag == 3) {
            System.out.println(loginController.createUser(matcher.group(3), matcher.group(1), matcher.group(2)));
        } else if (flag == 4) {
            System.out.println(loginController.createUser(matcher.group(2), matcher.group(3), matcher.group(1)));
        } else if (flag == 5) {
            System.out.println(loginController.createUser(matcher.group(3), matcher.group(2), matcher.group(1)));
        }
    }

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
}
