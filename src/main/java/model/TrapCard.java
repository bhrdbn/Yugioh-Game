package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrapCard extends Card{
    private ArrayList<TrapCard> traps;
    private String icon;
    private  String status;


    public TrapCard(String name, int number, String type, String cardDescription, boolean side, long price, String icon,String status) throws IOException {
        super(name, number, type, cardDescription, side, price);
        this.icon=icon;
        this.status=status;
    }
    public TrapCard(TrapCard card){
        super(card.name,card.number,card.cardType,card.description,card.side,card.price);
        this.icon=card.icon;
        this.status=card.status;
    }
 // String json = new String(Files.readAllBytes(Paths.get("resources//csvjsontrap.json")));
 // ArrayList<SpellCard> trapsOBJECT  = new Gson().fromJson(json,new TypeToken<List<TrapCard>>(){}.getType());
 // public void setTrapsOBJECT(ArrayList<TrapCard> trapsOBJECT) {
 //     for(int i = 0; i <trapsOBJECT.size() ; i++)
 //     {
 //         TrapCard trap =(trapsOBJECT.get(i));
 //         trap.setName(trapsOBJECT.get(i).name);
 //         trap.setType(trapsOBJECT.get(i).cardType);
 //         trap.setSide(trapsOBJECT.get(i).side);
 //         trap.setPrice(trapsOBJECT.get(i).price);
 //         trap.setCardDescription(trapsOBJECT.get(i).description);


 //     }
 // }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<TrapCard> getTraps() {
        return traps;
    }

    public void setTraps(ArrayList<TrapCard> traps) {
        this.traps = traps;
    }

}