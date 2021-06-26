package model;

import controller.GlobalVariable;

import java.io.File;
import java.util.ArrayList;

public class ActionSpell {
    public void setAction(int cardControllerNumber,PlayBoard opl,GraveYard graveYard, ArrayList<MonsterCard> monsters,Board board,Deck deck, Deck side, PlayBoard playBoard) {
        if (cardControllerNumber == 1) {
            addFieldSpellFromDeck(playBoard);
        }
        if (cardControllerNumber == 2) {
            addCard(deck, side);
        }
        if (cardControllerNumber == 3) {
            destroyopmon(playBoard);
        }
        if (cardControllerNumber == 33) {
            supply(playBoard, deck);
        }
        if (cardControllerNumber == 7) {
            spelllife(playBoard);
        }
        if (cardControllerNumber == 4) {
            fiendATKplus(monsters);
        }
        if (cardControllerNumber == 5) {
            spellcasterATKplus(monsters);
        }
        if (cardControllerNumber == 6) {
            fairyATKlose(monsters);
        }
        if (cardControllerNumber == 15) {
            BeastWarriorAtkplus(monsters);
        }
        if (cardControllerNumber == 16) {
            BeastAtkplus(monsters);
        }
        if (cardControllerNumber == 17) {
            InsectAtkplus(monsters);
        }
        if (cardControllerNumber == 18) {
            aquaAtkplus(monsters);
        }
        if (cardControllerNumber == 19) {
            aquadeflos(monsters);
        }
        if (cardControllerNumber == 20) {
            closed(playBoard, monsters);
        }
        if (cardControllerNumber == 21) {
            ring(board);
        }
        if (cardControllerNumber == 22) {
            des(playBoard,opl);
        }
        if (cardControllerNumber == 24) {
            destroytrapspelloponent(deck);
        }
        if (cardControllerNumber == 23) {
            reborn(graveYard,deck);
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
    public void supply(PlayBoard playBoard, Deck deck) {
        if (playBoard.getMonsters().size() < 2) {
            playBoard.setHand(deck.getMonsters(1));
        }
    } //33
public void ring(Board board)
{
    board.reverseTurn();
} //21
    public void addFieldSpellFromDeck(PlayBoard playBoard) {
        playBoard.getHand().add(
                playBoard.getFields());

    } //1
public void destroytrapspelloponent(Deck deckop)
{
   if (deckop.getMonsters(1).size()!=0)
   {
       deckop.getMainDeck().remove(1);
   }
   else if (deckop.getMonsters(2).size()!=0)
    {
        deckop.getMainDeck().remove(2);
    }
   else if (deckop.getMonsters(3).size()!=0)
    {
        deckop.getMainDeck().remove(3);
    }
   else if (deckop.getMonsters(4).size()!=0)
    {
        deckop.getMainDeck().remove(4);
    }
   else if (deckop.getMonsters(5).size()!=0)
    {
        deckop.getMainDeck().remove(5);
    }
} //24
    public void spelllife(PlayBoard playBoard) {
        playBoard.decreaseLifePoint(-500);
    } //7

    public void destroyopmon(PlayBoard playBoard) {
        for (MonsterCard monsterCard : playBoard.getAttackerCards()
        ) {
            playBoard.getAttackerCards().remove(monsterCard);
        }

    } //3
public void reborn(GraveYard graveYard,Deck deck)
{
    Card card;
    card=graveYard.getLostCards().get(1);
    deck.getSideDeck().add(card);

}
    public void addCard(Deck deck, Deck side) { //2
        deck.getMainDeck().add(deck.getSideDeck().get(1));
        deck.getSideDeck().remove(1);
        deck.getMainDeck().add(deck.getSideDeck().get(2));
        deck.getSideDeck().remove(2);


    }

    public void spellcasterATKplus(ArrayList<MonsterCard> spellcasters) { //5
        for (MonsterCard monsterCardd : spellcasters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }

    }


    public void fiendATKplus(ArrayList<MonsterCard> fieldmonsterCards) {
        for (MonsterCard monsterCardd : fieldmonsterCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }

    } //4

    public void fairyATKlose(ArrayList<MonsterCard> fairymonsters) {
        for (MonsterCard monsterCardd : fairymonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() - 200);
        }
    } //6

    public void InsectAtkplus(ArrayList<MonsterCard> insectmonsters) {
        for (MonsterCard monsterCardd : insectmonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
    } //17

    public void aquaAtkplus(ArrayList<MonsterCard> aquamonsters) {
        for (MonsterCard monsterCardd : aquamonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 500);
        }
    } //18

    public void aquadeflos(ArrayList<MonsterCard> aquamonsters) {
        for (MonsterCard monsterCardd : aquamonsters) {
            monsterCardd.setAttack(monsterCardd.getDefence() - 400);
        }
    } //19

    public void closed(PlayBoard playBoard, ArrayList<MonsterCard> beastCards) {
        for (Card card : playBoard.getGraveyards()) {
            for (MonsterCard monsterCard : beastCards) {
                monsterCard.setAttack(monsterCard.getAttack() + 100);
            }
        }
    }

    public void BeastAtkplus(ArrayList<MonsterCard> beastmonsters) {
        for (MonsterCard monsterCardd : beastmonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
    } //16

    public void BeastWarriorAtkplus(ArrayList<MonsterCard> bwmonsters) {
        for (MonsterCard monsterCardd : bwmonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
    } //15
public void des(PlayBoard playBoard,PlayBoard opl)
{
    playBoard.getAttackerCards().clear();
    opl.getAttackerCards().clear();
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
