package tictactoe;

public class Player {
    private char startingValue;
    private int numOfMoves;

    public Player() {
        numOfMoves = 0;
    }

    public void setStartingValue(Gameboard gameboard, int vert, int horiz) {
        if (gameboard.getNumOfXs() % gameboard.getNumOfOs() == 0) {
            gameboard.setXOnGameboard(vert, horiz);
            startingValue = 'X';
            numOfMoves++;
        } else {
            gameboard.setOOnGameboard(vert, horiz);
            startingValue = 'O';
            numOfMoves++;
        }
    }

    public void setValue(Gameboard gameboard, int vert, int horiz) {
        if (startingValue == 'X') {
            gameboard.setXOnGameboard(vert, horiz);
            numOfMoves++;
        } else {
            gameboard.setOOnGameboard(vert, horiz);
            numOfMoves++;
        }
    }

    public int getNumOfMoves() {
        return numOfMoves;
    }
}
