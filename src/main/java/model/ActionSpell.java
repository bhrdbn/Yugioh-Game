package model;

import servercontroller.GlobalVariable;

import java.util.ArrayList;
import java.util.List;

public class ActionSpell {
    public void setAction(int cardControllerNumber,Board board, String token) {
        if (cardControllerNumber == 1) {
            addFieldSpellFromDeck(token);
        }
        if (cardControllerNumber == 2) {
            addCard(token);
        }
        if (cardControllerNumber == 3) {
            destroyopmon(token);
        }
        if (cardControllerNumber == 33) {
            supply(token);
        }
        if (cardControllerNumber == 7) {
            spelllife(token);
        }
        if (cardControllerNumber == 4) {
            fiendATKplus(token);
        }
        if (cardControllerNumber == 5) {
            spellcasterATKplus(token);
        }
        if (cardControllerNumber == 6) {
            fairyATKlose(token);
        }
        if (cardControllerNumber == 15) {
            BeastWarriorAtkplus(token);
        }
        if (cardControllerNumber == 16) {
            BeastAtkplus(token);
        }
        if (cardControllerNumber == 17) {
            InsectAtkplus(token);
        }
        if (cardControllerNumber == 18) {
            aquaAtkplus(token);
        }
        if (cardControllerNumber == 19) {
            aquadeflos(token);
        }
        if (cardControllerNumber == 20) {
            closed(token);
        }
        if (cardControllerNumber == 21) {
            ring(board, token);
        }
        if (cardControllerNumber == 22) {
            des(token);
        }
        if (cardControllerNumber == 24) {
            destroytrapspelloponent(token);
        }
        if (cardControllerNumber == 23) {
            reborn(token);
        }
    }

    // 1 terraforming
    //2 PotofGreed
    //3  Raigeki
    // 4 5 6 Yami
    // 15 16 17 Forest
    // 18 19 Umiiruka
    //20 ClosedForest
    //7 SpellAbsorption
    //33 SupplySquad
    // 21 Ringofdefense
    // 22 DarkHole
    //23 MonsterReborn
    //24 HarpiesFeatherDuster

    public void supply(String token) {

        if (GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getMonsters().size() < 2) {
            GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand().add(GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getMonsters().get(1));

        }else{
            System.out.println("cannot activate");
        }
    } //33
public void ring(Board board, String token)
{
    board.reverseTurn();
} //21
    public void addFieldSpellFromDeck(String token) {
        GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand().add(
                GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getFields());
        System.out.println("successfully");

    } //1
public void destroytrapspelloponent(String token)
{ int i=0;

  while (i<GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getSpellTrap().size())
  {
      GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getSpellTrap().remove(i);
      i++;
  }
    System.out.println("successfully");
} //24
    public void spelllife(String token) {
        GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().decreaseLifePoint(-500);
        System.out.println("successfully");
    } //7

    public void destroyopmon(String token) {
        int i=0;
        while (i<GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getMonsters().size())
        {
            GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getMonsters().remove(i);
            i++;
        }
        System.out.println("successfully");

    } //3
public void reborn(String token)
{
    Card card;
    card=GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getGraveyards().get(0);
    GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getDeck().getSideDeck().add(card);
    System.out.println("successfully");

}
    public void addCard(String token) { //2
        GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getDeck().getMainDeck().add(GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getDeck().getSideDeck().get(1));
        GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getDeck().getSideDeck().remove(1);
        GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getDeck().getMainDeck().add(GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getDeck().getSideDeck().get(2));
        GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getDeck().getSideDeck().remove(2);
        System.out.println("successfully");
    }

    public void spellcasterATKplus(String token) {
        //5
        ArrayList<MonsterCard> spellcasters =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("SPELLCASTER"))
            {
                spellcasters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : spellcasters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
        System.out.println("successfully");
    }


    public void fiendATKplus( String token) {
        ArrayList<MonsterCard> fieldmonsterCards =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("FIEND"))
            {
                fieldmonsterCards.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : fieldmonsterCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
        System.out.println("successfully");
    } //4

    public void fairyATKlose(String token) {
        ArrayList<MonsterCard> fairymonsters =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("FIEND"))
            {
                fairymonsters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : fairymonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() - 200);
        }
        System.out.println("successfully");
    } //6

    public void InsectAtkplus(String token) {
        ArrayList<MonsterCard> insectmonsters =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("INSECT"))
            {
                insectmonsters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : insectmonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
        System.out.println("successfully");
    } //17

    public void aquaAtkplus(String token) {
        ArrayList<MonsterCard> aquamonsters =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("AQUA"))
            {
                aquamonsters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : aquamonsters) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 500);
        }
        System.out.println("successfully");
    } //18

    public void aquadeflos(String token) {
        ArrayList<MonsterCard> aquamonsters =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("AQUA"))
            {
                aquamonsters.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : aquamonsters) {
            monsterCardd.setAttack(monsterCardd.getDefence() - 400);
        }
        System.out.println("successfully");
    } //19

    public void closed(String token) {
        ArrayList<MonsterCard> beastCards =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("BEAST"))
            {
                beastCards.add((MonsterCard) card);
            }
        }
        for (Card card : GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getGraveyards()) {
            for (MonsterCard monsterCard : beastCards) {
                monsterCard.setAttack(monsterCard.getAttack() + 100);
            }
        }
        System.out.println("successfully");
    }

    public void BeastAtkplus(String token) {
        ArrayList<MonsterCard> beastCards =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("BEAST"))
            {
                beastCards.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : beastCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
        System.out.println("successfully");
    } //16

    public void BeastWarriorAtkplus(String token) {
        ArrayList<MonsterCard> beastCards =null;
        for (Card card:GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getHand()) {
            if (card.getType().equals("BEASTWARRIOR"))
            {
                beastCards.add((MonsterCard) card);
            }
        }
        for (MonsterCard monsterCardd : beastCards) {
            monsterCardd.setAttack(monsterCardd.getAttack() + 200);
        }
        System.out.println("successfully");
    } //15
public void des(String token)
{
    int i=0;
    while (i<GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getMonsters().size())
    {
        GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getOpponentPlayBoardByTurn().getMonsters().remove(i);
        i++;
    }
    while (i<GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getMonsters().size())
    {
        GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getMonsters().remove(i);
        i++;
    }
    System.out.println("successfully");
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
