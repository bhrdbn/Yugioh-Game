package model;

import java.util.ArrayList;

public class GraveYard {
    private ArrayList<Card> lostCards = new ArrayList<>();
    private boolean activeGraveYard=true;

    public ArrayList<Card> getLostCards() {
        return lostCards;
    }

    public void setLostCards(ArrayList<Card> lostCards) {
        this.lostCards = lostCards;
    }

    public boolean isActiveGraveYard() {
        return activeGraveYard;
    }

    public void setActiveGraveYard(boolean activeGraveYard) {
        this.activeGraveYard = activeGraveYard;
    }
   /* public static boolean CardinGraveYard(Card card){
        if (Playboard.getGraveYard().getCardsDeletedFromHand().contains(card)){
            return true;
        }
        return false;
    }*/
}
