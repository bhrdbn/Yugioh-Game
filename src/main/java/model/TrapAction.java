package model;

import servercontroller.GlobalVariable;

public class TrapAction {
    public void setAction(int cardControllerNumber, String token) {
        if (cardControllerNumber == 1) {
            getfromgrave(token);
        }
        if (cardControllerNumber == 2) {
            destroyop(token);
        }
        if (cardControllerNumber == 3) {
            timeseal(token);
        }
        if (cardControllerNumber == 4) {
            destroyattacker(token);
        }
        if (cardControllerNumber == 5) {
            solemn(token);
        }


    }

    //1 CallofTheHaunted
    //2  Torrential Tribute
    //3 TimeSeal
    //4 TrapHole
    //5 SolemnWarning
    public void getfromgrave(String token) {
        Card card;
        card = GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().get(1);
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getDeck().getMainDeck().add(card);
        System.out.println("succesfully");

    }

    public void destroyop(String token) {
        GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().clear();
        System.out.println("succesfully");
    }

    public void timeseal(String token) {
        GlobalVariable.getBoards().get(token).reverseTurn();
        System.out.println("succesfully");
    }

    public void destroyattacker(String token) {
        GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getAttackerCards().remove(1);
        System.out.println("succesfully");
    }

    public void solemn( String token) {
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().decreaseLifePoint(2000);
        GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getDeck().removeCard(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getHand().get(1), 2);
        System.out.println("succesfully");
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
