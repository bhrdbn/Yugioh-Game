package model;


import java.util.ArrayList;

public class MonsterCard extends Card {

    private int attack;
    private int deffence;
    private ArrayList<MonsterCard> monsters;
private String attribute;
private int level;
private String monsterType;

    public MonsterCard(String name, int number, String type, String cardDescription, ArrayList<Integer> cardController, boolean side, int price, int attack, int deffence, ArrayList<MonsterCard> monsters, String attribute, int level, String monsterType) {
        super(name, number, type, cardDescription, cardController, side, price);
        this.attack = attack;
        this.deffence = deffence;
        this.monsters = monsters;
        this.attribute = attribute;
        this.level = level;
        this.monsterType = monsterType;
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

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }


    MonsterCard BattleOX = new MonsterCard("battle ox",3,"Normal","A monster with tremendous power, it destroys enemies with a swing of its axe.",cardController,side,2900,1700,1000,monsters,"EARHT",4,"Beast-Warrior");
    MonsterCard ExploderDragon = new MonsterCard("Exploder Dragon",3,"Effect","If this card is destroyed by battle and sent to the Graveyard: Destroy the monster that destroyed it. Neither player takes any battle damage from attacks involving this attacking card.",cardController,side,1000,1000,0,monsters,"EARTH",3,"Dragon");
    MonsterCard AxeRaider = new MonsterCard("Axe Raider",3,"Normal","An axe-wielding monster of tremendous strength and agility.",cardController,side,3100,1700,1150,monsters,"EARHT",4,"Warrior");
    MonsterCard YomiShip = new MonsterCard("Yomi Ship",3,"Effect","If this card is destroyed by battle and sent to the GY: Destroy the monster that destroyed this card.",cardController,side,1700,800,1400,monsters,"WATER",3,"Aqua");
    MonsterCard HornImp = new MonsterCard("Horn Imp",3,"normal","A small fiend that dwells in the dark, its single horn makes it a formidable opponent.",cardController,side,2500,1300,1000,monsters,"DARK",4,"Fiend");
    MonsterCard SilverFang = new MonsterCard("Silver Fang",3,"Normal","A snow wolf that's beautiful to the eye, but absolutely vicious in battle.",cardController,side,1700,1200,800,monsters,"EARTH",3,"Beast");
    MonsterCard Suijin = new MonsterCard("Suijin",3,"Effect","During damage calculation in your opponent's turn, if this card is being attacked: You can target the attacking monster; make that target's ATK 0 during damage calculation only (this is a Quick Effect). This effect can only be used once while this card is face-up on the field.",cardController,side,8700,2500,2400,monsters,"WATER",7,"Aqua");
    MonsterCard Fireyarou = new MonsterCard("Fireyarou",3,"Normal","A malevolent creature wrapped in flames that attacks enemies with intense fire.",cardController,side,2500,1300,1000,monsters,"FIRE",4,"Pyro");
    MonsterCard Curtainofthedarkones = new MonsterCard("Curtain of the dark ones",3,"Normal","A curtain that a spellcaster made, it is said to raise a dark power.",cardController,side,700,600,500,monsters,"DARK",2,"Normal");
    MonsterCard FeraLImp = new MonsterCard("Feral Imp",3,"Normal","A playful little fiend that lurks in the dark, waiting to attack an unwary enemy.",cardController,side,2800,1300,1400,monsters,"DARK",4,"Fiend");
    MonsterCard Darkmagician = new MonsterCard("Dark magician",3,"Normal","The ultimate wizard in terms of attack and defense.",cardController,side,8300,2500,2100,monsters,"DARK",7,"Spellcaster");
    MonsterCard Wattkid = new MonsterCard("Wattkid",number,"Normal","A creature that electrocutes opponents with bolts of lightning.",cardController,side,1300,1000,500,monsters,"LIGHT",3,"Thunder");
    MonsterCard Babydragon = new MonsterCard("Baby dragon",number,"Normal","Much more than just a child, this dragon is gifted with untapped power.",cardController,side,1600,1200,700,monsters,"WIND",3,"Dragon");
    MonsterCard Herooftheeast = new MonsterCard("Hero of the east",number,"Normal","Feel da strength ah dis sword-swinging samurai from da Far East.",cardController,side,1700,1100,1000,monsters,"EARTH",3,"Warrior");
    MonsterCard Battlewarrior = new MonsterCard("Battle warrior",number,"Normal","A warrior that fights with his bare hands!!!",cardController,side,1300,700,1000,monsters,"EARTH",3,"Warrior");
    MonsterCard Crawlingdragon = new MonsterCard("Crawling dragon",number,"Normal","This weakened dragon can no longer fly, but is still a deadly force to be reckoned with.",cardController,side,3900,1600,1400,monsters,"EARTH",5,"Dragon");
    MonsterCard Flamemanipulator = new MonsterCard("Flame manipulator",number,"Normal","This Spellcaster attacks enemies with fire-related spells such as Sea of Flames and Wall of Fire.",cardController,side,1500,900,1000,monsters,"FIRE",3,"Spellcaster");
    MonsterCard BlueEyeswhitedragon = new MonsterCard("Blue-Eyes white dragon",number,"Normal","This legendary dragon is a powerful engine of destruction. Virtually invincible, very few have faced this awesome creature and lived to tell the tale.",cardController,side,11300,300,2500,monsters,"LIGHT",8,"Dragon");
   /* MonsterCard CrabTurtle = new MonsterCard("");
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

*/
}