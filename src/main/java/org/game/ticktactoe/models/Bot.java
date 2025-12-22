package org.game.ticktactoe.models;

import org.game.ticktactoe.factories.BotPlayingStrategyFactory;
import org.game.ticktactoe.strategies.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Bot(String name, char symbol, BotDifficultyLevel difficultyLevel){
        super(PlayerType.BOT, name, symbol);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this,board);
    }
}
