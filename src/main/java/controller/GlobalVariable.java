package controller;

import model.Player;

public class GlobalVariable {
    private static Player player;

    public static void setPlayer(Player player) {
        GlobalVariable.player = player;
    }

    public static Player getPlayer() {
        return player;
    }
}
