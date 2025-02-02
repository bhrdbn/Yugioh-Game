
package controller;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.*;
import view.Main;
import view.MainView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;

public class DuelController implements Initializable {
    private static DuelController duelController = null;
    public GridPane hand2;
    public GridPane hand1;
    public Rectangle show;
    public VBox grave1;
    public VBox grave2;
    public GridPane monster1;
    public GridPane monsters2;
    public GridPane spell1;
    public GridPane spell2;
    public Label phase1;
    int rounds;
    Player firstWinner;
    Player secondWinner;
    Player thirdWinner;
    int firstLp;
    int secondLp;
    int thirdLP;
    public void tributeMonsters(int monster) {
        GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().remove(monster);
        GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(monster));
    }
    public String ritualSummon() {
        Card card = GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard();
        if(!isSpellConditionMet((SpellCard)card))
            return "there is no way you could ritual summon a monster";
        else if(!((SpellCard)card).getIcon().equals("Ritual") || GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedMonsterCard().typeOfMonsterCard() .equals("Ritual") )
            return "you should ritual summon right now";
        else{
            System.out.println("please enter the cards(the number of cards) that you want to tribute");
            String monster1 = Main.scanner.nextLine();
            String monster2 = Main.scanner.nextLine();
            if(!isLevelMatched(monster1, monster2, card))
                return "selected monsters levels don't match with ritual monster";
            else{
                tributeMonsters(Integer.parseInt(monster1));
                tributeMonsters(Integer.parseInt(monster2));
                System.out.println("please enter the attack or defence status");
                String status = Main.scanner.nextLine();
                if(status.equals("attacking")) {
                    ((MonsterCard) card).setIsAttack(true);
                    card.setSide(false);
                }
                else if(status.equals("defensive"))
                    card.setSide(true);
                return "summoned successfully";
            }


        }

    }
    public boolean isLevelMatched(String monster1, String monster2, Card card) {
        if(GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(Integer.parseInt(monster1)).getLevel() + GlobalVariable.getBoard().getPlayBoardByTurn().getMonsters().get(Integer.parseInt(monster2)).getLevel() >= ((MonsterCard)card).getLevel())
            return true;
        else
            return false;
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
    public void select(String name , String type) {
      //  if(type.equals("spell"))
      //  ImagePattern background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/"
      //          + name + ".jpg").toExternalForm()));
      //  show.setFill(background);
    }
    public void loadCardsInHand(){

        ImagePattern background;
        int i=0;
        int j=0;
       for(Card card:GlobalVariable.getBoard().getPlayBoard1().getHand()){
           if(card instanceof MonsterCard){
               background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/"
                       + card.getName() + ".jpg").toExternalForm()));

           }
           else {
               background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/"
                       + card.getName() + ".jpg").toExternalForm()));
           }
           Rectangle rectangle=new Rectangle();
           rectangle.setId(card.getName());

           rectangle.setFill(background);
           hand1.add(rectangle,i,0);
           hand1.setVisible(true);
           i++;

       }
        for(Card card:GlobalVariable.getBoard().getPlayBoard2().getHand()){
            if(card instanceof MonsterCard){
                background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/"
                        + card.getName() + ".jpg").toExternalForm()));

            }
            else {
                background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/"
                        + card.getName() + ".jpg").toExternalForm()));
            }
            Rectangle rectangle=new Rectangle();
            rectangle.setFill(background);
            hand2.add(rectangle,j,0);
            hand2.setVisible(true);
            j++;

        }
    }
    public void loadCardsInMonster(){
        ImagePattern background;
        int i=0;
        int j=0;
        for(Card card:GlobalVariable.getBoard().getPlayBoard1().getMonsters()){
            if(!card.getName().equals("Nokhodi"))
                background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/"
                        + card.getName() + ".jpg").toExternalForm()));
            else background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/12.png").toExternalForm()));



            Rectangle rectangle=new Rectangle();
            rectangle.setFill(background);
            monster1.add(rectangle,i,0);
            monster1.setVisible(true);
            i++;

        }
        for(Card card:GlobalVariable.getBoard().getPlayBoard2().getMonsters()){
            if(!card.getName().equals("Nokhodi"))
                background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/"
                        + card.getName() + ".jpg").toExternalForm()));

           else  background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/12.png").toExternalForm()));

            Rectangle rectangle=new Rectangle();
            rectangle.setFill(background);
            monsters2.add(rectangle,j,0);
            monsters2.setVisible(true);
            j++;
        }
    }
    public void loadCardsInSpell(){
        ImagePattern background;
        int i=0;
        int j=0;
        for(Card card:GlobalVariable.getBoard().getPlayBoard1().getSpellTrap()){
            if(!card.getName().equals("Nothing"))
                background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/"
                        + card.getName() + ".jpg").toExternalForm()));
            else  background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/12.png").toExternalForm()));


            Rectangle rectangle=new Rectangle();
            rectangle.setFill(background);
            spell1.add(rectangle,i,0);
            spell1.setVisible(true);
            i++;

        }
        for(Card card:GlobalVariable.getBoard().getPlayBoard2().getSpellTrap()){
            if(!card.getName().equals("Nothing"))
                background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/"
                        + card.getName() + ".jpg").toExternalForm()));
            else  background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/12.png").toExternalForm()));

            Rectangle rectangle=new Rectangle();
            rectangle.setFill(background);
            spell2.add(rectangle,j,0);
            spell2.setVisible(true);
            j++;

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
        return "s";
