package controller;

import java.util.ArrayList;
import model.*;
public class ProfileController{
    private static ProfileController profileController=null;
    private ProfileController(){

    }
    public static ProfileController getInstance()
    {
        if (profileController == null)
            profileController = new ProfileController();

        return profileController;
    }


    public void changeNickName(String nickname){
        GlobalVariable.getPlayer().setNickname(nickname);
    }

    public String changePassword(String newPassword) {
        if(GlobalVariable.getPlayer().getPassword().equals(newPassword))
            return "please enter a new password";
        else{
            GlobalVariable.getPlayer().setPassword(newPassword);
            return "password changed successfully!";
            return null;
        }
    }


    public boolean checkNickName(String nickname){
        for (Player player: Player.getAllPlayers()) {
            if(!player.getNickname().equals(nickname))
                return true;
        }
        return false;
    }


    public boolean checkPassword(String currentPassword, String newPassword){
        for (Player player: Player.getAllPlayers()) {
            if(!player.getPassword().equals(currentPassword))
                return false;
        }

        return true;
    }

}
