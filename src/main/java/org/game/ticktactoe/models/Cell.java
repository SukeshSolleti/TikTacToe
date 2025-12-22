package org.game.ticktactoe.models;

public class Cell {
    private Player player;
    private int row;
    private int column;
    private CellState cellState;

    public Cell(int row, int column){
        this.row = row;
        this.column = column;
        this.cellState = CellState.EMPTY;
        this.player = null;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
