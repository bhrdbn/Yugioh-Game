package controller;

import model.*;

import model.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIController {
    public String newDuel(int round, String usernamePlayer) {

        if (Player.getPlayerByUser(usernamePlayer).getActivatedDeck() == null) {
            return usernamePlayer + " has no active deck";
        } else if (Player.getPlayerByUser(usernamePlayer).getActivatedDeck() == null) {
            return usernamePlayer + " has no active deck";
        } else if (!Player.getPlayerByUser(usernamePlayer).getActivatedDeck().isValid()) {
            return usernamePlayer + "’s deck is invalid";
        } else if (round != 1 && round != 3)
            return "number of rounds is not supported";
        else {
            PlayBoard playBoardPlayer = new PlayBoard(Player.getPlayerByUser(usernamePlayer));
            PlayBoard playBoardOpponent = new PlayBoard(new AI("pc", "123", "ai", new Deck("AI Deck")));
            GlobalVariable.setBoard(new Board(playBoardPlayer, playBoardOpponent));
            return "duel created";
        }
    }

    public String managePhaseAndPlay() {
        String finalOut = "";
        boolean summon = false;
        GlobalVariable.getBoard().addToHand(GlobalVariable.getBoard().getPlayBoardByTurn());
        finalOut += "draw phase\n";
        finalOut += "standby phase\n";
        finalOut += "1st Main phase\n";
        if (getMaxAttack().getAttack() > getMinOpponentAttack().getAttack()) {
            finalOut += getMaxAttack().getName() + " is summoned\n";
            GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().add(getMaxAttack())
            finalOut += "battle phase\n";
            MonsterCard.Attack(getMinOpponentAttack(), getMaxAttack());
            summon = true;
        }
        finalOut += "2nd Main phase\n";
        if (!summon) {
            MonsterCard.set(getMaxDefense());
            finalOut += "a card is set";
        }
        GlobalVariable.getBoard().changePhase(Phase.END);
        GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(false);
        GlobalVariable.getBoard().reverseTurn();
        finalOut += "End phase\n" + GlobalVariable.getBoard().getTurn().getNickname() + "'s turn";

        return finalOut;
    }



    public MonsterCard getMaxAttack() {
        int max = 0;
        MonsterCard monster = null;
        for (Card card : GlobalVariable.getBoard().getPlayBoardByTurn().getHand()) {
            if (card instanceof MonsterCard) {
                if (max < ((MonsterCard) card).getAttack()) {
                    max = ((MonsterCard) card).getAttack();
                    monster = (MonsterCard) card;
                }
            }
        }
        return monster;
    }

    public MonsterCard getMaxDefense() {
        int max = 0;
        MonsterCard monster = null;
        for (Card card : GlobalVariable.getBoard().getPlayBoardByTurn().getHand()) {
            if (card instanceof MonsterCard) {
                if (max < ((MonsterCard) card).getDefence()) {
                    max = ((MonsterCard) card).getDefence();
                    monster = (MonsterCard) card;
                }
            }
        }
        return monster;
    }

    public MonsterCard getMinOpponentAttack() {
        int max = 0;
        MonsterCard monster = null;
        for (Card card : GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters()) {
            if (card instanceof MonsterCard) {
                if (max < ((MonsterCard) card).getDefence()) {
                    max = ((MonsterCard) card).getDefence();
                    monster = (MonsterCard) card;
                }
            }
        }
        return monster;
    }

}
