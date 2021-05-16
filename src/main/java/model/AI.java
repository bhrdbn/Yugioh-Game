package model;

import java.util.ArrayList;
import java.util.List;

public class AI extends Player {
    public AI(String nickname, String password, String username) {
        super(nickname, password, username);
    }
/*    private Player AIPlayer;
    private static List<AI> aiPlayers = new ArrayList<>();
    private int winningPrize;

    public AI(String nickname, int score, int money, ArrayList<Deck> decks, ArrayList<Deck> otherDecks, Deck activatedDeck, String password, String username, ArrayList<Card> cards, Player AIPlayer, int winningPrize) {
        super(nickname, score, money, decks, otherDecks, activatedDeck, password, username, cards);
        this.AIPlayer = AIPlayer;
        this.winningPrize = winningPrize;
    }

    public Player getAIPlayer() {
        return AIPlayer;
    }

    public void setAIPlayer(Player AIPlayer) {
        this.AIPlayer = AIPlayer;
    }

    public static void addAIPlayer(List<AI> aiPlayers) {
        if (aiPlayers == null)
            return;
        for (AI aiPlayer : aiPlayers)
            addAIPlayer((List<AI>) aiPlayer);
    }
    private static void addAIPlayer(AI aiPlayer) {
        if (aiPlayer == null)
            return;
        aiPlayers.add(aiPlayer);
    }
    public static List<AI> getAiPlayers() {
        return aiPlayers;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
*/

}
