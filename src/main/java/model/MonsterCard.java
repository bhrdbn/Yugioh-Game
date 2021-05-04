package model;


import java.util.ArrayList;

public class MonsterCard
{
    private int number;
    private int attack;
    private int deffence;
    private ArrayList<MonsterCard> monsters;
    private boolean flip;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDeffence() {
        return deffence;
    }

    public void setDeffence(int deffence) {
        this.deffence = deffence;
    }

    public ArrayList<MonsterCard> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<MonsterCard> monsters) {
        this.monsters = monsters;
    }

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }
}