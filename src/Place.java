public class Place {

    Node firstNode ;
    Node secondNode;

    boolean isEmpty ;
    boolean isVertical;
    Piece placedPiece ;

    boolean isFirstPositive;
    boolean isSecondPositive;

    public Place(Node firstNode,Node secondNode,boolean isVertical){
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.isVertical = isVertical;
        this.isEmpty = true;
        this.firstNode.neighbour = this.secondNode;
        this.secondNode.neighbour = this.firstNode;
        placedPiece = new Piece() ;
    }
    public  Place (Piece piece,boolean isVertical){
        this.placedPiece =piece;
        this.isEmpty = isVertical;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public void setPlacedPieceEmpty() {
        placedPiece.setPieceEmpty(this);

    }
    public void setPlacedPiecePN() {
        placedPiece.setPiecePN(this);
    }
    public void setPlacedPieceNP() {
        placedPiece.setPieceNP(this);
    }

}
