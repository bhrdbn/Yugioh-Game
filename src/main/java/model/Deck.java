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

    public ArrayList<Card> getMainDeck() {
        return mainDeck;
    }

    public ArrayList<Card> getSideDeck() {
        return sideDeck;
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
    public ArrayList<Card> getMonsters(int position){
        ArrayList<Card>monsters=new ArrayList<>();
        if(position==1) {
            for (Card card1 : mainDeck) {
                if (card1 instanceof MonsterCard) monsters.add(card1);
            }
        }
        else {
            for (Card card2 : sideDeck) {
                if (card2 instanceof MonsterCard) monsters.add(card2);
            }
        }
        return monsters;
    }
    public ArrayList<Card> getTrapOrSpell(int position){
        ArrayList<Card>trapOrSpell=new ArrayList<>();
        if(position==1) {
            for (Card card1 : mainDeck) {
                if (card1 instanceof TrapCard||card1 instanceof SpellCard) trapOrSpell.add(card1);
            }
        }
        else {
            for (Card card2 : sideDeck) {
                if (card2 instanceof TrapCard || card2 instanceof SpellCard) trapOrSpell.add(card2);
            }
        }
        return trapOrSpell;
    }
    public boolean doesHaveCard(String name,int position){
        if(position==1) {
            for (Card card1 : mainDeck) {
                if (card1.getName().equals(name)) return true;
            }
        }
        else {
            for (Card card2 : sideDeck) {
                if (card2.getName().equals(name)) return true;
            }
        }
        return false;

    }

    public void setIsValid(){
        isValid= (mainDeck.size()>=40&&mainDeck.size()<=60
                && sideDeck.size()<=15);
    }
    public boolean isValid(){
        return isValid;
    }
    public String returnStringIsValid(){
        if(isValid)return "valid";
        return "invalid";
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
                name+": main deck "+mainDeck.size()+", side deck "+sideDeck.size()+", "+returnStringIsValid();
    }


}
