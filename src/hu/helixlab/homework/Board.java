package hu.helixlab.homework;

public class Board {

    public String[][] values;

    public Board() {
        initBoard();
    }

    public void initBoard() {
        values = new String[3][3];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                values[i][j] = "[ ]";
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                System.out.print(values[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------------");
        }
    }

    public boolean isWinner() {

        return rowChecker() || columnChecker() || crossChecker();

    }

    public boolean rowChecker() {

        for (int i = 0; i < values.length; i++) {

            if (!values[i][0].equals("[ ]") && (values[i][0].equals(values[i][1]) && values[i][1].equals(values[i][2]))) {
                return true;
            }
        }
        return false;
    }

    public boolean columnChecker() {

        for (int i = 0; i < values.length; i++) {

            if (!values[0][i].equals("[ ]") && values[0][i].equals(values[1][i]) && values[1][i].equals(values[2][i])) {
                return true;
            }
        }
        return false;
    }

    public boolean crossChecker() {

        if ((!values[0][0].equals("[ ]") && values[0][0].equals(values[1][1]) && values[1][1].equals(values[2][2])) || (!values[2][0].equals("[ ]") && values[2][0].equals(values[1][1]) && values[1][1].equals(values[0][2]))) {
            return true;
        }
        return false;
    }
}