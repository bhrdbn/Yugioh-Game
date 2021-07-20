package servercontroller;

import model.Board;
import model.Player;

import java.util.HashMap;

public class GlobalVariable {
    private static HashMap<String,Player>players=new HashMap<>();
    private static HashMap<String,Board> boards=new HashMap<>();
    private static HashMap<String,String> waitingList=new HashMap<>();

    public static HashMap<String, Board> getBoards() {
        return boards;
    }

    public static HashMap<String, Player> getPlayers() {
        return players;
    }

    public static HashMap<String, String> getWaitingList() {
        return waitingList;
    }
}
