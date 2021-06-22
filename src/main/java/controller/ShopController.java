package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import view.Main;

public class ShopController {

    private static ShopController shopController = null;
    private static MonsterCard monsterCard = null;
    private static SpellCard spellCard = null;
    private static TrapCard trapCard = null;
private ArrayList<MonsterCard> monsters = new ArrayList<>();
    private ArrayList<SpellCard> spells = new ArrayList<>();
    private ArrayList<TrapCard> traps = new ArrayList<>();
    private ShopController() {

    }

    public static ShopController getInstance() {
        if (shopController == null)
            shopController = new ShopController();

        return shopController;
    }
    public Scanner s = Main.scanner;

    String name;
    String type;
    int number;
    String cardDescription;
    int price;
    boolean side;
    String nickname;
    String password;
    String username;

    ArrayList<Integer> cardController;
    Card card = new Card(name, number, type, cardDescription, side, price);

    public String buy(String cardName) {

        Player player = new Player(nickname, password, username);
while (true){

            if (cardName.equals(name1)) {
                monsters.add(monsterCard);
break;
            } else if (cardName.equals(name2)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name3)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name4)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name5)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name6)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name7)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name8)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name9)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name10)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name11)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name12)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name13)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name14)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name15)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name16)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name17)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name18)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name19)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name20)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name21)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name22)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name23)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name24)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name25)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name26)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name27)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name28)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name29)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name30)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name31)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name32)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name33)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name34)) {
                monsters.add(monsterCard);
                break;
            } else if (cardName.equals(name35)) {
                monsters.add(monsterCard);
                break;
        }
            else if (cardName.equals(name36)) {
                monsters.add(monsterCard);
                break;
            }else if (cardName.equals(name37)) {
                monsters.add(monsterCard);
                break;
            }else if (cardName.equals(name38)) {
                monsters.add(monsterCard);
                break;
            }else if (cardName.equals(name39)) {
                monsters.add(monsterCard);
                break;
            }else if (cardName.equals(name40)) {
                monsters.add(monsterCard);
                break;
            }else if (cardName.equals(name41)) {
                monsters.add(monsterCard);
                break;
            }else if (cardName.equals(name42)) {
                monsters.add(monsterCard);
                break;
            }




            if (cardName.equals(names1)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names2)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names3)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names4)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names5)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names6)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names7)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names8)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names9)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names10)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names11)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names12)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names13)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names14)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names15)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names16)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names17)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names18)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names19)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names20)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names21)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names22)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names23)) {
                spells.add(spellCard);
                break;
            } else if (cardName.equals(names24)) {
                spells.add(spellCard);
                break;
            }

            if (cardName.equals(namet1)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet2)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet3)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet4)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet5)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet6)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet7)) {
                traps.add(trapCard);break;
            } else if (cardName.equals(namet8)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet9)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet10)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet11)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet12)) {
                traps.add(trapCard);
                break;
            } else if (cardName.equals(namet13)) {
                traps.add(trapCard);
            }

        }

        trapCard.setTrapsOBJECT(traps);
        monsterCard.setMonstersOBJECT(monsters);
        spellCard.setSpellOBJECT(spells);
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

    String name1 = "Battle OX";
    String name2 = "Axe Raider";
    String name3 = "Yomi Ship";
    String name4 = "Horn Imp";
    String name5 = "Silver Fang";
    String name6 = "Suijin";
    String name7 = "Fireyarou";
    String name8 = " Curtain of the dark ones";
    String name9 = "Feral Imp";
    String name10 = "Dark magician";
    String name11 = "Wattkid";
    String name12 = "Baby dragon";
    String name13 = " Hero of the east";
    String name14 = "Battle warrior";
    String name15 = "Crawling dragon";
    String name16 = "Flame manipulator";
    String name17 = "Blue-Eyes white dragon";
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
    String name36 = "Spiral Serpent";
    String name37 = "The Tricky";
    String name38 = "Terratiger";
    String name39 = "Wattaildragon";
    String name40 = "Nokhodi";
    String name41 = "Dark Blade";
    String name42 = "Warrior Dai Grepher";


    String names1 = "Monster Reborn ";
    String names2 = "Terraforming";
    String names3 = "Pot of Greed";
    String names4 = "Raigeki";
    String names5 = "Change of Heart";
    String names6 = "Swords of Revealing Light";
    String names7 = "Harpie's Feather Duster";
    String names8 = "Dark Hole";
    String names9 = "Supply Squad";
    String names10 = "Spell Absorption";
    String names11 = "Messenger of peace";
    String names12 = "Twin Twisters";
    String names13 = "Mystical space typhoon";
    String names14 = "Ring of defense";
    String names15 = "Yami";
    String names16 = "Forest";
    String names17 = "Closed Forest";
    String names18 = "Umiiruka";
    String names19 = "Sword of dark destruction";
    String names20 = "Black Pendant";
    String names21 = "United We Stand";
    String names22 = "Magnum Shield";
    String names23 = "Advanced Ritual Art";
    String names24 = "Nothing";

    String namet1 = "Trap Hole";
    String namet2 = "Mirror Force";
    String namet3 = "Magic Cylinder";
    String namet4 = "Mind Crush";
    String namet5 = "Torrential Tribute";
    String namet6 = "Time Seal";
    String namet7 = "Negate Attack";
    String namet8 = "Solemn Warning";
    String namet9 = "Magic Jamamer";
    String namet10 = "Call of The Haunted";
    String namet11 = "Vanity's Emptiness";
    String namet12 = "Wall of Revealing Light";
    String namet13 = "no";






    public void showAll() {
        for (Card cards : Card.getAllCards()) {
            System.out.println(cards.getName() + " " + cards.getCardDescription());
        }
    }

}
