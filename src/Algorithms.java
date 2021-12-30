/*


public class Algorithms {
    Board board;
    int[] save = new int[1000];
    Place p ;

    Constraint constraint = new Constraint();

    public Algorithms(Board board) {
        this.board = board;
    }

    public boolean backtrack() {
        return recursiveBacktrack();
    }

    private boolean recursiveBacktrack() {
        if (constraint.isProblemSatisfied(board)){

            return true;
        }

        Place tempP = selectVariable();
        if (tempP==null){
            //System.out.println("error");
        }
        for (int i=0;i<3;i++) {

                if (constraint.valueSatisfaction(tempP,board)){
                    //System.out.println("error333");
                    if (recursiveBacktrack()) return true;
                }
                unassigned(tempP);
            System.out.println("unassigned : ");
            board.printer();
        }
        return false;
    }
    private void unassigned(Place var) {


    }
    private void assign(Place var, Piece val) {

    }
    // LCV
    private Piece selectValue(Place place){

    }
    // MRV
    private Place selectVariable() {

    }
}
*/

public class Algorithms {
    Board board;
    Constraint constraint = new Constraint();
    public Algorithms(Board board){
        this.board = board;
    }
    public boolean backtrack(){
        return recursiveBacktrack();
    }
    private boolean recursiveBacktrack(){
        //if problem solved return true;
        if (constraint.isProblemSatisfied(board)) return true;
        Place  temp = MRV();
        for (int i = 0; i<3;i++) {
            Value chosen = LCV(temp);
            if (constraint.isThisValueLegal(board, temp, chosen)) {
                board.assign(temp, chosen);
                board.printer();
            }
            if (recursiveBacktrack()) {
                return true;
            } else {
                board.undoAssign(temp);
                board.printer();
            }
        }

        return false;
    }

    // LCV
    private Value LCV(Place place){
        int x1=0 ,x2=0,x3=0;
        if (place.legalValue.get(0).isLegal) {
            board.assign(place, place.legalValue.get(0));
            x1 = board.sumOFLegals;
            board.undoAssign(place);
        }
        if (place.legalValue.get(1).isLegal) {
            board.assign(place, place.legalValue.get(1));
            x2 = board.sumOFLegals;
            board.undoAssign(place);
        }
        if (place.legalValue.get(2).isLegal) {
            board.assign(place, place.legalValue.get(2));
            x3 = board.sumOFLegals;
            board.undoAssign(place);
        }
        if ( x1>=x2 && x1>=x3){
            return place.legalValue.get(0);
        }else if (x2>=x1&&x2>=x3){
            return place.legalValue.get(1);
        }else if (x3>=x1 && x3>=x2){
            return place.legalValue.get(2);
        }
         return place.legalValue.get(2);
    }
    // MRV
    private Place MRV(){
        int min = 10;
        int indexOfMin =0;
        for (int i =0;i<board.places.size();i++){
            if (!board.places.get(i).isAssign){
                if (board.places.get(i).legalValueNum<min){
                    indexOfMin = i;
                    min = board.places.get(i).legalValueNum;
                }
            }
        }
        return board.places.get(indexOfMin);
    }
}