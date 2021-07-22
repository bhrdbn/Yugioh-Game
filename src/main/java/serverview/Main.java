package serverview;

import model.SpellCard;
import servercontroller.*;
import model.Card;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {

        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            while (true) {
                Socket socket = serverSocket.accept();
                startNewThread(serverSocket, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startNewThread(ServerSocket serverSocket, Socket socket) {
        new Thread(() -> {
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                getInputAndProcess(dataInputStream, dataOutputStream);
                dataInputStream.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void getInputAndProcess(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException {
        while (true) {
            String input = dataInputStream.readUTF();
            String result = process(input);
            if (result.equals("")) break;
            dataOutputStream.writeUTF(result);
            dataOutputStream.flush();
        }
    }

    static String process(String command) {
        String[] parts = command.split(" ");
        if (command.startsWith("create")) {
            return String.valueOf(Controller.getInstance().createUser(parts[1], parts[2], parts[3]));
        } else if (command.startsWith("login")) {
            return String.valueOf(Controller.getInstance().loginUser(parts[1], parts[2]));
        } else if (command.startsWith("scoreboard")) {
            return Controller.getInstance().scoreboard();
        } else if (command.startsWith("logout")) {
            return Controller.getInstance().logoutUser(parts[1]);
        }
        else if(command.contains("nickname")){
            return Controller.getInstance().changeNickName(parts[2],parts[3]);
        }
        else if(command.contains("password")){
            return Controller.getInstance().changePassword(parts[2],parts[3],parts[4]);
        }
        else if(command.startsWith("buy"))
            return Controller.getInstance().buy(parts[1],parts[2]);
        else if(command.equals("show all"))
            return Controller.getInstance().showAll();
        else if(command.startsWith("admin enter"))
            return Controller.getInstance().admin(parts[2]);
        else if(command.startsWith("admin dec"))
            return Controller.getInstance().decreaseCard(parts[2]);
        else if(command.startsWith("admin in"))
            return Controller.getInstance().increaseCard(parts[2]);
        else if(command.startsWith("admin for"))
            return Controller.getInstance().setForbidden(parts[2]);
        else if(command.startsWith("admin all"))
            return Controller.getInstance().setAllowed(parts[2]);
        else if(command.startsWith("request"))
            Controller.getInstance().request(parts[1],parts[2]);
        else if(command.startsWith("sell"))
            return Controller.getInstance().sell(parts[1],parts[2]);
        else if(command.startsWith("deck create"))
            return Controller.getInstance().createDeck(parts[2], parts[3]);
        else if(command.startsWith("deck delete"))
            return Controller.getInstance().deleteDeck(parts[2], parts[3]);
        else if(command.startsWith("deck-set activate"))
            return Controller.getInstance().activateDeck(parts[2], parts[3]);
        else if(command.startsWith("deck add-card") && command.contains("side"))
            return Controller.getInstance().addCardToDeck(parts[5], parts[3], 0, parts[7]);
        else if(command.startsWith("deck add-card") && !command.contains("side"))
            return Controller.getInstance().addCardToDeck(parts[5], parts[3], 1, parts[6]);
        else if(command.startsWith("deck rm-card") && command.contains("side"))
            return Controller.getInstance().removeCardFromDeck(parts[5], parts[3], 0, parts[7]);
        else if(command.startsWith("deck rm-card") && !command.contains("side"))
            return Controller.getInstance().removeCardFromDeck(parts[5], parts[3], 1, parts[6]);
        else if(command.startsWith("deck show all"))
            return Controller.getInstance().showDecks(parts[3]);
        else if(command.startsWith("deck show deck-name") && command.contains("side"))
            return Controller.getInstance().showADeck(parts[3], 0, parts[5]);
        else if(command.startsWith("deck show deck-name") && !command.contains("side"))
            return Controller.getInstance().showADeck(parts[3], 1, parts[4]);
        else if(command.startsWith("deck show cards"))
            return Controller.getInstance().showAllCards(parts[3]);
        else if(command.startsWith("select monster"))
            return GameController.getInstance().selectOwnMonster(Integer.parseInt(parts[2]), parts[3]) + "\n" + GlobalVariable.getBoards().get(parts[3]).toString();
        else if(command.startsWith("select monster") && command.endsWith("opponent"))
            return GameController.getInstance().selectOpponentMonster(Integer.parseInt(parts[2]), parts[4]) + "\n" + GlobalVariable.getBoards().get(parts[4]).toString();
        else if(command.startsWith("select spell"))
            return GameController.getInstance().selectOwnSpell(Integer.parseInt(parts[2]), parts[3]) + "\n" + GlobalVariable.getBoards().get(parts[3]).toString();
        else if(command.startsWith("select spell") && command.endsWith("opponent"))
            return GameController.getInstance().selectOpponentSpell(Integer.parseInt(parts[2]), parts[4]) + "\n" + GlobalVariable.getBoards().get(parts[4]).toString();
        else if(command.startsWith("select hand"))
            return GameController.getInstance().selectHand(Integer.parseInt(parts[2]), parts[3]) + "\n" + GlobalVariable.getBoards().get(parts[3]).toString();
        else if(command.startsWith("select field"))
            return GameController.getInstance().selectField(parts[2]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
        else if(command.startsWith("select field opponent"))
            return GameController.getInstance().selectOpponentField(parts[3]) + "\n" + GlobalVariable.getBoards().get(parts[3]).toString();
        else if(command.startsWith("select -d"))
            return GameController.getInstance().deselect(parts[2]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
        else if(command.startsWith("summon"))
            return GameController.getInstance().summon(parts[1]) + "\n" + GlobalVariable.getBoards().get(parts[1]).toString();
        else if(command.startsWith("set"))
            return GameController.getInstance().setMonster(parts[1]) + "\n" + GlobalVariable.getBoards().get(parts[1]).toString();
        else if(command.startsWith("set position"))
            return GameController.getInstance().changePosition(parts[2], parts[3]) + "\n" + GlobalVariable.getBoards().get(parts[3]).toString();
        else if(command.startsWith("flip-summon"))
            return GameController.getInstance().flipSummon(parts[1]) + "\n" + GlobalVariable.getBoards().get(parts[1]).toString();
        else if(command.startsWith("attack"))
            return GameController.getInstance().attack(Integer.parseInt(parts[1]), parts[2]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
        else if(command.startsWith("attack direct"))
            return GameController.getInstance().directAttack(parts[2]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
        else if(command.startsWith("activate effect"))
            return GameController.getInstance().activateCard((SpellCard) GlobalVariable.getBoards().get(parts[2]).getPlayBoardByTurn().getSelectedCard(), parts[2]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
        else if(command.startsWith("setSpell"))
            return GameController.getInstance().setSpellCard(parts[1]) + "\n" + GlobalVariable.getBoards().get(parts[1]).toString();
        else if(command.startsWith("setTrap"))
            return GameController.getInstance().setTrapCard(parts[1]) + "\n" + GlobalVariable.getBoards().get(parts[1]).toString();
        else if(command.startsWith("ritual summon"))
            return GameController.getInstance().ritualSummon(parts[2]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
        else if(command.startsWith("show graveyard"))
            return GameController.getInstance().showMyGraveyard(parts[2]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
        else if(command.startsWith("show opponent graveyard"))
            return GameController.getInstance().showOpponentGraveyard(parts[3]) + "\n" + GlobalVariable.getBoards().get(parts[3]).toString();
        else if(command.startsWith("show card"))
            return GameController.getInstance().showCard(parts[2]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
        else if(command.startsWith("next phase"))
            return GameController.getInstance().goNextPhase(parts[2], parts[3]) + "\n" + GlobalVariable.getBoards().get(parts[2]).toString();
//        else if(command.equals("surrender"))
//            return GameController.getInstance().setWin();
        return "";
    }
}
