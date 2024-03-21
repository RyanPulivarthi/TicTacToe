package Models;

import javafx.util.Builder;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;

    List<Move> moves;
    GameStatus gameStatus;
    Player winner;
    int nextPlayerIndex;
    public static Builder builder(){
        return new Builder();
    }
    private Game(){}
    /*public Game(int dimensions,List<Player> players,GameStatus gameStatus){
        this.dimensions=dimensions;
        this.players=players;
        this.gameStatus=gameStatus;
    }*/

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public void makeMove(Cell cell,Player player){
        Move move=new Move(cell,player);
        moves.add(move);
    }



    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void display() {
        //System.out.println("| "+this.getPlayerList().ge);
    }

    public void undo() {
        moves.remove(moves.size()-1);
    }
    public static class Builder{
        int dimensions;

        List<Player> players;
        public Builder setPlayers(List<Player> playerList) {
            this.players = playerList;
            return this;
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Game build(){
            Game game=new Game();
            game.setBoard(new Board(dimensions));
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
          //  game.setPlayerList(players);
          //  game.nextPlayerIndex=0;
            return game;
        }
    }
}
