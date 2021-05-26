package controller;

import model.Card;
import view.Login;

public class GraveyardController {
    private static GraveyardController graveyardController = null;

    private GraveyardController() {
    }

    public static GraveyardController getInstance() {
        if (graveyardController == null)
            graveyardController = new GraveyardController();

        return graveyardController;
    }
    public String showMyGraveyard(){
        StringBuilder graveyard = new StringBuilder();
        int i=0;
        if(GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards().size()==0)
            return "it's empty";
        for(Card card: GlobalVariable.getBoard().getPlayBoardByTurn().getGraveyards()) {
            graveyard.append(i).append(". ") .append(card.toString()).append("\n");
            i++;
        }

        return graveyard.toString();

    }
    public String showOpponentGraveyard(){
        StringBuilder graveyard = new StringBuilder();
        int i=0;
        if(GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getGraveyards().size()==0)
            return "it's empty";
        for(Card card: GlobalVariable.getBoard().getOpponentPlayBoardByTurn().getGraveyards()) {
            graveyard.append(i).append(". ") .append(card.toString()).append("\n");
            i++;
        }
        return graveyard.toString();

    }
}
