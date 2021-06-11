package controller;

import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    private static LoginController loginController = null;
    Player player = new Player("ali","pop","sir");
    @Test
    void getInstance() {
        assertEquals(loginController,loginController.getInstance());
        assertNull(loginController.getInstance());
    }

    @Test
    void createNewUser() {

      loginController.createNewUser("ali","pop","sir");
        assertNotNull(player);
    }


    @Test
    void checkUserName() {
        assertFalse(loginController.checkUserName("ali"));
    }

    @Test
    void checkNickName() {
        assertFalse(loginController.checkNickName("mom"));
    }

    @Test
    void checkPassword() {
        assertFalse(loginController.checkPassword(player,"pass"));
    }

    @Test
    void loginUser() {
        assertEquals("Username and password didn't match!",loginController.loginUser("ali","mom"));
    }
}