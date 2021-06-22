package controller;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import model.Card;
import model.MonsterCard;

public class ImprotExport {



    public void serialize(MonsterCard card, String name, String describe, int number , List<Integer> list, int attack, int deffence, int price, String attribute, int level, String type, ArrayList<MonsterCard> monsterlist, boolean side, boolean isattackes,String json)
    {
        ImprotExport tester = new ImprotExport();
        try {
MonsterCard cards = new MonsterCard(name,number,type,describe,side,price,attack,deffence,monsterlist,attribute,level,type,isattackes,json,monsterlist);
            cards.setName(name);
            cards.setCardDescription(describe);
            cards.setPrice(price);
            cards.setSide(side);
            cards.setType(type);
            tester.writeJSON(cards);

            MonsterCard card1 = tester.readJSON();
            System.out.println(card1);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJSON(MonsterCard card) throws JsonGenerationException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/test/resources/json_car.json"), card);
    }

    private MonsterCard readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        MonsterCard card = mapper.readValue(new File("src/test/resources/json_car.json"),MonsterCard.class);
        return card;
    }

}
