import java.util.ArrayList;
import java.util.LinkedList;

public class Algorithms {
    Constraint constraint = new Constraint();
    ArrayList<Place> tempPlace = new ArrayList<>();
   int[] save = new int[1000];
    int index= -1;
    Board board;
    public Algorithms(Board board){
        this.board = board;
    }
    public boolean backtrack(){
        return recursiveBacktrack(board);
    }
    private boolean recursiveBacktrack(Board board){
        Place temp = select(board);
        if(constraint.isProblemSatisfied(board)) return true;

        /// iteration in moves (PN,NP,E)

            Place current = select(board);
            for (int m = 0; m < 3; m++) {
                assign(board, current, m);
                if (!constraint.valueSatisfaction(current, board)) {
                    if (recursiveBacktrack(board)) return true;
                }
                unassigned(current);

            }


        return false;
    }

    private void assign(Board board,Place place,int m){
        if (place.isEmpty) {
            save[place.index] = 1;
        }else {
            if (!place.placedPiece.isNP) {
                save[place.index] = 2;
            } else {
                save[place.index] = 3;
            }
        }
        if (m==0) {
                board.setPiecePN(place);
                System.out.println("\n::::::::::\n");
                board.printer();
                /*if (constraint.valueSatisfaction(place,board)){
                    unassigned(place);
                }*/
                return;
            }
            if (m==1) {
                board.setPieceNP(place);
                System.out.println("\n::::::::::\n");
                board.printer();
               /* if (constraint.valueSatisfaction(place,board)){
                    unassigned(place);
                }*/
                return;
            }
            if (m==2) {
                board.setPieceE(place);
                System.out.println("\n::::::::::\n");
                board.printer();
                /*if (constraint.valueSatisfaction(place,board)){
                    unassigned(place);
                }*/
                return;
            }

    }
    private void unassigned(Place place){
        if (save[place.index]==1) {
            board.setPieceE(place);
        }else if (save[place.index]==2){
            board.setPiecePN(place);
        }else if (save[place.index]==3){
            board.setPieceNP(place);
        }
    }
    private Place select(Board board){
        index++;
        return board.places.get(index);
    }



}
