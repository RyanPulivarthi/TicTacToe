package Models;

public class Cell {
    Player player;
    int row;
    int col;
    CellState cellState;

    public Cell(int row,int col,CellState cellState){
        this.row=row;
        this.col=col;
        this.cellState=cellState;
    }
    public Cell(int row,int col,Player player){
        this.row=row;
        this.col=col;
        this.player=player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
