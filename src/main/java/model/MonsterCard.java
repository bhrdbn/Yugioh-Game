package model;


import java.util.ArrayList;

public class MonsterCard extends Card {
    private int number;
    private int attack;
    private int deffence;
    private ArrayList<MonsterCard> monsters;
    private boolean flip;

    public void setSlotMachine(MonsterCard slotMachine) {
        SlotMachine = slotMachine;
    }

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

    public void setFlip(boolean flip) { //if true then its up
        this.flip = flip;
    }

    MonsterCard BattleOX = new MonsterCard();
    MonsterCard ExploderDragon = new MonsterCard();
    MonsterCard AxeRaider = new MonsterCard();
    MonsterCard YomiShip = new MonsterCard();
    MonsterCard HornImp = new MonsterCard();
    MonsterCard SilverFang = new MonsterCard();
    MonsterCard Suijin = new MonsterCard();
    MonsterCard Fireyarou = new MonsterCard();
    MonsterCard Curtainofthedarkones = new MonsterCard();
    MonsterCard FeraLImp = new MonsterCard();
    MonsterCard Darkmagician = new MonsterCard();
    MonsterCard Wattkid = new MonsterCard();
    MonsterCard Babydragon = new MonsterCard();
    MonsterCard Herooftheeast = new MonsterCard();
    MonsterCard Battlewarrior = new MonsterCard();
    MonsterCard Crawlingdragon = new MonsterCard();
    MonsterCard Flamemanipulator = new MonsterCard();
    MonsterCard BlueEyeswhitedragon = new MonsterCard();
    MonsterCard CrabTurtle = new MonsterCard();
    MonsterCard SkullGuardian = new MonsterCard();
    MonsterCard SlotMachine = new MonsterCard();
    MonsterCard Haniwa = new MonsterCard();
    MonsterCard HeraldofCreation = new MonsterCard();
    MonsterCard ManEaterBug = new MonsterCard();
    MonsterCard MirageDragon = new MonsterCard();
    MonsterCard GateGuardian = new MonsterCard();
    MonsterCard Scanner = new MonsterCard();
    MonsterCard AlexandriteDragon = new MonsterCard();
    MonsterCard Bitron = new MonsterCard();
    MonsterCard TheCalculator = new MonsterCard();
    MonsterCard Marshmallon = new MonsterCard();
    MonsterCard Leotron = new MonsterCard();
    MonsterCard BeastKingBarbaros = new MonsterCard();
    MonsterCard Texchanger = new MonsterCard();
    MonsterCard WarriorDaiGrepher = new MonsterCard();
    MonsterCard DarkBlade = new MonsterCard();
    MonsterCard Wattaildragon = new MonsterCard();
    MonsterCard TerratigertheEmpoweredWarrior = new MonsterCard();
    MonsterCard TheTricky = new MonsterCard();
    MonsterCard SpiralSerpent = new MonsterCard();
    MonsterCard CommandKnight = new MonsterCard();


}