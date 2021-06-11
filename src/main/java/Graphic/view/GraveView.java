package Graphic.view;


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
            String input=Main.scanner.nextLine();
            if(input.equals("back")){
                MenuHandler.runBack(Menu.GRAVEYARD);
                break;
            }
            else System.out.println("invalid command");
        }
    }
}
