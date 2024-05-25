package tictactoe;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class UserInterface {
    private String startingCells;
    private Scanner scanner;
    private String coordinates;

    public UserInterface() {
        this.startingCells = null;
        this.scanner = new Scanner(System.in);
    }
    public void run() {
        System.out.print("Enter the cells: > ");
        startingCells = scanner.nextLine();
    }
    public void askForCoordinates() {
        System.out.print("Enter the coordinates: > ");
        coordinates = scanner.nextLine();
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void occupiedCell() {
        System.out.println("This cell is occupied! Choose another one!");
    }

    public void invalidFormat() {
        System.out.println("You should enter numbers!");
    }

    public String getStartingCells() {
        return startingCells;
    }

    public void indexTooLarge() {
        System.out.println("Coordinates should be from 1 to 3!");
    }
}
