package clientcontroller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;




public class Controller {
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    private static MonsterCard monsterCard = null;
    private static SpellCard spellCard = null;
    private static TrapCard trapCard = null;
    ArrayList<MonsterCard> allMonsters = new ArrayList<>();
    ArrayList<SpellCard> allSpells = new ArrayList<>();
    ArrayList<TrapCard> allTraps = new ArrayList<>();
    private static Controller loginController = null;
    int rounds;
    Player firstWinner;
    Player secondWinner;
    Player thirdWinner;
    int firstLp;
    int secondLp;
    int thirdLP;
    String token;
    String boardToken;

    private Controller() {

    }

    public void networkInit() {
        try {
            socket = new Socket("localhost", 7777);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Controller getInstance() {
        if (loginController == null)
            loginController = new Controller();

        return loginController;
    }

    public String createUser(String userName, String nickName, String password) {

        try {
            dataOutputStream.writeUTF("create " + userName + " " + nickName + " " + password);
            dataOutputStream.flush();
            return dataInputStream.readUTF();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }


    }

    public String loginUser(String username, String password) {

        try {
            dataOutputStream.writeUTF("login " + username + " " + password);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            if (!result.contains("successfully"))
                return dataInputStream.readUTF();
            String[] resultSep = result.split(" ");
            token = resultSep[4];
            return result.substring(0, 14);


        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }

    }

    //------------------------
    public String scoreboard() {

        try {
            dataOutputStream.writeUTF("scoreboard");
            dataOutputStream.flush();
            return dataInputStream.readUTF();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }

    }

    public String logoutUser() {
        try {
            dataOutputStream.writeUTF("logout " + token);
            dataOutputStream.flush();
            return dataInputStream.readUTF();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }

    }

    public String changeNickName(String nickname) {
        try {
            dataOutputStream.writeUTF("change nickname " + nickname + " " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String changePassword(String newPassword, String oldPassword) {

        try {
            dataOutputStream.writeUTF("change password " + oldPassword + " " + newPassword + " " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";

        }
    }


    public ArrayList<MonsterCard> getAllMonsters() {
        return allMonsters;
    }


    public ArrayList<SpellCard> getAllSpells() {
        return allSpells;
    }

    public String buy(String cardName) {

        try {
            dataOutputStream.writeUTF("buy " + cardName + " " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";

        }

    }

    public String sell(String cardName) {

        try {
            dataOutputStream.writeUTF("sell " + cardName + " " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }

    }


    public String decreaseCard(String name) {

        try {
            dataOutputStream.writeUTF("admin decrease " + name);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";

        }

    }

    public String increaseCard(String name) {
        try {
            dataOutputStream.writeUTF("admin increase " + name);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";

        }

    }

    public String setForbidden(String name) {
        try {
            dataOutputStream.writeUTF("admin forbid " + name);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";

        }
    }

    public String setAllowed(String name) {
        try {
            dataOutputStream.writeUTF("admin allow " + name);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";

        }
    }


    public String showAll() {

        try {
            dataOutputStream.writeUTF("show all");
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";

        }

    }


    public boolean admin() {
        try {
            dataOutputStream.writeUTF("admin " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result.equals("true");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false;

        }
    }


    public String createDeck(String deckName) {
        try {
            dataOutputStream.writeUTF("deck create " + deckName + " " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String deleteDeck(String deckName) {
        try {
            dataOutputStream.writeUTF("deck delete " + deckName + " " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String activateDeck(String deckName) {
        try {
            dataOutputStream.writeUTF("deck set-activate " + deckName + " " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String addCardToDeck(String deckName, String cardName, int position) {

        try {
            if (position == 0) {
                dataOutputStream.writeUTF("deck add-card card " + cardName + " deck " + deckName + " side " + token);
                dataOutputStream.flush();
                String result = dataInputStream.readUTF();
                return result;
            } else {
                dataOutputStream.writeUTF("deck add-card card " + cardName + " deck " + deckName + " " + token);
                dataOutputStream.flush();
                String result = dataInputStream.readUTF();
                return result;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }

    }

    public String removeCardFromDeck(String deckName, String cardName, int position) {

        try {
            if (position == 0) {
                dataOutputStream.writeUTF("deck rm-card card " + cardName + " deck " + deckName + " side " + token);
                dataOutputStream.flush();
                String result = dataInputStream.readUTF();
                return result;
            } else {
                dataOutputStream.writeUTF("deck rm-card card " + cardName + " deck " + deckName + " " + token);
                dataOutputStream.flush();
                String result = dataInputStream.readUTF();
                return result;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }

    }

    public String showDecks() {
        try {
            dataOutputStream.writeUTF("deck show all " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String showADeck(String deckName, int position) {
        try {
            if (position == 0) {
                dataOutputStream.writeUTF("deck show deck-name " + deckName + " side " + token);
                dataOutputStream.flush();
                String result = dataInputStream.readUTF();
                return result;
            } else {
                dataOutputStream.writeUTF("deck show deck-name " + deckName + " " + token);
                dataOutputStream.flush();
                String result = dataInputStream.readUTF();
                return result;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String showAllCards() {
        try {
            dataOutputStream.writeUTF("deck show cards " + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String ritualSummon() {
        try {
            dataOutputStream.writeUTF("ritual summon " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }

    }


    //    public String newDuel(int round, String usernameOpponent, String usernamePlayer) {
//        if (Player.getPlayerByUser(usernameOpponent) == null) return "there is no player with this username";
//        else if (Player.getPlayerByUser(usernamePlayer).getActivatedDeck() == null) {
//            return usernamePlayer + " has no active deck";
//        } else if (Player.getPlayerByUser(usernameOpponent).getActivatedDeck() == null) {
//            return usernameOpponent + " has no active deck";
//        } else if (Player.getPlayerByUser(usernamePlayer).getActivatedDeck() == null) {
//            return usernamePlayer + " has no active deck";
//        } else if (!Player.getPlayerByUser(usernamePlayer).getActivatedDeck().isValid()) {
//            return usernamePlayer + "’s deck is invalid";
//        } else if (!Player.getPlayerByUser(usernameOpponent).getActivatedDeck().isValid()) {
//            return usernameOpponent + "’s deck is invalid";
//        } else if (round != 1 && round != 3)
//            return "number of rounds is not supported";
//        else {
//            rounds = round;
//            PlayBoard playBoardPlayer = new PlayBoard(Player.getPlayerByUser(usernamePlayer));
//            PlayBoard playBoardOpponent = new PlayBoard(Player.getPlayerByUser(usernameOpponent));
//            GlobalVariable.setBoard(new Board(playBoardPlayer, playBoardOpponent));
//            return "duel created";
//        }
//    }
//
//    public String newDuelAI(int round, String usernamePlayer) {
//
//        if (Player.getPlayerByUser(usernamePlayer).getActivatedDeck() == null) {
//            return usernamePlayer + " has no active deck";
//        } else if (Player.getPlayerByUser(usernamePlayer).getActivatedDeck() == null) {
//            return usernamePlayer + " has no active deck";
//        } else if (!Player.getPlayerByUser(usernamePlayer).getActivatedDeck().isValid()) {
//            return usernamePlayer + "’s deck is invalid";
//        } else if (round != 1 && round != 3)
//            return "number of rounds is not supported";
//        else {
//            PlayBoard playBoardPlayer = new PlayBoard(Player.getPlayerByUser(usernamePlayer));
//            PlayBoard playBoardOpponent = new PlayBoard(new AI("AI", "123", "AI"));
//            GlobalVariable.setBoard(new Board(playBoardPlayer, playBoardOpponent));
//            return "duel created";
//        }
//    }
//
//
    public String selectOwnMonster(int number) {
        try {
            dataOutputStream.writeUTF("select monster " + String.valueOf(number) + " " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String selectOpponentMonster(int number) {
        try {
            dataOutputStream.writeUTF("select monster " + String.valueOf(number) + " opponent " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String selectOwnSpell(int number) {
        try {
            dataOutputStream.writeUTF("select spell " + String.valueOf(number) + " " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String selectOpponentSpell(int number) {
        try {
            dataOutputStream.writeUTF("select spell " + String.valueOf(number) + " opponent" + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String selectHand(int number) {
        try {
            dataOutputStream.writeUTF("select hand " + String.valueOf(number) + " " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String selectField() {
        try {
            dataOutputStream.writeUTF("select field " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String selectOpponentField() {
        try {
            dataOutputStream.writeUTF("select field " + "opponent " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

//    public String manageAIPhaseAndPlay() {
//        String finalOut = "End phase\n" + GlobalVariable.getBoard().getTurn().getNickname() + "'s turn" + "\n" +
//                "draw phase\n" +
//                (GlobalVariable.getBoard().addToHand(GlobalVariable.getBoard().getPlayBoardByTurn()));
//        GlobalVariable.getBoard().setPhase(Phase.STANDBY);
//        finalOut += "standby phase\n";
//        GlobalVariable.getBoard().setPhase(Phase.MAIN1);
//        finalOut += "1st Main phase\n";
//        if (getMinOpponentAttack() != null && getMaxAttack().getAttack() > getMinOpponentAttack().getAttack()) {
//            GlobalVariable.getBoard().getPlayBoardByTurn().setSelectedCard(getMaxAttack());
//            finalOut += summon() + "\n";
//            GlobalVariable.getBoard().setPhase(Phase.BATTLE);
//            finalOut += "battle phase\n";
//            finalOut += MonsterCard.Attack(getMaxAttack(), getMinOpponentAttack(), getMinOpponentAttackIndex()) + "\n";
//
//        } else if (getMinOpponentAttack() == null) {
//            GlobalVariable.getBoard().getPlayBoardByTurn().setSelectedCard(getMaxAttack());
//            GlobalVariable.getBoard().setPhase(Phase.BATTLE);
//            finalOut += "battle phase\n";
//            MonsterCard.directAttack();
//        } else {
//            GlobalVariable.getBoard().setPhase(Phase.BATTLE);
//            finalOut += "battle phase\n";
//        }
//        finalOut += "2nd Main phase\n";
//        GlobalVariable.getBoard().setPhase(Phase.MAIN2);
//        if (!GlobalVariable.getBoard().getPlayBoardByTurn().isCardSummonedOrSet()) {
//            GlobalVariable.getBoard().getPlayBoardByTurn().setSelectedCard(getMaxDefense());
//            finalOut += setMonster() + "\n";
//        }
//        GlobalVariable.getBoard().setPhase(Phase.END);
//        finalOut += managePhase();
//        return finalOut;
//    }
//
//    public MonsterCard getMaxAttack() {
//        int max = 0;
//        MonsterCard monster = null;
//        for (Card card : GlobalVariable.getBoard().getPlayBoardByTurn().getHand()) {
//            if (card instanceof MonsterCard) {
//                if (max < ((MonsterCard) card).getAttack()) {
//                    max = ((MonsterCard) card).getAttack();
//                    monster = (MonsterCard) card;
//                }
//            }
//        }
//        return monster;
//    }
//
//    public MonsterCard getMaxDefense() {
//        int max = 0;
//        MonsterCard monster = null;
//        for (Card card : GlobalVariable.getBoard().getPlayBoardByTurn().getHand()) {
//            if (card instanceof MonsterCard) {
//                if (max < ((MonsterCard) card).getDefence()) {
//                    max = ((MonsterCard) card).getDefence();
//                    monster = (MonsterCard) card;
//                }
//            }
//        }
//        return monster;
//    }
//
//    public MonsterCard getMinOpponentAttack() {
//        int min = 99999;
//        MonsterCard monster = null;
//        for (MonsterCard card : GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters()) {
//            if (!card.getName().equals("nokhodi")) {
//                if (min > card.getDefence()) {
//                    min = card.getDefence();
//                    monster = card;
//                }
//            }
//        }
//        return monster;
//    }
//
//    public int getMinOpponentAttackIndex() {
//        int min = 99999;
//        int position = 0;
//        MonsterCard monster = null;
//        for (int i = 0; i < 5; i++) {
//            if (GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(i).getDefence() < min) {
//                min = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getMonsters().get(i).getDefence();
//                position = i + 1;
//            }
//        }
//        return position;
//    }
//
//    public void setWinner(int max) {
//        GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(300);
//        GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(3000 + max);
//        GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(3000);
//        System.out.println(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getUsername() + " won whole match");
//        MainView.getInstance().run();
//    }
//
//    public void lose() {
//        System.out.println(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().getUsername() + " won this round");
//        if (rounds == 1) {
//            GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer().increasePlayerMoney(100);
//            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increasePlayerMoney(1000 +
//                    GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint());
//            GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer().increaseScore(1000);
//            MainView.getInstance().run();
//        } else {
//            System.out.println("next round started");
//            if (firstWinner != null) {
//                if (secondWinner != null) {
//                    thirdWinner = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer();
//                    thirdLP = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint();
//                    if (firstWinner.getUsername().equals(thirdWinner.getUsername())) {
//                        int max = firstLp;
//                        if (firstLp < thirdLP) max = thirdLP;
//                        setWinner(max);
//                    } else {
//                        int max = secondLp;
//                        if (secondLp < thirdLP) max = thirdLP;
//                        setWinner(max);
//                    }
//                } else {
//                    secondWinner = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer();
//                    secondLp = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint();
//                    if (secondWinner.getUsername().equals(firstWinner.getUsername())) {
//                        int max = firstLp;
//                        if (firstLp < secondLp) max = secondLp;
//                        setWinner(max);
//                    } else getNewBoard();
//
//                }
//            } else {
//                firstWinner = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer();
//                firstLp = GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getLifePoint();
//                getNewBoard();
//            }
//        }
//
//
//    }
//
//    private void getNewBoard() {
//        PlayBoard playBoard = new PlayBoard(GlobalVariable.getBoard().getPlayBoardByTurn().getPlayer());
//        PlayBoard playBoard1 = new PlayBoard(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getPlayer());
//        Board board = new Board(playBoard, playBoard1);
//        GlobalVariable.setBoard(board);
//    }
//
    public String goNextPhase() {
        try {
            dataOutputStream.writeUTF("next phase " + boardToken + token);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }


    public String deselect() {
        try {
            dataOutputStream.writeUTF("select -d " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public void setWin() {
        try {
            dataOutputStream.writeUTF("surrender " + boardToken);
            dataOutputStream.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
//// ** monster ba ehzare vizhe ro nazadam **

    public String summon() {
        try {
            dataOutputStream.writeUTF("summon " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }

    }

    public String setMonster() {
        try {
            dataOutputStream.writeUTF("set " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String changePosition(String position) {
        try {
            dataOutputStream.writeUTF("set position " + position + " " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String flipSummon() {
        try {
            dataOutputStream.writeUTF("flip-summon " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }


    public String attack(int number) {
        try {
            dataOutputStream.writeUTF("attack " + String.valueOf(number) + " " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String directAttack() {
        try {
            dataOutputStream.writeUTF("attack direct " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String activateCard() {
        try {
            dataOutputStream.writeUTF("activate effect " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }


    }

    public String setSpellCard() {
        try {
            dataOutputStream.writeUTF("setSpell " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String setTrapCard() {
        try {
            dataOutputStream.writeUTF("setTrap " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String showMyGraveyard() {
        try {
            dataOutputStream.writeUTF("show graveyard " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String showOpponentGraveyard() {
        try {
            dataOutputStream.writeUTF("show opponent graveyard " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }

    public String showCard() {
        try {
            dataOutputStream.writeUTF("show card " + boardToken);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }
    public String request(String round){
        try {
            dataOutputStream.writeUTF("request " + token+" "+round);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
            if(result.startsWith("duel create")){
                String[] results=result.split(" ");
                boardToken=results[4];
            }
            return result;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "exception";
        }
    }
}


