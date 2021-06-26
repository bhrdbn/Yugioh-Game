package model;

import java.util.ArrayList;

public class ActionMonster {
    public void setAction(int cardControllerNumber, MonsterCard monsterCard, Deck deck,  PlayBoard playBoard, ArrayList<MonsterCard> monsterCards,int pos) {
    if (cardControllerNumber==1)
    {
        increaseAttackAll(monsterCards,monsterCard);
    }
    if (cardControllerNumber==2)
    {
        canNotBeAttacked(monsterCard);
    }
    if (cardControllerNumber==3)
    {
        getInBoardWithSacrifices(monsterCard,deck);
    }
    if (cardControllerNumber==4)
    {
        getInBoardWithSacrifices2(monsterCards,deck);
    }
    if (cardControllerNumber==5)
    {
        getInBoardWithSacrifices3(monsterCard,deck);
    }
    if (cardControllerNumber==6)
    {
        diewhenattack(monsterCard,playBoard);
    }
    if (cardControllerNumber==7)
    {
        acardwhenturned(monsterCard,playBoard);
    }
    if (cardControllerNumber==8)
    {barbaroswithoutsac(monsterCards,monsterCard,deck,pos);}
    if (cardControllerNumber==9)
    {barbaroswitsac(monsterCards,monsterCard,deck,pos);}
    if (cardControllerNumber==10)
    {
        calculate(monsterCards,monsterCard);
    }
    if (cardControllerNumber==11)
    {
        sacraficeOneToget(playBoard,deck,pos,monsterCards);
    }




    }
// 1  COMMANDKNIGHT
    // 2 SUIJIN
    //3 CRABTURTLE
    // 4 GATE GUARDIAN
    //5 skull guardian
    //6 yomi ship
    //7 man eater bug
    //8 9 king barbaros
    //10 calculator
//11 herald of creation
    public void increaseAttackAll(ArrayList<MonsterCard> monsterCards,MonsterCard monsterCard) //1
    {
        for (MonsterCard monsterCardd : monsterCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 400);

        }
        if (monsterCards.size() < 2)
            monsterCard.setIsAttack(false);
        else
            monsterCard.setIsAttack(true);
    }


    public void getInBoardWithSacrifices(MonsterCard monsterCard, Deck deck) //3
    {
        MonsterCard monsterCard1 = new MonsterCard("CrabTurtle", 1, "Ritual", "description:This monster can only be Ritual Summoned with the Ritual Spell Card, \"Turtle Oath\". You must also offer monsters whose total Level Stars equal 8 or more as a Tribute from the field or your hand.", true, 10200, 2550, 2500, null, "WATER", 8, "Aqua");

        deck.removeCard(monsterCard, 1);
        deck.addCard(monsterCard1, 1);
    }

    public void getInBoardWithSacrifices2(ArrayList<MonsterCard> monsterCards, Deck deck) //4
    {
        MonsterCard monsterCard1 = new MonsterCard("GateGuardian", 1, "Ritual", "description:This monster can only be Ritual Summoned with the Ritual Spell Card, \"Turtle Oath\". You must also offer monsters whose total Level Stars equal 8 or more as a Tribute from the field or your hand.", true, 10200, 2550, 2500, null, "WATER", 8, "Aqua");
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

    public void getInBoardWithSacrifices3(MonsterCard monsterCard, Deck deck) //5
    {
        MonsterCard monsterCard1 = new MonsterCard("SkullGuardian", 1, "Ritual", "description This monster can only be Ritual Summoned with the Ritual Spell Card, \"Novox's Prayer\". You must also offer monsters whose total Level Stars equal 7 or more as a Tribute from the field or your hand.",
                true, 7900, 2050, 2500, null, "LIGHT", 7, "Warrior");

        deck.removeCard(monsterCard, 1);

        deck.addCard(monsterCard1, 1);
    }

    public void canNotBeAttacked(MonsterCard monsterCard) //2
    {
        monsterCard.setIsAttack(false);
    }

    public void diewhenattack(MonsterCard monsterCard, PlayBoard playBoard) //6
    {
        if (monsterCard.getAttack() < playBoard.getSelectedMonsterCard().getAttack()) {
            if (monsterCard.getDefence() == 0) {
                playBoard.getSelectedMonsterCard().setDefence(0);
            }
        }
    }

    public void acardwhenturned(MonsterCard monsterCard, PlayBoard playBoard) //7
    {
        monsterCard.setSide(true);
        playBoard.getAttackerCards().remove(2);
    }


    public void barbaroswithoutsac(ArrayList<MonsterCard> monsterCards, MonsterCard monsterCard, Deck deck, int pos) //8
    {
        monsterCard.setAttack(1900);
        deck.addCard(monsterCard, pos);

    }

    public void barbaroswitsac(ArrayList<MonsterCard> monsterCards, MonsterCard monsterCard, Deck deck, int pos) //9
    {
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

    public void calculate(ArrayList<MonsterCard> monsterCards, MonsterCard monsterCard) //10
    {
        int sum = 0;
        for (MonsterCard monsterCardd : monsterCards) {
            sum = sum + monsterCardd.getAttack();
        }
        sum = sum * 300;
        monsterCard.setAttack(sum);
    }


    public void sacraficeOneToget(PlayBoard playBoard, Deck deck, int num, ArrayList<MonsterCard> monsterCards) //11
    {
        int i = 0,m=0;
        String t = "";
        deck.getMainDeck().remove(num);
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
