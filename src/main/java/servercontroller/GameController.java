package servercontroller;

import clientview.Main;
import clientview.MainView;
import model.*;


public class GameController {
    int rounds;
    Player firstWinner;
    Player secondWinner;
    Player thirdWinner;
    int firstLp;
    int secondLp;
    int thirdLP;
    private static GameController duelController = null;
    public static GameController getInstance() {
        if (duelController == null)
            duelController = new GameController();

        return duelController;
    }
        public void tributeMonsters(int monster, String token) {
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().remove(monster);
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().add(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster));

    }

    public String ritualSummon(String token) {
        Card card = GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard();
        if (!isSpellConditionMet((SpellCard) card, token))
            return "there is no way you could ritual summon a monster";
        else if (!((SpellCard) card).getIcon().equals("Ritual") || GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedMonsterCard().typeOfMonsterCard().equals("Ritual"))
            return "you should ritual summon right now";
        else {
            System.out.println("please enter the cards(the number of cards) that you want to tribute");
            String monster1 = Main.scanner.nextLine();
            String monster2 = Main.scanner.nextLine();
            if (!isLevelMatched(monster1, monster2, card, token))
                return "selected monsters levels don't match with ritual monster";
            else {
                tributeMonsters(Integer.parseInt(monster1), token);
                tributeMonsters(Integer.parseInt(monster2), token);
                System.out.println("please enter the attack or defence status");
                String status = Main.scanner.nextLine();
                if (status.equals("attacking")) {
                    ((MonsterCard) card).setIsAttack(true);
                    card.setSide(false);
                } else if (status.equals("defensive"))
                    card.setSide(true);
                return "summoned successfully";
            }


        }

    }

    public boolean isLevelMatched(String monster1, String monster2, Card card, String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(Integer.parseInt(monster1)).getLevel() + GlobalVariable.getBoards().get(GlobalVariable.getPlayers().get(token)).getPlayBoardByTurn().getMonsters().get(Integer.parseInt(monster2)).getLevel() >= ((MonsterCard) card).getLevel())
            return true;
        else
            return false;
    }

    public String selectOwnMonster(int number, String token) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().selectMonster(number).getName().equals("nokhodi"))
            return
                    "no card found in the given position";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().selectMonster(number));
            return "card selected";
        }
    }

    public String selectOpponentMonster(int number, String token) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().selectMonster(number).getName().equals("nokhodi"))
            return
                    "no card found in the given position";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().selectMonster(number));
            return "card selected";
        }
    }

    public String selectOwnSpell(int number, String token) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().selectSpellOrTrap(number).getName().equals("nokhodi"))
            return
                    "no card found in the given position";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().selectSpellOrTrap(number));
            return "card selected";
        }
    }

    public String selectOpponentSpell(int number, String token) {
        if (number > 5) return "selection is invalid";
        else if (GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().selectSpellOrTrap(number).getName().equals("nokhodi"))
            return
                    "no card found in the given position";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().selectSpellOrTrap(number));
            return "card selected";
        }
    }

    public String selectHand(int number, String token) {
        if (number > 6) return "selection is invalid";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().size() < number) return
                "no card found in the given position";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().selectFromHand(number));
            return "card selected";
        }
    }

    public String selectField(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getFields() == null)
            return "no card found in the given position";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedCard(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getFields());
            return "card selected";
        }
    }

    public String selectOpponentField(String token) {
        if (GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getFields() == null)
            return "no card found in the given position";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedOpponentCard(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getFields());
            return "card selected";
        }
    }

    public String managePhase(String token, String playerToken) {
        Phase phase = GlobalVariable.getBoards().get(token).getPhase();
        switch (phase) {
            case DRAW:
                return "draw phase\n" +
                        (GlobalVariable.getBoards().get(token).addToHand(GlobalVariable.getBoards().get(token).getPlayBoardByTurn()));
            case STANDBY:
                return "standby phase";

            case MAIN1:
                return "1st Main phase";

            case BATTLE:
                return "battle phase";

            case MAIN2:
                return "2nd main phase";

            case END:
                GlobalVariable.getBoards().get(token).changePhase(Phase.END);
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardSummonedOrSet(false);
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setSetSummonedMonster(null);
                GlobalVariable.getBoards().get(token).reverseTurn();
//                if (GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer() instanceof AI) {
//                    return manageAIPhaseAndPlay();
//                } else
                    return "End phase\n" + GlobalVariable.getBoards().get(token).getTurn().getNickname() + "'s turn" + "\n" +
                        "draw phase\n" +
                        (GlobalVariable.getBoards().get(token).addToHand(GlobalVariable.getBoards().get(token).getPlayBoardByTurn()));

            default:
                return "";
        }
    }

    public void setWinner(int max, String token) {
        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getPlayer().increasePlayerMoney(300);
        GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(3000 + max);
        GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer().increaseScore(3000);
        System.out.println(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer().getUsername() + " won whole match");
        MainView.getInstance().run();
    }

    public void lose(String token, String playerToken) {
        System.out.println(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer().getUsername() + " won this round");
        if (rounds == 1) {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getPlayer().increasePlayerMoney(100);
            GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(1000 +
                    GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getLifePoint());
            GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer().increaseScore(1000);
            MainView.getInstance().run();
        } else {
            System.out.println("next round started");
            if (firstWinner != null) {
                if (secondWinner != null) {
                    thirdWinner = GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer();
                    thirdLP = GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getLifePoint();
                    if (firstWinner.getUsername().equals(thirdWinner.getUsername())) {
                        int max = firstLp;
                        if (firstLp < thirdLP) max = thirdLP;
                        setWinner(max, token);
                    } else {
                        int max = secondLp;
                        if (secondLp < thirdLP) max = thirdLP;
                        setWinner(max, token);
                    }
                } else {
                    secondWinner = GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer();
                    secondLp = GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getLifePoint();
                    if (secondWinner.getUsername().equals(firstWinner.getUsername())) {
                        int max = firstLp;
                        if (firstLp < secondLp) max = secondLp;
                        setWinner(max, token);
                    } else getNewBoard(token, playerToken);

                }
            } else {
                firstWinner = GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer();
                firstLp = GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getLifePoint();
                getNewBoard(token, playerToken);
            }
        }


    }

    private void getNewBoard(String token, String playerToken) {
        PlayBoard playBoard = new PlayBoard(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getPlayer());
        PlayBoard playBoard1 = new PlayBoard(GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getPlayer());
        Board board = new Board(playBoard, playBoard1);
        Controller.getInstance().setBoard(token, GlobalVariable.getPlayers().get(playerToken));
    }

    public String goNextPhase(String token, String playerToken) {
        if (GlobalVariable.getBoards().get(token).getPhase() == Phase.MAIN2 && (GlobalVariable.getBoards().get(token).isDeckFinished() ||
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getLifePoint() <= 0)) {
            lose(token, playerToken);

        }
        GlobalVariable.getBoards().get(token).changePhase(GlobalVariable.getBoards().get(token).getPhase());
        return managePhase(token, playerToken);
    }


    public String deselect(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedOpponentCard() == null)
            return "no card is selected yet";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedOpponentCard(null);
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().
                    setSelectedCard(null);
            return "card deselected";
        }
    }

    public int countNokhodi(String token) {
        int number = 0;
        for (MonsterCard monster : GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters()) {
            if (monster.getName().equals("nokhodi")) number++;
        }
        return number;
    }

