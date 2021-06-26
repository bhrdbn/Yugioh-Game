package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.*;

public class Duel {
    DuelController duelController = DuelController.getInstance();
    private static Duel duel = null;

    private Duel() {

    }

    public static Duel getInstance() {
        if (duel == null)
            duel = new Duel();

        return duel;
    }

    Matcher matcherSelect;
    Matcher matcherSelect2;

    public void run() {
        System.out.println("welcome to duel menu");
        while (true) {
            String input = Main.scanner.nextLine();
            Matcher matcherPlayer0 = getCommand(input, "duel new second-player (\\w+) rounds (\\d)");
            Matcher matcherPlayer1 = getCommand(input, "duel new rounds (\\d) second-player (\\w+)");
            Matcher matcherSelect4 = getCommand(input, "select spell (\\d)");
            Matcher matcherSelect10 = getCommand(input, "select hand (\\d)");
            Matcher matcherSelect5 = getCommand(input, "select spell (\\d) opponent");
            Matcher matcherSelect6 = getCommand(input, "select opponent spell (\\d)");
            Matcher matcherSelect9 = getCommand(input, "select field");
            Matcher matcherSelect7 = getCommand(input, "select field opponent");
            Matcher matcherSelect8 = getCommand(input, "select opponent field");
            Matcher deselect = getCommand(input, "select -d");
            Matcher nextPhase = getCommand(input, "next phase");

            Matcher matcherAI = getCommand(input, "duel new ai rounds (\\w+)");
            matcherSelect = getCommand(input, "select monster (\\d)");
            matcherSelect2 = getCommand(input, "select monster (\\d) opponent");
            Matcher matcherSelect3 = getCommand(input, "select opponent monster (\\d)");
            Matcher matcherMainPhase = getCommand(input, "new card added to the hand : (\\w+)");
            Matcher matcherEndPhase = getCommand(input, "new card added to the hand : (\\w+)");
            Matcher matchersummon = getCommand(input, "^summon$");
            Matcher matcherstandbyPhase = getCommand(input, "new card added to the hand : (\\w+)");
            Matcher matcherSet = getCommand(input, "^set$");
            Matcher matchersetPosATK = getCommand(input, "set -- position (attack)");
            Matcher matchersetPosDEF = getCommand(input, "set -- position (defence)");
            Matcher matcherflipSummon = getCommand(input, "flip-summon");
            Matcher matcherAttack = getCommand(input, "attack (\\d)");
            Matcher matcherDirectAttack = getCommand(input, "attack direct$");
            Matcher activateEffect = getCommand(input, "activate effect");
            Matcher matcherSetSpell = getCommand(input, "setSpell");
            Matcher matcherSetTrap = getCommand(input, "SetTrap");
            Matcher showGraveyard = getCommand(input, "show graveyard");
            Matcher showOpponentGraveyard = getCommand(input, "show opponent graveyard");
            Matcher showCard = getCommand(input, "show card");
            Matcher matcherback = getCommand(input, "back");
            Matcher surrender = getCommand(input,"surrender");
            if (matcherPlayer0.find()) {
                newDuel(matcherPlayer0, 0);
            } else if (matcherPlayer1.find()) {
                newDuel(matcherPlayer1, 1);
            } else if (matcherSelect.find()) {
                selectOwnMonster(Integer.parseInt(matcherSelect.group(1)));
            } else if (matcherSelect10.find()) {
                selectHand(Integer.parseInt(matcherSelect10.group(1)));
            } else if (matcherSelect4.find()) {
                selectOwnSpell(Integer.parseInt(matcherSelect4.group(1)));
            } else if (matcherSelect2.find()) {
                selectOpponentMonster(Integer.parseInt(matcherSelect2.group(1)));
            } else if (matcherSelect3.find()) {
                selectOpponentMonster(Integer.parseInt(matcherSelect3.group(1)));
            } else if (matcherSelect5.find()) {
                selectOpponentSpell(Integer.parseInt(matcherSelect5.group(1)));
            } else if (matcherSelect6.find()) {
                selectOpponentMonster(Integer.parseInt(matcherSelect6.group(1)));
            } else if (matcherback.find()) MenuHandler.runBack(Menu.DUEL);

            else if (nextPhase.find()) {
                goNextPhase();
            } else if (matchersummon.find()) {
                summon(matchersummon);
            } else if (matcherSet.find()) {
                set(matcherSet);
            } else if (matcherSelect9.find()) {
                selectField();
            } else if (matcherSelect7.find() || matcherSelect8.find()) {
                selectOpponentField();
            } else if (deselect.find()) deselect();
            else if (showGraveyard.find()) {
                showGrave();
            } else if (showOpponentGraveyard.find()) {
                showOpponentGrave();
            } else if (showCard.find()) {
                showCard();
            } else if (matchersetPosATK.find()) {
                setPosATK(matchersetPosATK);
            } else if (matchersetPosDEF.find()) {
                setPosDEF(matchersetPosDEF);
            } else if (matcherflipSummon.find()) {
                flipSummons(matcherflipSummon);
            } else if (matcherAttack.find())
                attack(matcherAttack);
            else if (matcherDirectAttack.find())
                directAttack(matcherDirectAttack);
            else if (activateEffect.find())
                activateEffect(activateEffect);
            else if (matcherSetSpell.find())
                setSpell(matcherSetSpell);
            else if(matcherAI.find()){
                newDuelAI(matcherAI);
            }
            else if(matcherSetTrap.find()){
                setTrap(matcherSetTrap);
            }
            else if(surrender.find()){
                setWin();
            }
            else
                System.out.println("invalid command");
        }
    }

