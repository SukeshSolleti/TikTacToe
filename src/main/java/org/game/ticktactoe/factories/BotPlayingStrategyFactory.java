package org.game.ticktactoe.factories;

import org.game.ticktactoe.models.BotDifficultyLevel;
import org.game.ticktactoe.strategies.botPlayingStrategy.BotPlayingStrategy;
import org.game.ticktactoe.strategies.botPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
        return new RandomBotPlayingStrategy();
    }
}
