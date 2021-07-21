package model;

import clientview.MainClient;

import java.util.ArrayList;

public class GraveYard {
    private static ArrayList<Card> lostCards = new ArrayList<>();
    //private static ArrayList<Monster> monsters = new ArrayList<>();
    private static ArrayList<SpellCard> spells = new ArrayList<>();
    private static ArrayList<TrapCard> traps = new ArrayList<>();
    private boolean activeGraveYard=true;

    public ArrayList<Card> getLostCards() {
        return lostCards;
    }

    public void setLostCards(ArrayList<Card> lostCards) {
        this.lostCards = lostCards;
    }

    public boolean isActiveGraveYard() {
        return activeGraveYard;
    }

    public void setActiveGraveYard(boolean activeGraveYard) {
        this.activeGraveYard = activeGraveYard;
    }

   /* public static boolean CardinGraveYard(Card card){
        if (Playboard.getGraveYard().getCardsDeletedFromHand().contains(card)){
            return true;
        }
        return false;
    }*/

    /*
    public void showCards(){
        System.out.println("All cards in graveyard :");
        for(Card card : this.cards){
            card.show();
        }
        return;
    }
*/
    public void showMenu(){
        System.out.println("2. show cards");
        System.out.println("3. show menu");
        System.out.println("4. exit");
    }

    public void inputCommandLine(){
        System.out.println("Here is GraveYard");
        String inputLine = MainClient.scanner.nextLine();
        inputLine = inputLine.trim();
        inputLine = inputLine.toLowerCase();
        String[] input = inputLine.split("[ ]+");

        if(inputLine.equals("exit")){
            return;
        }
        else if(inputLine.equals("show cards")){
           // Card.show();
        } else if(inputLine.equals("show menu")){
            showMenu();
        }
        else
            System.out.println("Invalid Command !!!");
        inputCommandLine();;
    }

    public static void setCards(Card card){
        lostCards.add(card);
    }
    public static ArrayList<Card> getCards() {
        return lostCards;
    }

    public static ArrayList<SpellCard> getSpells() {
        return spells;
    }
    public static ArrayList<TrapCard> getTraps() {
        return traps;
    }

}


