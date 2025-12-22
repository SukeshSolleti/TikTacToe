package org.game.ticktactoe.controller;

import org.game.ticktactoe.models.Game;
import org.game.ticktactoe.models.GameState;
import org.game.ticktactoe.models.Player;

import java.util.List;

public class GameController {

    public void undoMove(Game game){
        game.undoMove();
    }

    public Game createGame(int dimensions, List<Player> players){
        try{
            return Game.getBuilder().setDimensions(dimensions).setPlayers(players).build();
        }catch (Exception e){
            return null;
        }
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameState getGameState(Game game){
        return game.getState();
    }

    public void nextMove(Game game){
        game.nextMove();
    }

}
