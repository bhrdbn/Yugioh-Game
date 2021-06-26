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


        private int atk;
        private int def;
        private ArrayList<MonsterCard> monsters;
    private String attribute;
    private int level;
    private String monsterType;
    private boolean isAttack;



    public void setAttack(int attack) {
        this.atk = attack;
    }
    public void setIsAttack(boolean isAttack){
        this.isAttack = isAttack;
    }

    public String typeOfMonsterCard(){
        return monsterType;
    }

    public int getDefence() {
        return def;
    }

    public void setDefence(int defence) {
        this.def = defence;
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

    public MonsterCard(String name, int number, String type, String cardDescription, boolean side, long price, int attack, int defence, ArrayList<MonsterCard> monsters, String attribute, int level, String monsterType)  {
        super(name, number, type, cardDescription, side, price);
        this.atk = attack;
        this.def = defence;
        this.monsters = monsters;
        this.attribute = attribute;
        this.level = level;
        this.monsterType = monsterType;


    }
    public MonsterCard(MonsterCard card){
        super(card.name,card.number,card.cardType,card.description,card.side,card.price);
        atk=card.atk;
        this.def = card.def;
        this.monsters =card.monsters;
        this.attribute = card.attribute;
        this.level = card.level;
        this.monsterType = card.monsterType;
    }

        public int getAttack() {
            return atk;

        }
    /*
action 7,2 == 32
action 12,22 == 33
action 22,10,14 ==34
action 12,15 == 35
action 1,12 ==36
     */

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

*/


    private static void lowerAttack(MonsterCard opponentMonster, MonsterCard currentMonster){
        int damage = currentMonster.atk - opponentMonster.atk;
        GraveYard.setCards(opponentMonster);
        GlobalVariable.getBoard().lowerLifePoint(damage);
        System.out.println("your opponent's monster is destroyed and your opponent receives " + damage  + "battle damage");
    }

    public static String Attack(MonsterCard opponentMonster, MonsterCard currentMonster, int number) {
        if(opponentMonster.isAttack()) {
            if (currentMonster.getAttack() > opponentMonster.getAttack()) {
                GlobalVariable.getBoard().lowerOpponentLifePoint(currentMonster.getAttack() - opponentMonster.getAttack());
                GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().remove(number);
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard().setLocation(Location.GRAVEYARD);
                return "your opponent monster is destroyed and your opponent receives " + (currentMonster.getAttack() - opponentMonster.getAttack()) + " battle damage";
            }
            else if(currentMonster.getAttack() == opponentMonster.getAttack()){
                currentMonster.setLocation(Location.GRAVEYARD);
                opponentMonster.setLocation(Location.GRAVEYARD);
                return "both you and your opponent monster cards are destroyed and no one receives damage";
            }
            else{
                GlobalVariable.getBoard().lowerLifePoint(currentMonster.getAttack() - opponentMonster.getAttack());
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().setLocation(Location.GRAVEYARD);
                return "your monster card is destroyed and you received " + (currentMonster.getAttack() - opponentMonster.getAttack()) + " battle damage";
            }
        }
        else if(!opponentMonster.isAttack() && opponentMonster.isSide()){
            if(currentMonster.getAttack() > opponentMonster.getDefence()){
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard().setLocation(Location.GRAVEYARD);
                    return "the defense position monster is destroyed";
            }
            else if(currentMonster.getAttack() == opponentMonster.getDefence())
                return "no card is destroyed";
            else{
                GlobalVariable.getBoard().lowerLifePoint(opponentMonster.getDefence() - currentMonster.getAttack());
                return "no card is destroyed and you received " + (opponentMonster.getDefence() - currentMonster.getAttack()) + " battle damage";
            }
        }
        else if(!opponentMonster.isAttack() && !opponentMonster.isSide()){
            if(currentMonster.getAttack() > opponentMonster.getDefence()){
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard().setLocation(Location.GRAVEYARD);
                return "opponent monster card was " + opponentMonster.getName() + " and the defense position monster is destroyed";
            }
            else if(currentMonster.getAttack() == opponentMonster.getDefence())
                return "opponent monster card was " + opponentMonster.getName() + " and no card is destroyed";
            else{
                GlobalVariable.getBoard().lowerLifePoint(opponentMonster.getDefence() - currentMonster.getAttack());
                return "opponent monster card was " + opponentMonster.getName() + " and no card is destroyed and you received " + (opponentMonster.getDefence() - currentMonster.getAttack()) + " battle damage";
            }
        }
    return null;
    }
    public static void directAttack(MonsterCard opponentMonster, MonsterCard currentMonster){
        if(currentMonster.atk > opponentMonster.atk) {
            lowerAttack(opponentMonster, currentMonster);
            int damage = currentMonster.atk - opponentMonster.atk;
            System.out.println("your opponent receives " + damage + " battle damage");
        }

    }


    public static void set(MonsterCard monster) {
        GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().add((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
    }

    public boolean isAttack() {
        return isAttack;
    }
}