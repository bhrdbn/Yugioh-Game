package model;

import controller.GlobalVariable;

import java.util.ArrayList;
import java.util.List;

public class ActionMonster {
    PlayBoard playBoard = GlobalVariable.getBoard().getPlayBoardByTurn();
    Deck deck = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getDeck();
    PlayBoard OPplayboard = GlobalVariable.getBoard().getOpponentPlayBoardByTurn();
    List<Card> graveYard = GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards();
    public void setAction(int cardControllerNumber,MonsterCard monsterCard) {
    if (cardControllerNumber==1)
    {
        increaseAttackAll(monsterCard);
    }
    if (cardControllerNumber==2)
    {
        canNotBeAttacked(monsterCard);
    }
    if (cardControllerNumber==3)
    {
        getInBoardWithSacrifices(monsterCard);
    }
    if (cardControllerNumber==4)
    {
        getInBoardWithSacrifices2();
    }
    if (cardControllerNumber==5)
    {
        getInBoardWithSacrifices3(monsterCard);
    }
    if (cardControllerNumber==6)
    {
        diewhenattack(monsterCard);
    }
    if (cardControllerNumber==7)
    {
        acardwhenturned(monsterCard);
    }
    if (cardControllerNumber==8)
    {barbaroswithoutsac(monsterCard);}
    if (cardControllerNumber==9)
    {barbaroswitsac(monsterCard);}
    if (cardControllerNumber==10)
    {
        calculate(monsterCard);
    }
    if (cardControllerNumber==11)
    {
        sacraficeOneToget();
    }




    }
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
    public void increaseAttackAll(MonsterCard monsterCard) //1
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        for (MonsterCard monsterCardd : monsterCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 400);

        }
        if (monsterCards.size() < 2)
            monsterCard.setIsAttack(false);
        else
            monsterCard.setIsAttack(true);
    }


    public void getInBoardWithSacrifices(MonsterCard monsterCard) //3
    {
        ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        MonsterCard monsterCard1 = new MonsterCard("CrabTurtle", 1, "Ritual", 2,"description:This monster can only be Ritual Summoned with the Ritual Spell Card, \"Turtle Oath\". You must also offer monsters whose total Level Stars equal 8 or more as a Tribute from the field or your hand.", true, 10200, 2550, 2500, null, "WATER", 8, "Aqua");

        monsterCards.remove(monsterCard);
        monsterCards.add(monsterCard1);
    }

    public void getInBoardWithSacrifices2() //4
    {
        ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        MonsterCard monsterCard1 = new MonsterCard("GateGuardian", 1, "Ritual", 2,"description:This monster can only be Ritual Summoned with the Ritual Spell Card, \"Turtle Oath\". You must also offer monsters whose total Level Stars equal 8 or more as a Tribute from the field or your hand.", true, 10200, 2550, 2500, null, "WATER", 8, "Aqua");
        if (monsterCards.size() > 3) {
            monsterCards.remove(1);
            monsterCards.remove(2);
            monsterCards.remove(3);
            deck.addCard(monsterCard1, 1);
            monsterCards.add(monsterCard1);
        } else {
            System.out.println("you cant summon");
        }

    }

    public void getInBoardWithSacrifices3(MonsterCard monsterCard) //5
    {
        ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        MonsterCard monsterCard1 = new MonsterCard("SkullGuardian", 1, "Ritual",2, "description This monster can only be Ritual Summoned with the Ritual Spell Card, \"Novox's Prayer\". You must also offer monsters whose total Level Stars equal 7 or more as a Tribute from the field or your hand.",
                true, 7900, 2050, 2500, null, "LIGHT", 7, "Warrior");

        monsterCards.remove(monsterCard);

        monsterCards.add(monsterCard1);
    }

    public void canNotBeAttacked(MonsterCard monsterCard) //2
    {
        monsterCard.setIsAttack(false);
    }

    public void diewhenattack(MonsterCard monsterCard) //6
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

            monsterCards.add((MonsterCard) card);

        }

        if (monsterCard.getAttack() < playBoard.getSelectedMonsterCard().getAttack()) {
            if (monsterCard.getDefence() == 0) {
                playBoard.getSelectedMonsterCard().setDefence(0);
            }
        }
    }

    public void acardwhenturned(MonsterCard monsterCard) //7
    {
        monsterCard.setSide(true);
        playBoard.getAttackerCards().remove(2);
    }


    public void barbaroswithoutsac(MonsterCard monsterCard) //8
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        monsterCard.setAttack(1900);
        deck.addCard(monsterCard,1);

    }

    public void barbaroswitsac(MonsterCard monsterCard) //9
    {ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

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
        deck.addCard(monsterCard, 1);

    }

    public void calculate( MonsterCard monsterCard) //10
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        int sum = 0;
        for (MonsterCard monsterCardd : monsterCards) {
            sum = sum + monsterCardd.getAttack();
        }
        sum = sum * 300;
        monsterCard.setAttack(sum);
    }


    public void sacraficeOneToget() //11
    { ArrayList<MonsterCard> monsterCards =null;
        for (Card card:playBoard.getHand()) {

            monsterCards.add((MonsterCard) card);

        }
        int i = 0,m=0;
        String t = "";
        deck.getMainDeck().remove(2);
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
        playBoard.getGraveyards().get(m);
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
