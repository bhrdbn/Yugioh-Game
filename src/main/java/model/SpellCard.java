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

public class SpellCard extends Card{

    private ArrayList<SpellCard> spells;
    private TypeOfSpellCard type;
    private String icon;
    private String status;


    public SpellCard(String status,String name, int number, String type, String cardDescription, boolean side, int price,  String icon) {
        super(name, number, type, cardDescription, side, price);
        this.icon=icon;
        this.status=status;
    }
    public SpellCard(SpellCard card){
        super(card.name,card.number,card.cardType,card.description,card.side,card.price);
        this.icon=card.icon;
        this.status= card.status;
    }

   //String json = new String(Files.readAllBytes(Paths.get("resources//csvjsonspell.json")));
   //ArrayList<SpellCard> spellsOBJECT  = new Gson().fromJson(json,new TypeToken<List<SpellCard>>(){}.getType());
   //public void setSpellOBJECT(ArrayList<SpellCard> spellOBJECT) {
   //    for(int i = 0; i <spellOBJECT.size() ; i++)
   //    {
   //        SpellCard spell =(spellOBJECT.get(i));
   //        spell.setName(spellOBJECT.get(i).name);
   //        spell.setType(spellOBJECT.get(i).getType());
   //        spell.setSide(spellOBJECT.get(i).side);
   //        spell.setPrice(spellOBJECT.get(i).price);
   //        spell.setCardDescription(spellOBJECT.get(i).description);


   //    }
   //}
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getIcon(){
        return icon;
    }

    public ArrayList<SpellCard> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<SpellCard> spells) {
        this.spells = spells;
    }

    public void setSpellType(TypeOfSpellCard type){
        this.type = type;
    }

    public TypeOfSpellCard getSpellType(){
        return type;
    }


}
