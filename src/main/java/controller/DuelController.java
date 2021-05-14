package controller;

import model.*;
import view.DeckView;

import java.util.regex.Matcher;

public class DuelController {
    private static DuelController duelController=null;
    private DuelController(){

    }
    public static DuelController getInstance()
    {
        if (duelController == null)
            duelController = new DuelController();

        return duelController;
    }


    public String newDuel(int round, String usernameOpponent, String usernamePlayer) {
        if (Player.getPlayerByUser(usernameOpponent) == null) return "there is no player with this username";
        else if (Player.getPlayerByUser(usernamePlayer).getActivatedDeck() == null) {
            return usernamePlayer + " has no active deck";
        } else if (Player.getPlayerByUser(usernameOpponent).getActivatedDeck() == null) {
            return usernameOpponent + " has no active deck";
        } else if (Player.getPlayerByUser(usernamePlayer).getActivatedDeck() == null) {
            return usernamePlayer + " has no active deck";
        } else if (!Player.getPlayerByUser(usernamePlayer).getActivatedDeck().isValid()) {
            return usernamePlayer + "’s deck is invalid";
        } else if (!Player.getPlayerByUser(usernameOpponent).getActivatedDeck().isValid()) {
            return usernameOpponent + "’s deck is invalid";
        }
        else if(round!=1&&round!=3)
            return "number of rounds is not supported";
        else {
            PlayBoard playBoardPlayer=new PlayBoard(Player.getPlayerByUser(usernamePlayer));
            PlayBoard playBoardOpponent=new PlayBoard(Player.getPlayerByUser(usernameOpponent));
            GlobalVariable.setBoard(new Board(playBoardPlayer,playBoardOpponent));
            return null;
        }
    }
    public String selectOwnMonster(int number) {
        if(number>5) return "selection is invalid" ;
        else if(GlobalVariable.getBoard().getPlayBoardByTurn().selectMonster(number)==null) return
                "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoard().getPlayBoardByTurn().selectMonster(number));
            return null;
        }
    }
    public String selectOpponentMonster(int number) {
        if(number>5) return "selection is invalid" ;
        else if(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectMonster(number)==null) return
                "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectMonster(number));
            return null;
        }
    }

    public Void addCard(String phase) {

    }

    public void summon(Matcher matcher) {

    }

    public void tributeMonsters(MonsterCard monser) {

    }

    public boolean isMonsterForTribute(Sring turn) {

    }

    public boolean isMonserInPosition(int place) {

    }

    public String setMonster(MonsterCard phase:String monster) {

    }

    public Sring changePosition(Matcher phase:String cardCardMatcher) {

    }

    public Sring flipSummon(int phase:String place) {

    }

    public String attack(MonsterCard matcher :Matcher phase:Sring monster) {

    }

    public String setDamage(MonsterCard card2:MonsterCard card1) {

    }

    public String attackDirect(MonsterCard phase :String monster) {

    }

    public String activateCard(Card card) {

    }

    public String isConditionMet(String spellCardPhase) {

    }

    public String setField(SpellCard field) {

    }

    public String setSpellCard(SpellCard phase:String spell) {

    }

    public String activateCardAndChangeTurn(SpellCard card) {

    }

    public String ritualsummon(SpellCard card) {

    }

    public boolean isLevelMatched(int level) {

    }

    public boolean areThereMatchedLevels(int level) {

    }

    public String SpecialSummon(Card card) {

    }

    public void showGrave() {

    }

    public String Surrender(String turn) {

    }

    public void showCard(Card card) {

    }
}
*/
        }