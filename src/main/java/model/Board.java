package model;

import controller.GlobalVariable;

import java.util.regex.Matcher;

public class Board {

    private Player turn;
    private Phase phase;
    private PlayBoard playBoard1;
    private PlayBoard playBoard2;
    public Board(PlayBoard playBoardPlayer, PlayBoard playBoardOpponent) {
        turn = GlobalVariable.getPlayer();
        playBoard1 = playBoardPlayer;
        playBoard2 = playBoardOpponent;
        phase = Phase.DRAW;
    }


    @Override
    public String toString() {
        String board = "";
        board += getOpponentPlayBoardByTurn().rotateToString();
        board += "\n----------------------\n";
        board += getPlayBoardByTurn().toString();
        board += "\n\n----------------------\n\n";
        return board;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public Phase getPhase() {
        return phase;
    }

    public void changePhase(Phase phase) {
        switch (phase) {
            case DRAW:
                setPhase(Phase.STANDBY);
                break;
            case STANDBY:
                setPhase(Phase.MAIN1);
                break;
            case MAIN1:
                setPhase(Phase.BATTLE);
                break;
            case BATTLE:
                setPhase(Phase.MAIN2);
                break;
            case MAIN2:
                setPhase(Phase.END);
                break;
            case END:
                setPhase(Phase.DRAW);
                break;

        }

    }


    public void reverseTurn() {
        if (playBoard2.getPlayer().getNickname().equals(turn.getNickname())) {
            turn = playBoard1.getPlayer();
        } else turn = playBoard2.getPlayer();

    }

    public PlayBoard getPlayBoardByTurn() {
        if (turn.getNickname().equals(playBoard1.getPlayer().getNickname()))
            return playBoard1;
        else return playBoard2;
    }

    public PlayBoard getOpponentPlayBoardByTurn() {
        if (turn.getNickname().equals(playBoard1.getPlayer().getNickname()))
            return playBoard2;
        else return playBoard1;
    }

    public void addToGrave(Card card, PlayBoard playBoard) {
        playBoard.getGraveyards().add(card);


    }

    public boolean isDeckFinished() {
        return getPlayBoardByTurn().getDeck().getMainDeck().size() == 0;
    }

    public String addToHand(PlayBoard playBoard) {

        if (playBoard.getHand().size() < 6) {
            Card card = playBoard.getDeck().getMainDeck().get(0);
            playBoard.getHand().add(card);
            card.setLocation(Location.HAND);
            playBoard.getDeck().getMainDeck().remove(0);
            return card.getName() + " added to hand";
        }
        else return "your hand is already full";

    }

    public void addToMonster(Card card) {

    }

    public Player getTurn() {
        return turn;
    }

    public void addToSpell(SpellCard card) {
        for (int i = 0; i < getPlayBoardByTurn().getSpellTrap().size(); i++) {
            if (getPlayBoardByTurn().getSpellTrap().get(i) == null)
                getPlayBoardByTurn().getSpellTrap().add(card);
            break;
        }

    }

    public void addToTrap(TrapCard trap){
        for (int i = 0; i < getPlayBoardByTurn().getTrap().size(); i++) {
            if (getPlayBoardByTurn().getTrap().get(i) == null)
                getPlayBoardByTurn().getTrap().add(trap);
            break;
        }
    }

    public void removeToGrave(Card card) {

    }

    public void removeToHand(Card card) {

    }

    public void removeToMonster(Card card) {

    }

    public void removeToSpell(Card card) {

    }

    public void removeToDeck(Card card) {

    }

    // public boolean isRitualCardInHand()
    // {

    // }

    public boolean isSpellZoneFull() {
        return getPlayBoardByTurn().getSpellTrap().size() == 5;

    }

    public boolean isFieldZoneFull() {
        return getPlayBoardByTurn().getFields() != null;
    }
//
//    public boolean wasSommoned(MonsterCard card)
//    {
//
//    }
//
//    public boolean wasAttacked(Card card)
//    {
//
//    }
//
//    public boolean wasChanged(Card Card)
//    {
//
//    }

    public Boolean isHandFull() {
        return getPlayBoardByTurn().getHand().size() == 6;

    }

    public boolean isMonsterZoneFull() {
        return getPlayBoardByTurn().getMonsters().size() == 5;

    }


    public void lowerLifePoint(int damage) {
        getPlayBoardByTurn().decreaseLifePoint(damage);
    }

    public void lowerOpponentLifePoint(int damage) {
        getOpponentPlayBoardByTurn().decreaseLifePoint(damage);
    }


}
