package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.MonsterCard;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class CardCreator implements Initializable {
    public Label warn;
    public Label description;
    ObservableList<String> levelList= FXCollections.observableArrayList("1","2",
            "3","4","5","6","7","8","9","10");
    ObservableList<String> actionList= FXCollections.observableArrayList("0","1","2",
            "3","4","5","7","10","11");

    public ChoiceBox level;
    public TextField name;
    public TextField attack;
    public TextField defense;
    public ChoiceBox action;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        level.setItems(levelList);
        action.setItems(actionList);
        String des="";
        for (String s : actionList) {
            int number=Integer.parseInt(s);
            des+=s+". "+ShopController.getInstance().getDescriptionByAction(number)+"\n";
        }
        description.setText(des);
    }
    public void submit(){
        if(level.getValue()==null||attack.getText()==null ||
                defense.getText()==null||action.getValue()==null||name.getText()==null){
            warn.setText("fill the blanks");
        }

        else  {
            String name1=name.getText();
            int level1=Integer.parseInt((String) level.getValue());
            int attack1=Integer.parseInt( attack.getText());
            int defense1=Integer.parseInt( defense.getText());
            int action1=Integer.parseInt((String) action.getValue());
            int price= level1*100+attack1+defense1+action1*20;
            String des=ShopController.getInstance().getDescriptionByAction(action1);
            MonsterCard monsterCard=new MonsterCard(name1,1,"Normal",action1,des,false,price,attack1,defense1,null,null,level1,"Warrior");
            Import.getInstance().addCard(monsterCard);
            warn.setText("the price will be "+price);
        }
        warn.setVisible(true);
    }

    public void back(MouseEvent mouseEvent) {
            try {
                Node node = (Node) mouseEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("/view/shop.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
    }
}
