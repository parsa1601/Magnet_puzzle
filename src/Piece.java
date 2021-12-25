public class Piece {

   boolean isEmpty; // no magnet
    boolean isNP; // false -> PN , true -> NP

    public Piece(){
        this.isEmpty=true;
    }
    public void setPiecePN(Place p){
        p.firstNode.changeMeP();
        p.secondNode.changeMeN();
        p.placedPiece.isEmpty =false;
        p.placedPiece.isNP = false;


    }
    public void setPieceNP(Place p){
        p.firstNode.changeMeN();
        p.secondNode.changeMeP();
        p.placedPiece.isEmpty =false;
        p.placedPiece.isNP = true;


    }
    public void setPieceEmpty(Place p){
        p.firstNode.changeMeE();
        p.secondNode.changeMeE();
        p.placedPiece.isEmpty =true;


    }

}
