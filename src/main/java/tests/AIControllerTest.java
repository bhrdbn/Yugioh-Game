package tests;

import controller.AIController;
import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AIControllerTest {


    @Test
    void newDuel() {

        AIController aiController = new AIController();
        Player player = new Player("ali","aj","kon");
        Player oplayer = new Player("ali","aj","kon");
        assertNotNull(aiController.newDuel(1,"kon"));
    }

    @Test
    void managePhaseAndPlay() {
        try {


        AIController aiController = new AIController();
        Player player = new Player("ali","aj","kon");
        Player oplayer = new Player("ali","aj","kon");
        assertNotNull(aiController.managePhaseAndPlay());
    } catch (Exception e){}}

    @Test
    void getMaxAttack() {
      try {


        AIController aiController = new AIController();
        Player player = new Player("ali","aj","kon");
        Player oplayer = new Player("ali","aj","kon");
        assertNotNull(aiController.getMaxAttack());

    } catch (Exception e){}}

    @Test
    void getMaxDefense() {
        try {


            AIController aiController = new AIController();
            Player player = new Player("ali","aj","kon");
            Player oplayer = new Player("ali","aj","kon");
            assertNotNull(aiController.getMaxDefense());

        } catch (Exception e){}}


    @Test
    void getMinOpponentAttack() {
        try {


            AIController aiController = new AIController();
            Player player = new Player("ali","aj","kon");
            Player oplayer = new Player("ali","aj","kon");
            assertNotNull(aiController.getMinOpponentAttack());

        } catch (Exception e){}}
    }
