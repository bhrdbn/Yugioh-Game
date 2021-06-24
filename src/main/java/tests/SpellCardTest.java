package tests;

import model.SpellCard;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static model.TypeOfSpellCard.EQUIP;
import static org.junit.jupiter.api.Assertions.*;

class SpellCardTest {
SpellCard spellCard = new SpellCard("s","s",1,"s","s",true,1,"s");
    ArrayList<SpellCard> spellcards = new ArrayList<>();

    SpellCardTest() throws IOException {
    }

    @Test
    void getNumber() {
        assertEquals(spellCard.getNumber(),1);
    }

    @Test
    void setNumber() {
        spellCard.setNumber(1);
        assertEquals(spellCard.getNumber(),1);

    }

    @Test
    void getSpells() {
    assertNull(spellCard.getSpells());
    }

    @Test
    void setSpells() {
        spellCard.setSpells(spellcards);
   assertEquals(spellCard.getSpells(),spellcards);
    }

    @Test
    void setSpellType() {
        spellCard.setSpellType(EQUIP);
        assertEquals(spellCard.getSpellType().toString(),"EQUIP");

    }

    @Test
    void getSpellType() {
        spellCard.setSpellType(EQUIP);
        assertEquals(spellCard.getSpellType().toString(),"EQUIP");
    }
}