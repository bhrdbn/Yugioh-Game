package controller;

import model.Board;
import model.PlayBoard;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalVariableTest {
GlobalVariable gl = null;
    @Test
    void setPlayer() {
        Player player = new Player("ali","koj","lol");
        setPlayer();
        assertNotNull(GlobalVariable.getPlayer());
    }

    @Test
    void getPlayer() {
        Player player = new Player("ali","koj","lol");

        assertNotNull(GlobalVariable.getPlayer());
    }

    @Test
    void setBoard() {
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        assertNotNull(GlobalVariable.getBoard());
    }

    @Test
    void getBoard() {
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
    assertNotNull(GlobalVariable.getBoard());

    }
}