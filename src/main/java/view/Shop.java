package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.regex.*;

import controller.*;

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


    public void run() {
        System.out.println("welcome to shop menu");
        while (true) {
            String input = Main.scanner.nextLine();
            Matcher matcher1 = getCommand(input, "shop buy ([a-zA-Z]+)");
            Matcher matcher2 = getCommand(input, "shop show --all");
            Matcher matcher3 = getCommand(input, "exit");
            if (matcher1.find())
                buy(matcher1);
            else if (matcher2.find())
                showAll();
            else if (matcher3.find()) MenuHandler.runBack(Menu.SHOP);
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
