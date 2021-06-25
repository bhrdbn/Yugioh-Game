package view;

import model.Card;

import java.util.Scanner;

public class Main {

    public static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        Login.getInstance().run();
    }
}
