package model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.GlobalVariable;

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
        private boolean isAttack = false;
        private ArrayList<MonsterCard> monsters;
    private String attribute;
    private int level;
    private String monsterType;

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setAttack(boolean attack) {
        isAttack = attack;
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

    public MonsterCard(String name, int number, String type, String cardDescription, ArrayList<Integer> cardController, boolean side, int price, int attack, int defence, ArrayList<MonsterCard> monsters, String attribute, int level, String monsterType) throws IOException {
            super(name, number, type, cardDescription, cardController, side, price);
            this.attack = attack;
            this.defence = defence;
            this.monsters = monsters;
            this.attribute = attribute;
            this.level = level;
            this.monsterType = monsterType;
        }


        public boolean isAttack() {
            return isAttack;
        }

        String json = new String(Files.readAllBytes(Paths.get("D://Monster.json")));
         ArrayList<MonsterCard> monstersOBJECT  = new Gson().fromJson(json,new TypeToken<List<MonsterCard>>(){}.getType());
        public int getAttack() {
            return attack;

        }

        public ArrayList<MonsterCard> getMonstersOBJECT() {

            return monstersOBJECT;
        }

        public void setMonstersOBJECT(ArrayList<MonsterCard> monstersOBJECT) {
            this.monstersOBJECT = monstersOBJECT;
            for(int i = 0; i <45 ; i++)
            {
                MonsterCard monster =(monstersOBJECT.get(i));
                monster.setName(monstersOBJECT.get(i).name);
                monster.setType(monstersOBJECT.get(i).type);
                monster.setSide(monstersOBJECT.get(i).side);
                monster.setPrice(monstersOBJECT.get(i).price);
                monster.setCardDescription(monstersOBJECT.get(i).cardDescription);
                monster.setAttack(monstersOBJECT.get(i).attack);
                monster.setDefence(monstersOBJECT.get(i).defence);
                monster.setAttribute(monstersOBJECT.get(i).attribute);

            }
        }

        //emtiazi
        //csv
        /*
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

    public void setIsAttack(){
        isAttack = true;
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

    private void lowerAttack(MonsterCard opponentMonster, MonsterCard currentMonster){
        int damage = currentMonster.attack - opponentMonster.attack;
        GraveYard.setCards(opponentMonster);
        GlobalVariable.getBoard().lowerLifePoint(damage);
        System.out.println("your opponent's monster is destroyed and your opponent receives " + damage  + "battle damage");
    }

    public void Attack(MonsterCard opponentMonster, MonsterCard currentMonster){
        if(currentMonster.attack > opponentMonster.attack) {
            lowerAttack(opponentMonster, currentMonster);
        }
        else if(currentMonster.attack == opponentMonster.attack){
            GraveYard.setCards(opponentMonster);
            GraveYard.setCards(currentMonster);
            System.out.println("both you and your opponent monster cards are destroyed and no one receives damage");
        }
        else{
            int damage = opponentMonster.attack - currentMonster.attack ;
            GlobalVariable.getBoard().lowerLifePoint(damage);
            GraveYard.setCards(currentMonster);
            System.out.println("Your monster card is destroyed and you received " + damage + "battle damage");
        }
    }

    public void defense(MonsterCard opponentMonster, MonsterCard currentMonster){

    }
 */
}