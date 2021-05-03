package controller;
import model.*;
import java.util.regex.Matcher;

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

        if (!Card.doesCardExist(cardName)) return "card with name " + cardName + " does not exist";
        else if (!player.doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if(position==1&&player.getDeckByName(deckName).isMainFull()) {

            return "main deck is full";
        }
        else if(position==0&&player.getDeckByName(deckName).isSideFull()) {

            return "main deck is full";
        }
        else if (player.getDeckByName(deckName).countACardInDeck(Card.getCardByName(cardName)) == 3) {
            return "there are already three cards with name " + cardName + " in deck " + deckName;
        } else {
            player.getDeckByName(deckName).addCard(Card.getCardByName(cardName), position);
            player.getDeckByName(deckName).setIsValid();
            return "card added to deck successfully";
        }

    }
    public String showDecks(){
        return "Decks:\n" +
                "Active deck:\n" +
                player.getActivatedDeck()+"\n" +
                "Other decks:\n" +
                "<other decks>";
    }

}

