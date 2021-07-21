package clientview;

import clientcontroller.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin {
    private static Admin admin = null;

    private Admin() {

    }

    public static Admin getInstance() {
        if (admin == null)
            admin = new Admin();

        return admin;
    }
    Controller controller=Controller.getInstance();
    public void run()  {
        System.out.println("welcome abp");
        while (true) {
            String input = MainClient.scanner.nextLine();
            Matcher matcher1 = getCommand(input, "^set ([a-zA-Z]+) forbidden$");
            Matcher matcher2 = getCommand(input, "^set ([a-zA-Z]+) allowed$");
            Matcher matcher3 = getCommand(input, "^exit");
            Matcher matcher4 = getCommand(input, "^increase ([a-zA-Z]+)$");
            Matcher matcher5 = getCommand(input, "^decrease ([a-zA-Z]+)$");
            if(matcher1.find()){
                System.out.println(controller.setForbidden(matcher1.group(1)));
            }
            else if(matcher2.find()){
                System.out.println(controller.setAllowed(matcher2.group(1)));
            }
            else if(matcher3.find())MenuHandler.runBack(Menu.SHOP);
            else if(matcher4.find()){
                System.out.println(controller.increaseCard(matcher4.group(1)));
            }
            else if(matcher5.find()){
                System.out.println(controller.decreaseCard(matcher5.group(1)));
            }
            else System.out.println("invalid command");

        }
    }
    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

}
