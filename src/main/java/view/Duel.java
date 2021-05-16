package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.*;

public class Duel {

/*
    public void run(String input) {
        while (true) {
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
            Matcher matcherSelectAdress = getCommand(input, "select (\\w+)");
            Matcher matcherAI = getCommand(input, "duel --new --ai --rounds(\\w+)");
            Matcher matcherSelect = getCommand(input, "select monster (\\d)");
            Matcher matcherSelect2 = getCommand(input, "select monster (\\d) opponent");
            Matcher matcherSelect3 = getCommand(input, "select opponent monster (\\d)");
            Matcher matcherSelectAdress = getCommand(input, "select (\\w+)");
            Matcher matcherSelectRemove = getCommand(input, "select -d");
            Matcher matcherNextPhase = getCommand(input, "phase:(\\w+)");
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
            Matcher matchershowGraveyard = getCommand(input, "showGraveyard");
            Matcher matchershowCard = getCommand(input, "show --card");
            Matcher matcherback = getCommand(input, "back");
            if(matcherPlayer0.find()) {
                newDuel(matcherPlayer0,0);
            }
            if(matcherPlayer1.find()) {
                newDuel(matcherPlayer1,1);
            }
            else if(matcherAI.find())
            { checkRoundsforAI();}
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
            else if(matcherSelectAdress.find())
            { select(matcherSelectAdress);}
            else if(matcherSelectRemove.find())
            { select(matcherSelectRemove);}
            else if(matchersummon.find())
            { summon(matchersummon);}
            else if(matcherSelect9.find()) {
                selectField();
            }
            else if(matcherSelect7.find()||matcherSelect8.find()) {
                selectOpponentField();
            }
            else if(deselect.find()) deselect();
            else if(matchersetPosATK.find())
            { setMonster(matchersetPosATK);}
            else if(matchersetPosDEF.find())
            { setMonster(matchersetPosDEF);}
            else if(matcherflipSummon.find())
            { flipSummon(matcherflipSummon);}
            else if(matcherAttack.find())
            { attack(matcherAttack);}
            else if(matcherSetSpell.find())
            { setSpellCard(matcherSetSpell);}
            else if(matcherSetTrap.find())
            { setTrapCard(matcherSetTrap);}
            else if(matchershowGraveyard.find())
            { showGrave(matchershowGraveyard);}
            else if(matchershowCard.find())
            { showCard(matchershowCard);}
            else
                System.out.println("invalid command");
        }
    }
    public void newDuel( Matcher matcherPlayer ,int flag){
        if(flag == 0)
            System.out.println(DuelController.getInstance().newDuel(Integer.parseInt
                (matcherPlayer.group(2)),matcherPlayer.group(1),GlobalVariable.getPlayer().getUsername()));
        else
            System.out.println(DuelController.getInstance().newDuel(Integer.parseInt
                (matcherPlayer.group(1)),matcherPlayer.group(2),GlobalVariable.getPlayer().getUsername()));
    }
    public void selectOwnMonster(int number) {
        System.out.println(DuelController.getInstance().selectOwnMonster(number));
    }
    public void selectOpponentMonster(int number) {
        System.out.println(DuelController.getInstance().selectOpponentMonster(number));
    }
    public void selectOwnSpell(int number) {
        System.out.println(DuelController.getInstance().selectOwnSpell(number));
    }
    public void selectOpponentSpell(int number) {
        System.out.println(DuelController.getInstance().selectOpponentSpell(number));
    }
    public void selectField() {
        System.out.println(DuelController.getInstance().selectField());
    }
    public void selectOpponentField() {
        System.out.println(DuelController.getInstance().selectOpponentField());
    }
    public void selectHand(int number) {
        System.out.println(DuelController.getInstance().selectHand(number));
    }
    public void deselect(int number) {
        System.out.println(DuelController.getInstance().deselect());
    }
    public boolean checkRoundsforPlayer(Matcher matcherPlayer){
        for (PlayBoard PlayBoard: PlayBoard.getRound) {
            if(matcher.group(2).eqauls(0)||matcher.group(2).eqauls(1)||matcher.group(2).eqauls(2))
                return true;
        }
        return false;
    }
    public boolean checkRoundsforAI(Matcher matcherPlayer){
        for (PlayBoard PlayBoard: PlayBoard.getRound) {
            if(matcher.group(1).eqauls(0)||matcher.group(1).eqauls(1)||matcher.group(1).eqauls(2))
                return true;
        }
        return false;
    }
    public void select(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();

    }

    public void summon(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }
    public void attack(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }
    public void setMonster(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }

    public void changePosition(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }

    public void flipSummon(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }

    public void attackDirect(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }

    public void activateCard(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }

    public String setSpellCard(SpellCard phase: String spell)
    {
        DuelController duelController = new DuelController();
    }
    public String setTrapCard(SpellCard phase: String spell)
    {
        DuelController duelController = new DuelController();
    }

    public void showGrave(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }

    public void showCard(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }

    public void Surrender(Matcher matcherPlayer)
    {
        DuelController duelController = new DuelController();
    }

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
}
 public static void getInput(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Login login = new Login();
            login.run(input);
        }
    }
*/
}