//    (GlobalVariable.getBoard().getPlayBoardByTurn().selectMonster(number).getName().equals("nokhodi"))
//            return
//                    "no card found in the given position";
//
//            GlobalVariable.getBoard().getPlayBoardByTurn().
//                    setSelectedCard(GlobalVariable.getBoard().getPlayBoardByTurn().selectMonster(number));
//
//            return "card selected";



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
    public void setWinner(int max){
        GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(300);
        GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(3000+ max);
        GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(3000);
        System.out.println(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getUsername()+" won whole match");
        MainView.getInstance().run();
    }
    public void lose(){
        System.out.println(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getUsername()+" won this round");
        if(rounds==1){
            GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(100);
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(1000+
                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint());
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(1000);
            MainView.getInstance().run();
        }
        else{
            System.out.println("next round started");
            if(firstWinner!=null){
                if(secondWinner!=null) {
                    thirdWinner=GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer();
                    thirdLP=GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint();
                    if(firstWinner.getUsername().equals(thirdWinner.getUsername())){
                        int max=firstLp;
                        if(firstLp<thirdLP)max=thirdLP;
                        setWinner(max);
                    }
                    else {
                        int max=secondLp;
                        if(secondLp<thirdLP)max=thirdLP;
                        setWinner(max);
                    }
                }
                else {
                    secondWinner=GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer();
                    secondLp=GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint();
                    if(secondWinner.getUsername().equals(firstWinner.getUsername())){
                        int max= firstLp;
                        if(firstLp<secondLp)max=secondLp;
                        setWinner(max);
                    }
                    else getNewBoard();

                }
            }
            else {
                firstWinner=GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer();
                firstLp=GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint();
                getNewBoard();
            }
        }


    }

    private void getNewBoard() {
        PlayBoard playBoard=new PlayBoard(GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer());
        PlayBoard playBoard1=new PlayBoard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer());
        Board board= new Board(playBoard,playBoard1);
        GlobalVariable.setBoard(board);
    }

    public void goNextPhase() {
        if (GlobalVariable.getBoard().getPhase() == Phase.MAIN2 && (GlobalVariable.getBoard().isDeckFinished()||
                GlobalVariable.getBoard().getPlayBoardByTurn().getLifePoint()<=0) ){
            lose();

        }
        GlobalVariable.getBoard().changePhase(GlobalVariable.getBoard().getPhase());
        phase1.setText(managePhase());
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
    public void setWin(){
        if(rounds==1){
            GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(100);
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(1000+
                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint());
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(1000);
            System.out.println(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getUsername()+" won the game : "+
                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getScore());
            MainView.getInstance().run();
        }
        else{
            GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(300);
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(3000+
                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint());
            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(3000);
            System.out.println(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getUsername()+" won whole match : "+
                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getScore());
            MainView.getInstance().run();
        }

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
                String s=Main.scanner.nextLine();
                if(s.equals("cancel")){
                    deselect();
                    return "";
                }
                int monster = Integer.parseInt(s);
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
                            getPlayBoardByTurn().getSelectedCard().getName().equals("CommandKnight")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(1,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("YomiShip")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(6,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("ManEaterBug")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(7,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("TheCalculator")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(10,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("HeraldofCreation")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(11,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("TheTricky")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(12,(MonsterCard) GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard());
                    }
                    if (GlobalVariable.getBoard().
                            getPlayBoardByTurn().getSelectedCard().getName().equals("Terratiger")){
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(13,(MonsterCard) GlobalVariable.getBoard().
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
                GlobalVariable.getBoard().isSpellZoneFull() && ((SpellCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).getIcon().equals("Field"))
            return "spell card zone is full";
        else if (!isSpellConditionMet((SpellCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()))
            return "preparations of this spell are not done yet ";
        else if (((SpellCard) GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard()).getIcon().equals("Field")) {
            if (GlobalVariable.getBoard().isFieldZoneFull())
                GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().add(GlobalVariable.getBoard().getPlayBoardByTurn().getFields());
            GlobalVariable.getBoard().getPlayBoardByTurn().setFields(card);
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardActivated(true);


            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Forest")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(15, GlobalVariable.getBoard());
                actionSpell.setAction(16, GlobalVariable.getBoard());
                actionSpell.setAction(17, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Umiiruka")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(18, GlobalVariable.getBoard());
                actionSpell.setAction(19, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("ClosedForest")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(20, GlobalVariable.getBoard());

            }

            return "spell activated";
        } else {

            GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().add(card);
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardActivated(true);
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Terraforming")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(1, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("PotofGreed")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(2, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Raigeki")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(3, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("SpellAbsorption")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(7, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("SupplySquad")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(33, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Yami")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(4, GlobalVariable.getBoard());
                actionSpell.setAction(5, GlobalVariable.getBoard());
                actionSpell.setAction(6, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Ringofdefense")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(21, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("DarkHole")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(22, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("MonsterReborn")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(23, GlobalVariable.getBoard());

            }
            if (GlobalVariable.getBoard().
                    getPlayBoardByTurn().getSelectedCard().getName().equals("HarpiesFeatherDuster")){
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(24, GlobalVariable.getBoard());

            }
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

        if(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getSpellTrap().contains(spellCard)) {
            activateCardAndChangeTurn(spellCard);
            return true;
        }

        return isConditionMet;
    }

//   public String setField(SpellCard field) {
//
//   }

    public String setSpellCard(SpellCard spell, Phase phase) {
        if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() != Location.HAND)
            return "you can't set this card";
        else if (!(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() instanceof SpellCard) || (GlobalVariable.getBoard().getPhase() != Phase.MAIN1 && GlobalVariable.getBoard().getPhase() != Phase.MAIN2))
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoard().isSpellZoneFull())
            return "spell card zone is full";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
            for (int i = 0; i < 5; i++) {
                if(GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().get(i).getName().equals("nokhodi")){
                    GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().set(i, GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().setSide(false);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().get(i).setLocation(Location.SPELL);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                }

            }
            return "set successfully";
        }
    }

    public String setTrapCard(TrapCard trap){
        if(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().getLocation() != Location.HAND)
            return "you can't set this card";
        else if(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard() instanceof TrapCard && (GlobalVariable.getBoard().getPhase() != Phase.MAIN1 && GlobalVariable.getBoard().getPhase() != Phase.MAIN2))
            return "you can't do this action in this phase";
        else if(GlobalVariable.getBoard().isSpellZoneFull())
            return "spell card zone is full";
        else {
            GlobalVariable.getBoard().getPlayBoardByTurn().setCardSummonedOrSet(true);
            for (int i = 0; i < 5; i++) {
                if(GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().get(i).getName().equals("nokhodi")){
                    GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().set(i, GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                    GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard().setSide(false);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().get(i).setLocation(Location.SPELL);
                    GlobalVariable.getBoard().getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoard().getPlayBoardByTurn().getSelectedCard());
                }

            }
            return "set successfully";
        }
    }


    public void activateCardAndChangeTurn(Card card) {
        if(isSpellConditionMet((SpellCard) card)) {
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
                        GlobalVariable.getBoard().getPlayBoardByTurn().getSpellTrap().add(card);
                        GlobalVariable.getBoard().getPlayBoardByTurn().setCardActivated(true);
                        if (GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard().getName().equals("CallofTheHaunted")){
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(1);

                        }
                        if (GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard().getName().equals("Torrential Tribute")){
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(2);

                        }
                        if (GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard().getName().equals("TimeSeal")){
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(3);

                        }
                        if (GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard().getName().equals("TrapHole")){
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(4);

                        }
                        if (GlobalVariable.getBoard().
                                getPlayBoardByTurn().getSelectedCard().getName().equals("SolemnWarning")){
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(5);

                        }
                        System.out.println("spell/trap activated");
                    }
                    else
                        System.out.println("it's not your turn to play this kind of moves");
                }

            }

        }
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

//    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCardsInHand();
        loadCardsInMonster();
        loadCardsInSpell();

    }

    public void back(MouseEvent mouseEvent) {
        try {
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/OnBoard.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }


}


