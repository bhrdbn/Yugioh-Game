package model;

import java.util.ArrayList;
import java.util.List;

public class PlayBoard {
    private Player player;
    private ArrayList<MonsterCard> changedPositionCards=new ArrayList<>();
    private ArrayList<MonsterCard> attackerCards=new ArrayList<>();
    private ArrayList<SpellCard> activatedSpellCards=new ArrayList<>();
    private List<MonsterCard> summonCards=new ArrayList<>();
    private ArrayList<Card> graveyards=new ArrayList<>();
    private ArrayList<SpellCard> fields=new ArrayList<>() ;
    private Deck deck ;

    private List<Card> monsters;
    private List<Card> SpellTrap;
    private List<List<Card>> hand;
    public PlayBoard(Player player){
        deck =new Deck(player.getActivatedDeck().getName());
        setDeck(player);
    }

    public List<MonsterCard> getChangedPositionCards() {
        return changedPositionCards;
    }

    public void setChangedPositionCards(List<MonsterCard> changedPositionCards) {
        this.changedPositionCards = (ArrayList<MonsterCard>) changedPositionCards;
    }


    public List<MonsterCard> getAttackerCards() {
        return attackerCards;
    }

    public void setAttackerCards(List<MonsterCard> attackerCards) {
        this.attackerCards = attackerCards;
    }

    public List<SpellCard> getActivatedSpellCards() {
        return activatedSpellCards;
    }

    public void setActivatedSpellCards(List<SpellCard> activatedSpellCards) {
        this.activatedSpellCards = activatedSpellCards;
    }

    public List<MonsterCard> getSummonCards() {
        return summonCards;
    }

    public void setSummonCards(List<MonsterCard> summonCards) {
        this.summonCards = summonCards;
    }

    public List<Card> getGraveyards() {
        return graveyards;
    }

    public void setGraveyards(List<Card> graveyards) {
        this.graveyards = graveyards;
    }

    public List<SpellCard> getFields() {
        return fields;
    }

    public void setFields(List<SpellCard> fields) {
        this.fields = fields;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Player player) {
        for(Card card:player.getActivatedDeck().getMainDeck()){
            deck.addCard(card,1);
        }
        for(Card card:player.getActivatedDeck().getSideDeck()){
            deck.addCard(card,0);
        }
    }

    public List<Card> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Card> monsters) {
        this.monsters = monsters;
    }

    public List<Card> getSpellTrap() {
        return SpellTrap;
    }

    public void setSpellTrap(List<Card> spellTrap) {
        SpellTrap = spellTrap;
    }

    public List<List<Card>> getHand() {
        return hand;
    }

    public void setHand(List<List<Card>> hand) {
        this.hand = hand;
    }
}
