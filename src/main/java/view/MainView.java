package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import  controller.*;
import model.*;
public class MainView {
    MainController mainController=MainController.getInstance();
    public void run(String input){
        while(true){
            Matcher matcher = getCommand(input, "scoreboard show");
            Matcher matcher1 = getCommand(input, "user logout");
            if(matcher.find())showScoreboard();
            else if(matcher1.find())logoutUser();

        }
    }


    public void showScoreboard() {
        for (Player player : MainController.scoreboard()) {
            System.out.println(player);
        }
    }
    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    public void logoutUser(){
        System.out.println(mainController.logoutUser());

    }
}
