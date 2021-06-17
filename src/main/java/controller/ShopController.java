package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class ShopController {

    private static ShopController shopController = null;
    private static MonsterCard monsterCard = null;
private ArrayList<MonsterCard> monsters = new ArrayList<>();
    private ShopController() {
        System.out.println("please enter the number of cards to buy");

    }

    public static ShopController getInstance() {
        if (shopController == null)
            shopController = new ShopController();

        return shopController;
    }
    public Scanner s = new Scanner(System.in);

    String name;
    String type;
    int number;
    String cardDescription;
    int price;
    boolean side;
    String nickname;
    String password;
    String username;
    int f = s.nextInt();
    ArrayList<Integer> cardController;
    Card card = new Card(name, number, type, cardDescription, side, price);

    public String buy(String cardName) {
        Player player = new Player(nickname, password, username);
        for (int i = 0; i <= f; i++) {


            if (card.getName().equals(name1)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name2)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name3)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name4)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name5)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name6)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name7)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name8)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name9)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name10)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name11)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name12)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name13)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name14)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name15)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name16)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name17)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name18)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name19)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name20)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name21)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name22)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name23)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name24)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name25)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name26)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name27)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name28)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name29)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name30)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name31)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name32)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name33)) {
                monsters.add(monsterCard);

            } else if (card.getName().equals(name34)) {
                monsters.add(monsterCard);

            }}

        monsterCard.setMonstersOBJECT(monsters);
        int count = 0;
        for (Card cards : card.getAllCards()) {
            if (!cards.getName().equals(cardName))
                count++;
        }
        if (count == card.getAllCards().size() - 1)
            return "there is no card with this name";
        else if (player.getMoney() < card.getPrice())
            return "not enough money";
        else {
            player.setMoney(player.getMoney() - card.getPrice());
        }
        return null;
    }

    String name1 = "Battle OX ";
    String name2 = "Axe Raider ";
    String name3 = "Yomi Ship ";
    String name4 = "Horn Imp ";
    String name5 = "Silver Fang ";
    String name6 = "Suijin ";
    String name7 = "Fireyarou ";
    String name8 = " Curtain of the dark ones";
    String name9 = "Feral Imp ";
    String name10 = "Dark magician ";
    String name11 = "Wattkid ";
    String name12 = "Baby dragon ";
    String name13 = " Hero of the east";
    String name14 = "Battle warrior ";
    String name15 = "Crawling dragon ";
    String name16 = "Flame manipulator ";
    String name17 = "Blue-Eyes white dragon ";
    String name18 = "Crab Turtle";
    String name20 = "Skull Guardian";
    String name21 = "Slot Machine";
    String name22 = "Haniwa";
    String name23 = "Man-Eater Bug";
    String name24 = "Gate Guardian";
    String name25 = "Scanner";
    String name26 = "Bitron";
    String name19 = "Marshmallon";
    String name27 = "Beast King Barbaros";
    String name28 = "Texchanger";
    String name35 = "Leotron";
    String name29 = "The Calculator";
    String name30 = "Alexandrite Dragon";
    String name31 = "Mirage Dragon";
    String name32 = "Herald of Creation";
    String name33 = "Exploder Dragon";
    String name34 = "Command Knight";


    public void showAll() {
        for (Card cards : card.getAllCards()) {
            System.out.println(cards.getName() + " " + cards.getCardDescription());
        }
    }

}
