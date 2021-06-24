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

        Deck deck = new Deck("first");
        GlobalVariable.setPlayer(player);

        player.addDeck(deck);
        Card card = new Card("laili",2,"pp","p",true,33);
        player.addToDeck(card);
        player.setActivatedDeck(deck);
        PlayBoard pl = new PlayBoard(player);
        PlayBoard opl = new PlayBoard(oplayer);
        Board board = new Board(pl,opl);
        GlobalVariable.setBoard(board);
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