//    public void setWin() {
//        if (rounds == 1) {
//            GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(100);
//            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(1000 +
//                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint());
//            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(1000);
//            System.out.println(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getUsername() + " won the game : " +
//                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getScore());
//            MainView.getInstance().run();
//        } else {
//            GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(300);
//            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(3000 +
//                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint());
//            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(3000);
//            System.out.println(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getUsername() + " won whole match : " +
//                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getScore());
//            MainView.getInstance().run();
//        }
//
//    }
//// ** monster ba ehzare vizhe ro nazadam **
//
    public String summon(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedOpponentCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().
                        getLocation() != Location.HAND || !(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()
                instanceof MonsterCard))
            return "you can’t summon this card";
        else if (!(GlobalVariable.getBoards().get(token).getPhase() == Phase.MAIN1 ||
                GlobalVariable.getBoards().get(token).getPhase() == Phase.MAIN2))
            return "action not allowed in this phase";
        else if (countNokhodi(token) == 0)
            return ("monster card zone is full");
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().isCardSummonedOrSet())
            return ("you already summoned/set on this turn");
        else if (((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).getLevel() <= 4) {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardSummonedOrSet(true);
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setSetSummonedMonster
                    ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
            for (int i = 0; i < 5; i++) {

                if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi")) {
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().
                            set(i, (MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setIsAttack(true);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setLocation(Location.MONSTERS);
                    break;
                }
            }
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard());
            return "summoned successfully";
        } else if (((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).getLevel() <= 6) {
            if (countNokhodi(token) == 5)
                return "there are not enough cards for tribute";
            else {
                String s = Main.scanner.nextLine();
                if (s.equals("cancel")) {
                    deselect(token);
                    return "";
                }
                int monster = Integer.parseInt(s);
                if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster - 1).getName().equals("nokhodi"))
                    return "there no monsters one this address";
                else {
                    Card card = GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster - 1);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().add(card);
                    setNokhodi(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster - 1));
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardSummonedOrSet(true);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setSetSummonedMonster
                            ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                    for (int i = 0; i < 5; i++) {

                        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi")) {
                            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().
                                    set(i, (MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setIsAttack(true);
                            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setLocation(Location.MONSTERS);
                            break;
                        }

                    }
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard());
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("Suijin")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(2, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("CrabTurtle")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(3, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("GateGuardian")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(4, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("SkullGuardian")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(5, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("CommandKnight")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(1, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("YomiShip")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(6, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("ManEaterBug")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(7, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("TheCalculator")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(10, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("HeraldofCreation")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(11, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("TheTricky")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(12, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("Terratiger")) {
                        ActionMonster actionMonster = new ActionMonster();
                        actionMonster.setAction(13, (MonsterCard) GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard(), token);
                    }
                    if (GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard().getName().equals("BeastKingBarbaros")) {
                        int i;
                        System.out.println("please enter which mode you want to sacrifice press 1 else 0");
                        i = Main.scanner.nextInt();
                        ActionMonster actionMonster = new ActionMonster();
                        if (i == 0) {
                            actionMonster.setAction(8, (MonsterCard) GlobalVariable.getBoards().get(token).
                                    getPlayBoardByTurn().getSelectedCard(), token);
                        } else {
                            actionMonster.setAction(9, (MonsterCard) GlobalVariable.getBoards().get(token).
                                    getPlayBoardByTurn().getSelectedCard(), token);
                        }
                    }
                    return "summoned successfully";

                }

            }

        } else {
            if (countNokhodi(token) > 3)
                return "there are not enough cards for tribute";
            else {
                int monster = Integer.parseInt(Main.scanner.nextLine());
                int monster1 = Integer.parseInt(Main.scanner.nextLine());
                if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster - 1).getName().equals("nokhodi") ||
                        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster1 - 1).getName().equals("nokhodi"))
                    return "there no monsters one this address";
                else {
                    Card card = GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster - 1);
                    Card card1 = GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster1 - 1);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().add(card);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().add(card1);
                    setNokhodi(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(monster - 1));
                    setNokhodi(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().remove(monster1 - 1));
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardSummonedOrSet(true);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setSetSummonedMonster
                            ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                    for (int i = 0; i < 5; i++) {

                        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi")) {
                            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().
                                    set(i, (MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setIsAttack(true);
                            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setLocation(Location.MONSTERS);
                            break;
                        }
                    }
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoards().get(token).
                            getPlayBoardByTurn().getSelectedCard());
                    return "summoned successfully";

                }

            }

        }

    }

    public void setNokhodi(Card card) {
        card = new Card("nokhodi", 1, "ff", "aa", false, 1);
    }


    public String setMonster(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().getLocation() != Location.HAND)
            return "you can't set this card";
        else if ((GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()
                instanceof MonsterCard) &&
                (GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN1 && GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN2))
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoards().get(token).isMonsterZoneFull())
            return "monster card zone is full";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().isCardSummonedOrSet())
            return "you already summoned/set on this turn";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardSummonedOrSet(true);
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setSetSummonedMonster
                    ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
            for (int i = 0; i < 5; i++) {
                if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi")) {
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().set(i, (MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setSide(false);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setIsAttack(false);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getMonsters().get(i).setLocation(Location.MONSTERS);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                    break;
                }

            }
            return "set successfully";
        }


    }

    public String changePosition(String position, String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().getLocation() != Location.MONSTERS)
            return "you can't change this card position";
        else if (GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN1 &&
                GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN2)
            return "you can't do this action in this phase";
        else if (position.equals("attack") && (!GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().isSide() ||
                ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).isAttack()))
            return "this card is already in the wanted position";
        else if (position.equals("defence") && !(((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).isAttack()))
            return "this card is already in the wanted position";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().isPositionChanged())
            return "you already changed this card position in this turn";
        else if (position.equals("attack")) {

            ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).setIsAttack(true);
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setPositionChanged(true);
            return "monster card position changed successfully";
        } else {


            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().setSide(true);
            ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).setIsAttack(false);
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setPositionChanged(true);


            return "monster card position changed successfully";
        }

    }

    public String flipSummon(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().getLocation() != Location.MONSTERS)
            return "you can't change this card position";
        else if (GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN1 &&
                GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN2)
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().isSide()
                || ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).isAttack() ||
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSetSummonedMonster() ==
                        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard())
            return "you can't flip summon this card";
        else {
            ((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).setIsAttack(true);
            return "flip summoned successfully";
        }
    }


    public String attack(int number, String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null &&
                GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number - 1).getName().equals("nokhodi"))
            return "no card is selected yet";
        else if (!GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number - 1).isCanBeAttacked() || GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().
                getLocation() != Location.MONSTERS)
            return "you can’t attack this card";
        else if (GlobalVariable.getBoards().get(token).getPhase() != Phase.BATTLE)
            return "you can't do this action in this phase";
        else if ((GlobalVariable.getBoards().get(token).getPlayBoardByTurn().isCardAttacked()))
            return "this card already attacked";
        else if (GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number - 1).getName().equals("nokhodi"))
            return "there is no card to attack here";
        else
            return MonsterCard.Attack((MonsterCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard(), GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(number - 1), number, token);
    }

    //  public String setDamage(MonsterCard card2, MonsterCard card1) {
