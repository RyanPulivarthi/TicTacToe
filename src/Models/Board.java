package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> cells;
    int dimension;
    Board(int dimension){
        this.dimension=dimension;
        cells=new ArrayList<>();
        for(int i=0;i<dimension;i++){
            this.cells.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                this.cells.get(i).add(new Cell(i,j,CellState.EMPTY));
            }
        }
    }
    public void display(){
        for(int i=0;i<dimension;i++){
            for (int j=0;j<dimension;j++){
                if(cells.get(i).get(j).getCellState().equals(CellState.EMPTY))
                    System.out.println("| |");
                System.out.println("|"+cells.get(i).get(j).getPlayer().getSymbol()+"|");
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }
}
