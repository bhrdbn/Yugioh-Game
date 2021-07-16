package tests;

import controller.ShopController;
import model.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopControllerTest {
 private ShopController shopController = ShopController.getInstance();
    @Test
    void getInstance() {
        assertNotNull(ShopController.getInstance());
    }

   // @Test
   // void buy() {
   //     assertEquals(shopController.buy("card"),"there is no card with this name");
   // }

    @Test
    void showAll() {
        Card card = new Card("laili",2,"pp","p",true,33);
    shopController.showAll();
    assertNotNull(card);
    }
}