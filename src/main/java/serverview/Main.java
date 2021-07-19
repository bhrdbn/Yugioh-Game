package serverview;

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
        else if(command.startsWith("admin"))
            return Controller.getInstance().admin(parts[1]);
        else if(command.startsWith("admin dec"))
            return Controller.getInstance().decreaseCard(parts[2]);
        else if(command.startsWith("admin in"))
            return Controller.getInstance().increaseCard(parts[2]);
        else if(command.startsWith("admin for"))
            return Controller.getInstance().setForbidden(parts[2]);
        else if(command.startsWith("admin all"))
            return Controller.getInstance().setAllowed(parts[2]);
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
        else if(command.equals("deck show all"))
            return Controller.getInstance().showDecks(parts[3]);
        else if(command.startsWith("deck show deck-name") && command.contains("side"))
            return Controller.getInstance().showADeck(parts[3], 0, parts[5]);
        else if(command.startsWith("deck show deck-name") && !command.contains("side"))
            return Controller.getInstance().showADeck(parts[3], 1, parts[4]);
        else if(command.equals("deck show cards"))
            return Controller.getInstance().showAllCards(parts[3]);
        return "";
    }
}
