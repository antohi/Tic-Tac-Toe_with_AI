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
        boolean sameRow;
        boolean sameColumn = false;
        for (int i = 0; i < gameboard.getGameboard().length; i++) {
            for (int j = 0; j < gameboard.getGameboard().length; j++) {
                sameRow = j == 0 ? true : false;
                if (sameRow && gameboard.getGameboard()[i][j] == 'X' && gameboard.getGameboard()[i][j+1] == 'X' && gameboard.getGameboard()[i][j+2] == 'X') {
                    System.out.println("Game over!");
                    return true;
                }
            }
        }
        return gameOver;
    }


    private boolean validCoordinates() {
        if (ui.getCoordinates() == null) return false;
        try {
            int vert = Integer.parseInt(String.valueOf(ui.getCoordinates().charAt(0)))-1;
            int horiz = Integer.parseInt(String.valueOf((ui.getCoordinates().charAt(2))))-1;
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
