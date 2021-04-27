package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.regex.*;

public class Shop {
    /*
    public void run(String input) {
        while (true) {
            Matcher matcher1 = getCommand(input, "shopBuy([a-zA-Z]+)");
            Matcher matcher2 = getCommand(input, "shop show --all");
            if(matcher1.find())
                buy(matcher1);
            else if(matcher2.find())
                showAll();
            else
                System.out.println("invalid command");
        }
    }

    public void showAll() {
        ShopController shopController = new ShopController();
        shopController.showAll();
    }

    public void buy(Matcher matcher1) {
        ShopController shopController = new ShopController();
        Card card = new Card();
        int count = 0;
        Player player = new Player();
        for (Card cards: card.getCards()) {
            if(!cards.getName().equals(cardName))
                count++;
        }
        if(count == card.getCards().size - 1)
            System.out.println("there is no card with this name");
        else if(player.getMoney < card.getPrice)
            System.out.println("not enough money");
        else{
            shopController.buy(matcher1.group(1));
        }
    }

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
*/
}
