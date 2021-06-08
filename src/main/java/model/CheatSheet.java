package model;

import java.util.ArrayList;
import controller.*;
import model.*;
public class CheatSheet extends Player {
    public CheatSheet(String nickname, String password, String username) {
        super(nickname, password, username);
    }
   private int code;

    public CheatSheet(String nickname, String password, String username, int code) {
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
        }
        if (code == 2) {
            this.setMoney(8888888);
        }
        if (code == 3) {
            this.setMoney(333333);
        }
        if (code ==5)
        {
            this.setCode(2);
        }
        if (code == 4) {
            setScore(1000000);
        }
        if (code ==5){
            this.setScore(999999);
        }
        if (code == 6)
        {
            this.setMoney(2000);
        }
    }


}



