package view;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.regex.*;

import controller.*;
import model.Card;
import model.CheatSheet;

public class Shop {

    ShopController shopController = ShopController.getInstance();
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
            String input = Main.scanner.nextLine();
            Matcher matcher1 = getCommand(input, "^shop buy ([a-zA-Z\\s]+)$");
            Matcher matcher2 = getCommand(input, "shop show --all");
            Matcher matcher3 = getCommand(input, "exit");
            Matcher matcher4 = getCommand(input, "cheat BAP ([a-zA-Z]+) and ([a-zA-Z]+) and ([a-zA-Z]+) code ([0-9])");
            Matcher matcher6 = getCommand(input, "Card serialize name ([a-zA-Z]+) describe ([a-zA-Z]+) number ([0-9]) attack ([0-9]) defence ([0-9]) price ([0-9]) attribute ([a-zA-Z]+) level ([0-9]) type ([a-zA-Z]+)");
            if (matcher1.find())
                buy(matcher1);
            else if (matcher2.find())
                showAll();
            else if (matcher3.find()) MenuHandler.runBack(Menu.SHOP);
            else if (matcher6.find()) {ImprotExport improtExport = new ImprotExport();
                improtExport.serialize(matcher6.group(1),matcher6.group(2),Integer.parseInt(matcher6.group(3)),Integer.parseInt(matcher6.group(4)),Integer.parseInt(matcher6.group(5)),Integer.parseInt(matcher6.group(6)),matcher6.group(7),Integer.parseInt(matcher6.group(8)), matcher6.group(9),null,true);
            }
            else if (matcher4.find()) {
                if (matcher4.group(1).equals("bahar") && matcher4.group(2).equals("ayla") && matcher4.group(3).equals("pardis")) {
                    CheatSheet cheatSheet = new CheatSheet(matcher4.group(1), matcher4.group(2), matcher4.group(3), Integer.parseInt(matcher4.group(4)));
                    cheatSheet.cheet(Integer.parseInt(matcher4.group(4)));
                }
            }
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

}
