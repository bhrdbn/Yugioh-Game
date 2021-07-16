package controller;
import javafx.scene.Node;
import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DeckController implements Initializable {
    public static DeckController deckController=null;
    @FXML
    private Button btn1,btn5;

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {


      if(event.getSource()==btn1){
             Stage stage = (Stage) btn1.getScene().getWindow();
           Parent root = FXMLLoader.load(getClass().getResource("/view/ShowDecks.fxml"));
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
        }

    }
    public static DeckController getInstance() {
        if (deckController == null)
            deckController = new DeckController();

        return deckController;
    }
    @FXML
    public void actionActivatedDeck() {
            TextInputDialog textInputDialog = new TextInputDialog("");
            textInputDialog.setHeaderText("Enter your deck name");
            textInputDialog.showAndWait();
            String newDeckName = textInputDialog.getEditor().getText();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(activateDeck(newDeckName));
            alert.show();
    }
    @FXML
    public void actionAddDeck() {

        TextInputDialog textInputDialog = new TextInputDialog("");
        textInputDialog.setHeaderText("Enter your deck name");
        textInputDialog.showAndWait();
        String newDeckName = textInputDialog.getEditor().getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(createDeck(newDeckName));
        alert.show();
        String a="";
        int i;
        while(!a.equals("1")){
            textInputDialog.setHeaderText("Enter your cardnames to add to deck to stop press 1");
            textInputDialog.showAndWait();
            a = textInputDialog.getEditor().getText();
            textInputDialog.setHeaderText("enter 1 for main or 0 for side");
            textInputDialog.showAndWait();
            i =Integer.parseInt( textInputDialog.getEditor().getText());
            alert.setTitle( addCardToDeck(newDeckName,a,i));
            alert.show();}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public String createDeck(String deckName){
        if(GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName)) return "deck with name "+ deckName +" already exists";
        else {
            Deck deck= new Deck(deckName);
            GlobalVariable.getPlayer().addDeck(deck);
            return "deck created successfully!";
        }
    }
    public String deleteDeck(String deckName){
        if(!GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName)) return "deck with name "+deckName+" does not exist";
        else {
            GlobalVariable.getPlayer().removeDeck(GlobalVariable.getPlayer().getDeckByName(deckName));
            return "deck deleted successfully";
        }
    }
    public String activateDeck(String deckName){
        if(!GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName)) return "deck with name "+deckName+" does not exist";
        else{
            GlobalVariable.getPlayer().setActivatedDeck(GlobalVariable.getPlayer().getDeckByName(deckName));
            return "deck activated successfully";
        }
    }
    public String addCardToDeck(String deckName,String cardName,int position){

        if (!GlobalVariable.getPlayer().doesHaveCardWithName(cardName)) return "card with name " + cardName + " does not exist";
        else if (!GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if(position==1&&GlobalVariable.getPlayer().getDeckByName(deckName).isMainFull()) {

            return "main deck is full";
        }
        else if(position==0&&GlobalVariable.getPlayer().getDeckByName(deckName).isSideFull()) {

            return "side deck is full";
        }
        else if (GlobalVariable.getPlayer().getDeckByName(deckName).countACardInDeck
                (GlobalVariable.getPlayer().getCardByName(cardName)) == 3) {
            return "there are already three cards with name " + cardName + " in deck " + deckName;
        } else {
            GlobalVariable.getPlayer().getDeckByName(deckName).addCard(GlobalVariable.getPlayer().getCardByName(cardName), position);
            GlobalVariable.getPlayer().getDeckByName(deckName).setIsValid();
            return "card added to deck successfully";
        }

    }
    public String removeCardFromDeck(String deckName,String cardName,int position){
         if (!GlobalVariable.getPlayer().doesHaveDeckWithThisName(deckName))
            return "deck with name " + deckName + " does not exist";
        else if (!GlobalVariable.getPlayer().getDeckByName(deckName).doesHaveCard(cardName,position))
            return "card with name " + cardName + " does not exist";

         else {
             GlobalVariable.getPlayer().getDeckByName(deckName).removeCard(GlobalVariable.getPlayer().getCardByName(cardName), position);
             GlobalVariable.getPlayer().getDeckByName(deckName).setIsValid();
            return "card removed from deck successfully";
        }

    }
    public String showDecks() {
        StringBuilder otherDecks= new StringBuilder("");
        Comparator<Deck> alphabetComparator = Comparator.comparing(Deck::getName);
        ArrayList<Deck> sortedOtherDeck = (ArrayList<Deck>) GlobalVariable.getPlayer().getOtherDecks().stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for(Deck deck:sortedOtherDeck){
            otherDecks.append(deck.toString()).append("\n");
        }
        return "Decks:\n" +
                "Active deck:\n" +
                GlobalVariable.getPlayer().getActivatedDeck()+"\n" +
                "Other decks:\n" +
                otherDecks;
    }
    public String showADeck(String deckName,int position) {
        StringBuilder monsterDeck= new StringBuilder("");
        StringBuilder trapAndSpellDeck= new StringBuilder("");
        String sideOrMain;
        if(position==1)sideOrMain="Main";
        else sideOrMain="Side";
        Comparator<Card> alphabetComparator = Comparator.comparing(Card::getName);
        ArrayList<Card> sortedMonsterCards = (ArrayList<Card>) GlobalVariable.getPlayer().getDeckByName(deckName).getMonsters(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for(Card card:sortedMonsterCards){
            monsterDeck.append(card.toString()).append("\n");
        }
        ArrayList<Card> sortedTrapCards = (ArrayList<Card>) GlobalVariable.getPlayer().getDeckByName(deckName).getTrapOrSpell(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        for(Card card:sortedTrapCards){
            trapAndSpellDeck.append(card.toString()).append("\n");
        }
        return "Deck: "+deckName +" "+
                sideOrMain+" deck:\n" +
                "Monsters:\n" +monsterDeck+

                "Spell and Traps:\n" +
                trapAndSpellDeck;
    }
    public String showAllCards(){
        StringBuilder cards= new StringBuilder("");
        for(Card card:GlobalVariable.getPlayer().getCards()){
            cards.append(card.toString()).append("\n");
        }
        return cards.toString();
    }


    public void back(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/OnBoard.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}


