package model;

import controller.ImprotExport;

import java.util.ArrayList;

public class Player extends ImprotExport {
    private String nickname;
    private static ArrayList<Player> allPlayers = new ArrayList<>();
    private int score;
    private int money;
    private  ArrayList<Deck> decks;
    private  ArrayList<Deck> otherDecks;
    private Deck activatedDeck;
    private String password;
    private String username;
    ArrayList<Card>cards=new ArrayList<>();
    private static Player currentPlayer;

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        Player.currentPlayer = currentPlayer;
    }

    public Player(String nickname, String password, String username) {
        this.nickname = nickname;
        this.money = 2000;
        this.password = password;
        this.username = username;
        decks=new ArrayList<>();
        otherDecks=new ArrayList<>();
        allPlayers.add(this);
    }

    public Player getPlayerByNickName(String nickname) {
        for(Player player:allPlayers){
            if(player.getNickname().equals(nickname))return player;
        }
        return null;

    }
    public boolean doesHaveCardWithName(String name) {
        for(Card card:cards){
            if(card.getName().equals(name))return true;
        }
        return false;

    }


    public String getNickname() {
        return nickname;
    }

    public void increasePlayerMoney(int increase) {
        money += increase;

    }

    public void setMoney(int money) {
        this.money=money;

    }


    public int getMoney() {
        return money;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return  nickname + ": " +
                score ;
    }

    public static ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }
    public boolean doesHaveDeckWithThisName(String name){
        for(Deck deck: decks){
            if (deck.getName().equals(name))return true;
        }
        return false;
    }

    public ArrayList<Deck> getOtherDecks() {
        return otherDecks;
    }

    public Deck getDeckByName(String name){
        for(Deck deck: decks){
            if (deck.getName().equals(name))return deck;
        }
        return null;
    }

    public void removeDeck(Deck deck){
        decks.remove(deck);
        if(!deck.getName().equals(activatedDeck.getName())) {
            otherDecks.remove(deck);
        }
        else activatedDeck=null;
    }
    public void removeFromDeck(Card card){
        cards.add(card);
    }
    public void addToDeck(Card card){
        cards.remove(card);
    }
    public void addDeck(Deck deck){
        decks.add(deck);
        otherDecks.add(deck);
    }

    public Deck getActivatedDeck() {
        return activatedDeck;
    }
    public static Player getPlayerByUser(String username){
        for (Player player:allPlayers){
            if (player.getUsername().equals(username)) return player;
        }
        return null;

    }


    public void setActivatedDeck(Deck activatedDeck) {
        this.activatedDeck = activatedDeck;
        otherDecks.remove(activatedDeck);
    }

    public void decreaseMoney(int decrease) {
        money -= decrease;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void logout() {
        currentPlayer = null;
    }
}
