public class Node {
    // left or top
    boolean isFirst;
    boolean isEmpty;
    boolean isPositive;
    Node neighbour;
    int rowNum;
    int columnNum;

    public Node(int rowNum,int columnNum,boolean isFirst){
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        this.isFirst = isFirst;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public Node getNeighbour() {
        return neighbour;
    }
}