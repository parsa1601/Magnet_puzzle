import java.util.ArrayList;

public class Place {

    Node firstNode ;
    Node secondNode;
    int index;
    //int m  ; // 0 not set . 1 PN . 2 NP . 3 E
    boolean isEmpty ;
    boolean isVertical;
     Piece placedPiece ;

    ArrayList<Piece> values = new ArrayList<>();
    boolean isFirstPositive;
    boolean isSecondPositive;

    public Place(Node firstNode,Node secondNode,boolean isVertical,int i){
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.isVertical = isVertical;
        this.isEmpty = true;
        this.firstNode.neighbour = this.secondNode;
        this.secondNode.neighbour = this.firstNode;
        placedPiece = new Piece() ;
        values.add(new Piece("PN"));
        values.add(new Piece("NP"));
        values.add(new Piece());
        this.index = i ;

    }
    public  Place (Piece piece,boolean isVertical){
        this.placedPiece =piece;
        this.isVertical = isVertical;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public void setPlacedPieceEmpty() {
        placedPiece.setPieceEmpty(this);
        this.isEmpty = true;

    }
    public void setPlacedPiecePN() {
        placedPiece.setPiecePN(this);
        isFirstPositive =true;
        isSecondPositive=false;
        this.isEmpty = false;
    }
    public void setPlacedPieceNP() {
        placedPiece.setPieceNP(this);
        isFirstPositive =false;
        isSecondPositive=true;
        this.isEmpty = false;
    }

    public Piece getPlacedPiece() {
        return placedPiece;
    }
}
