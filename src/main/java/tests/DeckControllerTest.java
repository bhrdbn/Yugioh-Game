package tests;

import controller.DeckController;
import controller.GlobalVariable;
import model.Board;
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
        GlobalVariable.setPlayer(player);

        DeckController deckControllerr = DeckController.getInstance();
        assertEquals(deckControllerr,deckController);
        assertNotEquals(deckControllerr,1);

    }

    @Test
    void createDeck() {
        GlobalVariable.setPlayer(player);
        assertNotEquals(deckController.createDeck("ali"),"deck with name"+ "mohammad" + "already exists");
        assertNotEquals(deckController.createDeck("ali"),"deck with name"+ "pari" + "already exists");
        assertNotNull(deckController.createDeck("ali"));

    }

    @Test
    void deleteDeck() {
        GlobalVariable.setPlayer(player);
        String deckName = "lol";
        Deck deck2 = new Deck("hoda");
        assertNotNull(deckController.deleteDeck("second"));
        assertEquals(deckController.deleteDeck("lol"),"deck with name "+deckName+" does not exist");
        assertNotEquals(deckController.deleteDeck("first"),"deck with name "+deckName+" does not exist");
        assertNotEquals(deckController.deleteDeck("hoda"),"deck with name "+deckName+" does not exist");
    }

    @Test
    void activateDeck() {
        GlobalVariable.setPlayer(player);
        String deckname ="pari";
        Deck deck2 = new Deck("mom");
        assertNotNull(deckController.activateDeck("ali"));
        assertNotNull(deckController.activateDeck("mom"));
    }

    @Test
    void addCardToDeck() {
        GlobalVariable.setPlayer(player);
        String cardName= "azar";
        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        assertEquals(deckController.addCardToDeck("first","azar",1),"card with name " + cardName + " does not exist");
        assertNotNull(deckController.addCardToDeck("D","azar",1));
        assertNotEquals(deckController.addCardToDeck("first","azar",0),"side deck is full");
        assertEquals(deckController.addCardToDeck("first","azar",0),"card with name " + cardName + " does not exist");
        assertEquals(deckController.addCardToDeck("first","azar",1),"card with name " + cardName + " does not exist");

    }

    @Test
    void removeCardFromDeck() {
        GlobalVariable.setPlayer(player);
        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        assertNotNull(deckController.removeCardFromDeck("first","laili",1));
    }

    @Test
    void showDecks() {
        GlobalVariable.setPlayer(player);

        assertNotNull(deckController.showDecks());

    }

    @Test
    void showADeck() {
        GlobalVariable.setPlayer(player);
        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        assertNotNull(deckController.showADeck("first",2));
    }

    @Test
    void showAllCards() {
        GlobalVariable.setPlayer(player);
        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        assertNotNull(deckController.showAllCards());
    }
}