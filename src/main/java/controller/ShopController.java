package controller;

import java.util.ArrayList;
import model.*;

public class ShopController {

    private static ShopController shopController=null;
    private ShopController(){

    }
    public static ShopController getInstance()
    {
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
    String nickname;
    String password;
    String username;
    ArrayList<Integer> cardController;
    Card card = new Card(name,number,type,cardDescription,side,price);
    public String buy(String cardName){
        Player player = new Player(nickname, password, username);

        int count = 0;
        for(Card cards : card.getAllCards()){
            if(!cards.getName().equals(cardName))
                count++;
        }
        if(count == card.getAllCards().size() - 1)
            return "there is no card with this name";
        else if(player.getMoney() < card.getPrice())
            return "not enough money";
        else{
            player.setMoney(player.getMoney() - card.getPrice());
        }
    return null;
    }
/*
String name1 ="Battle OX ";
String name2 = "Axe Raider ";
String name3 = "Yomi Ship ";
String name4 = "Horn Imp ";
String name5 = "Silver Fang ";
String name6 = "Suijin ";
String name7 = "Fireyarou ";
String name8 = " Curtain of the dark ones";
String name9 = "Feral Imp ";
String name10 = "Dark magician ";
String name11= "Wattkid ";
String name12= "Baby dragon ";
String name13= " Hero of the east";
String name14= "Battle warrior ";
String name15= "Crawling dragon ";
String name16= "Flame manipulator ";
String name17= "Blue-Eyes white dragon ";
String name18= "Crab Turtle";
String name20= "Skull Guardian";
String name21= "Slot Machine";
String name22= "Haniwa";
String name23= "Man-Eater Bug";
String name24=  "Gate Guardian";
String name25="Scanner";
String name26= "Bitron";
String name19= "Marshmallon";
String name27= "Beast King Barbaros";
String name28= "Texchanger";
String name26= "Leotron";
String name29=  "The Calculator";
String name30="Alexandrite Dragon";
String name31= "Mirage Dragon";
String name32= "Herald of Creation";
String name33= "Exploder Dragon";
String name34=  "Command Knight";




if ((card.getname()).equals name1)
{
Monstercard.getmonsterObject(name1)
} else if((card.getname()).equals name2)
{
Monstercard.getmonsterObject(name2)

} else if((card.getname()).equals name3)
{
Monstercard.getmonsterObject(name3)

} else if((card.getname()).equals name4)
{
Monstercard.getmonsterObject(name4)

} else if((card.getname()).equals name5)
{
Monstercard.getmonsterObject(name5)

} else if((card.getname()).equals name6)
{
Monstercard.getmonsterObject(name6)

} else if((card.getname()).equals name7)
{
Monstercard.getmonsterObject(name7)

} else if((card.getname()).equals name8)
{
Monstercard.getmonsterObject(name8)

} else if((card.getname()).equals name9)
{
Monstercard.getmonsterObject(name9)

} else if((card.getname()).equals name10)
{
Monstercard.getmonsterObject(name10)

} else if((card.getname()).equals name11)
{
Monstercard.getmonsterObject(name11)

} else if((card.getname()).equals name12)
{
Monstercard.getmonsterObject(name12)

} else if((card.getname()).equals name13)
{
Monstercard.getmonsterObject(name13)

} else if((card.getname()).equals name14)
{
Monstercard.getmonsterObject(name14)

} else if((card.getname()).equals name15)
{
Monstercard.getmonsterObject(name15)

} else if((card.getname()).equals name16)
{
Monstercard.getmonsterObject(name16)

}


 */

    public void showAll(){
        for(Card cards : card.getAllCards()){
            System.out.println(cards.getName() + " " + cards.getCardDescription());
        }
    }

}
