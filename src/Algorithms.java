//public class Algorithms {
/*    Board board;
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
// start
/*
public class Algorithms {
    Board board;


    Constraint constraint = new Constraint();

    public Algorithms(Board board) {
        this.board = board;
    }

    public boolean backtrack() {
//        Array
        return recursiveBacktrack();
    }

    private boolean recursiveBacktracking_FC() {
        if (constraint.isProblemSatisfied(board)) return true;
        if (board.FC_alert()) {
            return false;
        }
        return false;
    }

    private boolean recursiveBacktrack() {
        //if problem solved return true;
        if (constraint.isProblemSatisfied(board)) return true;
        Place temp = MRV();
        // System.out.println("Enter");
        while (temp.legalValueNum > 0) {
            //System.out.println(temp.index);
            //System.out.println("Enter2");
            // Value chosen =LCV(temp);
            Value chosen = new Value();
            for (int i = 0; i < 3; i++) {
                chosen = temp.legalValue.get(i);
                if (constraint.isThisValueLegal(board, temp, chosen)
                &&constraint.isValueInDomain(temp,chosen)) {
                    board.assign(temp, chosen);

                    *//*if (forwardChecking(temp)){
                        board.undoAssign(temp);
                        return false;
                    }*//*

                    if (recursiveBacktrack()) {
                        AC3(temp);
                        return true;
                    } else {
                        board.undoAssign(temp);
                    }
                }
            }
        }
       *//* if (constraint.isProblemSatisfied(board)) return true;
        Place temp = new Place();
        temp = MRV();
        //board.assign(temp,temp.legalValue.get(1));
        board.assign(temp,LCV(temp));
        if (recursiveBacktrack()) return true;
        board.undoAssign(temp);*//*
        AC3(temp);
        return false;
    }

    // LCV
    private Value LCV(Place place) {
        int x1 = 0, x2 = 0;
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


        if (x1 >= x2) {
            return place.legalValue.get(0);
        } else {
            return place.legalValue.get(1);
        }


    }

    // MRV
    private Place MRV() {
        int min = 10;
        int indexOfMin = 0;

        for (int i = 0; i < board.places.size(); i++) {
            // if (board.places.get(i).isAssign) continue;
            if (!board.places.get(i).isAssign) {
                if (board.places.get(i).legalValueNum <= min) {
                    indexOfMin = i;
                    min = board.places.get(i).legalValueNum;

//                    System.out.println("Enter IFFFFFFFFFFFFF");
//                    System.out.println("helli i am " + i + " - " +  board.places.get(i).legalValueNum + " my is assign " + board.places.get(i).isAssign);
//                    if ( i == 2 ) {
//                        try {
//                            wait(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                }
            }
        }
        return board.places.get(indexOfMin);
    }

    private boolean forwardChecking(Place place) {
        if (constraint.wontSatisfy(board,place)){
            return true;
        }
        return false;
    }

    private void AC3(Place place) {
        if (constraint.wontSatisfy(board,place)){
            if (place.currentValue.isEmpty){
                place.is_E_NotInDomain = true;
            }else {
                if (place.currentValue.isPN) {
                    place.is_PN_NotInDomain = true;
                } else {
                    place.is_NP_NotInDomain = true;
                }
            }
        }

    }


*//*
    private boolean isAllFriendAssigned(Place place) {
        boolean flag = true;
        for (Place p : place.friendList) {
            if (!p.isAssign) {
                flag = false;
            }
        }
        return flag;
    }*//*
}*/
// end

// new start

public class Algorithms {

    Board board;
    Constraint constraint = new Constraint();

    public Algorithms(Board board) {
        this.board = board;
    }

    public boolean backtrack() {
        return recursiveBacktrack();
    }

    private boolean recursiveBacktrack() {
        if (allAssign()) {
            if (constraint.isProblemSatisfied(board)) {
                return true;
            } else {
                return false;
            }
        }
        Place temp = MRV();
        Value chosen;
        for (Value v : temp.legalValue) {
            // age LCV nabud hamin halqe be tartib
            //chosen = LCV(temp);
            chosen = v;
            AC3(temp);
            if (constraint.isThisValueLegal(board, temp, chosen)
                    && constraint.isValueInDomain(temp, chosen)&& !forwardChecking(temp)) {
                board.assign(temp, chosen);

                if (recursiveBacktrack()) {
                    return true;
                } else {
                    board.undoAssign(temp);
                }

            }

        }
        return false;
    }

    private boolean allAssign() {
        boolean flag = true;
        for (Place p : board.places) {
            if (!p.isAssign)
                flag = false;
        }
        return flag;
    }

    private Place MRV() {
        int min = 10;
        int indexOfMin = 0;

        for (int i = 0; i < board.places.size(); i++) {
            if (!board.places.get(i).isAssign) {
                if (board.places.get(i).legalValueNum < min) {
                    indexOfMin = i;
                    min = board.places.get(i).legalValueNum;
                    // degree heuristic
                } else if (board.places.get(i).legalValueNum == min) {
                    if (board.places.get(i).friendList.size() > board.places.get(indexOfMin).friendList.size()) {
                        indexOfMin = i;
                        min = board.places.get(i).legalValueNum;
                    }
                }
            }
        }
        return board.places.get(indexOfMin);
    }

    private Value LCV(Place place) {
        if (place.tried > 2) {
            int x1 = 0, x2 = 0;
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

            place.tried++;
            if (x1 >= x2) {
                return place.legalValue.get(0);
            } else {
                return place.legalValue.get(1);
            }
        }
        if (place.tried == 2) {
            place.tried = 0;
            return place.legalValue.get(2);

        }
        return place.legalValue.get(2);
    }

    private void AC3(Place place) {
        if (constraint.wontSatisfy(board, place)) {
            if (place.currentValue.isEmpty) {
                place.is_E_NotInDomain = true;
            } else {
                if (place.currentValue.isPN) {
                    place.is_PN_NotInDomain = true;
                } else {
                    place.is_NP_NotInDomain = true;
                }
            }
        }

    }

    private boolean forwardChecking(Place place) {
        if (constraint.wontSatisfy(board, place)) {
            return true;
        }
        return false;
    }
}

// new end

///Last commit