package view;

import java.io.IOException;

public class MenuHandler {
    public static void runBack(Menu menu) {
        switch (menu) {
            case LOGIN:
                System.exit(0);
                break;
            case DECK:
            case DUEL:
            case SHOP:
            case PROFILE:
                MainView.getInstance().run();
                break;
            case Main:
                Login.getInstance().run();
                break;
            case GRAVEYARD:
                Duel.getInstance().run();

        }
    }

    public static void runNextLogin() {

        MainView.getInstance().run();
    }
    public static void runGraveFromDuel() {

      Duel.getInstance().run();
    }

    public static void runNextMain(Menu menu)  {
        switch (menu) {
            case PROFILE:
                Profile.getInstance().run();
                break;
            case DECK:
                DeckView.getInstance().run();
                break;
            case DUEL:
                Duel.getInstance().run();
                break;
            case SHOP:
                try {
                    Shop.getInstance().run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }

    }
}
