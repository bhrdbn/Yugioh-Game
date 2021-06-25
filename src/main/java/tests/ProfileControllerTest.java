package tests;

import controller.GlobalVariable;
import controller.ProfileController;
import model.Board;
import model.PlayBoard;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileControllerTest {
    private static ProfileController profileController=null;
    @Test
    void getInstance() {
        assertNull(ProfileController.getInstance());
    }

    @Test
    void changeNickName() {
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        profileController.changeNickName("ali");
        assertNotNull(profileController.checkNickName("alo"));

    }

    @Test
    void changePassword() {
        Player p = new Player("a","b","c");
   assertEquals(profileController.changePassword("b"),"please enter a new password");
        assertNull(profileController.changePassword("c"));


    }

    @Test
    void checkNickName() {
        Player p = new Player("a","b","c");
assertTrue(profileController.checkNickName("b"));
        assertFalse(profileController.checkNickName("a"));
    }

    @Test
    void checkPassword() {
        Player p = new Player("a","b","c");
        assertTrue(profileController.checkPassword("b","b"));
        assertFalse(profileController.checkPassword("b","d"));
    }
}