package controller;

import model.Card;
import model.Deck;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DeckControllerTest {
    private static DeckController deckController = DeckController.getInstance();
GlobalVariable globalVariable = new GlobalVariable();
 Player player = new Player("ali","aj","kon");
 Deck deck = new Deck("first");


    @Test
    void getInstance() {
        DeckController deckControllerr = DeckController.getInstance();
        assertEquals(deckControllerr,deckController);
        assertNotEquals(deckControllerr,1);
        assertNull(deckControllerr);
    }

    @Test
    void createDeck() {
        assertNotEquals(deckController.createDeck("ali"),"deck with name"+ "mohammad" + "already exists");
        assertNotEquals(deckController.createDeck("ali"),"deck with name"+ "pari" + "already exists");
        assertNotNull(deckController.createDeck("ali"));

    }

    @Test
    void deleteDeck() {
        String deckName = "lol";
        Deck deck2 = new Deck("hoda");
        assertNotNull(deckController.deleteDeck("second"));
        assertEquals(deckController.deleteDeck("pop"),"deck with name "+deckName+" does not exist");
        assertNotEquals(deckController.deleteDeck("first"),"deck with name "+deckName+" does not exist");
        assertNotEquals(deckController.deleteDeck("hoda"),"deck with name "+deckName+" does not exist");
    }

    @Test
    void activateDeck() {
        String deckname ="pari";
        Deck deck2 = new Deck("mom");
        assertNull(deckController.activateDeck("ali"));
        assertNull(deckController.activateDeck("mom"));
    }

    @Test
    void addCardToDeck() {
        String cardName= "azar";
        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        assertEquals(deckController.addCardToDeck("first","azar",1),"card with name " + cardName + " does not exist");
        assertNull(deckController.addCardToDeck("D","azar",1));
        assertNotEquals(deckController.addCardToDeck("first","azar",0),"side deck is full");
        assertEquals(deckController.addCardToDeck("first","azar",0),"card with name " + cardName + " does not exist");
        assertEquals(deckController.addCardToDeck("first","azar",1),"card with name " + cardName + " does not exist");

    }

    @Test
    void removeCardFromDeck() {
        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        assertNotNull(deckController.removeCardFromDeck("first","laili",1));
    }

    @Test
    void showDecks() {
        assertNotNull(deckController.showADeck("first",2));

    }

    @Test
    void showADeck() {
        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        assertNotNull(deckController.showADeck("first",2));
    }

    @Test
    void showAllCards() {
        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        assertEquals(deckController.showAllCards(),card.toString());
    }
}