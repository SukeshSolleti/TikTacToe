package org.game.ticktactoe.models;

import org.game.ticktactoe.exceptions.InvalidGameConstructionParameters;
import org.game.ticktactoe.strategies.gameWinningStrategy.GameWinningStrategy;
import org.game.ticktactoe.strategies.gameWinningStrategy.OrderOneGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState state;
    private Player winner;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private int nextMoveIndex;

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    private GameWinningStrategy gameWinningStrategy;

    public static Builder getBuilder(){
        return new Builder();
    }
    private Game(){}

    public void displayBoard(){
        this.board.displayBoard();
    }

    public void nextMove(){
        Player playerToMove = players.get(nextMoveIndex);

        System.out.println(playerToMove.getName() + " it's your turn");

        Move move = playerToMove.decideMove(this.board);


        //validate Move

        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        System.out.println("Move happened at row: " + row + " column: " + column + " by player: " + playerToMove.getName() + "");
        move.getCell().setCellState(CellState.Filled);
        board.getBoard().get(row).set(column, move.getCell());
        board.getBoard().get(row).get(column).setPlayer(playerToMove);
        this.moves.add(new Move(board.getBoard().get(row).get(column), playerToMove));
        if(gameWinningStrategy.checkForWin(playerToMove, board, move.getCell())){
            state = GameState.ENDED;
            this.setWinner(playerToMove);
        }
        nextMoveIndex = (nextMoveIndex + 1) % players.size();
    }

    public void undoMove(){
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public int getNextMoveIndex() {
        return nextMoveIndex;
    }

    public void setNextMoveIndex(int nextMoveIndex) {
        this.nextMoveIndex = nextMoveIndex;
    }

    public static class Builder{
        private int dimensions;
        private List<Player> players;

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public boolean valid() throws InvalidGameConstructionParameters {
            if(dimensions < 3 || players.size() != 2){
                throw new InvalidGameConstructionParameters("Players or dimensions are wrong");
            }

            //Validate no two people have the same character

            //only one bot
            return true;
        }

        public Game build() throws InvalidGameConstructionParameters{
            try{
                valid();
            }
            catch(Exception e){
                throw new InvalidGameConstructionParameters(e.getMessage());
            }

            Game game = new Game();
            game.setState( GameState.InProgress);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setBoard(new Board(dimensions));
            game.setNextMoveIndex(0);
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimensions));
            return game;
        }
    }
}
