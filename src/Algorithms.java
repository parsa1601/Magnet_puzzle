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
        System.out.println("Enter");

        while (temp.legalValueNum>0) {
            System.out.println(temp.index);
            System.out.println("Enter2");
            // Value chosen =LCV(temp);
            Value chosen = new Value();
            for (int i =0 ; i<3;i++) {
                chosen=temp.legalValue.get(i);
                if (chosen.isLegal) {
                    System.out.println("Enter : " + chosen.str);
                    board.assign(temp, chosen);
                    board.printer();

                    if (recursiveBacktrack()) {
                        return true;
                    } else {
                        board.undoAssign(temp);
                        board.printer();
                    }
                }
            }
        }
       /* if (constraint.isProblemSatisfied(board)) return true;
        Place temp = new Place();
        temp = MRV();
        //board.assign(temp,temp.legalValue.get(1));
        board.assign(temp,LCV(temp));
        if (recursiveBacktrack()) return true;
        board.undoAssign(temp);*/

        return false;
    }

    // LCV
    private Value LCV(Place place){
        int x1=0 ,x2=0;
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


        if ( x1>=x2 ){
            return place.legalValue.get(0);
        }else if (x2>x1){
            return place.legalValue.get(1);
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