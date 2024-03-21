package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckWinner {
    int dimension;
    List<HashMap<String,Integer>> rowCountmap=new ArrayList<>();
    List<HashMap<String,Integer>> colCountmap=new ArrayList<>();
    HashMap<String,Integer> leftdiagonal=new HashMap<>();
    HashMap<String,Integer>  rightDiagonal=new HashMap<>();

    CheckWinner(int dimension){
        this.dimension=dimension;
        for (int i=0;i<dimension;i++){
            rowCountmap.add(new HashMap<>());
            colCountmap.add(new HashMap<>());
        }

    }
    public boolean checkWinner(Board board,Move move){
        System.out.println("debug");
        String symbol=move.getPlayer().getSymbol();
        int row=move.cell.getRow();
        int col=move.cell.getCol();
     //   System.out.println("debug");
        if(!rowCountmap.get(row).containsKey(move.getPlayer().getSymbol())) {
            rowCountmap.get(row).put(move.getPlayer().getSymbol(), 0);
            System.out.println("debug in inner row count");
        }
        rowCountmap.get(row).put(move.getPlayer().getSymbol(),rowCountmap.get(row).get(move.getPlayer().getSymbol())+1);
        if(rowCountmap.get(row).get(symbol)==dimension) return true;

        if(!colCountmap.get(col).containsKey(symbol)){
            colCountmap.get(col).put(symbol,0);
            System.out.println("debug in inner col count");

        }
        colCountmap.get(col).put(symbol,colCountmap.get(col).get(symbol)+1);
        if(colCountmap.get(col).get(symbol)==dimension) return true;

        if(row==col){
            if(!leftdiagonal.containsKey(symbol))
                leftdiagonal.put(symbol,0);
            leftdiagonal.put(symbol,leftdiagonal.get(symbol)+1);
            System.out.println("debug in inner left diagonal");
            if(leftdiagonal.get(symbol)==dimension) return true;

        }
        if(row+col==dimension-1){
            if(!rightDiagonal.containsKey(symbol))
                rightDiagonal.put(symbol,0);
            rightDiagonal.put(symbol,rightDiagonal.get(symbol)+1);
            System.out.println("debug in inner right diagonal");
            if(rightDiagonal.get(symbol)==dimension) return false;

        }
        /*for(int i=0;i<dimension;i++){
            if(rowCountmap.get(i).get(symbol)==dimension) {

                return true;
            }
            if(colCountmap.get(i).get(symbol)==dimension)
                return  true;
        }
        if(leftdiagonal.get(symbol)==dimension) return true;
        if(rightDiagonal.get(symbol)==dimension) return true;*/
        return false;
    }

}
