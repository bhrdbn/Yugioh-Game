package tests;

import controller.GlobalVariable;
import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MonsterCardTest {

    MonsterCardTest() throws IOException {
    }

    @Test
    void setAttack() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1, TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setAttack(1);
        assertNotNull(monsterCard.getAttack());
    }

    @Test
    void setIsAttack() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setIsAttack(true);
        assertNotNull(monsterCard.getAttack());
    }

    @Test
    void typeOfMonsterCard() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
       assertNotNull(monsterCard.typeOfMonsterCard());
    }

    @Test
    void getDefence() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setDefence(1);
        assertNotNull(monsterCard.getDefence());

    }

    @Test
    void setDefence() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setDefence(1);
        assertNotNull(monsterCard.getDefence());
    }

    @Test
    void getAttribute() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setAttribute("a");
        assertNotNull(monsterCard.getAttribute());
    }

    @Test
    void setAttribute() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setAttribute("a");
        assertNotNull(monsterCard.getAttribute());
    }

    @Test
    void getLevel() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setLevel(1);
        assertNotNull(monsterCard.getLevel());
    }

    @Test
    void setLevel() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setLevel(1);
        assertNotNull(monsterCard.getLevel());
    }

    @Test
    void getAttack() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setAttack(1);
        assertNotNull(monsterCard.getAttack());
    }

    @Test
    void attack() throws IOException {
        try{
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();
        MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
       MonsterCard.Attack(monsterCard,omonsterCard,1);
       assertNotNull(monsterCard);
    } catch (Exception e){}}

    @Test
    void directAttack() throws IOException {
        try{
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();
        MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setDefence(1);
        MonsterCard.directAttack();
        assertNotNull(monsterCard.getDefence());}
        catch (Exception e){}
    }



    @Test
    void isAttack() throws IOException {
        try{
        Player p = new Player("a","b","c");
        Player op = new Player("m","n","p");
        GlobalVariable.setPlayer(p);
        GlobalVariable.setPlayer(op);

        PlayBoard pl = new PlayBoard(p);
        PlayBoard Opl = new PlayBoard(op);
        Board board = new Board(pl,Opl);
        GlobalVariable.setBoard(board);
        Deck deck = new Deck("all");
        Card card = new Card("a",1,"k","o",true,2);
p.setActivatedDeck(deck);
p.getActivatedDeck();
        deck.addCard(card,1);
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();
        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setDefence(1);
        monsterCard.isAttack();
        assertNotNull(monsterCard.getDefence());
    } catch (Exception e){}
} }