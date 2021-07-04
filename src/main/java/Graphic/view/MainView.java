package Graphic.view;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import  controller.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.*;
import view.Main;

public class MainView {
    private static MainView mainView=null;
    private MainView(){

    }
    public static MainView getInstance()
    {
        if (mainView == null)
            mainView = new MainView();

        return mainView;
    }

    MainController mainController=MainController.getInstance();



    public void showScoreboard() {
        for (Player player : MainController.scoreboard()) {
            System.out.println(player);
        }
    }
    public Matcher getCommand(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    public void logoutUser(){
        System.out.println(mainController.logoutUser());
        MenuHandler.runBack(Menu.Main);

    }
    public void navigateMenu(String menu){
        switch (menu){
            case "profile":
                MenuHandler.runNextMain(Menu.PROFILE);
                break;
            case "deck":
                MenuHandler.runNextMain(Menu.DECK);
                break;
            case "shop":
                MenuHandler.runNextMain(Menu.SHOP);
                break;
        }
    }
    private static MediaPlayer backgroundMediaPlayer;

    private static void initializeBackgroundMusic() {
        String path = MainView.class.getResource("background-music.mp3").toString();
        Media media = new Media(path);
        backgroundMediaPlayer = new MediaPlayer(media);
        backgroundMediaPlayer.play();
        backgroundMediaPlayer.autoPlayProperty().setValue(true);
        backgroundMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMediaPlayer.setOnEndOfMedia(backgroundMediaPlayer::play);
    }
}
