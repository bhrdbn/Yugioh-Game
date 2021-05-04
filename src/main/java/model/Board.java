package model;

import java.util.regex.Matcher;

public class Board {
    private Player player1;
    private Player turn;
    private String phase;
    private PlayBoard playboard1;
    private Player player2;
    private PlayBoard playboard2;

/*
    public Card selecFromGrave()
    {

    }

    public MonsterCard selectMonster(Matcher matcheer)
    {

    }

    public Card selectSpell(Matcher matcher)
    {

    }

    public Card selectFromHand(Matcher matcher)
    {

    }*/

    @Override
    public String toString() {
        return "Board{" +
                "player1=" + player1 +
                ", turn=" + turn +
                ", phase='" + phase + '\'' +
                ", playboard1=" + playboard1 +
                ", player2=" + player2 +
                ", playboard2=" + playboard2 +
                '}';
    }

    public void changePhase(String phase)
    {

    }

    public void reverseTurn()
    {

    }

    public void addToGrave(Card card)
    {

    }

    public void reverseBoard(String turn)
    {

    }

    public void addToHand(Card card)
    {

    }

    public void addToMonster(Card card)
    {

    }

    public void addToSpell(Card card)
    {

    }

    public void removeToGrave(Card card)
    {

    }

    public void removeToHand(Card card)
    {

    }

    public void removeToMonster(Card card)
    {

    }

    public void removeToSpell(Card card)
    {

    }

    public void removeToDeck(Card card)
    {

    }
/*
    public boolean isRitualCardInHand()
    {

    }

    public boolean isSpellZoneFull()
    {

    }

    public boolean wasSommoned(MonsterCard card)
    {

    }

    public boolean wasAttacked(Card card)
    {

    }

    public boolean wasChanged(Card Card)
    {

    }

    public Boolean isHandFull()
    {

    }

    public boolean isMonsterZoneFull()
    {

    }
    */

}
