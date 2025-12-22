package org.game.ticktactoe.models;

import java.util.Scanner;

public class Player {
    private PlayerType playerType;
    private String name;
    private char symbol;

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Move decideMove(Board board){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row for your move starting from 1 : ");
        int row = scanner.nextInt();
        System.out.println("Enter column for your move starting from 1 : ");
        int column = scanner.nextInt();
        return new Move(new Cell(row-1,column-1),this);
    }

    public Player(PlayerType playerType, String name, char symbol){
        this.playerType = playerType;
        this.name = name;
        this.symbol = symbol;
    }
}
