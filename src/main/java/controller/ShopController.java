package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.*;
import view.Main;

public class ShopController {

    private static ShopController shopController = null;
    private static MonsterCard monsterCard = null;
    private static SpellCard spellCard = null;
    private static TrapCard trapCard = null;
    ArrayList<MonsterCard> allMonsters = new ArrayList<>();
    ArrayList<SpellCard> allSpells = new ArrayList<>();

    private ShopController() {
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("csvjsonmonster.json")));
            allMonsters = new Gson().fromJson(json, new TypeToken<List<MonsterCard>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json1 = null;
        try {
            json1 = new String(Files.readAllBytes(Paths.get("csvjsonspell.json")));
            allSpells = new Gson().fromJson(json1, new TypeToken<List<SpellCard>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<MonsterCard> getAllMonsters() {
        return allMonsters;
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

    public String buy(String cardName) {

        for (MonsterCard card : allMonsters) {
            if (card.getName().equals(cardName)) {
                if (GlobalVariable.getPlayer().getMoney() < card.getPrice()) {
                    System.out.println(card.getPrice()+" "+GlobalVariable.getPlayer().getMoney());
                    return "no enough money";
                }
               else {
                    GlobalVariable.getPlayer().getCards().add(new MonsterCard(card));
                    GlobalVariable.getPlayer().decreaseMoney(card.getPrice());
                    return "card added successfully";
                }
            }
        }

        for (SpellCard card : allSpells) {
            if (card.getName().equals(cardName)) {
                if (GlobalVariable.getPlayer().getMoney() < card.getPrice()) {
                    System.out.println(card.getPrice()+" "+GlobalVariable.getPlayer().getMoney());
                    return "no enough money";
                }
                GlobalVariable.getPlayer().getCards().add(new SpellCard(card));
                GlobalVariable.getPlayer().decreaseMoney(card.getPrice());
                return "card added successfully";
            }
        }


        return "there is no card with this name";


    }


    public String showAll() {
        String showCard = "";
        Comparator<MonsterCard> alphabetComparator = Comparator.comparing(MonsterCard::getName);
        ArrayList<MonsterCard> sortedAllMonsters = (ArrayList<MonsterCard>) allMonsters.stream().sorted(alphabetComparator).
                collect(Collectors.toList());

        Comparator<SpellCard> alphabetComparator1 = Comparator.comparing(SpellCard::getName);
        ArrayList<SpellCard> sortedAllSpells = (ArrayList<SpellCard>) allSpells.stream().sorted(alphabetComparator1).
                collect(Collectors.toList());
        System.out.println("monster cards:\n");


        for (MonsterCard card : sortedAllMonsters) {
            showCard += card.getName() + " : " + card.getPrice() + "\n";
        }
        showCard += "\n\nspell cards:\n";

        for (SpellCard card : sortedAllSpells) {
            showCard += card.getName() + " : " + card.getPrice() + "\n";
        }
        return showCard;
    }

}
