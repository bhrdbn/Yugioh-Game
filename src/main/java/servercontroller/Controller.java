package servercontroller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import serverview.*;


public class Controller {

    private static MonsterCard monsterCard = null;
    private static SpellCard spellCard = null;
    private static TrapCard trapCard = null;
    ArrayList<MonsterCard> allMonsters = new ArrayList<>();
    ArrayList<SpellCard> allSpells = new ArrayList<>();
    ArrayList<TrapCard> allTraps = new ArrayList<>();
    private static Controller loginController = null;


    private Controller() {
        shopInit();
    }

    public static Controller getInstance() {
        if (loginController == null)
            loginController = new Controller();

        return loginController;
    }


    public void createNewUser(String nickName, String password, String userName) {
        Player player = new Player(nickName, password, userName);
    }

    public String createUser(String userName, String nickName, String password) {
        if (checkUserName(userName)) {
            if (checkNickNameExist(nickName)) {
                createNewUser(nickName, password, userName);
                return ("user created successfully!");
            } else
                return ("user with nickname " + nickName + " already exists");
        } else
            return ("user with username " + userName + " already exists");

    }


    public boolean checkUserName(String username) {
        for (Player player : Player.getAllPlayers()) {
            if (player.getUsername().equals(username))
                return false;
        }
        return true;
    }


    public boolean checkNickNameExist(String nickName) {
        for (Player player : Player.getAllPlayers()) {
            if (player.getNickname().equals(nickName))
                return false;
        }
        return true;
    }


    public boolean checkPassword(Player player, String password) {

        if (player.getPassword().equals(password)) return true;
        return false;
    }


    public String loginUser(String username, String password) {
        if (Player.getPlayerByUser(username) != null) {
            if (checkPassword(Player.getPlayerByUser(username), password)) {
                String token = UUID.randomUUID().toString();
                GlobalVariable.getPlayers().put(token, Player.getPlayerByUser(username));
                return ("user logged in successfully! " + token);
            } else
                return ("Username and password didn't match!");
        } else return ("Username and password didn't match!");
    }

    //------------------------
    public static String scoreboard() {
        Comparator<Player> scoreComparator = Comparator.comparing(Player::getScore).reversed();
        Comparator<Player> alphabetComparator = Comparator.comparing(Player::getNickname);
        Comparator<Player> multiComparator = scoreComparator.thenComparing(alphabetComparator);
        ArrayList<Player> sortedAllPerson = (ArrayList<Player>) Player.getAllPlayers().stream().sorted(multiComparator).
                collect(Collectors.toList());
        StringBuilder score = new StringBuilder();
        for (Player allPerson : sortedAllPerson) {
            score.append(allPerson.toString());
            if (isOnlineByName(allPerson.getUsername()))
                score.append("  online");
            score.append("\n");
        }
        return score.toString();
    }

    public static boolean isOnlineByName(String username) {
        for (Player value : GlobalVariable.getPlayers().values()) {
            if (value.getUsername().equals(username)) return true;
        }
        return false;
    }

    public String logoutUser(String token) {
        GlobalVariable.getPlayers().remove(token);
        return "user logged out successfully!";
    }

    public String changeNickName(String nickname, String token) {
        if (checkNickNameExist(nickname)) {
            GlobalVariable.getPlayers().get(token).setNickname(nickname);
            return "nickname changed successfully";
        } else return nickname + " already exists";
    }

    public String changePassword(String old, String newPassword, String token) {
        if (GlobalVariable.getPlayers().get(token).getPassword().equals(old)) {
            if (old.equals(newPassword)) return "please enter a new password";
            else {
                GlobalVariable.getPlayers().get(token).setPassword(newPassword);
                return "password changed";
            }
        } else return "username and password didn't match";

    }


    public boolean checkPassword(String currentPassword, String newPassword) {
        for (Player player : Player.getAllPlayers()) {
            if (!player.getPassword().equals(currentPassword))
                return false;
        }

        return true;
    }

