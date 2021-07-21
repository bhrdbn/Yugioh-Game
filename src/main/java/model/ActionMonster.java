package model;

import clientview.MainClient;
import servercontroller.GlobalVariable;

import java.util.ArrayList;

public class ActionMonster {
    public void setAction(int cardControllerNumber,MonsterCard monsterCard, String token) {
    if (cardControllerNumber==1)
    {
        increaseAttackAll(monsterCard, token);
    }
    if (cardControllerNumber==2)
    {
        canNotBeAttacked(monsterCard, token);
    }
    if (cardControllerNumber==3)
    {
        getInBoardWithSacrifices(monsterCard, token);
    }
    if (cardControllerNumber==4)
    {
        getInBoardWithSacrifices2(token);
    }
    if (cardControllerNumber==5)
    {
        getInBoardWithSacrifices3(monsterCard, token);
    }
    if (cardControllerNumber==6)
    {
        diewhenattack(monsterCard, token);
    }
    if (cardControllerNumber==7)
    {
        acardwhenturned(monsterCard, token);
    }
    if (cardControllerNumber==8)
    {barbaroswithoutsac(monsterCard, token);}
    if (cardControllerNumber==9)
    {barbaroswitsac(monsterCard, token);}
    if (cardControllerNumber==10)
    {
        calculate(monsterCard, token);
    }
    if (cardControllerNumber==11)
    {
        sacraficeOneToget(token);
    }
        if (cardControllerNumber == 12) {
            trick(token);
        }
        if (cardControllerNumber == 13) {
            terratiger(token);
        }




    }
    // 1  COMMANDKNIGHT
    // 2 SUIJIN
    //3 CRABTURTLE
    // 4 GATE GUARDIAN
    //5 skull guardian
    //6 yomi ship
    //7 man eater bug
    //8 9 king barbaros >>>>31
    //10 calculator
//11 herald of creation
// 1  CommandKnight 4-
    // 2 Suijin 7
    //3 CrabTurtle 8
    // 4 GateGuardian 11
    //5 SkullGuardian 7
    //6 YomiShip 3-
    //7 ManEaterBug 2-
    //8 9 BeastKingBarbaros 8
    //10 TheCalculator 2-
//11 HeraldofCreation 4 -
    public void increaseAttackAll(MonsterCard monsterCard, String token) //1
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        for (MonsterCard monsterCardd : monsterCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 400);

        }
        if (monsterCards.size() < 2)
            monsterCard.setIsAttack(false);
        else
            monsterCard.setIsAttack(true);
        System.out.println("succesfully");
    }
    public void trick(String token) //12
    {
        System.out.println("please enter the (index)monster you want from hand to drop");
        int num= MainClient.scanner.nextInt();
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().remove(num);
        System.out.println("succesfully");
    }

    public void terratiger(String token) //13
    {
        System.out.println("please enter the (index)monster you want from hand to put in defence");
        int num= MainClient.scanner.nextInt();
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setSelectedMonsterCard((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().get(num));
        System.out.println("succesfully");
    }


    public void getInBoardWithSacrifices(MonsterCard monsterCard, String token) //3
    {
        ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        MonsterCard monsterCard1 = new MonsterCard("CrabTurtle", 1, "Ritual", 2,"description:This monster can only be Ritual Summoned with the Ritual Spell Card, \"Turtle Oath\". You must also offer monsters whose total Level Stars equal 8 or more as a Tribute from the field or your hand.", true, 10200, 2550, 2500, null, "WATER", 8, "Aqua");

        monsterCards.remove(monsterCard);
        monsterCards.add(monsterCard1);
        System.out.println("succesfully");
    }

    public void getInBoardWithSacrifices2(String token) //4
    {
        ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);


        }
        MonsterCard monsterCard1 = new MonsterCard("GateGuardian", 1, "Ritual", 2,"description:This monster can only be Ritual Summoned with the Ritual Spell Card, \"Turtle Oath\". You must also offer monsters whose total Level Stars equal 8 or more as a Tribute from the field or your hand.", true, 10200, 2550, 2500, null, "WATER", 8, "Aqua");
        if (monsterCards.size() > 3) {
            monsterCards.remove(1);
            monsterCards.remove(2);
            monsterCards.remove(3);
            GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getDeck().addCard(monsterCard1, 1);
            monsterCards.add(monsterCard1);
        } else {
            System.out.println("you cant summon");
        }
        System.out.println("succesfully");
    }

    public void getInBoardWithSacrifices3(MonsterCard monsterCard, String token) //5
    {
        ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        MonsterCard monsterCard1 = new MonsterCard("SkullGuardian", 1, "Ritual",2, "description This monster can only be Ritual Summoned with the Ritual Spell Card, \"Novox's Prayer\". You must also offer monsters whose total Level Stars equal 7 or more as a Tribute from the field or your hand.",
                true, 7900, 2050, 2500, null, "LIGHT", 7, "Warrior");

        monsterCards.remove(monsterCard);

        monsterCards.add(monsterCard1);
        System.out.println("succesfully");
    }

    public void canNotBeAttacked(MonsterCard monsterCard, String token) //2
    {
        monsterCard.setIsAttack(false);
        System.out.println("succesfully");
    }

    public void diewhenattack(MonsterCard monsterCard, String token) //6
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);

        }

        if (monsterCard.getAttack() < GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedMonsterCard().getAttack()) {
            if (monsterCard.getDefence() == 0) {
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedMonsterCard().setDefence(0);
            }
        }
        System.out.println("succesfully");
    }

    public void acardwhenturned(MonsterCard monsterCard, String token) //7
    {
        monsterCard.setSide(true);
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getAttackerCards().remove(2);
        System.out.println("succesfully");
    }


    public void barbaroswithoutsac(MonsterCard monsterCard, String token) //8
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        monsterCard.setAttack(1900);
        GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getDeck().addCard(monsterCard,1);
        System.out.println("succesfully");
    }

    public void barbaroswitsac(MonsterCard monsterCard, String token) //9
    {ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        if (monsterCards.size() >= 3) {
            monsterCards.remove(1);
            monsterCards.remove(2);
            monsterCards.remove(3);
        } else {
            System.out.println("you cant summon this monster");
        }
        monsterCards.add(monsterCard);
        GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getDeck().addCard(monsterCard, 1);
        System.out.println("succesfully");
    }

    public void calculate( MonsterCard monsterCard, String token) //10
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        int sum = 0;
        for (MonsterCard monsterCardd : monsterCards) {
            sum = sum + monsterCardd.getAttack();
        }
        sum = sum * 300;
        monsterCard.setAttack(sum);
        System.out.println("succesfully");
    }


    public void sacraficeOneToget(String token) //11
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        int i = 0,m=0;
        String t = "";
        GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getDeck().getMainDeck().remove(2);
        for (MonsterCard monsterCardd : monsterCards) {

            if (monsterCardd.getLevel() > i)
            {i = monsterCardd.getLevel();
                t.equals(monsterCardd.name);
            }

        }
        for (int j = 0; j < monsterCards.size(); j++) {
            if (t.equals(monsterCards.get(j).getName()))
            {
                m=j;
            }
        }
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().get(m);
        System.out.println("succesfully");
    }


/*
    public void attack(MonsterCard monsterCard) //3
    {
        monsterCard.setAttack(monsterCard.getAttack() + 1900);
    }

    public void defence(MonsterCard monsterCard) //4
    {
        monsterCard.setDefence(6000);
    }


    public void ifFaceupcanuseOnce(MonsterCard monsterCard) //5
    {
        if (monsterCard.isSide())
            monsterCard.setAttack(monsterCard.getAttack() + 500);
        monsterCard.setSide(false);

    }


    public void upperDefence(MonsterCard monsterCard) //6
    {
        monsterCard.setDefence(9000);
    }

    public void upperAttack(MonsterCard monsterCard) //7
    {
        monsterCard.setAttack(9000);
    }

    public void sendFromsideDECK(MonsterCard monsterCard, Deck deck) //8
    {
        deck.getMainDeck().add(deck.getSideDeck().get(1));
    }

    public void run() {

    }
*/
}
