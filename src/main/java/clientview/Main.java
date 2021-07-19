package clientview;

import clientcontroller.Controller;
import model.Card;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Main {

    public static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        Controller.getInstance().networkInit();
        Login.getInstance().run();

    }
}
