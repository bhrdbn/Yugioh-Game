package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.*;
import javafx.scene.control.TableColumn.CellDataFeatures;



public class MainController implements Initializable {
    

    @FXML
    public TableView tblData;
    public ObservableList<ObservableList> data;

    @FXML
    public void handleEventsLogout(javafx.scene.input.MouseEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @FXML
    public void handleEventsDeck(javafx.scene.input.MouseEvent event){
        try {
            Node node = (Node) event.getSource();
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
    @FXML
    public void handleEventsNewDuel(javafx.scene.input.MouseEvent event){
        try {
            DuelController.getInstance().newDuel(1,"b","a");
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/Board.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
     //  TextInputDialog textInputDialog = new TextInputDialog("");
     //  textInputDialog.setHeaderText("enter AI duel = 0 or the second player username");
     //  textInputDialog.showAndWait();
     //  String duelStatus = textInputDialog.getEditor().getText();
     //  if(duelStatus.equals("0")){
     //      TextInputDialog textInputDialog1 = new TextInputDialog("");
     //      textInputDialog1.setHeaderText("enter number of rounds");
     //      textInputDialog1.showAndWait();
     //      int rounds = Integer.parseInt(textInputDialog1.getEditor().getText());
     //      DuelController.getInstance().newDuelAI(rounds, GlobalVariable.getPlayer().getUsername());
     //  }
     //  else{
     //      TextInputDialog textInputDialog1 = new TextInputDialog("");
     //      textInputDialog1.setHeaderText("enter number of rounds");
     //      textInputDialog1.showAndWait();
     //      int rounds = Integer.parseInt(textInputDialog1.getEditor().getText());
     //      String secondPlayer = textInputDialog.getEditor().getText();
     //      DuelController.getInstance().newDuel(rounds, secondPlayer, GlobalVariable.getPlayer().getUsername());

     //  }
    }
    @FXML
    public void handleEventsShop(javafx.scene.input.MouseEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/Shop.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @FXML
    public void handleEventsProfile(javafx.scene.input.MouseEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/Profile.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }



    public void fetColumnList() {
        List<String> columnList = new ArrayList<>();
        columnList.add("nickName");
        columnList.add("score");
        for (int i = 0; i < 1; i++) {
            final int j = i;
            TableColumn col = new TableColumn(columnList.get(i + 1).toUpperCase());
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }
            });
            tblData.getColumns().removeAll(col);
            tblData.getColumns().addAll(col);

            System.out.println("Column [" + i + "] ");
        }
    }

    public void fetRowList() {
        data = FXCollections.observableArrayList();
        try {
            List<Player> players = scoreboard();
            for (Player player: players) {
                ObservableList row = FXCollections.observableArrayList();
                row.add(player.getNickname());
                row.add(player.getScore());
                System.out.println("Row [1] added " + row);
                data.add(row);
            }
            tblData.setItems(data);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    // TODO: 7/8/2021 check singleton pattern in constructor
    public static MainController mainController = null;
    public MainController(){

    }
    public static MainController getInstance()
    {
        if (mainController == null)
            mainController = new MainController();

        return mainController;
    }


    public static ArrayList<Player> scoreboard() {
        Comparator<Player> scoreComparator = Comparator.comparing(Player::getScore).reversed();
        Comparator<Player> alphabetComparator = Comparator.comparing(Player::getNickname);
        Comparator<Player> multiComparator = scoreComparator.thenComparing(alphabetComparator);
        ArrayList<Player> sortedAllPerson = (ArrayList<Player>) Player.getAllPlayers().stream().sorted(multiComparator).
                collect(Collectors.toList());
        return sortedAllPerson;
    }

    public String logoutUser() {
        return "user logged out successfully!";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fetColumnList();
        fetRowList();
    }

    @FXML
    public void handleEventsSerialize(javafx.scene.input.MouseEvent event){

        ImprotExport tester = new ImprotExport();
        try {
            TextInputDialog textInputDialog = new TextInputDialog("");
            textInputDialog.setHeaderText("Enter your card name");
            textInputDialog.showAndWait();
            String name = textInputDialog.getEditor().getText();
            textInputDialog.setHeaderText("Enter your card type");
            textInputDialog.showAndWait();
            String type = textInputDialog.getEditor().getText();
            textInputDialog.setHeaderText("Enter your card describe");
            textInputDialog.showAndWait();
            String describe = textInputDialog.getEditor().getText();
            textInputDialog.setHeaderText("Enter your defence");
            textInputDialog.showAndWait();
            int deffence = Integer.parseInt(textInputDialog.getEditor().getText());
            textInputDialog.setHeaderText("Enter your attack");
            textInputDialog.showAndWait();
            int attack = Integer.parseInt(textInputDialog.getEditor().getText());
            textInputDialog.setHeaderText("Enter your attribute");
            textInputDialog.showAndWait();
            String attribute = textInputDialog.getEditor().getText();
            MonsterCard cards = new MonsterCard(name,1,type,1,describe,true,0,attack,deffence,null,attribute,1,type);
            cards.setName(name);
            cards.setCardDescription(describe);
            cards.setSide(true);
            cards.setPrice(0);
            cards.setType(type);
            tester.writeJSON(cards);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Successfully imported and exported!!!");
            alert.show();

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
