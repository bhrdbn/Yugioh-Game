
package controller;

import model.*;
import view.DeckView;
import view.GraveView;
import view.Main;

import java.util.HashMap;
import java.util.regex.Matcher;

public class DuelController {
    private static DuelController duelController = null;

    private DuelController() {

    }

    public static DuelController getInstance() {
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
        } else if (round != 1 && round != 3)
            return "number of rounds is not supported";
        else {
            PlayBoard playBoardPlayer = new PlayBoard(Player.getPlayerByUser(usernamePlayer));
            PlayBoard playBoardOpponent = new PlayBoard(Player.getPlayerByUser(usernameOpponent));
            GlobalVariable.setBoard(new Board(playBoardPlayer, playBoardOpponent));
            return "duel created";
        }
    }

    public String selectOwnMonster(int number) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().selectMonster(number) == null) return
                "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoard().getPlayBoardByTurn().selectMonster(number));
            return "card selected";
        }
    }

    public String selectOpponentMonster(int number) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectMonster(number) == null) return
                "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectMonster(number));
            return "card selected";
        }
    }

    public String selectOwnSpell(int number) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().selectSpellOrTrap(number) == null) return
                "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoard().getPlayBoardByTurn().selectSpellOrTrap(number));
            return "card selected";
        }
    }

    public String selectOpponentSpell(int number) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectSpellOrTrap(number) == null) return
                "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectSpellOrTrap(number));
            return "card selected";
        }
    }

    public String selectHand(int number) {
        if (number > 6) return "selection is invalid";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().selectSpellOrTrap(number) == null) return
                "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoard().getPlayBoardByTurn().selectFromHand(number));
            return "card selected";
        }
    }

    public String selectField() {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getFields() == null)
            return "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoard().getPlayBoardByTurn().getFields());
            return "card selected";
        }
    }

    public String selectOpponentField() {
        if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getFields() == null)
            return "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getFields());
            return "card selected";
        }
    }

    public String managePhase() {
        Phase phase = GlobalVariable.getBoard().getPhase();
        switch (phase) {
            case DRAW:
                GlobalVariable.getBoard().addToHand(GlobalVariable.getBoard().getPlayBoardByTurn());
                return "draw phase";

            case STANDBY:
                return "standby phase";

            case MAIN1:
                return "1st Main phase";

            case BATTLE:
                return "battle phase";

            case MAIN2:
                return "2nd main phase";

            case END:
                GlobalVariable.getBoard().changePhase(Phase.END);
                GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(false);
                GlobalVariable.getBoard().reverseTurn();
                return "End phase\n" + GlobalVariable.getBoard().getTurn().getNickname() + "'s turn";

            default:
                return "";
        }
    }

    public String goNextPhase() {
        if (GlobalVariable.getBoard().getPhase() == Phase.MAIN2 && GlobalVariable.getBoard().isDeckFinished()) {
            return "you lost";
        }
        GlobalVariable.getBoard().changePhase(GlobalVariable.getBoard().getPhase());
        return managePhase();
    }


    public String deselect() {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard() == null)
            return "no card is selected yet";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedOpponentCard(null);
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedCard(null);
            return "card deselected";
        }
    }
// ** monster ba ehzare vizhe ro nazadam **

    public String summon() {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().
                getLocation() != Location.HAND || !(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().
                instanceof MonsterCard))
            return "you can’t summon this card";
        else if (!(GlobalVariable.getBoard().getPhase() == Phase.MAIN1 ||
                GlobalVariable.getBoard().getPhase() == Phase.MAIN2))
            return "action not allowed in this phase";
        else if (GlobalVariable.getBoard().isMonsterZoneFull())
            return ("monster card zone is full");
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().isCardSummonedOrSet())
            return ("you already summoned/set on this turn");
        else if (((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).getLevel() <= 4) {
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
            GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().add
                    ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
            return "summoned successfully";
        }
        else if (((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).getLevel() <= 6) {
            if (GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().size() == 0)
                return "there are not enough cards for tribute";
            else {
                int monster= Integer.parseInt(Main.scanner.nextLine());
                if(GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster)==null)
                    return "there no monsters one this address";
                else {
                    Card card=GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(card);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().remove(monster);
                    GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().add
                            ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    return "summoned successfully";

                }

            }

        }
        else  {
            if (GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().size() < 2)
                return "there are not enough cards for tribute";
            else {
                int monster= Integer.parseInt(Main.scanner.nextLine());
                int monster1= Integer.parseInt(Main.scanner.nextLine());
                if(GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster)==null||
                        GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster1)==null)
                    return "there no monsters one this address";
                else {
                    Card card=GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster);
                    Card card1=GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster1);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(card);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(card1);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().remove(monster);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().remove(monster1);
                    GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().add
                            ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    return "summoned successfully";

                }

            }

        }

    }

    public void tributeMonsters(MonsterCard monser) {

    }

    public boolean isMonsterForTribute(String turn) {

    }

    public boolean isMonserInPosition(int place) {

    }

    public String setMonster(MonsterCard phase, String monster) {

    }

    public String changePosition(Matcher phase, String cardCardMatcher) {

    }

    public String flipSummon(int phase, String place) {

    }

     public String attack(MonsterCard matcher, Matcher phase, MonsterCard monster){
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().
                getLocation() != Location.HAND || GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().
                getLocation() != Location.MONSTERS)
            return "you can’t attack this card";
        else if(GlobalVariable.getBoard().getPhase() != Phase.BATTLE)
            return "you can't do this action in this phase";
        else if(GlobalVariable.getBoard().getPlayBoardByTurn().isCardAttacked())
            return "this card already attacked";
        else if(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard() == null)
            return "there is no card to attack here";
        else
            MonsterCard.Attack(matcher, monster);

    return null;
    }

    public String setDamage(MonsterCard card2, MonsterCard card1) {

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

    public String showCard() {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard() != null) {
            return (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().toString());
        }
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard() != null) {
            return (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard().toString());
        }
        return "no card is selected yet";
    }
}


