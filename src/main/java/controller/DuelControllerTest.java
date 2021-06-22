package controller;

import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class DuelControllerTest {
DuelController duelController = null;

    @Test
    void getInstance() {
DuelController duelController = DuelController.getInstance();
assertEquals(duelController,DuelController.getInstance());
assertNull(duelController);
    }

    @Test
    void newDuel() {
        Player player1 = new Player("tom","hi","mom");
        Player player2 = new Player("max","ss","dd");
        Player player3 = new Player("hh","ee","qq");
        Deck deck1 = new Deck("kok");
        Deck deck2 = new Deck("ktk");
        player2.addDeck(deck2);
        player1.addDeck(deck1);
        assertEquals(duelController.newDuel(1,"hh","dd"),"there is no player with this username");
        assertNotEquals(duelController.newDuel(1,"ss","dd"),"te");
        assertNotEquals(duelController.newDuel(1,"dd","ww"),"there is no  wits username");
        assertNotEquals(duelController.newDuel(1,"dd","qq"),"there is this username");
        assertNotEquals(duelController.newDuel(1,"hh","dd"),"there is this username");
        assertNotEquals(duelController.newDuel(10,"mom","dd"),"there is  username");

    }

    @Test
    void selectOwnMonster() {
        assertNotEquals(duelController.selectOwnMonster(10),"lol");
        assertNull(duelController.selectOwnMonster(1));

    }

    @Test
    void selectOpponentMonster() {
        GlobalVariable globalVariable = null;
        assertEquals(duelController.selectOpponentMonster(10),"selection is invalid");
        assertNotEquals(duelController.selectOpponentMonster(1),"selection is invalid");
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        Deck deck = new Deck("all");
        Card card = new Card("a",1,"k","o",true,2);

        deck.addCard(card,1);
        assertNotNull(duelController.selectOpponentMonster(2),"card");

    }

    @Test
    void selectOwnSpell() {
        assertNotEquals(duelController.selectOwnSpell(10),"selection is invalid");
        assertNotEquals(duelController.selectOwnSpell(1),"selection is invalid");

    }

    @Test
    void selectOpponentSpell() {
        assertNotEquals(duelController.selectOpponentSpell(10),"selection is invalid");
        assertNotEquals(duelController.selectOpponentSpell(1),"selection is invalid");

    }

    @Test
    void selectHand() {
        assertNotEquals(duelController.selectHand(10),"selection is invalid");
        assertNotEquals(duelController.selectHand(1),"selection is invalid");

    }

    @Test
    void selectField() {
        assertNotEquals(duelController.selectField(),"selection is invalid");

    }

    @Test
    void selectOpponentField() {
        assertNotEquals(duelController.selectOpponentField(),"selection is invalid");
    }

    @Test
    void managePhase() {

        assertNull(duelController.managePhase());

        GlobalVariable gl = null;
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        GlobalVariable.setPlayer(p);
        board.setPhase(Phase.DRAW);
        Phase phase = GlobalVariable.getBoard().getPhase();
        assertEquals(duelController.managePhase(),"draw phase");
        board.setPhase(Phase.STANDBY);
        phase = GlobalVariable.getBoard().getPhase();
        assertEquals(duelController.managePhase(),"standby phase");
        board.setPhase(Phase.MAIN1);
        phase = GlobalVariable.getBoard().getPhase();
        assertEquals(duelController.managePhase(),"1st Main phase");

        board.setPhase(Phase.BATTLE);
        phase = GlobalVariable.getBoard().getPhase();
        assertEquals(duelController.managePhase(),"battle phase");
        board.setPhase(Phase.MAIN2);
        phase = GlobalVariable.getBoard().getPhase();
        assertEquals(duelController.managePhase(),"2nd main phase");

        board.setPhase(Phase.END);
        phase = GlobalVariable.getBoard().getPhase();
        assertNotEquals(duelController.managePhase(),"2nd main phase");

    }

    @Test
    void goNextPhase() {
        assertNotNull(duelController.goNextPhase());
    }

    @Test
    void deselect() {
        assertNotNull(duelController.deselect());
    }

    @Test
    void summon() {
        GlobalVariable gl = null;
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        GlobalVariable.setPlayer(p);
        board.getPlayBoardByTurn();
        Card card = new Card("a",1,"k","o",true,2);
        Deck deck = new Deck("all");
        deck.addCard(card,1);
        assertNotNull(duelController.summon());
        board.setPhase(Phase.MAIN1);
        Phase phase = GlobalVariable.getBoard().getPhase();
        assertNotNull(duelController.summon());
    }

    @Test
    void tributeMonsters() throws IOException {
        ArrayList<MonsterCard> monsters = new ArrayList<>();
        MonsterCard monsterCard = new MonsterCard("a",1,"a","b",true,1,2,1,monsters,"w",1,"k",true,"k",monsters);
        monsters.add(monsterCard);
        duelController.tributeMonsters(monsterCard);
        assertNotNull(monsterCard);


    }

    @Test
    void isMonsterForTribute() {
        assertTrue(duelController.isMonsterForTribute("i"));
    }

    @Test
    void isMonserInPosition() {
        assertTrue(duelController.isMonserInPosition(1));

    }

    @Test
    void setMonster() throws IOException {
        ArrayList<MonsterCard> monsters = new ArrayList<>();
    MonsterCard monsterCard = new MonsterCard("a",1,"a","b",true,1,2,1,monsters,"w",1,"k",true,"k",monsters);
    monsters.add(monsterCard);
    assertEquals(duelController.setMonster(monsterCard,"dew"),"no card is selected yet");
        GlobalVariable gl = null;
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        GlobalVariable.setPlayer(p);
        board.getPlayBoardByTurn();
        Card card = new Card("a",1,"k","o",true,2);
        Deck deck = new Deck("all");
        deck.addCard(card,1);
    }

    @Test
    void changePosition() {
        GlobalVariable gl = null;
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        GlobalVariable.setPlayer(p);
        board.getPlayBoardByTurn();
        Card card = new Card("a",1,"k","o",true,2);
        Deck deck = new Deck("all");
        deck.addCard(card,1);
        board.setPhase(Phase.MAIN2);
        Phase phase = GlobalVariable.getBoard().getPhase();
Matcher matcher = null;
        phase = GlobalVariable.getBoard().getPhase();
        assertNotNull(duelController.changePosition(matcher,"s"));
    }

    @Test
    void flipSummon() {
        assertNotNull(duelController.flipSummon(1,"1"));
    }

    @Test
    void attack() throws IOException {
        ArrayList<MonsterCard> monsters = new ArrayList<>();
        MonsterCard monsterCard = new MonsterCard("a",1,"a","b",true,1,2,1,monsters,"w",1,"k",true,"k",monsters);
        monsters.add(monsterCard);
        Matcher matcher = null;
        assertNotNull(duelController.attack(monsterCard,monsterCard));
    }

    @Test
    void setDamage() {
    }

    @Test
    void directAttack() throws IOException {
        ArrayList<MonsterCard> monsters = new ArrayList<>();
        MonsterCard monsterCard = new MonsterCard("a",1,"a","b",true,1,2,1,monsters,"w",1,"k",true,"k",monsters);
        monsters.add(monsterCard);
        Matcher matcher = null;
        assertNotNull(duelController.directAttack(monsterCard,monsterCard));
    }

    @Test
    void activateCard() {
    }

    @Test
    void isConditionMet() {
    }

    @Test
    void setField() {
    }

    @Test
    void setSpellCard() {
    }

    @Test
    void activateCardAndChangeTurn() {
    }

    @Test
    void ritualsummon() {
    }

    @Test
    void isLevelMatched() {
    }

    @Test
    void areThereMatchedLevels() {
    }

    @Test
    void specialSummon() {
    }

    @Test
    void showGrave() {
    }

    @Test
    void surrender() {
    }

    @Test
    void showCard() {
        assertNotEquals(duelController.showCard(),"");
    }
}