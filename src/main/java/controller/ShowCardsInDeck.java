package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import model.Card;
import model.MonsterCard;
import model.SpellCard;
import model.TrapCard;
//import model.Deck;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ShowCardsInDeck implements Initializable {
    @FXML
    public GridPane decks;
    @FXML
    public static void show(String deckName)
    {
        TextInputDialog textInputDialog = new TextInputDialog("");
        textInputDialog.setHeaderText("enter Main = 1 or side = 0 deck");
        textInputDialog.showAndWait();
        int position = Integer.parseInt(textInputDialog.getEditor().getText());

        Comparator<Card> alphabetComparator = Comparator.comparing(Card::getName);
        ArrayList<Card> sortedMonsterCards = (ArrayList<Card>) GlobalVariable.getPlayer().getDeckByName(deckName).getMonsters(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
        ArrayList<Card> sortedTrapCards = (ArrayList<Card>) GlobalVariable.getPlayer().getDeckByName(deckName).getTrapOrSpell(position).stream().sorted(alphabetComparator).
                collect(Collectors.toList());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       loadCards();
    }
    public void loadCards(){
        int index=0;
        ImagePattern background;
        a:
        for (int i=0;i<4;i++) for(int j=0;j<15;j++) {
            if (index >= GlobalVariable.getPlayer().getDeckByName(GlobalVariable.getDeckName()).getMainDeck().size())
                break a;
            javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle();
            rectangle.setHeight(178);
            rectangle.setWidth(103);
            if(GlobalVariable.getPlayer().getDeckByName(GlobalVariable.getDeckName() ).getMainDeck().get(index) instanceof MonsterCard) {
                if(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/" +
                        GlobalVariable.getPlayer().getDeckByName(GlobalVariable.getDeckName()).getMainDeck().get(index).getName() + ".jpg")!=null)
                 background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/" + GlobalVariable.getPlayer().getDeckByName(GlobalVariable.getDeckName()).getMainDeck().get(index).getName() + ".jpg").toExternalForm()));
                else
                   background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/own.jpg" ).toExternalForm()));


                rectangle.setFill(background);
            }
            else if(GlobalVariable.getPlayer().getDeckByName(GlobalVariable.getDeckName() ).getMainDeck().get(index) instanceof SpellCard ||
                    GlobalVariable.getPlayer().getDeckByName(GlobalVariable.getDeckName() ).getMainDeck().get(index) instanceof TrapCard){
                 background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/" + GlobalVariable.getPlayer().getDeckByName(GlobalVariable.getDeckName()).getMainDeck().get(index).getName() + ".jpg").toExternalForm()));
                rectangle.setFill(background);
            }
            decks.add(rectangle, j, i);
            index++;
        }
    }
    public void back(MouseEvent mouseEvent) {
        try {
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/ShowDecks.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void remove() {
        TextInputDialog textInputDialog = new TextInputDialog("");
        TextInputDialog textInputDialog2 = new TextInputDialog("");
        textInputDialog2.setHeaderText("Main = 1 or side = 0 deck");
        textInputDialog2.showAndWait();
        int position = Integer.parseInt(textInputDialog2.getEditor().getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String cardName="";
        while(!cardName.equals("1")){
            textInputDialog.setHeaderText("Enter your cardnames to remove to deck to stop press 1");
            textInputDialog.showAndWait();
            cardName = textInputDialog.getEditor().getText();
            alert.setHeaderText(DeckController.getInstance().removeCardFromDeck(GlobalVariable.getDeckName(),cardName,position));
            alert.show();
            loadCards();
        }

    }

    public void add() {
        TextInputDialog textInputDialog = new TextInputDialog("");
        TextInputDialog textInputDialog2 = new TextInputDialog("");
        textInputDialog2.setHeaderText("Main = 1 or side = 0 deck");
        textInputDialog2.showAndWait();
        int position = Integer.parseInt(textInputDialog2.getEditor().getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String newCardName="";
        while(!newCardName.equals("1")){
            textInputDialog.setHeaderText("Enter your cardnames to add to deck to stop press 1");
            textInputDialog.showAndWait();
            newCardName = textInputDialog.getEditor().getText();
            alert.setHeaderText(DeckController.getInstance().addCardToDeck(GlobalVariable.getDeckName(),newCardName,position));
            alert.show();
            loadCards();
        }
    }
}