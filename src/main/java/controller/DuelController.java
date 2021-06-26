
package controller;

import com.google.gson.stream.JsonToken;
import model.*;
import view.Main;

import java.util.Scanner;
import java.util.regex.Matcher;

public class DuelController {
    private static DuelController duelController = null;
    int rounds;

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
            rounds=round;
            PlayBoard playBoardPlayer = new PlayBoard(Player.getPlayerByUser(usernamePlayer));
            PlayBoard playBoardOpponent = new PlayBoard(Player.getPlayerByUser(usernameOpponent));
            GlobalVariable.setBoard(new Board(playBoardPlayer, playBoardOpponent));
            return "duel created";
        }
    }

    public String newDuelAI(int round, String usernamePlayer) {

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
            PlayBoard playBoardOpponent = new PlayBoard(new AI("AI", "123", "AI"));
            GlobalVariable.setBoard(new Board(playBoardPlayer, playBoardOpponent));
            return "duel created";
        }
    }


    public String selectOwnMonster(int number) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().selectMonster(number).getName().equals("nokhodi"))
            return
                    "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoard().getPlayBoardByTurn().selectMonster(number));
            return "card selected";
        }
    }

    public String selectOpponentMonster(int number) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectMonster(number).getName().equals("nokhodi"))
            return
                    "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectMonster(number));
            return "card selected";
        }
    }

    public String selectOwnSpell(int number) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().selectSpellOrTrap(number).getName().equals("nokhodi"))
            return
                    "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoard().getPlayBoardByTurn().selectSpellOrTrap(number));
            return "card selected";
        }
    }

    public String selectOpponentSpell(int number) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectSpellOrTrap(number).getName().equals("nokhodi"))
            return
                    "no card found in the given position";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().selectSpellOrTrap(number));
            return "card selected";
        }
    }

    public String selectHand(int number) {
        if (number > 6) return "selection is invalid";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getHand().size() < number) return
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
                return "draw phase\n" +
                        (GlobalVariable.getBoard().addToHand(GlobalVariable.getBoard().getPlayBoardByTurn()));
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
                GlobalVariable.getBoard().getPlayBoardByTurn().setSetSummonedMonster(null);
                GlobalVariable.getBoard().reverseTurn();
                if (GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer() instanceof AI) {
                    return manageAIPhaseAndPlay();
                } else return "End phase\n" + GlobalVariable.getBoard().getTurn().getNickname() + "'s turn" + "\n" +
                        "draw phase\n" +
                        (GlobalVariable.getBoard().addToHand(GlobalVariable.getBoard().getPlayBoardByTurn()));

            default:
                return "";
        }
    }

    public String manageAIPhaseAndPlay() {
        String finalOut = "End phase\n" + GlobalVariable.getBoard().getTurn().getNickname() + "'s turn" + "\n" +
                "draw phase\n" +
                (GlobalVariable.getBoard().addToHand(GlobalVariable.getBoard().getPlayBoardByTurn()));
        GlobalVariable.getBoard().setPhase(Phase.STANDBY);
        finalOut += "standby phase\n";
        GlobalVariable.getBoard().setPhase(Phase.MAIN1);
        finalOut += "1st Main phase\n";
        if (getMinOpponentAttack()!=null&&getMaxAttack().getAttack() > getMinOpponentAttack().getAttack()) {
            GlobalVariable.getBoard().getPlayBoardByTurn().setSelectedCard(getMaxAttack());
            finalOut += summon() + "\n";
            GlobalVariable.getBoard().setPhase(Phase.BATTLE);
            finalOut += "battle phase\n";
            finalOut += MonsterCard.Attack(getMaxAttack(), getMinOpponentAttack(), getMinOpponentAttackIndex())+"\n";

        }
        else if(getMinOpponentAttack()==null){
            GlobalVariable.getBoard().getPlayBoardByTurn().setSelectedCard(getMaxAttack());
            GlobalVariable.getBoard().setPhase(Phase.BATTLE);
            finalOut += "battle phase\n";
            MonsterCard.directAttack();
        }
        else {
            GlobalVariable.getBoard().setPhase(Phase.BATTLE);
            finalOut += "battle phase\n";
        }
        finalOut += "2nd Main phase\n";
        GlobalVariable.getBoard().setPhase(Phase.MAIN2);
        if (!GlobalVariable.getBoard().getPlayBoardByTurn().isCardSummonedOrSet()) {
            GlobalVariable.getBoard().getPlayBoardByTurn().setSelectedCard(getMaxDefense());
            finalOut += setMonster() + "\n";
        }
        GlobalVariable.getBoard().setPhase(Phase.END);
        finalOut += managePhase();
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
        int min = 99999;
        MonsterCard monster = null;
        for (MonsterCard card : GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters()) {
            if (!card.getName().equals("nokhodi")) {
                if (min > card.getDefence()) {
                    min = card.getDefence();
                    monster = card;
                }
            }
        }
        return monster;
    }

    public int getMinOpponentAttackIndex() {
        int min = 99999;
        int position=0;
        MonsterCard monster = null;
        for (int i = 0; i < 5; i++) {
            if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(i).getDefence() < min) {
                min = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(i).getDefence();
                position=i+1;
            }
        }
        return position;
    }
    public void lose(){
        int lp= GlobalVariable.getBoard().getPlayBoardByTurn().getLifePoint();
        int opLp=GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint();
        if(rounds==1){
            GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(100);
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(1000+
                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint());
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(1000);
        }


    }

    public String goNextPhase() {
        if (GlobalVariable.getBoard().getPhase() == Phase.MAIN2 && (GlobalVariable.getBoard().isDeckFinished()||
                GlobalVariable.getBoard().getPlayBoardByTurn().getLifePoint()<=0) ){
            lose();
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

    public int countNokhodi() {
        int number = 0;
        for (MonsterCard monster : GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters()) {
            if (monster.getName().equals("nokhodi")) number++;
        }
        return number;
    }
// ** monster ba ehzare vizhe ro nazadam **

    public String summon() {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedOpponentCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().
                        getLocation() != Location.HAND || !(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()
                instanceof MonsterCard))
            return "you can’t summon this card";
        else if (!(GlobalVariable.getBoard().getPhase() == Phase.MAIN1 ||
                GlobalVariable.getBoard().getPhase() == Phase.MAIN2))
            return "action not allowed in this phase";
        else if (countNokhodi() == 0)
            return ("monster card zone is full");
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().isCardSummonedOrSet())
            return ("you already summoned/set on this turn");
        else if (((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).getLevel() <= 4) {
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
            GlobalVariable.getBoard().getPlayBoardByTurn().setSetSummonedMonster
                    ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
            for (int i = 0; i < 5; i++) {

                if (GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi")) {
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().
                            set(i, (MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setIsAttack(true);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setLocation(Location.MONSTERS);
                    break;
                }
            }
            GlobalVariable.getBoard().getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard());
            return "summoned successfully";
        } else if (((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).getLevel() <= 6) {
            if (countNokhodi() == 5)
                return "there are not enough cards for tribute";
            else {
                int monster = Integer.parseInt(Main.scanner.nextLine());
                if (GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster - 1).getName().equals("nokhodi"))
                    return "there no monsters one this address";
                else {
                    Card card = GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster - 1);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(card);
                    setNokhodi(GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster - 1));
                    GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
                    GlobalVariable.getBoard().getPlayBoardByTurn().setSetSummonedMonster
                            ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    for (int i = 0; i < 5; i++) {

                        if (GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi")) {
                            GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().
                                    set(i, (MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                            GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setIsAttack(true);
                            GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setLocation(Location.MONSTERS);
                            break;
                        }

                    }
                    GlobalVariable.getBoard().getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard());
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("Suijin")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(2,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("CrabTurtle")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(3,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("GateGuardian")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(4,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("SkullGuardian")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(5,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("BeastKingBarbaros")){
                        int i;
                        System.out.println("please enter which mode you want to sacrifice press 1 else 0");
                        i=Main.scanner.nextInt();
                        ActionMonster actionMonster = new ActionMonster();
                        if (i==0){ actionMonster.setAction(8,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());}
                        else {actionMonster.setAction(9,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());}
                    }
                    return "summoned successfully";

                }

            }

        } else {
            if (countNokhodi() > 3)
                return "there are not enough cards for tribute";
            else {
                int monster = Integer.parseInt(Main.scanner.nextLine());
                int monster1 = Integer.parseInt(Main.scanner.nextLine());
                if (GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster - 1).getName().equals("nokhodi") ||
                        GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster1 - 1).getName().equals("nokhodi"))
                    return "there no monsters one this address";
                else {
                    Card card = GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster - 1);
                    Card card1 = GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster1 - 1);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(card);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(card1);
                    setNokhodi(GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster - 1));
                    setNokhodi(GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().remove(monster1 - 1));
                    GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
                    GlobalVariable.getBoard().getPlayBoardByTurn().setSetSummonedMonster
                            ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    for (int i = 0; i < 5; i++) {

                        if (GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi")) {
                            GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().
                                    set(i, (MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                            GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setIsAttack(true);
                            GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setLocation(Location.MONSTERS);
                            break;
                        }
                    }
                    GlobalVariable.getBoard().getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard());
                    return "summoned successfully";

                }

            }

        }

    }

    public void setNokhodi(Card card) {
        card = new Card("nokhodi", 1, "ff", "aa", false, 1);
    }

    public void tributeMonsters(int monser) {

    }

    //  public boolean isMonsterForTribute(String turn) {
