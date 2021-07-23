package clientview;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clientcontroller.*;
import model.CheatSheet;

public class Shop {

    Controller shopController = Controller.getInstance();
    private static Shop shop = null;

    private Shop() {

    }

    public static Shop getInstance() {
        if (shop == null)
            shop = new Shop();

        return shop;
    }


    public void run() throws IOException {
        System.out.println("welcome to shop menu");
        while (true) {
            String input = MainClient.scanner.nextLine();
            Matcher matcher1 = getCommand(input, "^shop buy ([a-zA-Z\\s]+)$");
            Matcher matcher5=getCommand(input, "^shop sell ([a-zA-Z\\s]+)$");
            Matcher matcher2 = getCommand(input, "shop show --all");
            Matcher matcher3 = getCommand(input, "exit");
            Matcher matcher4 = getCommand(input, "cheat BAP ([a-zA-Z\\s]+) and ([a-zA-Z\\s]+) and ([a-zA-Z\\s]+) code ([0-9])");
            Matcher matcher= getCommand(input,"Im admin");
            if (matcher1.find())
                buy(matcher1);
            else if (matcher2.find())
                showAll();
            else if (matcher3.find()) MenuHandler.runBack(Menu.SHOP);

            else if (matcher4.find()) {
                if (matcher4.group(1).equals("bahar") && matcher4.group(2).equals("ayla") && matcher4.group(3).equals("pardis")) {
                    CheatSheet cheatSheet = new CheatSheet(matcher4.group(1), matcher4.group(2), matcher4.group(3), Integer.parseInt(matcher4.group(4)));
                    cheatSheet.cheet(Integer.parseInt(matcher4.group(4)));
                }
            }
            else if(matcher.find()) admin();
            else if (matcher5.find()) System.out.println(shopController.sell(matcher5.group(1)));
            else
                System.out.println("invalid command");
        }
    }

    public void showAll() {

        System.out.println(shopController.showAll());
    }

    public void buy(Matcher matcher1) {

        System.out.println(shopController.buy(matcher1.group(1)));
    }

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    public void admin(){

       if(shopController.admin()) MenuHandler.admin();
       else System.out.println("you don't have access");
    }

}
