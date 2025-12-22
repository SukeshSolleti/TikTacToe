package org.game.ticktactoe.strategies.gameWinningStrategy;

import org.game.ticktactoe.models.Board;
import org.game.ticktactoe.models.Cell;
import org.game.ticktactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {

    private List<HashMap<Character, Integer>> rowSymbolCounts = new ArrayList<>();

    private List<HashMap<Character, Integer>> columnSymbolCounts = new ArrayList<>();

    private HashMap<Character, Integer> topLeftdiagonalSymbolCounts = new HashMap<>();

    private HashMap<Character, Integer> topRightdiagonalSymbolCounts = new HashMap<>();

    public OrderOneGameWinningStrategy(int dimensions) {
        for (int i = 0; i < dimensions; i++) {
            rowSymbolCounts.add(new HashMap<>());
            columnSymbolCounts.add(new HashMap<>());
        }
    }


    public boolean isCellOnTopLeftDiagonal(int row, int column) {
        return row == column;
    }

    public boolean isCellOnTopRightDiagonal(int row, int column) {
        return row + column == rowSymbolCounts.size() - 1;
    }

    @Override
    public boolean checkForWin(Player player, Board board, Cell cell) {
        char symbol = cell.getPlayer().getSymbol();
        int row = cell.getRow();
        int column = cell.getColumn();
        int dimensions = board.getBoard().size();

        rowSymbolCounts.get(row).put(symbol, rowSymbolCounts.get(row).getOrDefault(symbol, 0) + 1);
        columnSymbolCounts.get(column).put(symbol, columnSymbolCounts.get(column).getOrDefault(symbol, 0) + 1);
        if (isCellOnTopLeftDiagonal(row, column)) {
            topLeftdiagonalSymbolCounts.put(symbol, topLeftdiagonalSymbolCounts.getOrDefault(symbol, 0) + 1);
        }
        if (isCellOnTopRightDiagonal(row, column)) {
            topRightdiagonalSymbolCounts.put(symbol, topRightdiagonalSymbolCounts.getOrDefault(symbol, 0) + 1);
        }

        return rowSymbolCounts.get(row).getOrDefault(symbol, 0) == dimensions ||
                columnSymbolCounts.get(column).getOrDefault(symbol, 0) == dimensions ||
                topLeftdiagonalSymbolCounts.getOrDefault(symbol, 0) == dimensions ||
                topRightdiagonalSymbolCounts.getOrDefault(symbol, 0) == dimensions;
    }
}
