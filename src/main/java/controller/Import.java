package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Card;
import model.MonsterCard;
import model.SpellCard;
import model.TrapCard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Import {
    private Import(){
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("csvjsonmonster.json")));
            allMonsters = new Gson().fromJson(json, new TypeToken<List<MonsterCard>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   private ArrayList<MonsterCard> allMonsters = new ArrayList<>();
    private static Import anImport=null;
    public static Import getInstance() {
        if (anImport == null)
            anImport = new Import();

        return anImport;

    }

    public ArrayList<MonsterCard> getAllMonsters() {
        return allMonsters;
    }
    public void addCard(MonsterCard card){
        allMonsters.add(card);
    }
}
