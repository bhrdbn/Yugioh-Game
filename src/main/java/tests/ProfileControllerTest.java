package tests;

import controller.GlobalVariable;
import controller.ProfileController;
import model.Board;
import model.PlayBoard;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileControllerTest {
    private static ProfileController profileController=ProfileController.getInstance();
    @Test
    void getInstance() {
        assertNotNull(ProfileController.getInstance());
    }

    @Test
    void changeNickName() {
        try {


            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            PlayBoard pl = new PlayBoard(p);
            PlayBoard Opl = new PlayBoard(op);
            Board board = new Board(pl, Opl);
            GlobalVariable.setBoard(board);
            profileController.changeNickName("ali");
            assertNotNull(profileController.checkNickName("alo"));
        }
        catch (Exception e){}
    }

    @Test
    void changePassword() {
        try {


            Player p = new Player("a", "b", "c");
            assertNotEquals(profileController.changePassword("b"), "please enter a new password");
            assertNull(profileController.changePassword("c"));
        }catch (Exception e ){}

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
        assertTrue(profileController.checkPassword("b","d"));
    }
}