package model;

import java.util.ArrayList;

public class TrapCard extends Card{
    private int number;
    private ArrayList<TrapCard> traps;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<TrapCard> getTraps() {
        return traps;
    }

    public void setTraps(ArrayList<TrapCard> traps) {
        this.traps = traps;
    }
    TrapCard TrapHole = new TrapCard();
    TrapCard MirrorForce = new TrapCard();
    TrapCard MagicCylinder = new TrapCard();
    TrapCard MindCrush = new TrapCard();
    TrapCard TorrentialTribute = new TrapCard();
    TrapCard TimeSeal = new TrapCard();
    TrapCard NegateAttack = new TrapCard();
    TrapCard SolemnWarning = new TrapCard();
    TrapCard MagicJamamer = new TrapCard();
    TrapCard CallOfTheHaunted = new TrapCard();
    TrapCard VanitySEmptiness = new TrapCard();
    TrapCard WallOfRevealingLight = new TrapCard();

}