    public void setTrap(Matcher matcherSetTrap) {
        System.out.println(duelController.setTrapCard(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedTrapCard()));
    }

    public void newDuelAI(Matcher matcher){
        int rounds=Integer.parseInt(matcher.group(1));
        System.out.println(duelController.newDuelAI(rounds,GlobalVariable.getPlayer().getUsername()));
        System.out.println(GlobalVariable.getBoard().toString());

    }
    public void setWin(){
        duelController.setWin();
    }


    public void activateEffect(Matcher activateEffect) {
        System.out.println(duelController.activateCard(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedSpellCard()));
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void setSpell(Matcher matcherSetSpell) {
        System.out.println(duelController.setSpellCard(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedSpellCard(), GlobalVariable.getBoard().getPhase()));
        System.out.println(GlobalVariable.getBoard().toString());
    }

   public void directAttack(Matcher matcherDirectAttack) {
       System.out.println(duelController.directAttack());
       System.out.println(GlobalVariable.getBoard().toString());

   }

    public void attack(Matcher matcherAttack) {
        System.out.println(duelController.attack(Integer.parseInt(matcherAttack.group(1))));
        System.out.println(GlobalVariable.getBoard().toString());

    }

    public void flipSummons(Matcher matcherflipSummon) {
        System.out.println(duelController.flipSummon());
        System.out.println(GlobalVariable.getBoard().toString());

    }

    public void setPosDEF(Matcher matchersetPosDEF) {
            System.out.println(duelController.changePosition(matchersetPosDEF));
        System.out.println(GlobalVariable.getBoard().toString());

    }

    public void setPosATK(Matcher matchersetPosATK) {
            System.out.println(duelController.changePosition(matchersetPosATK));
        System.out.println(GlobalVariable.getBoard().toString());

    }

    public void set(Matcher matcherSet) {
        System.out.println(duelController.setMonster());
        System.out.println(GlobalVariable.getBoard().toString());

    }

    public void newDuel(Matcher matcherPlayer, int flag) {
        if (flag == 0)
            System.out.println(duelController.newDuel(Integer.parseInt
                    (matcherPlayer.group(2)), matcherPlayer.group(1), GlobalVariable.getPlayer().getUsername()));
        else
            System.out.println(DuelController.getInstance().newDuel(Integer.parseInt
                    (matcherPlayer.group(1)), matcherPlayer.group(2), GlobalVariable.getPlayer().getUsername()));
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void goNextPhase() {
        System.out.println(duelController.goNextPhase());
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void selectOwnMonster(int number) {
        System.out.println(duelController.selectOwnMonster(number));
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void selectOpponentMonster(int number) {
        System.out.println(duelController.selectOpponentMonster(number));
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void selectOwnSpell(int number) {
        System.out.println(DuelController.getInstance().selectOwnSpell(number));
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void selectOpponentSpell(int number) {
        System.out.println(duelController.selectOpponentSpell(number));
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void selectField() {
        System.out.println(duelController.selectField());
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void selectOpponentField() {
        System.out.println(duelController.selectOpponentField());
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void selectHand(int number) {
        System.out.println(duelController.selectHand(number));
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void deselect() {
        System.out.println(duelController.deselect());
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void showGrave() {
        System.out.println(GraveyardController.getInstance().showMyGraveyard());
        GraveView.getInstance().run();
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void showOpponentGrave() {
        System.out.println(GraveyardController.getInstance().showOpponentGraveyard());
        GraveView.getInstance().run();
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void showCard() {
        System.out.println(duelController.showCard());
        System.out.println(GlobalVariable.getBoard().toString());
    }

    public void summon(Matcher matcherPlayer) {
        System.out.println(duelController.summon());
        System.out.println(GlobalVariable.getBoard().toString());

    }


    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }


}