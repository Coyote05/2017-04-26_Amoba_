package hu.helixlab.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Amoba {

    private int n;
    private int m;
    private String sign = "x";
    private String lastSign;

    private Board board;

    public Amoba() {
        board = new Board();
    }

    public Board getBoard() {

        return board;
    }

    public void playGame() {

        while (board.isWinner() == false) {

            scanCharacter();
        }
        System.out.println("Győzött a(z): " + lastSign);
        return;
    }

    public void scanCharacter() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Adja meg a sor indexét (0-2)!");
            n = scanner.nextInt();
            System.out.println("Adja meg az oszlop indexét (0-2)!");
            m = scanner.nextInt();

        } catch (InputMismatchException ex) {
            System.out.println("Nem számot adott meg!");
            return;
        }

        try {
            submitCharacter(n, m, sign);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Nem 0 és 2 közötti értéket adott meg!");
        }

        if (sign == "x") {
            sign = "o";
        }
        else if (sign == "o") {
            sign = "x";
        }
    }

    public void submitCharacter(int n, int m, String sign) {

        if (board.values[n][m].equals(" x ") || board.values[n][m].equals(" o ")) {

            System.out.println("Már foglalt a mező!");
            return;
        }

        board.values[n][m] = " " + sign + " ";

        lastSign = sign;

        board.printBoard();
    }
}