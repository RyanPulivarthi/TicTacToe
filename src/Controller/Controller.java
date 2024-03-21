package Controller;

import Models.Cell;
import Models.Game;
import Models.GameStatus;
import Models.Player;
import javafx.util.Builder;

import java.util.List;

public class Controller {
    public Game createGame(int dimension, List<Player> players, GameStatus gameStatus){
        Game game= Game.builder().setDimensions(dimension).setPlayers(players).build();
        return game;
    }
     public void  makeMove(Game game){
        game.makeMove();

    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public void display(Game game){
         game.getBoard().display();
    }
    public void undo(Game game){
        game.undo();
    }
}
