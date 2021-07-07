package Graphic.view;


import view.Main;

public class GraveView {
    private static GraveView graveView = null;

    private GraveView() {
    }

    public static GraveView getInstance() {
        if (graveView == null)
            graveView = new GraveView();

        return graveView;
    }
    public void run(){
        while(true){
            String input= Main.scanner.nextLine();

             System.out.println("invalid command");
        }
    }
}
