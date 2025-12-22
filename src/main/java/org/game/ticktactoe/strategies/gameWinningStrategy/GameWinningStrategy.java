package org.game.ticktactoe.strategies.gameWinningStrategy;

import org.game.ticktactoe.models.Board;
import org.game.ticktactoe.models.Cell;
import org.game.ticktactoe.models.Player;

public interface GameWinningStrategy {
    boolean checkForWin(Player player, Board board, Cell cell);
}
