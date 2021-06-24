package tests;

import controller.GlobalVariable;
import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalVariableTest {
GlobalVariable gl = null;
    @Test
    void setPlayer() {
        Player player = new Player("ali","koj","lol");
        GlobalVariable.setPlayer(player);
        assertNotNull(GlobalVariable.getPlayer());
    }

    @Test
    void getPlayer() {
        Player player = new Player("ali","koj","lol");
        GlobalVariable.setPlayer(player);
        assertNotNull(GlobalVariable.getPlayer());
    }

    @Test
    void setBoard() {
try {
    Player p = new Player("a","b","c");
    Player op = new Player("m","n","p");
    Deck deck = new Deck("a");
    Card card = new Card("a",1,"a","a",true,1);
    deck.addCard(card,1);
    GlobalVariable.setPlayer(p);
    p.addDeck(deck);
    p.setActivatedDeck(deck);

    PlayBoard pl = new PlayBoard(p);
    PlayBoard Opl = new PlayBoard(op);
    Board board = new Board(pl,Opl);
    GlobalVariable.setBoard(board);
}
    catch (Exception e){ }
        assertNull(GlobalVariable.getBoard());
    }

    @Test
    void getBoard() {
        try {
            Player p = new Player("a","b","c");
            Player op = new Player("m","n","p");
            Deck deck = new Deck("a");
            Card card = new Card("a",1,"a","a",true,1);
            deck.addCard(card,1);
            GlobalVariable.setPlayer(p);
            p.addDeck(deck);
            p.setActivatedDeck(deck);

            PlayBoard pl = new PlayBoard(p);
            PlayBoard Opl = new PlayBoard(op);
            Board board = new Board(pl,Opl);
            GlobalVariable.setBoard(board);
        }
        catch (Exception e){ }
        assertNull(GlobalVariable.getBoard());
    }
}