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
    private int number;
    private ArrayList<TrapCard> traps;

    public TrapCard(String name, int number, String type, String cardDescription, ArrayList<Integer> cardController, boolean side, int price) throws IOException {
        super(name, number, type, cardDescription, cardController, side, price);
    }
    String json = new String(Files.readAllBytes(Paths.get("D://Trap.json")));
    ArrayList<MonsterCard> trapOBJECT  = new Gson().fromJson(json,new TypeToken<List<MonsterCard>>(){}.getType());
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