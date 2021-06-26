package model;

import controller.GlobalVariable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ActionSpell {
    PlayBoard playBoard = GlobalVariable.getBoard().getPlayBoardByTurn();
    Deck deck = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getDeck();
    PlayBoard OPplayboard = GlobalVariable.getBoard().getOpponentPlayBoardByTurn();
    List<Card> graveYard = GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards();
    public void setAction(int cardControllerNumber,Board board) {
        if (cardControllerNumber == 1) {
            addFieldSpellFromDeck();
        }
        if (cardControllerNumber == 2) {
            addCard();
        }
        if (cardControllerNumber == 3) {
            destroyopmon();
        }
        if (cardControllerNumber == 33) {
            supply();
        }
        if (cardControllerNumber == 7) {
            spelllife();
        }
        if (cardControllerNumber == 4) {
            fiendATKplus();
        }
        if (cardControllerNumber == 5) {
            spellcasterATKplus();
        }
        if (cardControllerNumber == 6) {
            fairyATKlose();
        }
        if (cardControllerNumber == 15) {
            BeastWarriorAtkplus();
        }
        if (cardControllerNumber == 16) {
            BeastAtkplus();
        }
        if (cardControllerNumber == 17) {
            InsectAtkplus();
        }
        if (cardControllerNumber == 18) {
            aquaAtkplus();
        }
        if (cardControllerNumber == 19) {
            aquadeflos();
        }
        if (cardControllerNumber == 20) {
            closed();
        }
        if (cardControllerNumber == 21) {
            ring(board);
        }
        if (cardControllerNumber == 22) {
            des();
        }
        if (cardControllerNumber == 24) {
            destroytrapspelloponent();
        }
        if (cardControllerNumber == 23) {
            reborn();
        }
    }

    // 1 terraforming
    //2 pot of greed
    //3 raigeki
    // 4 5 6 yami
    // 15 16 17 forest
    // 18 19 umiruka
    //20 closed forest
    //7 spell absorption
    //33 supply squad
    // 21 ring of defence
    // 22 dark hole
    //23 monster reborn
    //24 Harpie’s Feather Duster
    //25
    public void supply() {

        if (playBoard.getMonsters().size() < 2) {
            GlobalVariable.getBoard().getPlayBoardByTurn().getHand().add(GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(1));

        }else{
            System.out.println("cannot activate");
        }
    } //33
public void ring(Board board)
{
    board.reverseTurn();
} //21
    public void addFieldSpellFromDeck() {
        playBoard.getHand().add(
                playBoard.getFields());

    } //1
public void destroytrapspelloponent()
{ int i=0;

  while (i<GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getSpellTrap().size())
  {
      GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getSpellTrap().remove(i);
      i++;
  }
} //24
    public void spelllife() {
        playBoard.decreaseLifePoint(-500);
    } //7

    public void destroyopmon() {
        int i=0;
        while (i<GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().size())
        {
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().remove(i);
            i++;
        }

    } //3
public void reborn()
{
    Card card;
    card=graveYard.get(0);
    deck.getSideDeck().add(card);

}
    public void addCard() { //2
        deck.getMainDeck().add(deck.getSideDeck().get(1));
        deck.getSideDeck().remove(1);
        deck.getMainDeck().add(deck.getSideDeck().get(2));
        deck.getSideDeck().remove(2);
    }

    public void spellcasterATKplus() {
        //5
        ArrayList<MonsterCard> spellcasters =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("SPELLCASTER"))
            {
                spellcasters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : spellcasters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }

    }


    public void fiendATKplus( ) {
        ArrayList<MonsterCard> fieldmonsterCards =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("FIEND"))
            {
                fieldmonsterCards.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : fieldmonsterCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }

    } //4

    public void fairyATKlose() {
        ArrayList<MonsterCard> fairymonsters =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("FIEND"))
            {
                fairymonsters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : fairymonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() - 200);
        }
    } //6

    public void InsectAtkplus() {
        ArrayList<MonsterCard> insectmonsters =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("INSECT"))
            {
                insectmonsters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : insectmonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
    } //17

    public void aquaAtkplus() {
        ArrayList<MonsterCard> aquamonsters =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("AQUA"))
            {
                aquamonsters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : aquamonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 500);
        }
    } //18

    public void aquadeflos() {
        ArrayList<MonsterCard> aquamonsters =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("AQUA"))
            {
                aquamonsters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : aquamonsters) {
            monsterCardd.setAttack(monsterCardd.getDefence() - 400);
        }
    } //19

    public void closed() {
        ArrayList<MonsterCard> beastCards =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("BEAST"))
            {
                beastCards.add((MonsterCard) card);
            }
        }
        for (Card card : playBoard.getGraveyards()) {
            for (MonsterCard monsterCard : beastCards) {
                monsterCard.setAttack(monsterCard.getAttack() + 100);
            }
        }
    }

    public void BeastAtkplus() {
        ArrayList<MonsterCard> beastCards =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("BEAST"))
            {
                beastCards.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : beastCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
    } //16

    public void BeastWarriorAtkplus() {
        ArrayList<MonsterCard> beastCards =null;
        for (Card card:playBoard.getHand()) {
            if (card.getType().equals("BEASTWARRIOR"))
            {
                beastCards.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : beastCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
    } //15
public void des()
{
    int i=0;
    while (i<GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().size())
    {
        GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().remove(i);
        i++;
    }
    while (i<GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().size())
    {
        GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().remove(i);
        i++;
    }
}
/*
    public void BeastATKincreaseforGraveYard(int cardControllerNumber) {

    }

    public void beastWarrordefplus(int cardControllerNumber) {

    }

    public void aquaIncreaseAtkdecreaseDef(int cardControllerNumber) {

    }

    public void fiendATKincreaseandDEFdecrease(int cardControllerNumber) {

    }

    public void ThrowAwayOneAndDestroy2spellOrTraps(int cardControllerNumber) {

    }

    public void destroyASpellOrATrap(int cardControllerNumber) {

    }

    public void trapOPattackToZero(int cardControllerNumber) {

    }

    public void spellcasterATKincreaseandDEFdecrease(int cardControllerNumber) {

    }

    public void equipedCards(int cardControllerNumber) {

    }

    public void destroyallMonstersOnField(int cardControllerNumber) {

    }

    public void changeAmonsterForThisRound(int cardControllerNumber) {

    }

    public void destoryAllSpellAndTraps(int cardControllerNumber) {

    }

    public void ifFrontCantAttack(int cardControllerNumber) {

    }

    public void freezethegame(int cardControllerNumber) {

    }

    public void destroyallMonstersFromBothSides(int cardControllerNumber) {

    }

    public void ifACardLostTakeAnother(int cardControllerNumber) {

    }

    public void equippedMonstersEach(int cardControllerNumber) {

    }

    public void warriorEquipped(int cardControllerNumber) {

    }


    public void run() {

    }

*/
}
