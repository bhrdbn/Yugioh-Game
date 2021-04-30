package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Duel {
    public static int a;
/*
    public void run(String input) {
        while (true) {
            Matcher matcherPlayer = getCommand(input, "duel --new --second-player (\\w+) --rounds (\\w+)");
            Matcher matcherAI = getCommand(input, "duel --new --ai --rounds(\\w+)");
            Matcher matcherSelect = getCommand(input, "select --monster (\\s)");
            Matcher matcherSelect2 = getCommand(input, "select --monster (\\s) --opponent");
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
            if(matcherPlayer.find()) {
                checkUserName(matcherPlayer);
                checkRoundsforPlayer
            }
            else if(matcherAI.find())
            { checkRoundsforAI();}
            else if(matcherSelect.find())
            { select(matcherSelect);}
            else if(matcherSelect2.find())
            { select(matcherSelect2);}
            else if(matcherSelectAdress.find())
            { select(matcherSelectAdress);}
            else if(matcherSelectRemove.find())
            { select(matcherSelectRemove);}
            else if(matchersummon.find())
            { summon(matchersummon);}
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
    public boolean checkUserName( Matcher matcherPlayer){
        for (Player player: player.getPlayer) {
            if(player.getUserName().eqauls(username))
                return false;
        }
        return true;
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
*/
}