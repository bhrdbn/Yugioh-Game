package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import model.*;

public class MainController {
    private static MainController mainController = null;
    private MainController(){

    }
    public static MainController getInstance()
    {
        if (mainController == null)
            mainController = new MainController();

        return mainController;
    }


    public static ArrayList<Player> scoreboard() {
        Comparator<Player> scoreComparator = Comparator.comparing(Player::getScore).reversed();
        Comparator<Player> alphabetComparator = Comparator.comparing(Player::getNickname);
        Comparator<Player> multiComparator = scoreComparator.thenComparing(alphabetComparator);
        ArrayList<Player> sortedAllPerson = (ArrayList<Player>) Player.getAllPlayers().stream().sorted(multiComparator).
                collect(Collectors.toList());
        return sortedAllPerson;
    }

    public String logoutUser() {
        return "user logged out successfully!";
    }
}
