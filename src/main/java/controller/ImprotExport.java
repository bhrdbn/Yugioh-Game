package controller;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

  *//*
import com.google.gson.JsonParseException;
import model.MonsterCard;

public class ImprotExport {



    public void serialize(MonsterCard card, String name, String describe, int number , List<Integer> list, int attack, int deffence, int price, String attribute, int level, String type, ArrayList<MonsterCard> monsterlist, boolean side)
    {
        JacksonTester tester = new JacksonTester();
        try {
            MonsterCard cards = new MonsterCard(name,number,type,describe,list<Integer>,side,price,attack,deffence,monsterlist<MonsterCard>,attribute,level,type)
            cards.setName(name);
            cards.setCardDescription(describe);
            cards.setCardController(list<>);
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
        mapper.writeValue(new File("Monster.json"), card);
    }

    private MonsterCard readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        MonsterCard card = mapper.readValue(new File("Monster.json"));
        return card;
    }
    */
}
