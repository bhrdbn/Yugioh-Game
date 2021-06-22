package model;

import controller.GlobalVariable;

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

    public Card(String name, int number, String type, String cardDescription, boolean side, int price) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.cardDescription = cardDescription;
     //   this.commands = new ArrayList<>();
        this.side = side;
        this.price = price;
    }

  // public void run(PlayBoard playBoard,Card card){
  //      for (Command command:commands)
  //          command.doAction(GlobalVariable.getBoard());
  // }


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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected String name;
    protected int number;
    protected String type;
    protected String cardDescription;
    //protected ArrayList<Command> commands;
    protected boolean side;
    protected int price;
    boolean canBeAttacked;
    private Location location;

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

    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }

    public static boolean doesCardExist(String name) {
        for(Card card:allCards){
            if(card.getName().equals(name))return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card name : " + name +
                " cardDescription : " + cardDescription
                ;
    }
}
