package model;

import view.GraveView;

import java.util.ArrayList;

public class TrapAction {
    public void setAction(int cardControllerNumber, Board board, MonsterCard monsterCard, ArrayList<MonsterCard> monsters, Deck deck, PlayBoard playBoard, GraveYard graveYard) {
        if (cardControllerNumber == 1) {
            getfromgrave(graveYard, deck);
        }
        if (cardControllerNumber == 2) {
            destroyop(playBoard);
        }
        if (cardControllerNumber == 3) {
            timeseal(board);
        }
        if (cardControllerNumber == 4) {
            destroyattacker(playBoard);
        }
        if (cardControllerNumber == 5) {
            solemn(playBoard, monsterCard, deck);
        }


    }

    //1 call of the haunted
    //2  Torrential Tribute
    //3 time seal
    //4 trap hole
    //5 solemn warning
    public void getfromgrave(GraveYard graveYard, Deck deck) {
        Card card;
        card = graveYard.getLostCards().get(1);
        deck.getMainDeck().add(card);

    }

    public void destroyop(PlayBoard playBoard) {
        playBoard.getAttackerCards().clear();
    }

    public void timeseal(Board board) {
        board.reverseTurn();
    }

    public void destroyattacker(PlayBoard playBoard) {
        playBoard.getAttackerCards().remove(1);
    }

    public void solemn(PlayBoard playBoard, MonsterCard monsterCard, Deck deckop) {
        playBoard.decreaseLifePoint(2000);
        deckop.removeCard(monsterCard, 2);
    }
}
   /* public void destroyAllAttackModes() {

    }

    public void destroyAllVersions() {

    }

    public void destroyOPRitualMonster(int cardControllerNumber) {

    }

    public void destroyAllMonsters(int cardControllerNumber) {

    }

    public void noCardForOpponent(int cardControllerNumber) {

    }

    public void neutralizeATK(int cardControllerNumber) {

    }

    public void stopTheRitual(int cardControllerNumber) {

    }

    public void throwAwayOneAndDestroySpell(int cardControllerNumber) {

    }

    public void retributeACardFromGraveYard(int cardControllerNumber) {

    }

    public void run() {

    }
}

*/
