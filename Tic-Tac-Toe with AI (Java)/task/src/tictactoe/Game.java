package tictactoe;

public class Game {
    private final UserInterface ui;
    private boolean gameOver;
    private Gameboard gameboard;
    private Player player;

    public Game() {
        ui = new UserInterface();
        gameboard = new Gameboard();
        player = new Player();
        gameOver = false;
    }

    public void newGame() {
        ui.run();
        gameboard.printStartingBoard(ui.getStartingCells());
        while (!gameOver()) {
            ui.askForCoordinates();
            if (validCoordinates()) {
                gameboard.printBoard();
            }
        }
    }

    public boolean gameOver() {
        for (int i = 0; i < gameboard.getGameboard().length; i++) {
            for (int j = 0; j < gameboard.getGameboard().length; j++) {
                if (checkRow(i, j)) {
                    System.out.println(player.getStartingValue() + "wins");
                    return true;
                }
            }
        }
        return gameOver;
    }

    public boolean checkRow(int i, int j) {
        if (j != 0) {
            return false;
        }
        if (gameboard.getGameboard()[i][j] == player.getStartingValue()
                && gameboard.getGameboard()[i][j + 1] == player.getStartingValue()
                && gameboard.getGameboard()[i][j + 2] == player.getStartingValue()) {
            return true;
        }
        return false;
    }

    private boolean validCoordinates() {
        if (ui.getCoordinates() == null) return false;
        try {
            int vert = Integer.parseInt(String.valueOf(ui.getCoordinates().charAt(0))) - 1;
            int horiz = Integer.parseInt(String.valueOf((ui.getCoordinates().charAt(2)))) - 1;
            if (vert > 2) {
                ui.indexTooLarge();
                return false;
            }
            if (gameboard.getGameboard()[vert][horiz] != ' ') {
                ui.occupiedCell();
                return false;
            }
            if (player.getNumOfMoves() == 0) {
                player.setStartingValue(gameboard, vert, horiz);
            } else {
                player.setValue(gameboard, vert, horiz);
            }
            return true;

        } catch (Exception e) {
            ui.invalidFormat();
            return false;
        }
    }

}
