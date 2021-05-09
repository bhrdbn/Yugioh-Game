package controller;

import java.util.ArrayList;
import model.*;

public class ShopController {

    private static ShopController shopController=null;
    private ShopController(){

    }
    public static ShopController getInstance()
    {
        if (shopController == null)
            shopController = new ShopController();

        return shopController;
    }

    String name;
    String type;
    int number;
    String cardDescription;
    int price;
    boolean side;
    String nickname;
    String password;
    String username;
    ArrayList<Integer> cardController;
    Card card = new Card(name, number,type, cardDescription, cardController,side, price);
    public String buy(String cardName){
        Player player = new Player(nickname, password, username);
        Card card = new Card(name, number,type, cardDescription, cardController,side, price);
        int count = 0;
        for(Card cards : card.getAllCards()){
            if(!cards.getName().equals(cardName))
                count++;
        }
        if(count == card.getAllCards().size() - 1)
            return "there is no card with this name";
        else if(player.getMoney() < card.getPrice())
            return "not enough money";
        else{
            player.setMoney(player.getMoney() - card.getPrice());
        }
    return null;
    }


    public void showAll(){
        for(Card cards : card.getAllCards()){
            System.out.println(cards.getName() + " " + cards.getCardDescription());
        }
    }

}
