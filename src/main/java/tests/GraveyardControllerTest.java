package tests;

import controller.GraveyardController;
import model.GraveYard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraveyardControllerTest {
    private static GraveyardController graveyardController = GraveyardController.getInstance();

    @Test
    void getInstance() {
        assertNotNull(GraveyardController.getInstance());
    }

    @Test
    void showMyGraveyard() {
        try {


        assertEquals(graveyardController.showMyGraveyard(),"it's empty");
    }catch (Exception e){}}

    @Test
    void showOpponentGraveyard() {
        try {
            assertEquals(graveyardController.showOpponentGraveyard(), "it's empty");
        }catch (Exception e){}}
    }
