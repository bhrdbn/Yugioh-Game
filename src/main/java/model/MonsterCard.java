package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

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
    public static void read() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("D://Monster.csv"));
        String line = null;
        HashMap<String, String> mapMonster = new HashMap<String, String>();

        while ((line = br.readLine()) != null) {
            String str[] = line.split(",");
            for (int i = 1; i < str.length; i++) {
                String arr[] = str[i].split(":");
                mapMonster.put(arr[0], arr[1]);
            }
        }
    }
}