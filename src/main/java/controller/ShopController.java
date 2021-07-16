package controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.*;

public class ShopController implements Initializable {
    @FXML
    public GridPane cards;
    @FXML
    public Button buyBtn;
    @FXML
    public Rectangle detail;
    @FXML
    public Label cardPrice;
    @FXML
    public Label warn;


    private static ShopController shopController = null;
    private static MonsterCard monsterCard = null;
    private static SpellCard spellCard = null;
    private static TrapCard trapCard = null;

    ArrayList<SpellCard> allSpells = new ArrayList<>();
    ArrayList<TrapCard> allTraps = new ArrayList<>();

    public ShopController() {

        String json1 = null;
        try {
            json1 = new String(Files.readAllBytes(Paths.get("csvjsonspell.json")));
            allSpells = new Gson().fromJson(json1, new TypeToken<List<SpellCard>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json2 = null;
        try {
            json2 = new String(Files.readAllBytes(Paths.get("csvjsontrap.json")));
            allTraps = new Gson().fromJson(json2, new TypeToken<List<TrapCard>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        showAll();


    }




    public ArrayList<SpellCard> getAllSpells() {
        return allSpells;
    }

    public static ShopController getInstance() {
        if (shopController == null)
            shopController = new ShopController();

        return shopController;
    }


    String name;
    String type;
    int number;
    String cardDescription;
    int price;
    boolean side;

    public void buy(String cardName) {

        for (MonsterCard card : Import.getInstance().getAllMonsters()) {
            if (card.getName().equals(cardName)) {
                if (GlobalVariable.getPlayer().getMoney() < card.getPrice()) {
                    warn.setText("not enough money");
                    warn.setStyle("-fx-text-fill: white;-fx-background-color: red;-fx-padding: 10 10 10 10;");

                } else {
                    GlobalVariable.getPlayer().getCards().add(new MonsterCard(card));
                    GlobalVariable.getPlayer().decreaseMoney(card.getPrice());
                    warn.setText("the card added successfully");
                    warn.setStyle("-fx-text-fill: white;-fx-background-color: green;-fx-padding: 10 10 10 10;");

                }
                warn.setVisible(true);
            }
        }

        for (SpellCard card : allSpells) {
            if (card.getName().equals(cardName)) {
                if (GlobalVariable.getPlayer().getMoney() < card.getPrice()) {
                    System.out.println(card.getPrice() + " " + GlobalVariable.getPlayer().getMoney());

                }
                GlobalVariable.getPlayer().getCards().add(new SpellCard(card));
                GlobalVariable.getPlayer().decreaseMoney(card.getPrice());

            }
        }
        for (TrapCard card : allTraps) {
            if (card.getName().equals(cardName)) {
                if (GlobalVariable.getPlayer().getMoney() < card.getPrice()) {
                    System.out.println(card.getPrice() + " " + GlobalVariable.getPlayer().getMoney());

                }
                GlobalVariable.getPlayer().getCards().add(new TrapCard(card));
                GlobalVariable.getPlayer().decreaseMoney(card.getPrice());
            }
        }
    }


    public void showAll() {

        Comparator<MonsterCard> alphabetComparator = Comparator.comparing(MonsterCard::getName);
        ArrayList<MonsterCard> sortedAllMonsters = (ArrayList<MonsterCard>) Import.getInstance().getAllMonsters().stream().sorted(alphabetComparator).
                collect(Collectors.toList());

        Comparator<SpellCard> alphabetComparator1 = Comparator.comparing(SpellCard::getName);
        ArrayList<SpellCard> sortedAllSpells = (ArrayList<SpellCard>) allSpells.stream().sorted(alphabetComparator1).
                collect(Collectors.toList());
        Comparator<TrapCard> alphabetComparator2 = Comparator.comparing(TrapCard::getName);
        ArrayList<TrapCard> sortedAllTraps = (ArrayList<TrapCard>) allTraps.stream().sorted(alphabetComparator2).
                collect(Collectors.toList());


    }

    public String getPriceByName(String name) {
        for (MonsterCard monsterCard : Import.getInstance().getAllMonsters()) {
            if (monsterCard.getName().equals(name)) return String.valueOf(monsterCard.getPrice());
        }
        for (SpellCard s : allSpells) {
            if (s.getName().equals(name)) return String.valueOf(s.getPrice());
        }
        for (TrapCard s : allTraps) {
            if (s.getName().equals(name)) return String.valueOf(s.getPrice());
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadMonster();

    }

    public void loadMonster() {
        int index = 0;
        ImagePattern background;
        cards.getChildren().clear();
        a:
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 8; j++) {
                if (index>=Import.getInstance().getAllMonsters().size()) break a;
                if(index!=41) {
                    Rectangle rectangle = new Rectangle();
                    rectangle.setHeight(134.3);
                    rectangle.setWidth(193);
                    if (getClass().getResource("/com/yugioh/card/image/Cards/Monsters/"
                            + Import.getInstance().getAllMonsters().get(index).getName() + ".jpg") != null) {
                        background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/"
                                + Import.getInstance().getAllMonsters().get(index).getName() + ".jpg").toExternalForm()));
                    } else {
                        background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/Monsters/own.jpg").toExternalForm()));
                    }
                    rectangle.setFill(background);
                    rectangle.setId(Import.getInstance().getAllMonsters().get(index).getName());
                    rectangle.setCursor(Cursor.HAND);
                    ImagePattern finalBackground = background;
                    rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            buyBtn.setVisible(true);
                            buyBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    buy(rectangle.getId());
                                    cardPrice.setText("Price: " + getPriceByName(rectangle.getId()) + "     your money: "
                                            + GlobalVariable.getPlayer().getMoney()+"\ncount: "+GlobalVariable.getPlayer().
                                            countTotalCard(rectangle.getId()));
                                }
                            });
                            detail.setFill(finalBackground);
                            detail.setVisible(true);
                            cardPrice.setText("Price: " + getPriceByName(rectangle.getId()) + "     your money: "
                                    + GlobalVariable.getPlayer().getMoney()+"\ncount: "+GlobalVariable.getPlayer().
                                    countTotalCard(rectangle.getId()));
                            cardPrice.setVisible(true);

                        }
                    });

                    cards.add(rectangle, j, i);
                }
                else{
                    j--;
                }
                if(Import.getInstance().getAllMonsters().size()>42){
                    int a=3;
                }
                    index++;
                }


    }

    public void loadSpellTrap() {
        ImagePattern background;
        int index = 0;
        cards.getChildren().clear();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 7; j++) {
                Rectangle rectangle = new Rectangle();
                rectangle.setHeight(134.2);
                rectangle.setWidth(193);
                if (index < 23) {
                    background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/"
                            + allSpells.get(index).getName() + ".jpg").toExternalForm()));
                    rectangle.setFill(background);
                    rectangle.setId(allSpells.get(index).getName());
                } else {
                    background = new ImagePattern(new Image(getClass().getResource("/com/yugioh/card/image/Cards/SpellTrap/"
                            + allTraps.get(index - 23).getName() + ".jpg").toExternalForm()));
                    rectangle.setFill(background);
                    rectangle.setId(allTraps.get(index - 23).getName());

                }
                rectangle.setCursor(Cursor.HAND);
                ImagePattern finalBackground = background;
                rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        buyBtn.setVisible(true);
                        buyBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                buy(rectangle.getId());
                                cardPrice.setText("Price: " + getPriceByName(rectangle.getId()) + "     your money: "
                                        + GlobalVariable.getPlayer().getMoney()+"\ncount: "+GlobalVariable.getPlayer().
                                        countTotalCard(rectangle.getId()));
                            }
                        });
                        detail.setFill(finalBackground);
                        detail.setVisible(true);
                        cardPrice.setText("Price: " + getPriceByName(rectangle.getId()) + "   your money: "
                                + GlobalVariable.getPlayer().getMoney()+"\ncount: "+GlobalVariable.getPlayer().
                                countTotalCard(rectangle.getId()));
                        cardPrice.setVisible(true);

                    }
                });


                cards.add(rectangle, j, i);
                index++;
            }
    }

    public void createCard(javafx.scene.input.MouseEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/view/CardCreator.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public String getDescriptionByAction(int action) {
        for (MonsterCard monsterCard : Import.getInstance().getAllMonsters()) {
            if (monsterCard.getAction() == action)
                return monsterCard.getCardDescription();
        }
            return null;
    }

    public void back(MouseEvent mouseEvent) {
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
    //  public void createNewCard() {
    //      System.out.println("input card type");
    //      String type = Main.scanner.nextLine();
    //      System.out.println("input card name");
    //      String name = Main.scanner.nextLine();
    //      System.out.println("input card level");
    //      int level = Integer.parseInt(Main.scanner.nextLine());
    //      if (type.equals("monster")) {
    //          System.out.println("input card attack");
    //          int attack = Integer.parseInt(Main.scanner.nextLine());
    //          System.out.println("input card defence");
    //          int defence = Integer.parseInt(Main.scanner.nextLine());
    //          System.out.println("input card attribute");
    //          String attribute = Main.scanner.nextLine();
    //          System.out.println("input monsterType");
    //          String monsterType = Main.scanner.nextLine();
    //          for (MonsterCard monsterCard : ShopController.getInstance().getAllMonsters()) {
    //              if (monsterCard.getAction() != 0)
    //                  System.out.println(monsterCard.getCardDescription() + " : " + monsterCard.getAction());
    //          }
    //          System.out.println("please enter a valid action id or enter 0 for non action");
    //          int action = Integer.parseInt(Main.scanner.nextLine());
    //          int price= level100+attack2+defence+action*20;
    //          MonsterCard monsterCard=new MonsterCard(name,1,type,action,null,false,price,attack,defence,null,attribute,level,monsterType);
    //          ShopController.getInstance().getAllMonsters().add(monsterCard);
    //      }


    //  }


}
