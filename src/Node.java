public class Node {
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
        this.isEmpty =true;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }
    public void changeMeP(){
        this.isEmpty =false;
        isPositive = true;
    }
    public void changeMeN(){
        this.isEmpty =false;
        isPositive = false;
    }
    public void changeMeE(){
        isPositive = false;
        this.isEmpty = true;

    }
}
