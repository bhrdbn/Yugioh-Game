package Graphic.view;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import controller.*;
import view.Main;

public class DeckView  {
    private static DeckView deckView=null;
    private DeckView(){

    }
    public static DeckView getInstance()
    {
        if (deckView == null)
            deckView = new DeckView();

        return deckView;
    }



    DeckController deckController = DeckController.getInstance();

    public void run() {
        while (true) {
            String input= Main.scanner.nextLine();
            Matcher matcher = getCommand(input, "deck create (\\w+)");
            Matcher matcher1 = getCommand(input, "deck delete (\\w+)");
            Matcher matcher2 = getCommand(input, "^deck set-activate (\\w+)$");
            Matcher matcher3= getCommand(input, "^deck add-card card (\\w+) deck (\\w+)$");
            Matcher matcher3_1= getCommand(input, "^deck add-card deck (\\w+) card (\\w+)$");
            Matcher matcher4=getCommand(input, "deck add-card deck (\\w+) card (\\w+) side");
            Matcher matcher4_1=getCommand(input, "deck add-card card (\\w+) deck (\\w+) side");
            Matcher matcher4_2=getCommand(input, "deck add-card side deck (\\w+) card (\\w+)");
            Matcher matcher4_3=getCommand(input, "deck add-card side card (\\w+) deck (\\w+)");
            Matcher matcher5=getCommand(input,"deck rm-card card (\\w+) deck (\\w+)");
            Matcher matcher5_1=getCommand(input,"deck rm-card deck (\\w+) card (\\w+)");
            Matcher matcher6=getCommand(input,"deck rm-card deck (\\w+) card (\\w+) side");
            Matcher matcher6_1=getCommand(input,"deck rm-card card (\\w+) deck (\\w+) side");
            Matcher matcher6_2=getCommand(input,"deck rm-card side deck (\\w+) card (\\w+)");
            Matcher matcher6_3=getCommand(input,"deck rm-card side card (\\w+) deck (\\w+)");
            Matcher matcher7= getCommand(input, "deck show all");
            Matcher matcher8=getCommand(input, "^deck show deck-name (\\w+)$");
            Matcher matcher9=getCommand(input, "deck show deck-name (\\w+) side");
            Matcher matcher10=getCommand(input, "deck show side(Opt) deck-name (\\w+)");
            Matcher matcher11=getCommand(input, "deck show cards");
            Matcher matcher12=getCommand(input, "exit");

            if (matcher.find()) createDeck(matcher);
            else if (matcher1.find()) deleteDeck(matcher1);
            else if (matcher2.find()) activateDeck(matcher2);
            else if (matcher3.find()) addCardToDeck(matcher3,0);
            else if(matcher3_1.find()) addCardToDeck(matcher3_1,1);
            else if(matcher4.find())   addCardToDeck(matcher4,2);
            else if(matcher4_1.find())   addCardToDeck(matcher4_1,3);
            else if(matcher4_2.find())   addCardToDeck(matcher4_2,4);
            else if(matcher4_3.find())   addCardToDeck(matcher4_3,5);
            else if (matcher5.find()) removeCardFromDeck(matcher5,0);
            else if(matcher5_1.find()) removeCardFromDeck(matcher5_1,1);
            else if(matcher6.find())   removeCardFromDeck(matcher6,2);
            else if(matcher6_1.find())   removeCardFromDeck(matcher6_1,3);
            else if(matcher6_2.find())   removeCardFromDeck(matcher6_2,4);
            else if(matcher6_3.find())   removeCardFromDeck(matcher6_3,5);
            else if(matcher7.find()) showAllDecks();
            else if(matcher8.find()) showADeck(1,matcher8);
            else if(matcher9.find()) showADeck(2,matcher9);
            else if(matcher10.find()) showADeck(3,matcher10);
            else if(matcher11.find())  showAllCards();
            else if(matcher12.find())  MenuHandler.runBack(Menu.DECK);
            else System.out.println("invalid command");



        }
    }

    public void createDeck(Matcher matcher) {
        System.out.println(deckController.createDeck(matcher.group(1)));
    }
    public void deleteDeck(Matcher matcher) {
        System.out.println(deckController.deleteDeck(matcher.group(1)));
    }
    public void activateDeck(Matcher matcher){
        System.out.println(deckController.activateDeck(matcher.group(1)));
    }
    public void addCardToDeck(Matcher matcher,int flag){
        if(flag==0)
            System.out.println(deckController.addCardToDeck(matcher.group(2), matcher.group(1), 1));
        else if(flag==1)
            System.out.println(deckController.addCardToDeck(matcher.group(1), matcher.group(2), 1));
        else if(flag==2||flag==4)
            System.out.println(deckController.addCardToDeck(matcher.group(1), matcher.group(2), 0));
        else if(flag==3||flag==5)
            System.out.println(deckController.addCardToDeck(matcher.group(2), matcher.group(1), 0));
    }
    public void removeCardFromDeck(Matcher matcher,int flag){
        if(flag==0)
            System.out.println(deckController.removeCardFromDeck(matcher.group(2), matcher.group(1), 1));
        else if(flag==1)
            System.out.println(deckController.removeCardFromDeck(matcher.group(1), matcher.group(2), 1));
        else if(flag==2||flag==4)
            System.out.println(deckController.removeCardFromDeck(matcher.group(1), matcher.group(2), 0));
        else if(flag==3||flag==5)
            System.out.println(deckController.removeCardFromDeck(matcher.group(2), matcher.group(1), 0));
    }
    public void showAllDecks(){
        System.out.println(deckController.showDecks());
    }
    public void showADeck(int flag , Matcher matcher){
        if(flag==1) {
            System.out.println(deckController.showADeck(matcher.group(1), 1));
        }
        else {
            System.out.println(deckController.showADeck(matcher.group(1),0));
        }

    }
    public void showAllCards(){
        System.out.println(deckController.showAllCards());
    }

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }




}
