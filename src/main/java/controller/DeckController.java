package controller;
import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class DeckController  {
    private static DeckController deckController=null;
    private DeckController(){

    }
    public static DeckController getInstance()
    {
        if (deckController== null)
            deckController = new DeckController();

        return deckController;
    }

    public String createDeck(String deckName){
        if(GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName)) return "deck with name <deck name> already exists";
        else {
            Deck deck= new Deck(deckName);
            GlobalVariable.getPlayer().addDeck(deck);
            return "deck created successfully!";
        }
    }
    public String deleteDeck(String deckName){
        if(!GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName)) return "deck with name "+deckName+" does not exist";
        else {
            GlobalVariable.getPlayer().removeDeck(GlobalVariable.getPlayer().getDeckByName(deckName));
            return "deck deleted successfully";
        }
    }
    public String activateDeck(String deckName){
        if(!GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName)) return "deck with name "+deckName+" does not exist";
        else{
            GlobalVariable.getPlayer().setActivatedDeck(GlobalVariable.getPlayer().getDeckByName(deckName));
            return "deck activated successfully";
        }
    }
    public String addCardToDeck(String deckName,String cardName,int position){

        if (!GlobalVariable.getPlayer().doesHaveCardWithName(cardName)) return "card with name " + cardName + " does not exist";
        else if (!GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if(position==1&&GlobalVariable.getPlayer().getDeckByName(deckName).isMainFull()) {

            return "main deck is full";
        }
        else if(position==0&&GlobalVariable.getPlayer().getDeckByName(deckName).isSideFull()) {

            return "side deck is full";
        }
        else if (GlobalVariable.getPlayer().getDeckByName(deckName).countACardInDeck(Card.getCardByName(cardName)) == 3) {
            return "there are already three cards with name " + cardName + " in deck " + deckName;
        } else {
            GlobalVariable.getPlayer().getDeckByName(deckName).addCard(Card.getCardByName(cardName), position);
            GlobalVariable.getPlayer().getDeckByName(deckName).setIsValid();
            return "card added to deck successfully";
        }

    }
    public String removeCardFromDeck(String deckName,String cardName,int position){


         if (!GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if (GlobalVariable.getPlayer().getDeckByName(deckName).doesHaveCard(cardName,position))
            return "card with name " + cardName + " does not exist";

         else {
             GlobalVariable.getPlayer().getDeckByName(deckName).removeCard(Card.getCardByName(cardName), position);
             GlobalVariable.getPlayer().getDeckByName(deckName).setIsValid();
            return "card removed from deck successfully";
        }

    }
    public String showDecks() {
        StringBuilder otherDecks= new StringBuilder("");
        Comparator<Deck> alphabetComparator = Comparator.comparing(Deck::getName);
        ArrayList<Deck> sortedOtherDeck = (ArrayList<Deck>) GlobalVariable.getPlayer().getOtherDecks().stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for(Deck deck:sortedOtherDeck){
            otherDecks.append(deck.toString()).append("\n");
        }
        return "Decks:\n" +
                "Active deck:\n" +
                GlobalVariable.getPlayer().getActivatedDeck()+"\n" +
                "Other decks:\n" +
                otherDecks;
    }
    public String showADeck(String deckName,int position) {
        StringBuilder monsterDeck= new StringBuilder("");
        StringBuilder trapAndSpellDeck= new StringBuilder("");
        String sideOrMain;
        if(position==1)sideOrMain="Main";
        else sideOrMain="Side";
        Comparator<Card> alphabetComparator = Comparator.comparing(Card::getName);
        ArrayList<Card> sortedMonsterCards = (ArrayList<Card>) GlobalVariable.getPlayer().getDeckByName(deckName).getMonsters(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for(Card card:sortedMonsterCards){
            monsterDeck.append(card.toString()).append("\n");
        }
        ArrayList<Card> sortedTrapCards = (ArrayList<Card>) GlobalVariable.getPlayer().getDeckByName(deckName).getTrapOrSpell(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for(Card card:sortedTrapCards){
            trapAndSpellDeck.append(card.toString()).append("\n");
        }
        return "Deck: "+deckName +" "+
                sideOrMain+" deck:\n" +
                "Monsters:\n" +monsterDeck+

                "Spell and Traps:\n" +
                trapAndSpellDeck;
    }
    public String showAllCards(){
        StringBuilder cards= new StringBuilder("");
        for(Card card:GlobalVariable.getPlayer().getCards()){
            cards.append(card.toString()).append("\n");
        }
        return cards.toString();
    }

}

