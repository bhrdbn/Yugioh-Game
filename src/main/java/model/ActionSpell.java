package model;

import controller.GlobalVariable;

import java.io.File;
import java.util.ArrayList;

public class ActionSpell {
    private int cardControllerNumber;

    public void setAction(int cardControllerNumber, SpellCard spellCard, MonsterCard monsterCard) {

        if (cardControllerNumber == 1) {
            addFieldSpellFromDeck(spellCard);
        } else if (cardControllerNumber == 2) {
            stopSpell();
        } else if (cardControllerNumber == 3) {
            spellcasterATKplus(monsterCard);
        } else if (cardControllerNumber == 4) {
            fiendATKplus(monsterCard);
        } else if (cardControllerNumber == 5) {
            spellcasterDEFplus(monsterCard);
        } else if (cardControllerNumber == 6) {
            fiendDefplus(monsterCard);
        } else if (cardControllerNumber == 7) {
            fairyATKlose(monsterCard);
        } else if (cardControllerNumber == 8) {
            InsectAtkplus(monsterCard);
        } else if (cardControllerNumber == 9) {
            BeastAtkplus(monsterCard);
        } else if (cardControllerNumber == 10) {
            BeastWarriorAtkplus(monsterCard);
        }  else if (cardControllerNumber == 16) {
            ritualSummon(spellCard);
        }


    }


    public void addFieldSpellFromDeck(SpellCard spellCard) {
        GlobalVariable.getPlayer().addToDeck(spellCard);
    }


    public void stopSpell() {

        GlobalVariable.getPlayer().getActivatedDeck().getMainDeck().get(1).setType("NORMAL");

    }


    public void spellcasterATKplus(MonsterCard monsterCard) {

        monsterCard.setAttack(8000);

    }

    public void fiendATKplus(MonsterCard monsterCard) {
        monsterCard.setAttack(8000);
    }

    public void spellcasterDEFplus(MonsterCard monsterCard) {
        monsterCard.setDefence(8000);
    }

    public void fiendDefplus(MonsterCard monsterCard) {
        monsterCard.setDefence(8000);
    }

    public void fairyATKlose(MonsterCard monsterCard) {
        monsterCard.setAttack(8000);
    }

    public void InsectAtkplus(MonsterCard monsterCard) {
        monsterCard.setAttack(8000);
    }

    public void BeastAtkplus(MonsterCard monsterCard) {
        monsterCard.setAttack(8000);
    }

    public void BeastWarriorAtkplus(MonsterCard monsterCard) {
        monsterCard.setAttack(8000);
    }

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
