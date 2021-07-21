package model;





import servercontroller.Controller;
import servercontroller.GameController;
import servercontroller.GlobalVariable;

import java.util.ArrayList;

public class MonsterCard extends Card {


        private int atk;
        private int def;
        private ArrayList<MonsterCard> monsters;
    private String attribute;
    private int level;
    private String monsterType;
    private boolean isAttack;
    private int action;
    private boolean canBeAttacked=true;

    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }

    public boolean isCanBeAttacked() {
        return canBeAttacked;
    }

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

    public int getAction() {
        return action;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public MonsterCard(String name, int number, String type, int action,String cardDescription, boolean side, long price, int attack, int defence, ArrayList<MonsterCard> monsters, String attribute, int level, String monsterType)  {
        super(name, number, type, cardDescription, side, price);
        this.atk = attack;
        this.def = defence;
        this.monsters = monsters;
        this.attribute = attribute;
        this.level = level;
        this.monsterType = monsterType;
        this.action=action;



    }
    public MonsterCard(MonsterCard card){
        super(card.name,card.number,card.cardType,card.description,card.side,card.price);
        atk=card.atk;
        this.def = card.def;
        this.monsters =card.monsters;
        this.attribute = card.attribute;
        this.level = card.level;
        this.monsterType = card.monsterType;
        this.action=card.getAction();
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

    public static String Attack(MonsterCard currentMonster, MonsterCard opponentMonster, int number, String token) {
        if(opponentMonster.isAttack()) {
            MonsterCard nokhodi=new MonsterCard("nokhodi",1,"a",1,"s",true,1,1,1,null,"f",1,"a");

            if (currentMonster.getAttack() > opponentMonster.getAttack()) {
                GlobalVariable.getBoards().get(token).lowerOpponentLifePoint(currentMonster.getAttack() - opponentMonster.getAttack());
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number - 1).setLocation(Location.GRAVEYARD);
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getGraveyards().add(opponentMonster);
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().set(number-1,
                        nokhodi);
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "your opponent monster is destroyed and your opponent receives " + (currentMonster.getAttack() - opponentMonster.getAttack()) + " battle damage";
            }
            else if(currentMonster.getAttack() == opponentMonster.getAttack()){
                currentMonster.setLocation(Location.GRAVEYARD);
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().add(currentMonster);
                GameController.getInstance().setNokhodi(currentMonster);
                opponentMonster.setLocation(Location.GRAVEYARD);
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getGraveyards().add(opponentMonster);
                GameController.getInstance().setNokhodi(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number-1));
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "both you and your opponent monster cards are destroyed and no one receives damage";
            }
            else{
                GlobalVariable.getBoards().get(token).lowerLifePoint(currentMonster.getAttack() - opponentMonster.getAttack());
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().setLocation(Location.GRAVEYARD);
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().add(currentMonster);
                GameController.getInstance().setNokhodi((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "your monster card is destroyed and you received " + (currentMonster.getAttack() - opponentMonster.getAttack()) + " battle damage";
            }
        }
        else if(!opponentMonster.isAttack() && opponentMonster.isSide()){
            if(currentMonster.getAttack() > opponentMonster.getDefence()){
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number - 1).setLocation(Location.GRAVEYARD);
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getGraveyards().add(opponentMonster);
                GameController.getInstance().setNokhodi(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number-1));
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "the defense position monster is destroyed";
            }
            else if(currentMonster.getAttack() == opponentMonster.getDefence()) {
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "no card is destroyed";
            }
            else{
                GlobalVariable.getBoards().get(token).lowerLifePoint(opponentMonster.getDefence() - currentMonster.getAttack());
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "no card is destroyed and you received " + (opponentMonster.getDefence() - currentMonster.getAttack()) + " battle damage";
            }
        }
        else if(!opponentMonster.isAttack() && !opponentMonster.isSide()){
            if(currentMonster.getAttack() > opponentMonster.getDefence()){
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number - 1).setLocation(Location.GRAVEYARD);
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getGraveyards().add(opponentMonster);
                GameController.getInstance().setNokhodi(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number-1));
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "opponent monster card was " + opponentMonster.getName() + " and the defense position monster is destroyed";
            }
            else if(currentMonster.getAttack() == opponentMonster.getDefence()) {
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "opponent monster card was " + opponentMonster.getName() + " and no card is destroyed";
            }
            else{
                GlobalVariable.getBoards().get(token).lowerLifePoint(opponentMonster.getDefence() - currentMonster.getAttack());
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardAttacked(true);
                return "opponent monster card was " + opponentMonster.getName() + " and no card is destroyed and you received " + (opponentMonster.getDefence() - currentMonster.getAttack()) + " battle damage";
            }
        }
    return null;
    }
    public static String directAttack(String token){
        int damage = ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).getAttack();
        GlobalVariable.getBoards().get(token).lowerOpponentLifePoint(damage);
        return "your opponent receives " + damage + " battle damage";
    }

    public boolean isAttack() {
        return isAttack;
    }
}