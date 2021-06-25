package tests;

import controller.LoginController;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    LoginController loginController = LoginController.getInstance();
    Player player = new Player("ali","pop","sir");
    @Test
    void getInstance() {
        assertEquals(loginController,loginController.getInstance());
        assertNotNull(loginController.getInstance());
    }

    @Test
    void createNewUser() {

      loginController.createNewUser("ali","pop","sir");
        assertNotNull(player);
    }


    @Test
    void checkUserName() {
        assertTrue(loginController.checkUserName("ali"));
    }

    @Test
    void checkNickName() {
        assertTrue(loginController.checkNickName("mom"));
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