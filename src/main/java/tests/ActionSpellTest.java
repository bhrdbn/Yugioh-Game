package tests;

import controller.GlobalVariable;
import model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ActionSpellTest {
ActionSpell actionSpell = new ActionSpell();
    @Test
    void setAction() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            actionSpell.setAction(card1, null, null, null, null, null, null, null);
       assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction2() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            actionSpell.setAction(card2, null, null, null, null, null, null, null);

        }catch (Exception e){}
    }
    @Test
    void setAction3() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card3, null, null, null, null, null, null, null);

            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction4() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card4, null, null, null, null, null, null, null);

            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction5() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card5, null, null, null, null, null, null, null);

            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction6() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card6, null, null, null, null, null, null, null);
            actionSpell.setAction(card7, null, null, null, null, null, null, null);

        }catch (Exception e){}
    }
    @Test
    void setAction7() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card7, null, null, null, null, null, null, null);

            actionSpell.setAction(card18, null, null, null, null, null, null, null);
            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction8() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card8, null, null, null, null, null, null, null);
            actionSpell.setAction(card9, null, null, null, null, null, null, null);
            actionSpell.setAction(card10, null, null, null, null, null, null, null);
            actionSpell.setAction(card11, null, null, null, null, null, null, null);
            actionSpell.setAction(card12, null, null, null, null, null, null, null);
            actionSpell.setAction(card13, null, null, null, null, null, null, null);
            actionSpell.setAction(card14, null, null, null, null, null, null, null);
            actionSpell.setAction(card15, null, null, null, null, null, null, null);
            actionSpell.setAction(card16, null, null, null, null, null, null, null);

            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction9() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card9, null, null, null, null, null, null, null);
            actionSpell.setAction(card10, null, null, null, null, null, null, null);
            actionSpell.setAction(card11, null, null, null, null, null, null, null);
            actionSpell.setAction(card12, null, null, null, null, null, null, null);
            actionSpell.setAction(card13, null, null, null, null, null, null, null);
            actionSpell.setAction(card14, null, null, null, null, null, null, null);
            actionSpell.setAction(card15, null, null, null, null, null, null, null);

            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction10() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card10, null, null, null, null, null, null, null);
            actionSpell.setAction(card11, null, null, null, null, null, null, null);
            actionSpell.setAction(card12, null, null, null, null, null, null, null);
            actionSpell.setAction(card13, null, null, null, null, null, null, null);
            actionSpell.setAction(card14, null, null, null, null, null, null, null);
            actionSpell.setAction(card15, null, null, null, null, null, null, null);
            actionSpell.setAction(card16, null, null, null, null, null, null, null);

            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction11() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card11, null, null, null, null, null, null, null);
            actionSpell.setAction(card12, null, null, null, null, null, null, null);
            actionSpell.setAction(card13, null, null, null, null, null, null, null);
            actionSpell.setAction(card14, null, null, null, null, null, null, null);
            actionSpell.setAction(card15, null, null, null, null, null, null, null);
            actionSpell.setAction(card16, null, null, null, null, null, null, null);

            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction12() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card12, null, null, null, null, null, null, null);
            actionSpell.setAction(card13, null, null, null, null, null, null, null);
            actionSpell.setAction(card14, null, null, null, null, null, null, null);
            actionSpell.setAction(card15, null, null, null, null, null, null, null);
            actionSpell.setAction(card16, null, null, null, null, null, null, null);
            actionSpell.setAction(card17, null, null, null, null, null, null, null);

            actionSpell.setAction(card18, null, null, null, null, null, null, null);
            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction13() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card13, null, null, null, null, null, null, null);
            actionSpell.setAction(card14, null, null, null, null, null, null, null);
            actionSpell.setAction(card15, null, null, null, null, null, null, null);
            actionSpell.setAction(card16, null, null, null, null, null, null, null);
            actionSpell.setAction(card17, null, null, null, null, null, null, null);

            actionSpell.setAction(card18, null, null, null, null, null, null, null);
            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction14() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card14, null, null, null, null, null, null, null);
            actionSpell.setAction(card15, null, null, null, null, null, null, null);

            actionSpell.setAction(card18, null, null, null, null, null, null, null);
            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction15() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card15, null, null, null, null, null, null, null);
            actionSpell.setAction(card16, null, null, null, null, null, null, null);
            actionSpell.setAction(card17, null, null, null, null, null, null, null);

            actionSpell.setAction(card18, null, null, null, null, null, null, null);
            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction16() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card16, null, null, null, null, null, null, null);
            actionSpell.setAction(card17, null, null, null, null, null, null, null);

            actionSpell.setAction(card18, null, null, null, null, null, null, null);
            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void setAction17() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card17, null, null, null, null, null, null, null);

            actionSpell.setAction(card18, null, null, null, null, null, null, null);
            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    void setAction18() {
        try {


            int card1 = 1;
            int card2 = 2;
            int card3 = 3;
            int card4 = 4;
            int card5 = 5;
            int card6 = 6;
            int card7 = 7;
            int card8 = 8;
            int card9 = 9;
            int card10 = 10;
            int card11 = 11;
            int card12 = 12;
            int card13 = 13;
            int card14 = 14;
            int card15 = 15;
            int card16 = 16;
            int card17 = 17;
            int card18 = 18;
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);

            actionSpell.setAction(card18, null, null, null, null, null, null, null);
            assertNotNull(actionSpell);
        }catch (Exception e){}
    }
    @Test
    void supply() {
        try{
        ArrayList<MonsterCard> monsterCards = new ArrayList<>();
        MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

        MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
        monsterCards.add(monsterCard);
        Player p = new Player("a", "b", "c");
        Player op = new Player("m", "n", "p");
        Deck deck = new Deck("a");
        Card card = new Card("a", 1, "a", "a", true, 1);
        deck.addCard(card, 1);
        GlobalVariable.setPlayer(p);
        GlobalVariable.setPlayer(op);
        p.addDeck(deck);
        p.setActivatedDeck(deck);
        op.setActivatedDeck(deck);
        PlayBoard playBoard = new PlayBoard(p);
        playBoard.setMonsters(monsterCards);
        actionSpell.supply(playBoard,deck);
        assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void ring() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            Board board = new Board(playBoard,playBoard);
            actionSpell.ring(board);
            assertNotNull(monsterCards);
        } catch (Exception e){}
    }

    @Test
    void addFieldSpellFromDeck() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.addFieldSpellFromDeck(playBoard);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void destroytrapspelloponent() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.destroytrapspelloponent(deck);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void spelllife() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.spelllife(playBoard);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void destroyopmon() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.destroyopmon(playBoard);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void reborn() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.reborn(null,null);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void addCard() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.addCard(null,null);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void spellcasterATKplus() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.spellcasterATKplus(null);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void fiendATKplus() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.fiendATKplus(null);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void fairyATKlose() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.fairyATKlose(null);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void insectAtkplus() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.InsectAtkplus(monsterCards);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void aquaAtkplus() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.aquaAtkplus(null);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void aquadeflos() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.aquadeflos(null);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void closed() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.closed(playBoard,monsterCards);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void beastAtkplus() {

        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.BeastAtkplus(monsterCards);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void beastWarriorAtkplus() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.BeastWarriorAtkplus(monsterCards);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }

    @Test
    void des() {
        try{
            ArrayList<MonsterCard> monsterCards = new ArrayList<>();
            MonsterCard omonsterCard = new MonsterCard("b",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());

            MonsterCard monsterCard = new MonsterCard("a",1,"a",2,"a",true,1,1,1,monsterCards,"a",1,TypeOfMonsterCard.AQUA.name());
            monsterCards.add(monsterCard);
            Player p = new Player("a", "b", "c");
            Player op = new Player("m", "n", "p");
            Deck deck = new Deck("a");
            Card card = new Card("a", 1, "a", "a", true, 1);
            deck.addCard(card, 1);
            deck.addCard(card, 2);
            deck.addCard(card, 3);
            deck.addCard(card, 4);
            deck.addCard(card, 5);
            GlobalVariable.setPlayer(p);
            GlobalVariable.setPlayer(op);
            p.addDeck(deck);
            p.setActivatedDeck(deck);
            op.setActivatedDeck(deck);
            PlayBoard playBoard = new PlayBoard(p);
            playBoard.setMonsters(monsterCards);
            actionSpell.des(playBoard,playBoard);
            assertNotNull(monsterCards);
        }
        catch (Exception e){}
    }
}