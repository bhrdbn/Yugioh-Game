package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import com.yugioh.Paths;
import com.yugioh.PlayerInfo;
import com.yugioh.Settings;
import com.yugioh.YugiohDuel;
import com.yugioh.model.BoardController;
import com.yugioh.model.GameInfo;
import com.yugioh.model.HasCardController;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.*;
import javafx.scene.control.TableColumn.CellDataFeatures;



public class MainController implements Initializable {
    private static HasCardController rootController;

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
    public void handleEventsNewDual(javafx.scene.input.MouseEvent event) throws IOException {
        YugiohDuel yugiohDuel = new YugiohDuel();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        yugiohDuel.start(stage);
//        Node node = (Node) event.getSource();
//        Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
//        FXMLLoader rootLoader = FXMLLoader.load(getClass().getResource("/com/yugioh/fxml/Board.fxml"));
////        FXMLLoader rootLoader = new FXMLLoader(getClass().getResource(Paths.appFXML));
//        Parent root = rootLoader.load();
//        Scene scene = new Scene(root, Settings.screenWidth, Settings.screenHeight);
//        scene.getStylesheets().add(getClass().getResource(Paths.boardCSS).toExternalForm());
//        stage.setScene(scene);
//        stage.setTitle(Settings.titleName);
//        stage.setResizable(false);
//        stage.show();
//        rootController = rootLoader.getController();
//        BoardController boardController = (BoardController) rootController;
//        GameInfo.addPlayer(1, new PlayerInfo(Settings.player1Name, Settings.player1Color));
//        GameInfo.addPlayer(2, new PlayerInfo(Settings.player2Name, Settings.player2Color));
//        boardController.init();
//        ((BoardController) rootController).startGame();
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
}
