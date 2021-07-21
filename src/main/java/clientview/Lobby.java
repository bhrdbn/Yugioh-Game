package clientview;

import clientcontroller.Controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lobby {
    private static Lobby lobby=null;
    private Lobby(){

    }
    public static Lobby getInstance()
    {
        if (lobby == null)
            lobby = new Lobby();

        return lobby;
    }
    public void run(){
        System.out.println("welcome to main menu");
        while(true){
            String input= MainClient.scanner.nextLine();
            Matcher matcher = getCommand(input, "^request game round (\\d)$");
            //Matcher matcher1 = getCommand(input, "^request game round (\\d) username");
            Matcher matcher2 = getCommand(input, "exit");
            if(matcher.find())requestView(matcher.group(1));
            else if(matcher2.find())MenuHandler.runBack(Menu.LOBBY);
            else System.out.println("invalid command");

        }
    }
    public void requestView(String round){
        String s;
        LocalDateTime l=LocalDateTime.now();
        System.out.println("you cancel your request by typing 'cancel request' or wait to connect ...");
        while(ChronoUnit.SECONDS.between(l,LocalDateTime.now())<6) {
             s = MainClient.scanner.nextLine();
            if(s!=null&&s.startsWith("cancel")) {
                System.out.println("you canceled");
                return;
            }
        }
        String result=Controller.getInstance().request(round);
        if(result.startsWith("duel created")){
            System.out.println();
            MenuHandler.runNextMain(Menu.DUEL);
        }

    }
    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }


}