//
    //  }
//
    //  public boolean isMonserInPosition(int place) {
//
    //  }
//
    public String setMonster() {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() != Location.HAND)
            return "you can't set this card";
        else if ((GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()
                instanceof MonsterCard) &&
                (GlobalVariable.getBoard().getPhase() != Phase.MAIN1 && GlobalVariable.getBoard().getPhase() != Phase.MAIN2))
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoard().isMonsterZoneFull())
            return "monster card zone is full";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().isCardSummonedOrSet())
            return "you already summoned/set on this turn";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
            GlobalVariable.getBoard().getPlayBoardByTurn().setSetSummonedMonster
                    ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
            for (int i = 0; i < 5; i++) {
                if (GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi")) {
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().set(i, (MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setSide(false);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setIsAttack(false);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(i).setLocation(Location.MONSTERS);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    break;
                }

            }
            return "set successfully";
        }


    }

    public String changePosition(Matcher phase) {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() != Location.MONSTERS)
            return "you can't change this card position";
        else if (GlobalVariable.getBoard().getPhase() != Phase.MAIN1 &&
                GlobalVariable.getBoard().getPhase() != Phase.MAIN2)
            return "you can't do this action in this phase";
        else if (phase.group(1).equals("attack") && (!GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().isSide() ||
                ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).isAttack()))
            return "this card is already in the wanted position";
        else if (phase.group(1).equals("defence") && !(((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).isAttack()))
            return "this card is already in the wanted position";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().isPositionChanged())
            return "you already changed this card position in this turn";
        else if (phase.group(1).equals("attack")) {

            ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).setIsAttack(true);
            GlobalVariable.getBoard().getPlayBoardByTurn().setPositionChanged(true);
            return "monster card position changed successfully";
        } else {


            GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().setSide(true);
            ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).setIsAttack(false);
            GlobalVariable.getBoard().getPlayBoardByTurn().setPositionChanged(true);


            return "monster card position changed successfully";
        }

    }

    public String flipSummon() {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() != Location.MONSTERS)
            return "you can't change this card position";
        else if (GlobalVariable.getBoard().getPhase() != Phase.MAIN1 &&
                GlobalVariable.getBoard().getPhase() != Phase.MAIN2)
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().isSide()
                || ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).isAttack() ||
                GlobalVariable.getBoard().getPlayBoardByTurn().getSetSummonedMonster() ==
                        GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard())
            return "you can't flip summon this card";
        else {
            ((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).setIsAttack(true);
            return "flip summoned successfully";
        }
    }


    public String attack(int number) {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(number - 1).getName().equals("nokhodi"))
            return "no card is selected yet";
        else if (!GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(number - 1).isCanBeAttacked()|| GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().
                getLocation() != Location.MONSTERS)
            return "you can’t attack this card";
        else if (GlobalVariable.getBoard().getPhase() != Phase.BATTLE)
            return "you can't do this action in this phase";
        else if ((GlobalVariable.getBoard().getPlayBoardByTurn().isCardAttacked()))
            return "this card already attacked";
        else if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(number - 1).getName().equals("nokhodi"))
            return "there is no card to attack here";
        else
            return MonsterCard.Attack((MonsterCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard(), GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(number - 1), number);
    }

    //  public String setDamage(MonsterCard card2, MonsterCard card1) {
