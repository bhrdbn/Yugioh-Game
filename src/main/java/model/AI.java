package model;

import controller.Import;
import controller.ShopController;

import java.util.ArrayList;
import java.util.List;

public class AI extends Player {

    public AI(String nickname, String password, String username) {
        super(nickname, password, username);
        Deck deck=new Deck("AIDeck");
        for (MonsterCard card : Import.getInstance().getAllMonsters()) {
            if(card.getAction()==0)deck.getMainDeck().add(new MonsterCard(card));
        }
        setActivatedDeck(deck);
    }

    @Override
    public void setActivatedDeck(Deck deck) {
        this.activatedDeck=deck;
    }
    // public AI(String nickname, String password, String username) {
 //     super(nickname, password, username);
 // }
 //private Player AIPlayer;
 // private static List<AI> aiPlayers = new ArrayList<>();
 // private int winningPrize;



 // public Player getAIPlayer() {
 //     return AIPlayer;
 // }

 // public void setAIPlayer(Player AIPlayer) {
 //     this.AIPlayer = AIPlayer;
 // }

 // public static void addAIPlayer(List<AI> aiPlayers) {
 //     if (aiPlayers == null)
 //         return;
 //     for (AI aiPlayer : aiPlayers)
 //         addAIPlayer((List<AI>) aiPlayer);
 // }
 // private static void addAIPlayer(AI aiPlayer) {
 //     if (aiPlayer == null)
 //         return;
 //     aiPlayers.add(aiPlayer);
 // }
 // public static List<AI> getAiPlayers() {
 //     return aiPlayers;
 // }

 // public int getWinningPrize() {
 //     return winningPrize;
 // }

}
