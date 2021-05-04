package model;

import java.util.List;

public class PlayBoard {
    private List<MonsterCard> changedPositionCards;
    private List<MonsterCard> attackerCards;
    private List<SpellCard> activatedSpellCards;
    private List<MonsterCard> summonCards;
    private List<Card> graveyards;
    private List<SpellCard> fields;
    private Deck deck;
    private List<Card> monsters;
    private List<Card> SpellTrap;
    private List<List<Card>> hand;

    public List<MonsterCard> getChangedPositionCards() {
        return changedPositionCards;
    }

    public void setChangedPositionCards(List<MonsterCard> changedPositionCards) {
        this.changedPositionCards = changedPositionCards;
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

    public void setDeck(Deck deck) {
        this.deck = deck;
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