    private void shopInit() {
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("csvjsonmonster.json")));
            allMonsters = new Gson().fromJson(json, new TypeToken<List<MonsterCard>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json1 = null;
        try {
            json1 = new String(Files.readAllBytes(Paths.get("csvjsonspell.json")));
            allSpells = new Gson().fromJson(json1, new TypeToken<List<SpellCard>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json2 = null;
        try {
            json2 = new String(Files.readAllBytes(Paths.get("csvjsontrap.json")));
            allTraps = new Gson().fromJson(json2, new TypeToken<List<TrapCard>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setCountM(allMonsters);
        setCountS(allSpells);
        setCountT(allTraps);

    }

    public void setCountM(ArrayList<MonsterCard> cards) {
        for (Card card : cards) {
            card.setCountInShop(5);
        }
    }

    public void setCountS(ArrayList<SpellCard> cards) {
        for (Card card : cards) {
            card.setCountInShop(5);
        }
    }

    public void setCountT(ArrayList<TrapCard> cards) {
        for (Card card : cards) {
            card.setCountInShop(5);
        }
    }

    public ArrayList<MonsterCard> getAllMonsters() {
        return allMonsters;
    }


    public ArrayList<SpellCard> getAllSpells() {
        return allSpells;
    }

    public String buy(String cardName, String token) {
        try {
            Card card = getCardByName(cardName);
            if (card.isForbidden()) return "this card is forbidden";
            if (card.getCountInShop() <= 0) return "card is finished";
            if (GlobalVariable.getPlayers().get(token).getMoney() < card.getPrice()) {
                return (card.getPrice() + " " + GlobalVariable.getPlayers().get(token).getMoney() +
                        "\nno enough money");
            } else {
                if (card instanceof MonsterCard)
                    GlobalVariable.getPlayers().get(token).getCards().add(new MonsterCard((MonsterCard) card));
                else if (card instanceof SpellCard)
                    GlobalVariable.getPlayers().get(token).getCards().add(new SpellCard((SpellCard) card));
                if (card instanceof TrapCard)
                    GlobalVariable.getPlayers().get(token).getCards().add(new TrapCard((TrapCard) card));
                GlobalVariable.getPlayers().get(token).decreaseMoney(card.getPrice());
                card.decCountInShop();
                return "card added successfully";
            }
        } catch (Exception e) {
            return "no card with this name";
        }
    }

    public String sell(String cardName, String token) {
        if (!GlobalVariable.getPlayers().get(token).doesHaveCardWithName(cardName))
            return "you don't have this card";
        getCardByName(cardName).addCountInShop();
        GlobalVariable.getPlayers().get(token).increasePlayerMoney((int) getCardByName(cardName).getPrice());
        Card card = GlobalVariable.getPlayers().get(token).getCardByName(cardName);
        GlobalVariable.getPlayers().get(token).getCards().remove(card);
        return "you sold the card successfully";

    }


    public Card getCardByName(String name) {
        for (MonsterCard card : allMonsters) {
            if (card.getName().equals(name)) return card;
        }
        for (SpellCard card : allSpells) {
            if (card.getName().equals(name)) return card;
        }
        for (TrapCard card : allTraps) {
            if (card.getName().equals(name)) return card;
        }
        return null;
    }

    public String decreaseCard(String name) {
        try {
            getCardByName(name).decCountInShop();
            return "card decreased successfully";

        } catch (NullPointerException e) {
            return "the name is wrong";
        }

    }

    public String increaseCard(String name) {
        try {
            getCardByName(name).addCountInShop();
            return "card added successfully";

        } catch (NullPointerException e) {
            return "the name is wrong";

        }

    }

    public String setForbidden(String name) {
        try {
            getCardByName(name).setForbidden(true);
            return "card is forbidden now";

        } catch (NullPointerException e) {
            return "the name is wrong";

        }

    }

    public String setAllowed(String name) {
        try {
            getCardByName(name).setForbidden(false);
            return "card is allowed now";

        } catch (NullPointerException e) {
            return "the name is wrong";

        }

    }

    public String addAuction(String token, String name, int price) {
        if (!GlobalVariable.getPlayers().get(token).doesHaveCardWithName(name))
            return "you don't have this card";

        new Thread(() -> {
            Auction auction = new Auction(price, GlobalVariable.getPlayers().get(token), getCardByName(name));
            LocalDateTime now0 = LocalDateTime.now();
            while (ChronoUnit.MINUTES.between(now0, LocalDateTime.now()) <= 5) {
                auction.setTime((int) (300-(ChronoUnit.SECONDS.between(now0, LocalDateTime.now()))));
                if(auction.getTime()<=0)break;

            }
            auction.setActive(false);


        }).start();
        return "auction created";
    }


    public String showAll() {
        String showCard = "";
        Comparator<MonsterCard> alphabetComparator = Comparator.comparing(MonsterCard::getName);
        ArrayList<MonsterCard> sortedAllMonsters = (ArrayList<MonsterCard>) allMonsters.stream().sorted(alphabetComparator).
                collect(Collectors.toList());

        Comparator<SpellCard> alphabetComparator1 = Comparator.comparing(SpellCard::getName);
        ArrayList<SpellCard> sortedAllSpells = (ArrayList<SpellCard>) allSpells.stream().sorted(alphabetComparator1).
                collect(Collectors.toList());
        Comparator<TrapCard> alphabetComparator2 = Comparator.comparing(TrapCard::getName);
        ArrayList<TrapCard> sortedAllTraps = (ArrayList<TrapCard>) allTraps.stream().sorted(alphabetComparator2).
                collect(Collectors.toList());
        System.out.println("monster cards:\n");


        for (MonsterCard card : sortedAllMonsters) {
            showCard += card.getName() + " : " + card.getPrice() + "\n";
        }
        showCard += "\n\nspell cards:\n";

        for (SpellCard card : sortedAllSpells) {
            showCard += card.getName() + " : " + card.getPrice() + "\n";
        }
        showCard += "\n\ntrap cards:\n";

        for (TrapCard card : sortedAllTraps) {
            showCard += card.getName() + " : " + card.getPrice() + "\n";
        }
        return showCard;
    }


    public String admin(String token) {
        if (GlobalVariable.getPlayers().get(token).getUsername().equals("abp")) return "true";
        return "false";
    }
    //todo : continue from here

    public String createDeck(String deckName, String token) {
        if (GlobalVariable.getPlayers().get(token).doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " already exists";
        else {
            Deck deck = new Deck(deckName);
            GlobalVariable.getPlayers().get(token).addDeck(deck);
            return "deck created successfully!";
        }
    }

    public String deleteDeck(String deckName, String token) {
        if (!GlobalVariable.getPlayers().get(token).doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else {
            GlobalVariable.getPlayers().get(token).removeDeck(GlobalVariable.getPlayers().get(token).getDeckByName(deckName));
            return "deck deleted successfully";
        }
    }

    public String activateDeck(String deckName, String token) {
        if (!GlobalVariable.getPlayers().get(token).doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else {
            GlobalVariable.getPlayers().get(token).setActivatedDeck(GlobalVariable.getPlayers().get(token).getDeckByName(deckName));
            return "deck activated successfully";
        }
    }

    public String addCardToDeck(String deckName, String cardName, int position, String token) {

        if (GlobalVariable.getPlayers().get(token) != null && !GlobalVariable.getPlayers().get(token).doesHaveCardWithName(cardName))
            return "card with name " + cardName + " does not exist";
        else if (GlobalVariable.getPlayers().get(token) != null && !GlobalVariable.getPlayers().get(token).doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if (GlobalVariable.getPlayers().get(token) != null && position == 1 && GlobalVariable.getPlayers().get(token).getDeckByName(deckName).isMainFull()) {

            return "main deck is full";
        } else if (GlobalVariable.getPlayers().get(token) != null && position == 0 && GlobalVariable.getPlayers().get(token).getDeckByName(deckName).isSideFull()) {

            return "side deck is full";
        } else if (GlobalVariable.getPlayers().get(token) != null && GlobalVariable.getPlayers().get(token).getDeckByName(deckName).countACardInDeck
                (GlobalVariable.getPlayers().get(token).getCardByName(cardName)) == 3) {
            return "there are already three cards with name " + cardName + " in deck " + deckName;
        } else {
            if (GlobalVariable.getPlayers().get(token) != null) {
                GlobalVariable.getPlayers().get(token).getDeckByName(deckName).addCard(GlobalVariable.getPlayers().get(token).getCardByName(cardName), position);
                GlobalVariable.getPlayers().get(token).getDeckByName(deckName).setIsValid();
            }
            return "card added to deck successfully";
        }

    }

    public String removeCardFromDeck(String deckName, String cardName, int position, String token) {
        if (!GlobalVariable.getPlayers().get(token).doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if (!GlobalVariable.getPlayers().get(token).getDeckByName(deckName).doesHaveCard(cardName, position))
            return "card with name " + cardName + " does not exist";

        else {
            if (GlobalVariable.getPlayers().get(token) != null) {
                GlobalVariable.getPlayers().get(token).getDeckByName(deckName).removeCard(GlobalVariable.getPlayers().get(token).getCardByName(cardName), position);
                GlobalVariable.getPlayers().get(token).getDeckByName(deckName).setIsValid();
            }
            return "card removed from deck successfully";
        }

    }

    public String showDecks(String token) {
        StringBuilder otherDecks = new StringBuilder("");
        Comparator<Deck> alphabetComparator = Comparator.comparing(Deck::getName);
        ArrayList<Deck> sortedOtherDeck = (ArrayList<Deck>) GlobalVariable.getPlayers().get(token).getOtherDecks().stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for (Deck deck : sortedOtherDeck) {
            otherDecks.append(deck.toString()).append("\n");
        }
        return "Decks:\n" +
                "Active deck:\n" +
                GlobalVariable.getPlayers().get(token).getActivatedDeck() + "\n" +
                "Other decks:\n" +
                otherDecks;
    }

    public String showADeck(String deckName, int position, String token) {
        StringBuilder monsterDeck = new StringBuilder("");
        StringBuilder trapAndSpellDeck = new StringBuilder("");
        String sideOrMain;
        if (position == 1) sideOrMain = "Main";
        else sideOrMain = "Side";
        Comparator<Card> alphabetComparator = Comparator.comparing(Card::getName);
        ArrayList<Card> sortedMonsterCards = (ArrayList<Card>) GlobalVariable.getPlayers().get(token).getDeckByName(deckName).getMonsters(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for (Card card : sortedMonsterCards) {
            monsterDeck.append(card.toString()).append("\n");
        }
        ArrayList<Card> sortedTrapCards = (ArrayList<Card>) GlobalVariable.getPlayers().get(token).getDeckByName(deckName).getTrapOrSpell(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for (Card card : sortedTrapCards) {
            trapAndSpellDeck.append(card.toString()).append("\n");
        }
        return "Deck: " + deckName + " " +
                sideOrMain + " deck:\n" +
                "Monsters:\n" + monsterDeck +

                "Spell and Traps:\n" +
                trapAndSpellDeck;
    }

    public String showAllCards(String token) {
        StringBuilder cards = new StringBuilder("");
        for (Card card : GlobalVariable.getPlayers().get(token).getCards()) {
            cards.append(card.toString()).append("\n");
        }
        return cards.toString();
    }

    public String request(String token, String round) {
        if (GlobalVariable.getPlayers().get(token).getActivatedDeck() == null) {
            return " you have no active deck";
        } else if (!GlobalVariable.getPlayers().get(token).getActivatedDeck().isValid()) {
            return "your deck is invalid";
        } else {

            GlobalVariable.getWaitingList().put(token, round);
            return wait(token, round);
        }
    }


    public synchronized String opponentExists(String token) {
        for (Map.Entry<String, String> entry : GlobalVariable.getP2p().entrySet()) {
            if (entry.getValue().equals(token)) {
                return entry.getKey();
            }
        }
        return "";
    }

    public synchronized String wait(String token, String round) {
        Player player;
        LocalDateTime now0 = LocalDateTime.now();
        String secondToken = opponentExists(token);
        if (secondToken.equals("")) {
            while (ChronoUnit.SECONDS.between(now0, LocalDateTime.now()) <= 15) {
                player = getOpponent(token, round);
                if (player != null) {
                    String boardToken = setBoard(token, player);
                    return "duel created with " + player.getUsername() + " " + boardToken;
                }
            }
            while (true) {
                player = getOpponentRound(token, round);
                if (player != null) {
                    String boardToken = setBoard(token, player);
                    return "duel created with " + player.getUsername() + " " + boardToken;
                }
            }
        } else {
            String boardToken = GlobalVariable.getP2board().get(secondToken);
            return "duel created with " + GlobalVariable.getPlayers().get(secondToken).getUsername()
                    + " " + boardToken;

        }

    }


    public synchronized String setBoard(String token, Player player) {
        PlayBoard playBoard2 = new PlayBoard(player);
        PlayBoard playBoard1 = new PlayBoard(GlobalVariable.getPlayers().get(token));
        Board board = new Board(playBoard1, playBoard2, token);
        String boardToken = UUID.randomUUID().toString();
        GlobalVariable.getBoards().put(boardToken, board);
        GlobalVariable.getP2board().put(token, boardToken);
        GameController.getInstance().setRounds(Integer.parseInt(GlobalVariable.getWaitingList().get(token)));
        GlobalVariable.getWaitingList().remove(token);
        return boardToken;
    }

    public synchronized Player getOpponent(String token, String round) {
        Player player = null;
        for (Map.Entry<String, String> entry : GlobalVariable.getWaitingList().entrySet()) {
            if (entry.getValue().equals(round) &&
                    Math.abs(GlobalVariable.getPlayers().get(entry.getKey()).getScore() - GlobalVariable.getPlayers().get(token).getScore()) <= 1500
                    && !entry.getKey().equals(token)) {
                player = GlobalVariable.getPlayers().get(entry.getKey());
                GlobalVariable.getWaitingList().remove(entry.getKey());
                GlobalVariable.getP2p().put(token, entry.getKey());
                return player;
            }
        }
        return null;
    }

    public synchronized Player getOpponentRound(String token, String round) {
        Player player = null;
        for (Map.Entry<String, String> entry : GlobalVariable.getWaitingList().entrySet()) {
            if (entry.getValue().equals(round) &&
                    !entry.getKey().equals(token)) {
                player = GlobalVariable.getPlayers().get(entry.getKey());
                GlobalVariable.getWaitingList().remove(entry.getKey());
                GlobalVariable.getP2p().put(token, entry.getKey());
                return player;
            }
        }
        return null;
    }

    public String showAuction() {
        StringBuilder str = new StringBuilder();
        for (Auction auction : Auction.getAuctions()) {
            str.append(auction.toString());
            str.append("\n");

        }
        str.append("\n");
        str.append("if you have a suggestion for a specific id enter id and your suggestion");
        return str.toString();
    }

    public String suggestAuction(int id, int price, String token) {
        Auction auction = Auction.getAuctionById(id);
        if (auction == null) return "enter valid id";
        if (!auction.getActive()) return "auction is expired";
        if (auction.getPrice() >= price) return "your suggested payment is not enough";
        if (price > GlobalVariable.getPlayers().get(token).getMoney()) return "you don't have enough money";
        if (auction.getCustomer() != null) {
            int difference=price-auction.getPrice();
            auction.getCustomer().increasePlayerMoney(auction.getPrice());
            auction.setCustomer(GlobalVariable.getPlayers().get(token));
            GlobalVariable.getPlayers().get(token).decreaseMoney(price);
            auction.setPrice(price);
            auction.getSeller().increasePlayerMoney(difference);
            return "your current money is "+GlobalVariable.getPlayers().get(token).getMoney();
        }
        auction.setCustomer(GlobalVariable.getPlayers().get(token));
        GlobalVariable.getPlayers().get(token).decreaseMoney(price);
        auction.setPrice(price);
        auction.getSeller().increasePlayerMoney(price);
        getCardByName(auction.getCard().getName()).addCountInShop();
        Card card = GlobalVariable.getPlayers().get(token).getCardByName(auction.getCard().getName());
        GlobalVariable.getPlayers().get(token).getCards().remove(card);
        return "your current money is "+GlobalVariable.getPlayers().get(token).getMoney();
    }
}


