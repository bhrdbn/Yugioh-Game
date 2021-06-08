package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.*;

public class Duel {
    DuelController duelController = DuelController.getInstance();
    private static Duel duel=null;
    private Duel(){

    }
    public static Duel getInstance()
    {
        if (duel == null)
            duel = new Duel();

        return duel;
    }


    public void run() {
        while (true) {
            String input=Main.scanner.nextLine();
            Matcher matcherPlayer0 = getCommand(input, "duel new second-player (\\w+) rounds (\\d)");
            Matcher matcherPlayer1 = getCommand(input, "duel new rounds (\\d) second-player (\\w+)");
            Matcher matcherSelect4 = getCommand(input, "select spell (\\d)");
            Matcher matcherSelect10 = getCommand(input, "select hand (\\d)");
            Matcher matcherSelect5 = getCommand(input, "select spell (\\d) opponent");
            Matcher matcherSelect6 = getCommand(input, "select opponent spell (\\d)");
            Matcher matcherSelect9 = getCommand(input, "select field");
            Matcher matcherSelect7 = getCommand(input, "select field opponent");
            Matcher matcherSelect8 = getCommand(input, "select opponent field");
            Matcher deselect=getCommand(input, "select -d");
            Matcher nextPhase=getCommand(input,"next phase");

            Matcher matcherAI = getCommand(input, "duel --new --ai --rounds(\\w+)");
            Matcher matcherSelect = getCommand(input, "select monster (\\d)");
            Matcher matcherSelect2 = getCommand(input, "select monster (\\d) opponent");
            Matcher matcherSelect3 = getCommand(input, "select opponent monster (\\d)");
            Matcher matcherMainPhase = getCommand(input, "new card added to the hand : (\\w+)");
            Matcher matcherEndPhase = getCommand(input, "new card added to the hand : (\\w+)");
            Matcher matchersummon = getCommand(input, "summon");
            Matcher matcherstandbyPhase = getCommand(input, "new card added to the hand : (\\w+)");
            Matcher matcherset = getCommand(input, "duel --new --second-player (\\w+) --rounds (\\w+)");
            Matcher matchersetPosATK = getCommand(input, "set -- position attack");
            Matcher matchersetPosDEF = getCommand(input, "set -- position defence");
            Matcher matcherflipSummon = getCommand(input, "flip-summon");
            Matcher matcherAttack = getCommand(input, "attack (\\s)");
            Matcher matcherSetSpell = getCommand(input, "setTrap");
            Matcher matcherSetTrap = getCommand(input, "SetTrap");
            Matcher showGraveyard = getCommand(input, "show graveyard");
            Matcher showOpponentGraveyard = getCommand(input, "show opponent graveyard");
            Matcher showCard = getCommand(input, "show card");
            Matcher matcherback = getCommand(input, "back");
            if(matcherPlayer0.find()) {
                newDuel(matcherPlayer0,0);
            }
            if(matcherPlayer1.find()) {
                newDuel(matcherPlayer1,1);
            }

            else if(matcherSelect.find())
            { selectOwnMonster(Integer.parseInt(matcherSelect.group(1)));}
            else if(matcherSelect10.find())
            { selectHand(Integer.parseInt(matcherSelect10.group(1)));}
            else if(matcherSelect4.find())
            { selectOwnSpell(Integer.parseInt(matcherSelect4.group(1)));}
            else if(matcherSelect2.find())
            { selectOpponentMonster(Integer.parseInt(matcherSelect2.group(1)));}
            else if(matcherSelect3.find())
            { selectOpponentMonster(Integer.parseInt(matcherSelect3.group(1)));}
            else if(matcherSelect5.find())
            { selectOpponentSpell(Integer.parseInt(matcherSelect5.group(1)));}
            else if(matcherSelect6.find())
            { selectOpponentMonster(Integer.parseInt(matcherSelect6.group(1)));}
           else if(nextPhase.find()) {
               goNextPhase();
            }
            else if(matchersummon.find())
            { summon(matchersummon);}
            else if(matcherSelect9.find()) {
                selectField();
            }
            else if(matcherSelect7.find()||matcherSelect8.find()) {
                selectOpponentField();
            }
            else if(deselect.find()) deselect();
            else if(showGraveyard.find())
            { showGrave();}
            else if(showOpponentGraveyard.find())
            {showOpponentGrave();}
            else if(showCard.find())
            { showCard();}
            else
                System.out.println("invalid command");
        }
    }
    public void newDuel( Matcher matcherPlayer ,int flag){
        if(flag == 0)
            System.out.println(duelController.newDuel(Integer.parseInt
                (matcherPlayer.group(2)),matcherPlayer.group(1),GlobalVariable.getPlayer().getUsername()));
        else
            System.out.println(DuelController.getInstance().newDuel(Integer.parseInt
                (matcherPlayer.group(1)),matcherPlayer.group(2),GlobalVariable.getPlayer().getUsername()));
    }
    public void goNextPhase(){
        System.out.println(duelController.goNextPhase());
    }

    public void selectOwnMonster(int number) {
        System.out.println(duelController.selectOwnMonster(number));
    }
    public void selectOpponentMonster(int number) {
        System.out.println(duelController.selectOpponentMonster(number));
    }
    public void selectOwnSpell(int number) {
        System.out.println(DuelController.getInstance().selectOwnSpell(number));
    }
    public void selectOpponentSpell(int number) {
        System.out.println(duelController.selectOpponentSpell(number));
    }
    public void selectField() {
        System.out.println(duelController.selectField());
    }
    public void selectOpponentField() {
        System.out.println(duelController.selectOpponentField());
    }
    public void selectHand(int number) {
        System.out.println(duelController.selectHand(number));
    }
    public void deselect() {
        System.out.println(duelController.deselect());
    }
    public void showGrave()
    {
        System.out.println(GraveyardController.getInstance().showMyGraveyard());
        GraveView.getInstance().run();
    }
    public void showOpponentGrave()
    {
        System.out.println(GraveyardController.getInstance().showOpponentGraveyard());
        GraveView.getInstance().run();
    }

    public void showCard()
    {
        System.out.println(duelController.showCard());
    }

    public void summon(Matcher matcherPlayer)
    {

    }


    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }


}