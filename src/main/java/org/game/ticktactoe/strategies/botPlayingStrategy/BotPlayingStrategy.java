package org.game.ticktactoe.strategies.botPlayingStrategy;

import org.game.ticktactoe.models.Board;
import org.game.ticktactoe.models.Move;
import org.game.ticktactoe.models.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player, Board board);
}
