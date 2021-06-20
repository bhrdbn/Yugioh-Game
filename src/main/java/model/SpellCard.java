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
    private int number;
    private ArrayList<SpellCard> spells;
    private TypeOfSpellCard type;


    public SpellCard(String name, int number, String type, String cardDescription, boolean side, int price, int number1, ArrayList<SpellCard> spells) throws IOException {
        super(name, number, type, cardDescription, side, price);
        this.number = number1;
        this.spells = spells;
    }

    String json = new String(Files.readAllBytes(Paths.get("resources//csvjsonspell.json")));
    ArrayList<SpellCard> spellsOBJECT  = new Gson().fromJson(json,new TypeToken<List<SpellCard>>(){}.getType());
    public void setSpellOBJECT(ArrayList<SpellCard> spellOBJECT) {
        for(int i = 0; i <45 ; i++)
        {
            SpellCard spell =(spellOBJECT.get(i));
            spell.setName(spellOBJECT.get(i).name);
            spell.setType(spellOBJECT.get(i).type);
            spell.setSide(spellOBJECT.get(i).side);
            spell.setPrice(spellOBJECT.get(i).price);
            spell.setCardDescription(spellOBJECT.get(i).cardDescription);


        }
    }
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
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
