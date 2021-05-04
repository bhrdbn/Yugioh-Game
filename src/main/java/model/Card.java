package model;

import java.util.ArrayList;

public class Card {
    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ArrayList<Integer> getCardController() {
        return cardController;
    }

    public void setCardController(ArrayList<Integer> cardController) {
        this.cardController = cardController;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    public static ArrayList<Card> getAllCards() {
        return allCards;
    }

    public static void setAllCards(ArrayList<Card> allCards) {
        Card.allCards = allCards;
    }

    protected String name;
    protected int number;
    protected String type;
    protected String cardDescription;
    protected String icon;
    protected ArrayList<Integer> cardController;
    protected int level;
    protected boolean side;
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
