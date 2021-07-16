package controller;

import model.Board;
import model.Player;

public class GlobalVariable {
    private static Player player;
    private static Board board;
    private  static String deckName;
    public static void setPlayer(Player player) {
        GlobalVariable.player = player;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setBoard(Board board) {
        GlobalVariable.board = board;
    }

    public static Board getBoard() {
        return board;
    }

    public static void setDeckName(String deckName) {
        GlobalVariable.deckName = deckName;
    }

    public static String getDeckName() {
        return deckName;
    }
}
