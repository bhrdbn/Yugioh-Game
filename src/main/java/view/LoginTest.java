package view;

import controller.LoginController;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import controller.*;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    LoginController loginController = new LoginController();
    Login login =new Login();
    @Test
    void run(String s) {
      run("user create --username alimohseni --nickname ali --password alialavi20002");
      int b = Login.b;
        assertEquals(9,b);
    }
    @Test
    void loginUser(Matcher matcher, int flag) {
        loginUser(matcher,0);
        int b = Login.b;
        assertEquals(8,b);
    }

    @Test
    void createUser(Matcher matcher, int flag) {
        createUser(matcher,0);
        int b = Login.b;
        assertEquals(6,b);
    }

}