//
    //  }

    public String directAttack() {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() != Location.MONSTERS)
            return "you can't attack with this card";
        else if (GlobalVariable.getBoard().getPhase() != Phase.BATTLE)
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().isCardAttacked())
            return "this card already attacked";
        else {
            int counter = 0;
            for (int i = 0; i < 5; i++) {
                if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi"))
                    counter++;
            }
            if (counter != 5)
                return "you can't attack the opponent directly";
            else
                return MonsterCard.directAttack();
        }
    }

    public String activateCard(SpellCard card) {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (!(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() instanceof SpellCard))
            return "activate effect is only for spell cards";
        else if (GlobalVariable.getBoard().getPhase() != Phase.MAIN1 && GlobalVariable.getBoard().getPhase() != Phase.MAIN2)
            return "you can't activate effect on this turn";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().isCardActivated())
            return "you have already activated this card";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() == Location.HAND &&
                GlobalVariable.getBoard().isSpellZoneFull() && GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedSpellCard().getSpellType() != TypeOfSpellCard.FIELD)
            return "spell card zone is full";
        else if (!isSpellConditionMet((SpellCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()))
            return "preparations of this spell are not done yet";
        else if (((SpellCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedSpellCard()).getIcon().equals("Field")) {
            GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().add(card);
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardActivated(true);
            return "spell activated";
        } else {
            if (GlobalVariable.getBoard().isFieldZoneFull())
                GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(GlobalVariable.getBoard().getPlayBoardByTurn().getFields());
            GlobalVariable.getBoard().getPlayBoardByTurn().setFields(card);
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardActivated(true);
            return "spell activated";

        }


    }

    public boolean isSpellConditionMet(SpellCard spellCard) {
        boolean isConditionMet = false;
        switch (spellCard.getIcon()) {
            case "Equip":
            case "Ritual":
            case "Counter":
            case "Normal":
                isConditionMet = GlobalVariable.getBoard().getPlayBoardByTurn().isCardActivated();
                break;
            case "Continuous":
            case "Field":
                isConditionMet = spellCard.isSide();
                break;
            case "Quick-play":
                isConditionMet = GlobalVariable.getBoard().getPlayBoardByTurn().isCardSummonedOrSet();
                break;
        }

        return isConditionMet;
    }

//   public String setField(SpellCard field) {
//
//   }

    public String setSpellCard(SpellCard spell, Phase phase) {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedSpellCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() != Location.HAND)
            return "you can't set this card";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() instanceof SpellCard && (GlobalVariable.getBoard().getPhase() != Phase.MAIN1 || GlobalVariable.getBoard().getPhase() != Phase.MAIN2))
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoard().isSpellZoneFull())
            return "spell card zone is full";
        else {
            GlobalVariable.getBoard().addToSpell(spell);
            GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().setSide(false);
            return "set successfully";
        }
    }

   public String setTrapCard(TrapCard trap){
       if(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedTrapCard() == null)
           return "no card is selected yet";
       else if(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() != Location.HAND)
           return "you can't set this card";
       else if(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() instanceof TrapCard && (GlobalVariable.getBoard().getPhase() != Phase.MAIN1 || GlobalVariable.getBoard().getPhase() != Phase.MAIN2))
           return "you can't do this action in this phase";
       else if(GlobalVariable.getBoard().isSpellZoneFull())
           return "spell card zone is full";
       else{
           GlobalVariable.getBoard().addToTrap(trap);
           GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().setSide(false);
           return "set successfully";
       }
   }

 //  }
   public String activateCardAndChangeTurn(SpellCard card) {
       if(isSpellConditionMet(card)) {
           System.out.println("now it will be " + GlobalVariable.getPlayer().getUsername() + " turn");
           System.out.println(GlobalVariable.getBoard().getPlayBoardByTurn());
           System.out.println("do you want to activate your trap and spell?");
           String input= Main.scanner.nextLine();
           String activation= Main.scanner.nextLine();
           if(input.equals("no")) {
               System.out.println("now it will be " + GlobalVariable.getPlayer().getUsername() + " turn");
               System.out.println(GlobalVariable.getBoard().getPlayBoardByTurn());
           }
           else{
               if(activation.equals("activate spell") || activation.equals("activate trap")) {
                   if (isSpellConditionMet(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedSpellCard())) {
                       activateCard(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedSpellCard());
                       return "spell/trap activated";
                   }
                   else
                       return "it's not your turn to play this kind of moves";
               }

           }

       }
  return null;
   }

  //public String ritualSummon(SpellCard card) {
  //     if(!isConditionMet(card))
  //         return "there is no way you could ritual summon a monster";
  //     else if(isConditionMet(card) && (!GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedSpellCard().getSpellType() .equals("Ritual") || GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedMonsterCard().typeOfMonsterCard() .equals("Ritual") ))
  //         return "you should ritual summon right now";
  //     else{
  //         System.out.println("please enter the cards that you want to tribute");
  //         String input = Main.scanner.nextLine();
  //         if(!isMonsterForTribute(input))
  //             return "selected monsters levels don't match with ritual monster";
  //         else{
  //             tributeMonsters(Integer.parseInt(input));
  //             //tavize halat
  //             return "summoned successfully";
  //         }


  //     }


  //}

 //  public boolean isLevelMatched(int level) {

 //  }

 //  public boolean areThereMatchedLevels(int level) {

 //  }

   //public String SpecialSummon(Card card) {
//
   //}

 //  public void showGrave() {

 //  }

 //  public String Surrender(String turn) {

 //  }

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


