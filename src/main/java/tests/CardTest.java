package tests;

import model.Card;
import model.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
Card card = new Card("a",1,"a","a",true,1);

    @Test
    void setName() {
        card.setName("a");
assertEquals(card.getName(),"a");
    }

    @Test
    void getNumber() {
        assertEquals(card.getNumber(),1);
    }

    @Test
    void setNumber() {
        card.setNumber(1);
        assertEquals(card.getNumber(),1);
    }

    @Test
    void getType() {
        card.setType("a");
        assertEquals(card.getType(),"a");
    }

    @Test
    void setType() {
        card.setType("a");
        assertEquals(card.getType(),"a");
    }

    @Test
    void getCardDescription() {
        card.setCardDescription("a");
        assertEquals(card.getCardDescription(),"a");
    }

    @Test
    void setCardDescription() {
        card.setCardDescription("a");
        assertEquals(card.getCardDescription(),"a");
    }

    @Test
    void isSide() {
        card.setSide(true);
        assertEquals(card.isSide(),true);
    }

    @Test
    void setSide() {
        card.setSide(true);
        assertEquals(card.isSide(),true);
    }

    @Test
    void getPrice() {
        card.setPrice(1);
        assertEquals(card.getPrice(),1);
    }

    @Test
    void setPrice() {
        card.setPrice(1);
        assertEquals(card.getPrice(),1);
    }

    @Test
    void getName() {
        card.setName("a");
        assertEquals(card.getName(),"a");
    }

    @Test
    void setLocation() {
        card.setLocation(Location.DECK);
        assertEquals(card.getLocation(),Location.DECK);
    }

    @Test
    void getLocation() {
        card.setLocation(Location.DECK);
        assertEquals(card.getLocation(),Location.DECK);
    }

}