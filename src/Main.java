import Controller.Controller;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Controller controller=new Controller();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to TicTacToe Game");
        System.out.println("Enter the dimensions of the board");
        int n=scanner.nextInt();
        if(n<=2) return;
        int playerIndex=0;

        List<Player> players=new ArrayList<>();
        for(int i=0;i< n-1;i++){
            System.out.println("Enter name of player "+(i+1));
            String name=scanner.next();
            System.out.println("Enter the symbol of the player");
            String symbol=scanner.next();
            players.add(new Player(name,symbol));
        }
        Game game=controller.createGame(n,players, GameStatus.IN_PROGRESS);
        System.out.println("Debug");
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            System.out.println("debug");
            controller.display(game);
            System.out.println("Enter row :");
            int row=scanner.nextInt();
            System.out.println("Enter col :");
            int col=scanner.nextInt();

         //   controller.makeMove(new Cell(row,col,CellState.FILLED),players.get(playerIndex++),game);

        }
        if (game.getGameStatus().equals(GameStatus.DRAW)){
            System.out.println("The game is Draw");
            return;
        }
        else if(game.getGameStatus().equals(GameStatus.WIN)){
            //code for winner
            System.out.println(game.getWinner());
        }


    }
}