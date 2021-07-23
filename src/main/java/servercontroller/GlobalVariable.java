package servercontroller;

import model.Board;
import model.Player;

import java.util.HashMap;

public class GlobalVariable {
    private static HashMap<String,Player>players=new HashMap<>();
    private static HashMap<String,Board> boards=new HashMap<>();
    private static HashMap<String,String> waitingList=new HashMap<>();
    private static HashMap<String,String> p2p=new HashMap<>();
    private static HashMap<String,String> p2board=new HashMap<>();

    public static HashMap<String, String> getP2board() {
        return p2board;
    }

    public static HashMap<String, String> getP2p() {
        return p2p;
    }

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
