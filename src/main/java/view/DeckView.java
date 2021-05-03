package view;

import java.util.regex.Matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.*;

public class DeckView {

    DeckController deckController = new DeckController();

    public void run(String input) {
        while (true) {
            Matcher matcher = getCommand(input, "deck create (\\w+)");
            Matcher matcher1 = getCommand(input, "deck delete (\\w+)");
            Matcher matcher2 = getCommand(input, "deck set-activate (\\w+)");
            Matcher matcher3= getCommand(input, "deck add-card card (\\w+) deck (\\w+)");
            Matcher matcher3_1= getCommand(input, "deck add-card deck (\\w+) card (\\w+)");
            Matcher matcher4=getCommand(input, "deck add-card deck (\\w+) card (\\w+) side");
            Matcher matcher4_1=getCommand(input, "deck add-card card (\\w+) deck (\\w+) side");
            Matcher matcher4_2=getCommand(input, "deck add-card side deck (\\w+) card (\\w+)");
            Matcher matcher4_3=getCommand(input, "deck add-card side card (\\w+) deck (\\w+) side");






            if (matcher.find()) createDeck(matcher);
            if (matcher1.find()) deleteDeck(matcher1);
            if (matcher2.find()) activateDeck(matcher2);
            if (matcher3.find()) addCardToDeck(matcher3,0);
            if(matcher3_1.find()) addCardToDeck(matcher3_1,1);
            if(matcher4.find())   addCardToDeck(matcher4,2);
            if(matcher4_1.find())   addCardToDeck(matcher4_1,3);
            if(matcher4_2.find())   addCardToDeck(matcher4_2,4);
            if(matcher4_3.find())   addCardToDeck(matcher4_3,5);



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

    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

}
