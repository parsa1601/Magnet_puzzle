public class Place {

    Node firstNode ;
    Node secondNode;

    boolean isEmpty ;
    boolean isVertical;
    Piece placedPiece;

    boolean isFirstPositive;
    boolean isSecondPositive;

    public Place(Node firstNode,Node secondNode,boolean isVertical){
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.isVertical = isVertical;
        this.isEmpty = true;
        this.firstNode.neighbour = this.secondNode;
        this.secondNode.neighbour = this.firstNode;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public void setPiecePN(Place p){

    }
    public void setPieceNP(Place p){

    }
    public void setPieceEmpty(Place p){

    }
}
