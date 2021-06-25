package controller;

import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AIControllerTest {
    private static AIController aiController = new AIController();
    GlobalVariable globalVariable = new GlobalVariable();
    Player player = new Player("ali","aj","kon");
    Player oplayer = new Player("ali","aj","kon");

    @Test
    void newDuel() {

        assertNotNull(aiController.newDuel(1,"kon"));
    }

    @Test
    void managePhaseAndPlay() {
    }

    @Test
    void getMaxAttack() {
    }

    @Test
    void getMaxDefense() {
    }

    @Test
    void getMinOpponentAttack() {
    }
}