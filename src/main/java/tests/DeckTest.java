package tests;

import model.Card;
import model.Deck;
import model.SpellCard;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
     ArrayList<Card> mainDeck ;
     ArrayList<Card> sideDeck ;
    Deck deck = new Deck("A");
     @Test
    void getMainDeck() {
        deck.getMainDeck();
        assertNull(mainDeck);
    }

    @Test
    void getSideDeck() {

        deck.getSideDeck();
        assertNull(sideDeck);
    }

    @Test
    void getName() {
         deck.getName();
         assertNull(deck);
    }

    @Test
    void addCard() throws IOException {
        SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");

        deck.addCard(spellCard,1);
        assertNotNull(deck);
    }

    @Test
    void removeCard() throws IOException {
        SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");

        deck.addCard(spellCard,1);
        deck.removeCard(spellCard,1);
        assertNotNull(deck);
     }

    @Test
    void countACardInDeck() throws IOException {
        SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");

        deck.addCard(spellCard,1);
         deck.countACardInDeck(spellCard);
        assertNotNull(deck);
    }

    @Test
    void getMonsters() {
        assertEquals( deck.getMonsters(1),0);
    }

    @Test
    void getTrapOrSpell() {
        assertEquals( deck.getTrapOrSpell(1),0);
    }

    @Test
    void doesHaveCard() {
        assertEquals( deck.doesHaveCard("a",1),false);
     }

    @Test
    void setIsValid() {
        deck.setIsValid();
        assertNotNull(deck);
    }

    @Test
    void isValid() {
        deck.isValid();
        assertNotNull(deck);
     }

    @Test
    void returnStringIsValid() {
        deck.returnStringIsValid();
        assertNotNull(deck);
    }

    @Test
    void isMainFull() {
        deck.isMainFull();
        assertNotNull(deck);
    }

    @Test
    void isSideFull() {
        deck.isSideFull();
        assertNotNull(deck);
    }


}