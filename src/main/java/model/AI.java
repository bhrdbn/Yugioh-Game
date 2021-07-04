package model;

import controller.ShopController;

import java.util.ArrayList;
import java.util.List;

public class AI extends Player {

    public AI(String nickname, String password, String username) {
        super(nickname, password, username);
        Deck deck=new Deck("AIDeck");
        for (MonsterCard card : ShopController.getInstance().getAllMonsters()) {
            if(card.getAction()==0)deck.getMainDeck().add(new MonsterCard(card));
        }
        setActivatedDeck(deck);
    }

    @Override
    public void setActivatedDeck(Deck deck) {
        this.activatedDeck=deck;
    }


}
