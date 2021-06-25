package tests;

import model.CheatSheet;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheatSheetTest {

    @Test
    void getCode() {
        CheatSheet cheatSheet = new CheatSheet("a","a","a");
        cheatSheet.setCode(1);
        assertEquals(cheatSheet.getCode(),1);
    }

    @Test
    void setCode() {
        CheatSheet cheatSheet = new CheatSheet("a","a","a");
        cheatSheet.setCode(1);
        assertEquals(cheatSheet.getCode(),1);
    }

    @Test
    void cheet() {
        Player player = new Player("a","a","a");
        CheatSheet cheatSheet = new CheatSheet("a","a","a");
        cheatSheet.cheet(1);
        assertNotEquals(player.getMoney(),1);
        cheatSheet.cheet(2);
        assertNotEquals(player.getMoney(),1);
        cheatSheet.cheet(3);
        assertNotEquals(player.getMoney(),1);
       cheatSheet.cheet(4);
        assertNotEquals(player.getScore(),1);
        cheatSheet.cheet(5);
        assertNotEquals(player.getScore(),1);
        assertNotEquals(player.getMoney(),1);
        cheatSheet.cheet(6);
        assertNotEquals(player.getMoney(),1);
    }
}