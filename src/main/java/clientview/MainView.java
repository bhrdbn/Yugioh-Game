package clientview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import  clientcontroller.*;
import model.*;
public class MainView {
    private static MainView mainView=null;
    private MainView(){

    }
    public static MainView getInstance()
    {
        if (mainView == null)
            mainView = new MainView();

        return mainView;
    }

    Controller mainController=Controller.getInstance();
    public void run(){
        System.out.println("welcome to main menu");
        while(true){
            String input=Main.scanner.nextLine();
            Matcher matcher = getCommand(input, "scoreboard show");
            Matcher matcher1 = getCommand(input, "user logout");
            Matcher matcher2 = getCommand(input, "exit");
            Matcher matcher3 = getCommand(input, "enter menu (\\w+)");
            if(matcher.find())showScoreboard();
            else if(matcher1.find()||matcher2.find())logoutUser();
            else if(matcher3.find())navigateMenu(matcher3.group(1));
            else System.out.println("invalid command");

        }
    }


    public void showScoreboard() {

            System.out.println(mainController.scoreboard());

    }
    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    public void logoutUser(){
        System.out.println(mainController.logoutUser());
        MenuHandler.runBack(Menu.Main);

    }
    public void navigateMenu(String menu){
        switch (menu){
            case "profile":
                MenuHandler.runNextMain(Menu.PROFILE);
                break;
            case "deck":
                MenuHandler.runNextMain(Menu.DECK);
                break;
            case "shop":
                MenuHandler.runNextMain(Menu.SHOP);
                break;
            case "duel":
                MenuHandler.runNextMain(Menu.DUEL);
                break;
        }
    }
}
