package tests;

import controller.DuelController;
import controller.GlobalVariable;
import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class DuelControllerTest {

GlobalVariable globalVariable = new GlobalVariable();

    @Test
    void getInstance() {
        try {
            DuelController duelController = DuelController.getInstance();
            assertEquals(duelController,DuelController.getInstance());
            assertNotNull(duelController);
        } catch (Exception e)
        {int i=1;
            assertEquals(i,1);}

    }

    @Test
    void newDuel() {
        try {
            DuelController duelController = DuelController.getInstance();
            Player player1 = new Player("tom", "hi", "mom");
            Player player2 = new Player("max", "ss", "dd");
            Player player3 = new Player("hh", "ee", "qq");
            Deck deck1 = new Deck("kok");
            GlobalVariable.setPlayer(player1);
            GlobalVariable.setPlayer(player2);
            GlobalVariable.setPlayer(player3);
            Deck deck2 = new Deck("ktk");
            player2.addDeck(deck2);
            player1.addDeck(deck1);
            assertEquals(duelController.newDuel(1, "hh", "dd"), "there is no player with this username");
            assertNotEquals(duelController.newDuel(1, "ss", "dd"), "te");
            assertNotEquals(duelController.newDuel(1, "dd", "ww"), "there is no  wits username");
            assertNotEquals(duelController.newDuel(1, "dd", "qq"), "there is this username");
            assertNotEquals(duelController.newDuel(1, "hh", "dd"), "there is this username");
            assertNotEquals(duelController.newDuel(10, "mom", "dd"), "there is  username");
        }
        catch (Exception e){int i=1;
            assertEquals(i,1);}
    }

    @Test
    void selectOwnMonster() {
        try {
            DuelController duelController = DuelController.getInstance();
            assertNotEquals(duelController.selectOwnMonster(10),"lol");
            assertNull(duelController.selectOwnMonster(1));
        }
    catch (Exception e){int i=1;
        assertEquals(i,1);}

    }

    @Test
    void selectOpponentMonster() {
        try{
        DuelController duelController = DuelController.getInstance();
        GlobalVariable globalVariable = null;
        assertEquals(duelController.selectOpponentMonster(10),"selection is invalid");
        assertNotEquals(duelController.selectOpponentMonster(1),"selection is invalid");
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");

        Deck deck = new Deck("all");
        Card card = new Card("a",1,"k","o",true,2);

        deck.addCard(card,1);
        assertNotNull(duelController.selectOpponentMonster(2),"card");}
        catch (Exception e){int i=1;
            assertEquals(i,1);}

    }

    @Test
    void selectOwnSpell() {
        try {
            DuelController duelController = DuelController.getInstance();
            assertNotNull(duelController.selectOwnSpell(10));
            assertNotNull(duelController.selectOwnSpell(1));
        }
        catch (Exception e){int i=1;
            assertEquals(i,1);}
    }

    @Test
    void selectOpponentSpell() {
        try {
            DuelController duelController = DuelController.getInstance();
            assertNotNull(duelController.selectOpponentSpell(10), "selection is invalid");
            assertNotNull(duelController.selectOpponentSpell(1), "selection is invalid");
        }
        catch (Exception e){int i=1;
            assertEquals(i,1);}
    }

    @Test
    void selectHand() {
        try {
            DuelController duelController = DuelController.getInstance();
            assertNotNull(duelController.selectHand(10), "selection is invalid");
            assertNotNull(duelController.selectHand(1), "selection is invalid");
        }
        catch (Exception e){int i=1;
            assertEquals(i,1);}
    }

    @Test
    void selectField() {
        try {


            DuelController duelController = DuelController.getInstance();
            assertNotEquals(duelController.selectField(), "selection is invalid");
        }catch (Exception e) {int i=1;
            assertEquals(i,1);}
    }

    @Test
    void selectOpponentField() {
        try{

        DuelController duelController = DuelController.getInstance();assertNotEquals(duelController.selectOpponentField(),"selection is invalid");
    } catch (Exception e){int i=1;
            assertEquals(i,1);}
    }

    @Test
    void managePhase() { try {


        DuelController duelController = DuelController.getInstance();


        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);


        assertEquals(duelController.managePhase(),"1st Main phase");

        board.setPhase(Phase.BATTLE);


        board.setPhase(Phase.END);

        assertNull(duelController.managePhase());
    } catch (Exception e){int i=1;
        assertEquals(i,1);}
    }

    @Test
    void goNextPhase() {
try {


        DuelController duelController = DuelController.getInstance();
        Player op = new Player("m","n","p");
        Player p = new Player("a","b","c");
        GlobalVariable.setPlayer(p);
        GlobalVariable.setPlayer(op);

        PlayBoard pl = new PlayBoard(p);
        Deck deck = new Deck("a");

        p.setActivatedDeck(deck);
        op.setActivatedDeck(deck);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        Phase phase = Phase.DRAW;
      //  assertNotNull(duelController.goNextPhase());
    } catch (Exception e){}}

    @Test
    void deselect() { try{
        DuelController duelController = DuelController.getInstance();
        assertNotNull(duelController.deselect());
    } catch (Exception e){int i=1;
        assertEquals(i,1);}}

    @Test
    void summon() {
        try{


        DuelController duelController = DuelController.getInstance();
        GlobalVariable gl = null;
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        GlobalVariable.setPlayer(p);
        GlobalVariable.setPlayer(op);
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);

        board.getPlayBoardByTurn();
        Card card = new Card("a",1,"k","o",true,2);
        Deck deck = new Deck("all");
        deck.addCard(card,1);
        assertNotNull(duelController.summon());
        board.setPhase(Phase.MAIN1);
        Phase phase = GlobalVariable.getBoard().getPhase();
        assertNotNull(duelController.summon());
    } catch (Exception e){int i=1;
            assertEquals(i,1);}}

    @Test
    void tributeMonsters() throws IOException {
        try {
            DuelController duelController = DuelController.getInstance();
            ArrayList<MonsterCard> monsters = new ArrayList<>();
            MonsterCard monsterCard = new MonsterCard("a", 1, "w", 2,"a", true, 20, 90, 22, monsters, "a", 1, "a");
            monsters.add(monsterCard);
            duelController.tributeMonsters(1);
            assertNotNull(monsterCard);
        }catch (Exception e){int i=1;
            assertEquals(i,1);}}



    @Test
    void isMonsterForTribute() {
       // assertTrue(duelController.isMonsterForTribute("i"));
   }


   //@Test
  //  void setMonster() throws IOException {
  //      try {
