package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayBoard {
    private Player player;
    private ArrayList<MonsterCard> changedPositionCards=new ArrayList<>();
    private ArrayList<MonsterCard> attackerCards=new ArrayList<>();
    private ArrayList<SpellCard> activatedSpellCards=new ArrayList<>();
    private List<MonsterCard> summonCards=new ArrayList<>();
    private boolean isCardSummonedOrSet;
    private boolean isCardAttacked;
    private boolean isPositionChanged;
    private boolean isCardActivated;
    private ArrayList<Card> graveyard=new ArrayList<>();
    private SpellCard fields;
    private Deck deck; ;
    private int lifePoint;

    private ArrayList<MonsterCard> monsters=new ArrayList<>();
    private ArrayList<SpellCard> SpellTrap=new ArrayList<>();
    private ArrayList<Card> hand=new ArrayList<>();
    private Card selectedCard;
    private SpellCard selectedSpellCard;
    private MonsterCard selectedMonsterCard;
    private Card selectedOpponentCard;
    public PlayBoard(Player player){
        deck =new Deck(player.getActivatedDeck().getName());
        setDeck(player);
        lifePoint=8000;
        setPlayer(player);
        for (int i=0;i<5;i++) {
            monsters.add( new MonsterCard("nokhodi",1,"a","dd",true,12345,0,0,null,"aa",1,"ww"));
            SpellTrap.add(new SpellCard("s","nokhodi",1,"t","t",true,1,"d"));
        }
        for(int i=0;i<4;i++){
            hand.add(deck.getMainDeck().get(0));
            deck.getMainDeck().remove(0);
        }
    }

    public void setSelectedOpponentCard(Card selectedOpponentCard) {
        this.selectedOpponentCard = selectedOpponentCard;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public Card getSelectedOpponentCard() {
        return selectedOpponentCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public void setSelectedSpellCard(SpellCard selectedSpellCard){
        this.selectedSpellCard = selectedSpellCard;
    }

    public void setSelectedMonsterCard(MonsterCard selectedMonsterCard){
        this.selectedMonsterCard = selectedMonsterCard;
    }

    public SpellCard getSelectedSpellCard(){
        return selectedSpellCard;
    }

    public MonsterCard getSelectedMonsterCard(){
        return selectedMonsterCard;
    }

    public boolean isCardSummonedOrSet() {
        return isCardSummonedOrSet;
    }

    public boolean isCardAttacked(){
        return isCardAttacked;
    }

    public boolean isCardActivated(){
        return isCardActivated;
    }

    public void setCardSummonedOrSet(boolean cardSummonedOrSet) {
        isCardSummonedOrSet = cardSummonedOrSet;
    }

    public void setCardAttacked(boolean cardAttacked){
        isCardAttacked = cardAttacked;
    }

    public void setPositionChanged(boolean positionChanged){
        isPositionChanged = positionChanged;
    }

    public void setCardActivated(boolean activated){
        isCardActivated = activated;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public MonsterCard selectMonster(int number)
    {

        return (MonsterCard) getMonsters().get(number-1);

    }

    public Card selectSpellOrTrap(int number)
    {
        return  getSpellTrap().get(number-1);

    }


    public Card selectFromHand(int number)
    {
        return getHand().get(number-1);


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

    public SpellCard getFields() {
        return fields;
    }

    public void setFields(SpellCard fields) {
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

    public ArrayList<MonsterCard> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<MonsterCard> monsters) {
        this.monsters = monsters;
    }

    public List<SpellCard> getSpellTrap() {
        return SpellTrap;
    }

    public void setSpellTrap(ArrayList<SpellCard> spellTrap) {
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
    public boolean isDeckFinished(){
        return deck.getMainDeck().size()==0;
    }
    public String monster(int number){
        if(monsters.get(number)==null) return "\tE";
        else if(monsters.get(number).isAttack()){
            return "\tOO";
        }
        else if(monsters.get(number).isSide()) return "\tDO";
        else return "\tDH";
    }
    public String spell(int number){
        if(SpellTrap.get(number)==null) return "\tE";
        else if(SpellTrap.get(number).isSide()){
            return "\tO";
        }
        else return "\tH";
    }
    @Override
    public String toString() {
        StringBuilder playBoard= new StringBuilder();
        if(fields==null){
            playBoard.append("E");
        }
        else playBoard.append("O");
        playBoard.append("\t\t\t\t\t\t");
        playBoard.append(graveyard.size()).append("\n");
        for (int i : new int[]{5, 3, 1, 2, 4}) {
            playBoard.append(monster(i));
        }
        playBoard.append("\n");
        for (int i : new int[]{5, 3, 1, 2, 4}) {
            playBoard.append(spell(i));
        }
        playBoard.append("\n");
        playBoard.append("\t\t\t\t\t\t");
        playBoard.append(deck.getMainDeck().size()).append("\n");


        for(Card card:hand){
            playBoard.append("C\t");
        }
        playBoard.append("\n");
        playBoard.append(player.getNickname()).append(":");
        playBoard.append(lifePoint);

        return playBoard.toString();
    }
    public String rotateToString(){
        StringBuilder playBoard= new StringBuilder();
        playBoard.append(player.getNickname()).append(":");
        playBoard.append(lifePoint);
        for(Card card:hand){
            playBoard.append("\tC");
        }
        playBoard.append(deck.getMainDeck().size()).append("\n");
        for (int i : new int[]{4, 2, 1, 3, 5}) {
            playBoard.append(spell(i));
        }
        for (int i : new int[]{4, 2, 1, 3, 5}) {
            playBoard.append(monster(i));
        }
        playBoard.append("\n");
        playBoard.append(graveyard.size()).append("\n");
        playBoard.append("\t\t\t\t\t\t");
        if(fields==null){
            playBoard.append("E");
        }
        else playBoard.append("O");
        return playBoard.toString();
    }

    public void decreaseLifePoint(int damage) {
        lifePoint -= damage;
    }

    public boolean isPositionChanged() {
        return isPositionChanged;
    }
}
