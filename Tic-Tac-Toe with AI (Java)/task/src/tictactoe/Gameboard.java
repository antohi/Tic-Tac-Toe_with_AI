package tictactoe;

public class Gameboard {
    private char[][] gameboard;
    private int numOfXs;
    private int numOfOs;

    public Gameboard() {
        this.gameboard = new char[3][3];
        this.numOfXs = 0;
        this.numOfOs = 0;
    }

    public void printStartingBoard(String startingCells) {
        System.out.print("---------\n");
        int charIndex = 0;
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                gameboard[i][j] = startingCells.charAt(charIndex);
                if (gameboard[i][j] == 'X') {
                    numOfXs++;
                } else if (gameboard[i][j] == 'O') {
                    numOfOs++;
                }
                gameboard[i][j] = gameboard[i][j] == '_' ? ' ' : startingCells.charAt(charIndex);
                System.out.print(gameboard[i][j] + " ");
                charIndex++;
                if (j == gameboard.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public void printBoard() {
        System.out.print("---------\n");
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(gameboard[i][j] + " ");
                if (j == gameboard.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public char[][] getGameboard() {
        return gameboard;
    }

    public void setXOnGameboard(int vert, int horiz) {
        gameboard[vert][horiz] = 'X';
    }

    public void setOOnGameboard(int vert, int horiz) {
        gameboard[vert][horiz] = 'O';
    }

    public int getNumOfXs() {
        return numOfXs;
    }

    public int getNumOfOs() {
        return numOfOs;
    }
}