//
    //  }

    public String directAttack(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().getLocation() != Location.MONSTERS)
            return "you can't attack with this card";
        else if (GlobalVariable.getBoards().get(token).getPhase() != Phase.BATTLE)
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().isCardAttacked())
            return "this card already attacked";
        else {
            int counter = 0;
            for (int i = 0; i < 5; i++) {
                if (GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getMonsters().get(i).getName().equals("nokhodi"))
                    counter++;
            }
            if (counter != 5)
                return "you can't attack the opponent directly";
            else
                return MonsterCard.directAttack(token);
        }
    }

    public String activateCard(SpellCard card, String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (!(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() instanceof SpellCard))
            return "activate effect is only for spell cards";
        else if (GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN1 && GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN2)
            return "you can't activate effect on this turn";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().isCardActivated())
            return "you have already activated this card";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().getLocation() == Location.HAND &&
                GlobalVariable.getBoards().get(token).isSpellZoneFull() && ((SpellCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).getIcon().equals("Field"))
            return "spell card zone is full";
        else if (!isSpellConditionMet((SpellCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard(), token))
            return "preparations of this spell are not done yet ";
        else if (((SpellCard) GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard()).getIcon().equals("Field")) {
            if (GlobalVariable.getBoards().get(token).isFieldZoneFull())
                GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().add(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getFields());
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setFields(card);
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardActivated(true);


            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Forest")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(15, GlobalVariable.getBoards().get(token), token);
                actionSpell.setAction(16, GlobalVariable.getBoards().get(token), token);
                actionSpell.setAction(17, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Umiiruka")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(18, GlobalVariable.getBoards().get(token), token);
                actionSpell.setAction(19, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("ClosedForest")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(20, GlobalVariable.getBoards().get(token), token);

            }

            return "spell activated";
        } else {

            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSpellTrap().add(card);
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardActivated(true);
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Terraforming")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(1, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("PotofGreed")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(2, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Raigeki")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(3, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("SpellAbsorption")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(7, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("SupplySquad")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(33, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Yami")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(4, GlobalVariable.getBoards().get(token), token);
                actionSpell.setAction(5, GlobalVariable.getBoards().get(token), token);
                actionSpell.setAction(6, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("Ringofdefense")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(21, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("DarkHole")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(22, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("MonsterReborn")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(23, GlobalVariable.getBoards().get(token), token);

            }
            if (GlobalVariable.getBoards().get(token).
                    getPlayBoardByTurn().getSelectedCard().getName().equals("HarpiesFeatherDuster")) {
                ActionSpell actionSpell = new ActionSpell();
                actionSpell.setAction(24, GlobalVariable.getBoards().get(token), token);

            }
            return "spell activated";

        }


    }

    public boolean isSpellConditionMet(SpellCard spellCard, String token) {
        boolean isConditionMet = false;
        switch (spellCard.getIcon()) {
            case "Equip":
            case "Ritual":
            case "Counter":
            case "Normal":
                isConditionMet = GlobalVariable.getBoards().get(token).getPlayBoardByTurn().isCardActivated();
                break;
            case "Continuous":
            case "Field":
                isConditionMet = spellCard.isSide();
                break;
            case "Quick-play":
                isConditionMet = GlobalVariable.getBoards().get(token).getPlayBoardByTurn().isCardSummonedOrSet();
                break;
        }

        if (GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getSpellTrap().contains(spellCard)) {
            activateCardAndChangeTurn(spellCard, token);
            return true;
        }

        return isConditionMet;
    }

////   public String setField(SpellCard field) {
////
////   }
//
    public String setSpellCard(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().getLocation() != Location.HAND)
            return "you can't set this card";
        else if (!(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() instanceof SpellCard) || (GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN1 && GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN2))
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoards().get(token).isSpellZoneFull())
            return "spell card zone is full";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardSummonedOrSet(true);
            for (int i = 0; i < 5; i++) {
                if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSpellTrap().get(i).getName().equals("nokhodi")) {
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSpellTrap().set(i, GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().setSide(false);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSpellTrap().get(i).setLocation(Location.SPELL);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                }

            }
            return "set successfully";
        }
    }

    public String setTrapCard(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() == null)
            return "no card is selected yet";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().getLocation() != Location.HAND)
            return "you can't set this card";
        else if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard() instanceof TrapCard && (GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN1 && GlobalVariable.getBoards().get(token).getPhase() != Phase.MAIN2))
            return "you can't do this action in this phase";
        else if (GlobalVariable.getBoards().get(token).isSpellZoneFull())
            return "spell card zone is full";
        else {
            GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardSummonedOrSet(true);
            for (int i = 0; i < 5; i++) {
                if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSpellTrap().get(i).getName().equals("nokhodi")) {
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSpellTrap().set(i, GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().setSide(false);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSpellTrap().get(i).setLocation(Location.SPELL);
                    GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getHand().remove(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard());
                }

            }
            return "set successfully";
        }
    }


    public void activateCardAndChangeTurn(Card card, String token) {
        if (isSpellConditionMet((SpellCard) card, token)) {
            System.out.println("now it will be " + GlobalVariable.getPlayers().get(token).getUsername() + " turn");
            System.out.println(GlobalVariable.getBoards().get(token).getPlayBoardByTurn());
            System.out.println("do you want to activate your trap and spell?");
            String input = Main.scanner.nextLine();
            String activation = Main.scanner.nextLine();
            if (input.equals("no")) {
                System.out.println("now it will be " + GlobalVariable.getPlayers().get(token).getUsername() + " turn");
                System.out.println(GlobalVariable.getBoards().get(token).getPlayBoardByTurn());
            } else {
                if (activation.equals("activate spell") || activation.equals("activate trap")) {
                    if (isSpellConditionMet(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedSpellCard(), token)) {
                        activateCard(GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedSpellCard(), token);
                        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSpellTrap().add(card);
                        GlobalVariable.getBoards().get(token).getPlayBoardByTurn().setCardActivated(true);
                        if (GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard().getName().equals("CallofTheHaunted")) {
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(1, token);

                        }
                        if (GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard().getName().equals("Torrential Tribute")) {
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(2, token);

                        }
                        if (GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard().getName().equals("TimeSeal")) {
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(3, token);

                        }
                        if (GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard().getName().equals("TrapHole")) {
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(4, token);

                        }
                        if (GlobalVariable.getBoards().get(token).
                                getPlayBoardByTurn().getSelectedCard().getName().equals("SolemnWarning")) {
                            TrapAction trapAction = new TrapAction();
                            trapAction.setAction(5, token);

                        }
                        System.out.println("spell/trap activated");
                    } else
                        System.out.println("it's not your turn to play this kind of moves");
                }

            }

        }
    }

    public String showMyGraveyard(String token) {
        StringBuilder graveyard = new StringBuilder();
        int i = 0;
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards().size() == 0)
            return "it's empty";
        for (Card card : GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getGraveyards()) {
            graveyard.append(i).append(". ").append(card.toString()).append("\n");
            i++;
        }

        return graveyard.toString();

    }

    public String showOpponentGraveyard(String token) {
        StringBuilder graveyard = new StringBuilder();
        int i = 0;
        if (GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getGraveyards().size() == 0)
            return "it's empty";
        for (Card card : GlobalVariable.getBoards().get(token).getOpponentPlayBoardByTurn().getGraveyards()) {
            graveyard.append(i).append(". ").append(card.toString()).append("\n");
            i++;
        }
        return graveyard.toString();

    }

    public String showCard(String token) {
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedOpponentCard() != null) {
            return (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedCard().toString());
        }
        if (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedOpponentCard() != null) {
            return (GlobalVariable.getBoards().get(token).getPlayBoardByTurn().getSelectedOpponentCard().toString());
        }
        return "no card is selected yet";
    }


}
