package org.game.ticktactoe;

import org.game.ticktactoe.controller.GameController;
import org.game.ticktactoe.models.*;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TickTacToeApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TickTacToeApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Please enter the dimensions of the board");
        int dimensions = scanner.nextInt();
        int toIterate = dimensions - 1;

        System.out.println("Is there going to be a bot? y/n");
        String isBot = scanner.next();

        List<Player> players = new ArrayList<>();

        if(isBot.equals("y")){
            System.out.println("Please enter the difficulty level of the bot:");
            String difficulty = scanner.next();
            System.out.println("Please enter the name of the bot");
            String botName = scanner.next();
            System.out.println("Please enter the symbol for the bot");
            String botSymbol = scanner.next();
            players.add(new Bot(botName, botSymbol.charAt(0), BotDifficultyLevel.valueOf(difficulty)));
            toIterate--;
        }


        for(int i = 0; i < toIterate; i++){
            System.out.println("Please enter the name of player " + (i+1));
            String playerName = scanner.next();
            System.out.println("Please enter the symbol for player " + (i+1));
            char playerSymbol = scanner.next().charAt(0);
            players.add(new Player(PlayerType.HUMAN,playerName,playerSymbol));
        }
        Game game = gameController.createGame(dimensions,players);

        while(gameController.getGameState(game).equals(GameState.InProgress)){
            System.out.println("This is the current board: ");

            //print the board
            gameController.displayBoard(game);

            System.out.println("Does anyone want to undo? y/n");

            String undo = scanner.next();
            if(undo.equals("y")){
                //undo logic
                gameController.undoMove(game);
            }else{
                gameController.nextMove(game);
            }
        }

        System.out.println("Game Has Ended. Result was:");
        if(!gameController.getGameState(game).equals(GameState.Draw)){
            gameController.displayBoard(game);
            System.out.println("Winner was: " + game.getWinner().getName());
        }

    }

}
