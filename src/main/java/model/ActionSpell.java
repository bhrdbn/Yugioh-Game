package model;

import controller.GlobalVariable;

import java.io.File;
import java.util.ArrayList;

public class ActionSpell {
    private int cardControllerNumber;

    public void setAction(int cardControllerNumber, SpellCard spellCard, MonsterCard monsterCard, Deck deck, Deck side) {

        if (cardControllerNumber == 1) {
            addFieldSpellFromDeck(spellCard);
        }  if (cardControllerNumber == 2) {
            stopSpell();
        }  if (cardControllerNumber == 3) {
            spellcasterATKplus(monsterCard);
        }  if (cardControllerNumber == 4) {
            fiendATKplus(monsterCard);
        }  if (cardControllerNumber == 5) {
            spellcasterDEFplus(monsterCard);
        }  if (cardControllerNumber == 6) {
            fiendDefplus(monsterCard);
        }  if (cardControllerNumber == 7) {
            fairyATKlose(monsterCard);
        }  if (cardControllerNumber == 8) {
            InsectAtkplus(monsterCard);
        }  if (cardControllerNumber == 9) {
            BeastAtkplus(monsterCard);
        }  if (cardControllerNumber == 10) {
            BeastWarriorAtkplus(monsterCard);
        }  if (cardControllerNumber == 16) {
            ritualSummon(spellCard);
        }  if (cardControllerNumber == 17) {
            Insectdefplus(monsterCard);
        } if (cardControllerNumber == 18) {
            addCard(deck, side);
        } if (cardControllerNumber == 19) {
            aquaAtkplus(monsterCard);
        } if (cardControllerNumber == 20) {
            aquadeflos(monsterCard);
        } if (cardControllerNumber == 21) {
            equiprd(monsterCard);
        }


    }

 // 1 terraforming
    //2 pot of greed
    // 4 5 6 yami
 // 15 16 17 forest
    // 18 19 umiruka
    // 20 black pendant
    public void addFieldSpellFromDeck(SpellCard spellCard) {
        GlobalVariable.getPlayer().addToDeck(spellCard);
    } //1


    public void stopSpell() {

        GlobalVariable.getPlayer().getActivatedDeck().getMainDeck().get(1).setType("NORMAL");

    }
    public void addCard(Deck deck, Deck side) { //2
        deck.getMainDeck().add(deck.getSideDeck().get(1));
deck.getSideDeck().remove(1);
        deck.getMainDeck().add(deck.getSideDeck().get(2));
        deck.getSideDeck().remove(2);


    }

    public void spellcasterATKplus(MonsterCard monsterCard) { //5

        monsterCard.setAttack(8000);

    }


    public void fiendATKplus(MonsterCard monsterCard) {
        monsterCard.setAttack(monsterCard.getAttack()+400);
    } //4

    public void spellcasterDEFplus(MonsterCard monsterCard) {
        monsterCard.setDefence(8000);
    }

    public void fiendDefplus(MonsterCard monsterCard) {
        monsterCard.setDefence(8000);
    }

    public void fairyATKlose(MonsterCard monsterCard) {
        monsterCard.setAttack(monsterCard.getAttack()-200);
    } //6

    public void InsectAtkplus(MonsterCard monsterCard) {
        monsterCard.setAttack(monsterCard.getAttack()+200);
    } //17
    public void aquaAtkplus(MonsterCard monsterCard) {
        monsterCard.setAttack(monsterCard.getAttack()+500);
    } //18
    public void aquadeflos(MonsterCard monsterCard) {
        monsterCard.setDefence(monsterCard.getDefence()-400);
    } //19
    public void equiprd(MonsterCard monsterCard) {
        monsterCard.setAttack(monsterCard.getAttack()+500);
    } //20

    public void BeastAtkplus(MonsterCard monsterCard) {
        monsterCard.setAttack(monsterCard.getAttack()+200);
    } //16

    public void BeastWarriorAtkplus(MonsterCard monsterCard) {
        monsterCard.setAttack(monsterCard.getAttack()+200);
    } //15

    public void Insectdefplus(MonsterCard monsterCard) {
        monsterCard.setDefence(8000);

    }

    public void ritualSummon(SpellCard spellCard) {
        GlobalVariable.getPlayer().getActivatedDeck().getMainDeck().add(spellCard);
    }

/*
    public void BeastATKincreaseforGraveYard(int cardControllerNumber)
    {

    }

    public void beastWarrordefplus(int cardControllerNumber)
    {

    }

    public void aquaIncreaseAtkdecreaseDef(int cardControllerNumber)
    {

    }

    public void fiendATKincreaseandDEFdecrease(int cardControllerNumber)
    {

    }
 public void ThrowAwayOneAndDestroy2spellOrTraps(int cardControllerNumber)
    {

    }

    public void destroyASpellOrATrap(int cardControllerNumber)
    {

    }

    public void trapOPattackToZero(int cardControllerNumber)
    {

    }

    public void spellcasterATKincreaseandDEFdecrease(int cardControllerNumber)
    {

    }

    public void equipedCards(int cardControllerNumber)
    {

    }
public void destroyallMonstersOnField(int cardControllerNumber)
    {

    }

    public void changeAmonsterForThisRound(int cardControllerNumber)
    {

    }

    public void destoryAllSpellAndTraps(int cardControllerNumber)
    {

    }

    public void ifFrontCantAttack(int cardControllerNumber)
    {

    }

    public void freezethegame(int cardControllerNumber)
    {

    }

    public void destroyallMonstersFromBothSides(int cardControllerNumber)
    {

    }

    public void ifACardLostTakeAnother(int cardControllerNumber)
    {

    }
    public void equippedMonstersEach(int cardControllerNumber)
    {

    }

    public void warriorEquipped(int cardControllerNumber)
    {

    }



    public void run()
    {

    }

 */
}
