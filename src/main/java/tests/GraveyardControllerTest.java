package tests;

import controller.GraveyardController;
import model.GraveYard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraveyardControllerTest {
    private static GraveyardController graveyardController = null;

    @Test
    void getInstance() {
        assertNull(GraveyardController.getInstance());
    }

    @Test
    void showMyGraveyard() {
    assertEquals(graveyardController.showMyGraveyard(),"it's empty");
    }

    @Test
    void showOpponentGraveyard() {
        assertEquals(graveyardController.showOpponentGraveyard(),"it's empty");

    }
}