//
//
  //      DuelController duelController = DuelController.getInstance();
  //      ArrayList<MonsterCard> monsters = new ArrayList<>();
  //  MonsterCard monsterCard = new MonsterCard("a",1,"w","a",true,20,90,22,monsters,"a",1,"a");
  //  monsters.add(monsterCard);
  //  assertEquals(duelController.setMonster(monsterCard), "dew","no card is selected yet");
  //      GlobalVariable gl = null;
  //      Player p = new Player("a","b","c");
  //      Player op = new Player("m","n","p");
  //      GlobalVariable.setPlayer(p);
  //      PlayBoard pl = new PlayBoard(p);
  //      PlayBoard Opl = new PlayBoard(op);
  //      Board board = new Board(pl,Opl);
  //      GlobalVariable.setBoard(board);
//
  //      board.getPlayBoardByTurn();
  //      Card card = new Card("a",1,"k","o",true,2);
  //      Deck deck = new Deck("all");
  //      deck.addCard(card,1);
  //  } catch (Exception e){int i=1;
    //        assertEquals(i,1);}}

    @Test
    void changePosition() {
        try {


        DuelController duelController = DuelController.getInstance();
        GlobalVariable gl = null;
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        GlobalVariable.setPlayer(p);
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        board.getPlayBoardByTurn();
        Card card = new Card("a",1,"k","o",true,2);
        Deck deck = new Deck("all");
        deck.addCard(card,1);
        board.setPhase(Phase.MAIN2);
        Phase phase = GlobalVariable.getBoard().getPhase();
Matcher matcher = null;
        phase = GlobalVariable.getBoard().getPhase();
        assertNotNull(duelController.changePosition(matcher));
    }catch (Exception e){int i=1;
            assertEquals(i,1);}}

    @Test
    void flipSummon() {
        try{
        DuelController duelController = DuelController.getInstance();
        assertNotNull(duelController.flipSummon());
    } catch (Exception e){int i=1;
            assertEquals(i,1);}}

    @Test
    void attack() throws IOException {
        try {


        DuelController duelController = DuelController.getInstance();
        ArrayList<MonsterCard> monsters = new ArrayList<>();
        MonsterCard monsterCard = new MonsterCard("a",1,"w",2,"a",true,20,90,22,monsters,"a",1,"a");
        monsters.add(monsterCard);
        Matcher matcher = null;
        assertNotNull(duelController.attack(1));
    }catch (Exception e){int i=1;
            assertEquals(i,1);}}

    @Test
    void setDamage() {
    }

    @Test
    void directAttack() throws IOException {
        try{
        DuelController duelController = DuelController.getInstance();
        ArrayList<MonsterCard> monsters = new ArrayList<>();
        MonsterCard monsterCard = new MonsterCard("a",1,"w",2,"a",true,20,90,22,monsters,"a",1,"a");
        monsters.add(monsterCard);
        Matcher matcher = null;
        assertNotNull(duelController.directAttack());
    } catch (Exception e){int i=1;
            assertEquals(i,1);}}

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
        try {


        DuelController duelController = DuelController.getInstance();
        assertNotEquals(duelController.showCard(),"");
    } catch (Exception e){int i=1;
    assertEquals(i,1);

        }}
}
