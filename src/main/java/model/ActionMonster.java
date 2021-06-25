package model;

import java.util.ArrayList;

public class ActionMonster {
    public void setAction(int cardControllerNumber, MonsterCard monsterCard, Deck deck) {
        if (cardControllerNumber == 1) {
            increaseAttackAll(monsterCard);
        } else if (cardControllerNumber == 2) {
            invinsibleTillOtherMonstersExist(monsterCard, deck);
        } else if (cardControllerNumber == 3) {
            attack(monsterCard);
        } else if (cardControllerNumber == 4) {
            defence(monsterCard);
        } else if (cardControllerNumber == 5) {
            ifFaceupcanuseOnce(monsterCard);
        } else if (cardControllerNumber == 6) {
            upperDefence(monsterCard);
        } else if (cardControllerNumber == 7) {
            upperAttack(monsterCard);
        } else if (cardControllerNumber == 8) {
            sendFromsideDECK(monsterCard, deck);
        } else if (cardControllerNumber == 9) {
            getInBoardWithSacrifices(monsterCard, deck);
        } else if (cardControllerNumber == 10) {
            getInBoardWithSacrifices2(monsterCard, deck);
        } else if (cardControllerNumber == 11) {
            canNotBeAttacked(monsterCard);
        }

    }


    public void increaseAttackAll(MonsterCard monsterCard) //1
    {
        monsterCard.setAttack(5000);
    }

    public void invinsibleTillOtherMonstersExist(MonsterCard monsterCard, Deck deck) //2
    {
        if (deck.getMonsters(1).size() + deck.getMonsters(2).size() + deck.getMonsters(3).size() > 1)
            monsterCard.setDefence(5000);
    }

    public void attack(MonsterCard monsterCard) //3
    {
        monsterCard.setAttack(6000);
    }

    public void defence(MonsterCard monsterCard) //4
    {
        monsterCard.setDefence(6000);
    }


    public void ifFaceupcanuseOnce(MonsterCard monsterCard) //5
    {
        monsterCard.setAttack(10000);
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


    public void getInBoardWithSacrifices(MonsterCard monsterCard, Deck deck) //10
    {
        MonsterCard monsterCard1 = new MonsterCard("CrabTurtle", 1, "effect", "description:This monster can only be Ritual Summoned with the Ritual Spell Card, \"Turtle Oath\". You must also offer monsters whose total Level Stars equal 8 or more as a Tribute from the field or your hand.", true, 10200, 2550, 2500, null, "WATER", 8, "Aqua");

        deck.removeCard(monsterCard, 1);
        deck.addCard(monsterCard1, 1);
    }

    public void getInBoardWithSacrifices2(MonsterCard monsterCard, Deck deck) //25
    {
        MonsterCard monsterCard1 = new MonsterCard("GateGuardian", 1, "effect", "description:This monster can only be Ritual Summoned with the Ritual Spell Card, \"Turtle Oath\". You must also offer monsters whose total Level Stars equal 8 or more as a Tribute from the field or your hand.", true, 10200, 2550, 2500, null, "WATER", 8, "Aqua");

        deck.removeCard(monsterCard, 1);
        deck.addCard(monsterCard1, 1);
    }


    public void canNotBeAttacked(MonsterCard monsterCard) //12
    {
        monsterCard.setIsAttack(false);
    }
/*
    public void decreaseAttackWithOutSacrifices(int cardControllerNumber) //13
    {

    }

    public void destroyAllCards(int cardControllerNumber) //14
    {

    }

    public void summonCyberseOnly(int cardControllerNumber) //15
    {

    }

    public void attackIStheSumOfFrontCards(int cardControllerNumber) //16
    {

    }

    public void noTrapsAvailableForOpponent(int cardControllerNumber) //17
    {

    }

    public void loseOnegetFromGraveYard(int cardControllerNumber) //18
    {

    }

    public void destroysBothCardsWithoutAnyLifeDamage(int cardControllerNumber) //19
    {

    }

    public void getAnotherDefenceStateCard(int cardControllerNumber) //20
    {

    }

    public void sacraficeOneToget(int cardControllerNumber) //21
    {

    }

 */

}
