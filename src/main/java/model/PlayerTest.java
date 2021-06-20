package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player = new Player("a","b","c");
    private String nickname;
    private static ArrayList<Player> allPlayers = new ArrayList<>();
    private int score;
    private int money;
    private  ArrayList<Deck> decks;
    private  ArrayList<Deck> otherDecks;
    private Deck activatedDeck;
    private String password;
    private String username;
    Deck deck = new Deck("a");
    ArrayList<Card>cards=new ArrayList<>();
    private static Player currentPlayer;
    @Test
    void getCurrentPlayer() {
        assertNotNull(Player.getCurrentPlayer());
    }

    @Test
    void setCurrentPlayer() {
        Player.setCurrentPlayer(player);
        assertNotNull(Player.getCurrentPlayer());

    }

    @Test
    void getPlayerByNickName() {
    assertEquals(player.getPlayerByNickName("a"),"a");
    }


    @Test
    void doesHaveCardWithName() {
        assertFalse(player.doesHaveCardWithName("c"));
    }

    @Test
    void getNickname() {
    assertEquals(player.getNickname(),"a");
    }

    @Test
    void increasePlayerMoney() {
        player.increasePlayerMoney(1);
        assertEquals(player.getMoney(),1);
    }

    @Test
    void setMoney() {
player.setMoney(1);
        assertEquals(player.getMoney(),1);
    }

    @Test
    void getMoney() {
        assertEquals(player.getMoney(),1);
    }

    @Test
    void setScore() {
        player.setScore(1);
        assertEquals(player.getScore(),1);
    }

    @Test
    void getScore() {
        assertEquals(player.getScore(),0);
    }

    @Test
    void getUsername() {
       assertEquals(player.getUsername(),"b");
    }

    @Test
    void getPassword() {
        assertEquals(player.getPassword(),"c");
    }

    @Test
    void setNickname() {
        player.setNickname("c");
        assertEquals(player.getNickname(),"c");
    }

    @Test
    void setPassword() {
        player.setPassword("c");
        assertEquals(player.getPassword(),"c");
    }

    @Test
    void setUsername() {
        player.setUsername("c");
        assertEquals(player.getUsername(),"c");
    }

    @Test
    void testToString() {
 assertEquals(player.toString(),"a : 0");

    }

    @Test
    void getAllPlayers() {
        assertNotNull(Player.getAllPlayers());
    }

    @Test
    void doesHaveDeckWithThisName() {
    assertFalse(player.doesHaveDeckWithThisName("c"));
    }

    @Test
    void getOtherDecks() {
    assertNull(player.getOtherDecks());
    }

    @Test
    void getDeckByName() {
    assertNull(player.getDeckByName("c"));
    }

    @Test
    void removeDeck() {
        player.removeDeck(deck);
        assertNull(decks);
    }

    @Test
    void removeFromDeck() {
        player.removeFromDeck(Card.getCardByName("a"));
        assertNull(deck);

    }

    @Test
    void addToDeck() {
        player.addToDeck(Card.getCardByName("a"));
        assertNull(deck);

    }

    @Test
    void addDeck() {
        player.addDeck(deck);
        assertNull(deck);
    }

    @Test
    void getActivatedDeck() {
        assertNull(player.getActivatedDeck());
    }

    @Test
    void getPlayerByUser() {
        assertNull(Player.getPlayerByUser("a"));
    }

    @Test
    void setActivatedDeck() {
        player.setActivatedDeck(deck);
        assertNull(deck);
    }

    @Test
    void decreaseMoney() {
   player.decreaseMoney(1);
   assertNotNull(money);
    }


    @Test
    void getCards() {
    assertNull(player.getCards());
    }

    @Test
    void logout() {
        Player.logout();
        assertNull(player);
    }
}