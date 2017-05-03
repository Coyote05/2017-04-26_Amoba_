package hu.helixlab.homework;

public class Main {

    public static void main(String[] args) {

        Amoba game = new Amoba();
        game.getBoard().printBoard();
        game.playGame();
    }
}