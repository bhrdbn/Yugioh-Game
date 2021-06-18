package controller;

import model.Deck;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIController  {
    //ye seri ide benazaram ghavi nist vali hala :)

    Player player;
    private int counter = -1;
    Random random = new Random();
    public AIController(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public String sendRandomRequest(Player opponent){
        counter++;
            switch (counter) {
                case 0:
                    return insertRandomCard();
                case 1:
                    return selectRandomCard();
                case 2:
                    return moveRandomCard();
                case 3:
                    return attackRandomCard(opponent);
                case 4:
                    return "end turn";
                case 5:
                    counter = -1;
                    return "";
            }
        return "chert";
    }
    private String insertRandomCard(){

        ArrayList<Card> handCards = new ArrayList<>(player.getHandCards().values());
        Card randomCard ;
        Collections.shuffle(handCards);

        for (Card handCard : handCards) {
            if (handCard.getAttack()<player.getAttack()) {
                return card;
            }
        }
        return cardNull;
    }
    private String attackRandomCard(Player opponent){
        Card card = player.getSelectedCard();
        if (card == null)
            return "forefeit";
        ArrayList<Card> opponentInBattleCards = new ArrayList<>(opponent.getInBattleCards().keySet());
        if(opponentInBattleCards.size() == 0)
            return "enemy has no card";
        Card opponentCard = opponentInBattleCards.get(random.nextInt(opponentInBattleCards.size()));
        return "attack "+opponentCard.getInBattleCardId();

    }

    private String selectRandomCard(){
        ArrayList<Card> inBattleCards = new ArrayList<>(player.getInBattleCards().keySet());
        if(inBattleCards.size()==0)
            return card;
        Card card = inBattleCards.get(random.nextInt(inBattleCards.size()));
        return card.getInBattleCardId();
    }
}



  */
}
