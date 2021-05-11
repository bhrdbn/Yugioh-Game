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

    public SpellCard(String name, int number, String type, String cardDescription, ArrayList<Integer> cardController, boolean side, int price) throws IOException {
        super(name, number, type, cardDescription, cardController, side, price);
    }
    String json = new String(Files.readAllBytes(Paths.get("D://Spell.json")));
    ArrayList<MonsterCard> spellsOBJECT  = new Gson().fromJson(json,new TypeToken<List<MonsterCard>>(){}.getType());
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



}
