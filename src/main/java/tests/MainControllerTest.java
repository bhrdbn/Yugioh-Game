package tests;

import controller.GlobalVariable;
import controller.MainController;
import model.Board;
import model.PlayBoard;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {
    private static MainController mainController = null;

    @Test
    void getInstance() {
        assertNull(MainController.getInstance());
    }

    @Test
    void scoreboard() {
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        assertNull(MainController.scoreboard());
    }

    @Test
    void logoutUser() {
        assertEquals(mainController.logoutUser(),"user logged out successfully!");
    }
}