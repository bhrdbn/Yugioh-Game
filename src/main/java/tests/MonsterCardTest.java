package tests;

import model.MonsterCard;
import model.TypeOfMonsterCard;
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

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1, TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setAttack(1);
        assertNotNull(monsterCard.getAttack());
    }

    @Test
    void setIsAttack() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setIsAttack(true);
        assertNotNull(monsterCard.getAttack());
    }

    @Test
    void typeOfMonsterCard() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
       assertNotNull(monsterCard.typeOfMonsterCard());
    }

    @Test
    void getDefence() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setDefence(1);
        assertNotNull(monsterCard.getDefence());

    }

    @Test
    void setDefence() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setDefence(1);
        assertNotNull(monsterCard.getDefence());
    }

    @Test
    void getAttribute() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setAttribute("a");
        assertNotNull(monsterCard.getAttribute());
    }

    @Test
    void setAttribute() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setAttribute("a");
        assertNotNull(monsterCard.getAttribute());
    }

    @Test
    void getLevel() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setLevel(1);
        assertNotNull(monsterCard.getLevel());
    }

    @Test
    void setLevel() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setLevel(1);
        assertNotNull(monsterCard.getLevel());
    }

    @Test
    void getAttack() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setAttack(1);
        assertNotNull(monsterCard.getAttack());
    }

    @Test
    void attack() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();
        MonsterCard omonsterCard = new MonsterCard("b",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
       MonsterCard.Attack(monsterCard,omonsterCard);
       assertNotNull(monsterCard);
    }

    @Test
    void directAttack() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();
        MonsterCard omonsterCard = new MonsterCard("b",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setDefence(1);
        MonsterCard.directAttack(monsterCard,omonsterCard);
        assertNotNull(monsterCard.getDefence());
    }



    @Test
    void isAttack() throws IOException {
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();

        MonsterCard monsterCard = new MonsterCard("a",1,"a","a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        monsterCard.setDefence(1);
        monsterCard.isAttack();
        assertNotNull(monsterCard.getDefence());
    }
}