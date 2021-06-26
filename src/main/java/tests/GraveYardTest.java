package tests;

import model.Card;
import model.GraveYard;
import model.SpellCard;
import model.TrapCard;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraveYardTest {
     ArrayList<Card> lostCards = new ArrayList<>();

    GraveYard graveYard = new GraveYard();
    ArrayList<SpellCard> spells = new ArrayList<>();
  ArrayList<TrapCard> traps = new ArrayList<>();

    @Test
    void getLostCards() throws IOException {
        SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");
        lostCards.add(spellCard);
        graveYard.setLostCards(lostCards);
        assertNotNull(graveYard.getLostCards());
    }

    @Test
    void setLostCards() throws IOException {
        SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");
        lostCards.add(spellCard);
        graveYard.setLostCards(lostCards);
        assertNotNull(graveYard.getLostCards());
    }

    @Test
    void isActiveGraveYard() throws IOException {
        SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");
        lostCards.add(spellCard);
        graveYard.setLostCards(lostCards);
        assertNotNull(graveYard.isActiveGraveYard());
    }

    @Test
    void setActiveGraveYard() throws IOException {
        SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");
        lostCards.add(spellCard);
        graveYard.setLostCards(lostCards);
        graveYard.setActiveGraveYard(true);
        assertNotNull(graveYard.isActiveGraveYard());
    }

    @Test
    void showMenu() {
        graveYard.showMenu();
        assertNotNull(graveYard);
    }


    @Test
    void setCards() throws IOException {
        Card spellCard = new Card("a",1,"a","a",true,1);
        lostCards.add(spellCard);
        graveYard.setLostCards(lostCards);
        graveYard.setActiveGraveYard(true);
        GraveYard.setCards(spellCard);
        assertNotNull(GraveYard.getCards());

    }

    @Test
    void getCards() {
        Card spellCard = new Card("a",1,"a","a",true,1);
        lostCards.add(spellCard);
        graveYard.setLostCards(lostCards);
        graveYard.setActiveGraveYard(true);
        GraveYard.setCards(spellCard);
        assertNotNull(GraveYard.getCards());
    }

    @Test
    void getSpells() throws IOException {
        SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");
        lostCards.add(spellCard);
        graveYard.setLostCards(lostCards);
        graveYard.setActiveGraveYard(true);

        assertNotNull(GraveYard.getSpells());
    }

    @Test
    void getTraps() throws IOException {
        TrapCard trapCard = new TrapCard("s",1,"A","s",true,1,"d","s");
        lostCards.add(trapCard);
        graveYard.setLostCards(lostCards);
        graveYard.setActiveGraveYard(true);

        assertNotNull(GraveYard.getTraps());

    }
}