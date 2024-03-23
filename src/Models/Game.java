package Models;

import javafx.util.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    CheckWinner checkWinner;
    Board board;
    List<Player> players;

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
    public void setPlayers(List<Player> playerList) {
        this.players = playerList;
    }

    public Board getBoard() {
        return board;
    }

    public CheckWinner getCheckWinner() {
        return checkWinner;
    }

    public void setCheckWinner(CheckWinner checkWinner) {
        this.checkWinner = checkWinner;
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
    public void makeMove(){
        Player playerToMove=players.get(nextPlayerIndex++);
        System.out.println("It's "+playerToMove.getName()+"'s turn");
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter row: ");
        int row=scanner.nextInt();
        System.out.println("Enter Col: ");
        int col=scanner.nextInt();

        if(board.getCells().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            //make a move
         //   System.out.println("Debug");
            Cell cell=new Cell(row,col,CellState.FILLED);
            cell.setPlayer(playerToMove);

            Move move=new Move(cell,playerToMove);

            moves.add(move);
            //System.out.println("debug");
            if(checkWinner.checkWinner(board,move)){
                this.setGameStatus(GameStatus.WIN);
                System.out.println(playerToMove.getName()+" has won the game");
            }
            System.out.println("debug in outside if");
            nextPlayerIndex%= board.dimension;


        }
        else {
            //Exception
        }

    }




    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
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
            game.setPlayers(players);
            game.setCheckWinner(new CheckWinner(dimensions));
            game.nextPlayerIndex=0;
            return game;
        }
    }
}
