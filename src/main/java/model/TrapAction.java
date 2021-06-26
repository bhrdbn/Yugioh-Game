package model;

import controller.GlobalVariable;
import view.GraveView;

import java.util.ArrayList;
import java.util.List;

public class TrapAction {
    PlayBoard playBoard = GlobalVariable.getBoard().getPlayBoardByTurn();
    Deck deck = GlobalVariable.getBoard().getPlayBoardByTurn().getDeck();
    Deck deckop = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getDeck();
    PlayBoard OPplayboard = GlobalVariable.getBoard().getOpponentPlayBoardByTurn();
    List<Card> graveYard = GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards();
    Board board = GlobalVariable.getBoard();
    public void setAction(int cardControllerNumber) {
        if (cardControllerNumber == 1) {
            getfromgrave();
        }
        if (cardControllerNumber == 2) {
            destroyop();
        }
        if (cardControllerNumber == 3) {
            timeseal();
        }
        if (cardControllerNumber == 4) {
            destroyattacker();
        }
        if (cardControllerNumber == 5) {
            solemn();
        }


    }

    //1 CallofTheHaunted
    //2  Torrential Tribute
    //3 TimeSeal
    //4 TrapHole
    //5 SolemnWarning
    public void getfromgrave() {
        Card card;
        card = graveYard.get(1);
        deck.getMainDeck().add(card);

    }

    public void destroyop() {
        playBoard.getAttackerCards().clear();
    }

    public void timeseal() {
        board.reverseTurn();
    }

    public void destroyattacker() {
        playBoard.getAttackerCards().remove(1);
    }

    public void solemn( ) {
        playBoard.decreaseLifePoint(2000);
        deckop.removeCard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getHand().get(1), 2);
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
