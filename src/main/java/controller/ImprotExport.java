package controller;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Card;
import model.MonsterCard;

public class ImprotExport {



    public void serialize(String name, String describe, int number , int attack, int deffence, int price,int action, String attribute, int level, String type, ArrayList<MonsterCard> monsterlist, boolean side)
    {
        ImprotExport tester = new ImprotExport();
        try {
MonsterCard cards = new MonsterCard(name,number,type,action,describe,side,price,attack,deffence,monsterlist,attribute,level,type);
            cards.setName(name);
            cards.setCardDescription(describe);
            cards.setPrice(price);
            cards.setSide(side);
            cards.setType(type);
            ArrayList<MonsterCard>myCards=new ArrayList<>();
            myCards.add(cards);
            tester.writeJSON(myCards);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJSON(ArrayList<MonsterCard>cards ) throws JsonGenerationException, JsonMappingException, IOException{
        try {
            FileWriter myWriter = new FileWriter("json.json",true);
            myWriter.write(new Gson().toJson(cards.get(0)));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readJSON() throws JsonParseException, JsonMappingException, IOException{
        try {
            String json = new String(Files.readAllBytes(Paths.get("json.json")));
            ArrayList<MonsterCard> mons;
            MonsterCard[] vehiclesArray = new Gson().fromJson(json,
                    new TypeToken<List<MonsterCard>>(){}.getType()
                    // Vehicle[].class
            );
            mons = (ArrayList<MonsterCard>) Arrays.asList(vehiclesArray);
            for (MonsterCard vehicle : mons) {
                System.out.println(vehicle.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
