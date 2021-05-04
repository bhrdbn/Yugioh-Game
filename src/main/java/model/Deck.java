package model;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> mainDeck ;
    private ArrayList<Card> sideDeck ;
    private boolean isValid;
    private String name;

    public Deck(String name) {
        this.name=name;
        mainDeck=new ArrayList<>();
        sideDeck=new ArrayList<>();
        isValid=false;


    }

    public String getName() {
        return name;
    }

    public void addCard(Card card,int position){
        if(position==1)mainDeck.add(card);
        else sideDeck.add(card);
    }
    public void removeCard(Card card,int position){
        if(position==1)mainDeck.remove(card);
        else sideDeck.remove(card);
    }
    public int countACardInDeck(Card card){
        int counter=0;
        for(Card card1: mainDeck){
            if (card1.getName().equals(card.getName())) counter++;
        }
        for (Card card2:sideDeck){
            if (card2.getName().equals(card.getName())) counter++;
        }
        return counter;

    }

    public void setIsValid(){
        isValid= (mainDeck.size()>=40&&mainDeck.size()<=60
                && sideDeck.size()<=15);
    }
    public boolean isValid(){
        return isValid;
    }
    public boolean isMainFull(){
        return (mainDeck.size()==60);
    }
    public boolean isSideFull(){
        return (sideDeck.size()==15);
    }


    @Override
    public String toString() {
        return
                name+": main deck "+mainDeck.size()+", side deck "+sideDeck.size()+", "+isValid();
    }

}
