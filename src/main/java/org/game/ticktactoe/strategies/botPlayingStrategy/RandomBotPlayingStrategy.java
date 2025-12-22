package org.game.ticktactoe.strategies.botPlayingStrategy;

import org.game.ticktactoe.models.*;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move decideMove(Player player, Board board) {
        for(int i=0;i<board.getBoard().size();i++){
            for(int j=0;j<board.getBoard().get(i).size();j++){
                if(board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    return new Move(new Cell(i,j), player);
                }
            }
        }
        return null;
    }
}
