package servercontroller;

import model.Board;
import model.Player;

import java.util.HashMap;

public class GlobalVariable {
    private static HashMap<String,Player>players=new HashMap<>();
    private static HashMap<Player,Board> boards=new HashMap<>();

    public static HashMap<Player, Board> getBoards() {
        return boards;
    }

    public static HashMap<String, Player> getPlayers() {
        return players;
    }
}
