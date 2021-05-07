package controller;
import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class DeckController {
    Player player;

    public String createDeck(String deckName){
        if(player.doesHaveDeckWithThisName(deckName)) return "deck with name <deck name> already exists";
        else {
            Deck deck= new Deck(deckName);
            player.addDeck(deck);
            return "deck created successfully!";
        }
    }
    public String deleteDeck(String deckName){
        if(!player.doesHaveDeckWithThisName(deckName)) return "deck with name "+deckName+" does not exist";
        else {
            player.removeDeck(player.getDeckByName(deckName));
            return "deck deleted successfully";
        }
    }
    public String activateDeck(String deckName){
        if(!player.doesHaveDeckWithThisName(deckName)) return "deck with name "+deckName+" does not exist";
        else{
            player.setActivatedDeck(player.getDeckByName(deckName));
            return "deck activated successfully";
        }
    }
    public String addCardToDeck(String deckName,String cardName,int position){

        if (!player.doesHaveCardWithName(cardName)) return "card with name " + cardName + " does not exist";
        else if (!player.doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if(position==1&&player.getDeckByName(deckName).isMainFull()) {

            return "main deck is full";
        }
        else if(position==0&&player.getDeckByName(deckName).isSideFull()) {

            return "side deck is full";
        }
        else if (player.getDeckByName(deckName).countACardInDeck(Card.getCardByName(cardName)) == 3) {
            return "there are already three cards with name " + cardName + " in deck " + deckName;
        } else {
            player.getDeckByName(deckName).addCard(Card.getCardByName(cardName), position);
            player.getDeckByName(deckName).setIsValid();
            return "card added to deck successfully";
        }

    }
    public String removeCardFromDeck(String deckName,String cardName,int position){


         if (!player.doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if (player.getDeckByName(deckName).doesHaveCard(cardName,position))
            return "card with name " + cardName + " does not exist";

         else {
            player.getDeckByName(deckName).removeCard(Card.getCardByName(cardName), position);
            player.getDeckByName(deckName).setIsValid();
            return "card removed from deck successfully";
        }

    }
    public String showDecks() {
        StringBuilder otherDecks= new StringBuilder("");
        Comparator<Deck> alphabetComparator = Comparator.comparing(Deck::getName);
        ArrayList<Deck> sortedOtherDeck = (ArrayList<Deck>) player.getOtherDecks().stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for(Deck deck:sortedOtherDeck){
            otherDecks.append(deck.toString()).append("\n");
        }
        return "Decks:\n" +
                "Active deck:\n" +
                player.getActivatedDeck()+"\n" +
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
        ArrayList<Card> sortedMonsterCards = (ArrayList<Card>) player.getDeckByName(deckName).getMonsters(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for(Card card:sortedMonsterCards){
            monsterDeck.append(card.toString()).append("\n");
        }
        ArrayList<Card> sortedTrapCards = (ArrayList<Card>) player.getDeckByName(deckName).getTrapOrSpell(position).stream().sorted(alphabetComparator).
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
        for(Card card:player.getCards()){
            cards.append(card.toString()).append("\n");
        }
        return cards.toString();
    }

}

