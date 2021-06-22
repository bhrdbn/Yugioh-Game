package model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayBoardTest {


    private Player player1 = new Player("ali","hassan","lol");
    private Player player2 = new Player("kami","mom","ltl");
private Card card = new Card("a",1,"1","1",true,1);
    private Card card2 = new Card("b",1,"1","1",true,1);
    private Card card3 = new Card("b",1,"1","1",true,1);
    PlayBoard playBoard = new PlayBoard(player1);
    private ArrayList<MonsterCard> changedPositionCards=new ArrayList<>();
    private ArrayList<MonsterCard> attackerCards=new ArrayList<>();
    private ArrayList<SpellCard> activatedSpellCards=new ArrayList<>();
    private List<MonsterCard> summonCards=new ArrayList<>();
    private boolean isCardSummonedOrSet;
    private boolean isCardAttacked;
    private boolean isPositionChanged;
    private ArrayList<Card> graveyard=new ArrayList<>();
    private SpellCard fields = new SpellCard("a","s",1,"a","c",true,1,"ff");
    private Deck deck1 =  new Deck("a");
    private Deck deck2 =  new Deck("b");
    private int lifePoint;

    private ArrayList<MonsterCard> monsters=new ArrayList<>();
    private ArrayList<Card> SpellTrap=new ArrayList<>();
    private ArrayList<Card> hand=new ArrayList<>();
    private Card selectedCard;
    private Card selectedOpponentCard;

    PlayBoardTest() throws IOException {

    }


    @Test
    void setSelectedOpponentCard(Card card) {
        playBoard.setSelectedOpponentCard(this.card);
        Card card20 =playBoard.getSelectedCard() ;
        assertEquals(card20,card);
    }

    @Test
    void getSelectedCard() {
        assertEquals(playBoard.getSelectedCard(),card);
    }

    @Test
    void getSelectedOpponentCard() {
   assertEquals(playBoard.getSelectedOpponentCard(),card);
    }

    @Test
    void setSelectedCard() {
        playBoard.setSelectedCard(this.card);
        Card card20 =playBoard.getSelectedCard() ;
        assertEquals(card20,card);
    }

    @Test
    void isCardSummonedOrSet() {
       Boolean s = playBoard.isCardSummonedOrSet();
        assertTrue(s);
    }

    @Test
    void isCardAttacked() {
        Boolean s = playBoard.isCardAttacked();
        assertTrue(s);

    }

    @Test
    void setCardSummonedOrSet() {
        playBoard.setCardSummonedOrSet(playBoard.isCardSummonedOrSet());

        assertTrue(isCardSummonedOrSet);
    }

    @Test
    void setCardAttacked() {
        playBoard.setCardAttacked(isCardAttacked);

        assertTrue(isCardAttacked);
    }

    @Test
    void setPositionChanged() {
        playBoard.setPositionChanged(isPositionChanged);
        assertTrue(isPositionChanged);
    }

    @Test
    void setPlayer() {
        playBoard.setPlayer(player1);
        assertEquals(playBoard.getPlayer(),player1);
    }

    @Test
    void selectMonster() {
        MonsterCard m =playBoard.selectMonster(1);
        assertNotNull(m);
    }

    @Test
    void selectSpellOrTrap() {
        Card s =playBoard.selectSpellOrTrap(1);
        assertNotNull(s);
    }

    @Test
    void selectFromHand() {
        Card s =playBoard.selectFromHand(1);
        assertNotNull(s);
    }

    @Test
    void getChangedPositionCards() {
        List<MonsterCard> l = playBoard.getChangedPositionCards();
        assertNotNull(l);
    }

    @Test
    void setChangedPositionCards() {
        playBoard.setChangedPositionCards(changedPositionCards);
        assertNotNull(playBoard.getChangedPositionCards());
    }

    @Test
    void getAttackerCards() {
        assertNotNull(playBoard.getAttackerCards());
    }

    @Test
    void setAttackerCards() {
        playBoard.setAttackerCards(attackerCards);
        assertNotNull(playBoard.getAttackerCards());
    }

    @Test
    void getActivatedSpellCards() {
        assertNotNull(playBoard.getActivatedSpellCards());
    }

    @Test
    void setActivatedSpellCards() {
        playBoard.setActivatedSpellCards(activatedSpellCards);
        assertNotNull(playBoard.getActivatedSpellCards());
    }

    @Test
    void getSummonCards() {
        assertNotNull(playBoard.getSummonCards());
    }

    @Test
    void setSummonCards() {
        playBoard.setSummonCards(summonCards);
        assertNotNull(playBoard.getSummonCards());
    }

    @Test
    void getGraveyards() {
        assertNotNull(playBoard.getGraveyards());
    }

    @Test
    void setGraveyards() {
playBoard.setGraveyards(graveyard);
        assertNotNull(playBoard.getGraveyards());
    }

    @Test
    void getFields() {
        assertNotNull(playBoard.getFields());
    }

    @Test
    void setFields() {
playBoard.setFields(fields);
        assertNotNull(playBoard.getFields());
    }

    @Test
    void getDeck() {
        assertNotNull(playBoard.getDeck());
    }

    @Test
    void setDeck() {
playBoard.setDeck(player1);
        assertNotNull(playBoard.getDeck());
    }

    @Test
    void getMonsters() {
        assertNotNull(playBoard.getMonsters());
    }

    @Test
    void setMonsters() {
        playBoard.setMonsters(monsters);
        assertNotNull(playBoard.getMonsters());
    }

    @Test
    void getSpellTrap() {
        assertNotNull(playBoard.getSpellTrap());

    }

    //@Test
   // void setSpellTrap() {
   //     playBoard.setSpellTrap(SpellTrap);
   //     assertNotNull(playBoard.getMonsters());
   // }

    @Test
    void getHand() {
        assertNotNull(playBoard.getHand());
    }

    @Test
    void setHand() {
        playBoard.setHand(hand);
        assertNotNull(playBoard.getHand());
    }

    @Test
    void graveToString() {
        assertNotEquals(playBoard.graveToString(),"hi");
    }

    @Test
    void getPlayer() {
        assertNotNull(playBoard.getPlayer());
    }

    @Test
    void isDeckFinished() {
        assertTrue(playBoard.isDeckFinished());
    }

    @Test
    void monster() {
        assertNotNull(playBoard.monster(1));
    }

    @Test
    void spell() {
        assertNotNull(playBoard.spell(2));
    }


    @Test
    void rotateToString() {
        assertNotNull(playBoard.rotateToString());
    }

    @Test
    void decreaseLifePoint() {
        playBoard.decreaseLifePoint(1);
        assertNotNull(lifePoint);
    }

    @Test
    void isPositionChanged() {
        assertTrue(playBoard.isPositionChanged());
    }
}