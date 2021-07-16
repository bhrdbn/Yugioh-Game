package tests;

import model.TrapCard;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrapCardTest {
    ArrayList<TrapCard> trapCards = new ArrayList<>();
TrapCard trapCard = new TrapCard("ali",1,"a","b",true,1,"ss","a");

    TrapCardTest() throws IOException {
    }

    @Test
    void getNumber() {

        assertEquals(trapCard.getNumber(),1);

    }

    @Test
    void setNumber() {
    trapCard.setNumber(1);
    assertEquals(trapCard.getNumber(),1);
    }

    @Test
    void getTraps() {
        trapCards.add(trapCard);
        trapCard.setTraps(trapCards);
        assertNotNull(trapCard.getTraps());
    }

    @Test
    void setTraps() {

        trapCards.add(trapCard);
trapCard.setTraps(trapCards);
        assertNotNull(trapCard.getTraps());
    }
}