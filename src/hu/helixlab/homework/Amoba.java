package hu.helixlab.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Amoba {

    private int n;
    private int m;
    private char sign;
    String lastStringSign = new String();

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
        System.out.println("Győzött a(z): " + lastStringSign);
        return;
    }

    public void scanCharacter() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Adja meg a sor indexét (0-2)!");
        try {
            n = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Nem számot adott meg!");
            return;
        }

        System.out.println("Adja meg az oszlop indexét (0-2)!");
        m = scanner.nextInt();

        System.out.println("Adja meg a jelet (x vagy o)!");
        sign = scanner.next().charAt(0);

        try {
            submitCharacter(n, m, sign);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Nem 0 és 2 közötti értéket adott meg!");
        }
    }

    public void submitCharacter(int n, int m, char sign) {

        String stringSign = String.valueOf(sign);

        if (lastStringSign.equals(stringSign)) {

            System.out.println("Nem a(z) " + lastStringSign + " jön!");
            return;
        }

        if (!stringSign.equals("x") && !stringSign.equals("o")) {

            System.out.println("Nem a megfelelő karaktereket adta meg (x vagy o)!");
            return;
        }

        if (!board.values[m][n].equals("[ ]")) {

            System.out.println("Már foglalt a mező!");
            return;
        }

        board.values[n][m] = " " + stringSign + " ";

        lastStringSign = stringSign;

        board.printBoard();
    }
}