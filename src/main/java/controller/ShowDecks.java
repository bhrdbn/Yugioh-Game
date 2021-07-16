package controller;

import controller.GlobalVariable;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import model.Deck;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ShowDecks implements Initializable {
    @FXML
    public GridPane decks;
    public Pane all;

    //    @FXML
//    Button removeButton;
//    @FXML
//    javafx.scene.shape.Rectangle details;
//    @FXML
//    Label deckName;
//    @FXML
//    Label cardNumber;
//    @FXML
//    Label activationState;
    @FXML
    public static void show()
    {
        Comparator<Deck> alphabetComparator = Comparator.comparing(Deck::getName);
        ArrayList<Deck> sortedOtherDeck = (ArrayList<Deck>) GlobalVariable.getPlayer().getOtherDecks().stream().sorted(alphabetComparator).
                collect(Collectors.toList());
    }
    public void back(MouseEvent mouseEvent) {
        try {
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/sample.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void loadDecks(){
        int index=0;
        String activationStatus;
        a:
        for (int i=0;i<4;i++) for(int j=0;j<5;j++){
            if(index>=GlobalVariable.getPlayer().getDecks().size()) break a;
            javafx.scene.shape.Rectangle rectangle=new javafx.scene.shape.Rectangle();
            rectangle.setHeight(110);
            rectangle.setWidth(396);
            if(GlobalVariable.getPlayer().getActivatedDeck()!=null&&GlobalVariable.getPlayer().getActivatedDeck().getName().equals(GlobalVariable.getPlayer().getDecks().get(index).getName()))
                activationStatus = "activated deck";
            else
                activationStatus = "non activated deck";
            ImagePattern background=new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Assets/Items/help05_02_02_01a.dds.png").toExternalForm()));
            Label label=new Label(GlobalVariable.getPlayer().getDecks().get(index).getName()+"\n"+
                    GlobalVariable.getPlayer().getDecks().get(index).countAll()+"\n"+activationStatus);
            // if(GlobalVariable.getPlayer().getActivatedDeck().getName().equals(deckName.getText()))
            // //activationState.setText("activated deck");
            // else
            //     activationState.setText("non activated deck");
            rectangle.setFill(background);
            Button button=new Button("remove deck");
            int finalIndex = index;
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(DeckController.getInstance().deleteDeck(GlobalVariable.getPlayer().getDecks().get(finalIndex).getName()));
                    alert.show();
                    loadDecks();

                }
            });
            Button button1=new Button("Edit Deck");
            button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    GlobalVariable.setDeckName(GlobalVariable.getPlayer().getDecks().get(finalIndex).getName());
                    Stage stage = (Stage) button1.getScene().getWindow();
                    Parent root ;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/ShowCardsInDeck.fxml"));
                        ShowCardsInDeck.show(GlobalVariable.getPlayer().getDecks().get(finalIndex).getName());
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            button.setLayoutX(446*(j+1)+30);
            button.setLayoutY(160*(i+1));
            button1.setLayoutX(446*(j+1)+30);
            button1.setLayoutY(160*(i+1)-40);
            label.setLayoutY(160*(i+1)+20);
            label.setLayoutX(446*(j+1));
            button. setStyle("-fx-background-color: purple; -fx-text-fill: yellow");
            button1. setStyle("-fx-background-color: purple; -fx-text-fill: yellow");
            all.getChildren().add(button);
            all.getChildren().add(label);
            all.getChildren().add(button1);
            decks.add(rectangle,j,i);
            index++;

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDecks();
    }
}
