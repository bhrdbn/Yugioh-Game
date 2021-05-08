package view;

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

        }
    }

    public static void runNextLogin() {

        MainView.getInstance().run();
    }

    public static void runNextMain(Menu menu) {
        switch (menu) {
            case PROFILE:
                Profile.getInstance().run();
                break;
            case DECK:
                DeckView.getInstance().run();
                break;

        }

    }
}
