package model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonsterCard extends Card {

    private int attack;
    private int defence;
    private ArrayList<MonsterCard> monsters;
private String attribute;
private int level;
private String monsterType;

    public MonsterCard(String name, int number, String type, String cardDescription, ArrayList<Integer> cardController, boolean side, int price, int attack, int defence, ArrayList<MonsterCard> monsters, String attribute, int level, String monsterType) throws IOException {
        super(name, number, type, cardDescription, cardController, side, price);
        this.attack = attack;
        this.defence = defence;
        this.monsters = monsters;
        this.attribute = attribute;
        this.level = level;
        this.monsterType = monsterType;
    }
String json = new String(Files.readAllBytes(Paths.get("D://Monster.json")));
     ArrayList<MonsterCard> monstersOBJECT  = new Gson().fromJson(json,new TypeToken<List<MonsterCard>>(){}.getType());
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
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

}