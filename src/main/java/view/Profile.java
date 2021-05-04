package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.regex.*;
import controller.*;
public class Profile {
    ProfileController profileController = new ProfileController();
    public void run(String input){
        while(true){
            Matcher matcher1 = getCommand(input, "profile change --nickname(\\w+)");
            Matcher matcher2 = getCommand(input, "profile change --password --current(\\w+) --new(\\w+)|profile change --current --password(\\w+) --new(\\w+)|profile change --current(\\w+) --new(\\w+) --password");
            Matcher matcher2_1 = getCommand(input, "profile change --password --new(\\w+) --current(\\w+)|profile change --new(\\w+) --password --current(\\w+)|profile change --new(\\w+) --current(\\w+) --password");
            if(matcher1.find())
                changeNickName(matcher1);
            else if(matcher2.find())
                changePassword(matcher2, 0);
            else if(matcher2_1.find())
                changePassword(matcher2_1, 1);
            else
                System.out.println("invalid command");

        }
    }

    public void changePassword(Matcher matcher, int flag) {

        if(flag == 0) {
            if (profileController.checkPassword(matcher.group(1), matcher.group(2))) {
                profileController.changePassword(matcher.group(2));
                System.out.println(profileController.changePassword(matcher.group(2)));
            } else
                System.out.println("current password is invalid");
        }
        else if(flag == 1){
            if (profileController.checkPassword(matcher.group(2), matcher.group(1))) {
                profileController.changePassword(matcher.group(1));
                System.out.println(profileController.changePassword(matcher.group(1)));
            } else
                System.out.println("current password is invalid");
        }


    }

    public void changeNickName(Matcher matcher1) {
        ProfileController profileController = new ProfileController();
        if(profileController.checkNickName(matcher1.group(1))) {
            profileController.changeNickName(matcher1.group(1));
            System.out.println("nickname changed successfully");
        }
        else
            System.out.println("user with nickname " + matcher1.group(1) + " already exists");
    }

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

}
