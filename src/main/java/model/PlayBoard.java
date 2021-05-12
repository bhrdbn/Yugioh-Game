package model;

import java.util.ArrayList;
import java.util.List;

public class PlayBoard {
    private Player player;
    private ArrayList<MonsterCard> changedPositionCards=new ArrayList<>();
    private ArrayList<MonsterCard> attackerCards=new ArrayList<>();
    private ArrayList<SpellCard> activatedSpellCards=new ArrayList<>();
    private List<MonsterCard> summonCards=new ArrayList<>();
    private ArrayList<Card> graveyard=new ArrayList<>();
    private SpellCard fields;
    private Deck deck ;

    private ArrayList<Card> monsters;
    private ArrayList<Card> SpellTrap;
    private ArrayList<Card> hand;
    public PlayBoard(Player player){
        deck =new Deck(player.getActivatedDeck().getName());
        setDeck(player);
    }

    public List<MonsterCard> getChangedPositionCards() {
        return changedPositionCards;
    }

    public void setChangedPositionCards(ArrayList<MonsterCard> changedPositionCards) {
        this.changedPositionCards = changedPositionCards;
    }

    public List<MonsterCard> getAttackerCards() {
        return attackerCards;
    }

    public void setAttackerCards(ArrayList<MonsterCard> attackerCards) {
        this.attackerCards = attackerCards;
    }

    public List<SpellCard> getActivatedSpellCards() {
        return activatedSpellCards;
    }

    public void setActivatedSpellCards(ArrayList<SpellCard> activatedSpellCards) {
        this.activatedSpellCards = activatedSpellCards;
    }

    public List<MonsterCard> getSummonCards() {
        return summonCards;
    }

    public void setSummonCards(List<MonsterCard> summonCards) {
        this.summonCards = summonCards;
    }

    public List<Card> getGraveyards() {
        return graveyard;
    }

    public void setGraveyards(ArrayList<Card> graveyards) {
        this.graveyard = graveyards;
    }

    public List<SpellCard> getFields() {
        return fields;
    }

    public void setFields(ArrayList<SpellCard> fields) {
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

    public void setMonsters(ArrayList<Card> monsters) {
        this.monsters = monsters;
    }

    public List<Card> getSpellTrap() {
        return SpellTrap;
    }

    public void setSpellTrap(ArrayList<Card> spellTrap) {
        SpellTrap = spellTrap;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public String graveToString(){
        StringBuilder grave= new StringBuilder();
        for(Card card:graveyard){
            grave.append(card).append("\n");
        }
        return grave.toString();
    }

    public Player getPlayer() {
        return player;
    }

    public String toString(int number) {
        String playBoard="";
        if(fields==null){
            playBoard+="E";
        }
        else playBoard+="O";
        playBoard+="\t\t\t\t\t\t";
        playBoard+=graveyard.size()+"\n";
        for(Card card:hand){
            playBoard+="c\t";
        }
        return playBoard;
    }
}
