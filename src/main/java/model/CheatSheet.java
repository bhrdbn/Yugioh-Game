package model;

import java.util.ArrayList;

import model.*;
public class CheatSheet extends Player {
    private int code;
    public CheatSheet(String nickname, String password, String username,int code) {
        super(nickname, password, username);
        this.code = code;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void cheet(int code) {
        if (code == 1) {
            this.setMoney(9999999);
            System.out.println("successful code activation");

        }
        if (code == 2) {
            this.setMoney(8888888);
            System.out.println("successful code activation");
        }
        if (code == 3) {
            this.setMoney(333333);
            System.out.println("successful code activation");
        }
        if (code ==5)
        {
            this.setMoney(2);
            System.out.println("successful code activation");
        }
        if (code == 4) {
            setScore(1000000);
            System.out.println("successful code activation");
        }
        if (code ==7){
            this.setScore(999999);
            System.out.println("successful code activation");
        }
        if (code == 6)
        {
            this.setMoney(2000);
            System.out.println("successful code activation");
        }
        if (code == 7)
        {
            CheatSheet.getCurrentPlayer().setScore(1000000);
            System.out.println("successful code activation");
        }
        if (code == 8)
        { MonsterCard monsterCard = new MonsterCard("Haniwa",1,"Normal",2,"An earthen figure that protects the tomb of an ancient ruler.",true,600,500,500,null,"EARTH",2,"Rock");
            CheatSheet.getCurrentPlayer().addToDeck(monsterCard);
            System.out.println("successful code activation");
        }
    }


}



