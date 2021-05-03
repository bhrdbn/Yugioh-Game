package model;

import java.util.ArrayList;

public class Card {
    private String name;
    private  static ArrayList<Card> allCards=new ArrayList<>();

    public String getName() {
        return name;
    }
    public static Card getCardByName(String name) {
        for(Card card:allCards){
            if(card.getName().equals(name))return card;
        }
        return null;
    }
    public static boolean doesCardExist(String name) {
        for(Card card:allCards){
            if(card.getName().equals(name))return true;
        }
        return false;
    }
}
