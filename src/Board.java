import java.util.ArrayList;
import java.util.List;

public class Board {
    int n, m;
    int sumOFLegals;
    int[] row_positive;
    int[] row_negative;
    Node[][] nodes;
    int[][] matrix;
    int[] column_positive;
    int[] column_negative;
    ArrayList<Place> places = new ArrayList<>();
    int i =0;
    Constraint constraint = new Constraint();
    public void boardCreator() {
        sumOFLegals = 0;
        IO io = new IO();
        io.getInput();
        io.output();
        matrix = io.getMatrix();
        n = io.getN();
        m = io.getM();
        nodes = new Node[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == n - 1 && j == m - 1) {
                    continue;
                } else if (j == m - 1) {
                    if (matrix[i][j] == matrix[i + 1][j]) {
                        places.add(placeCreator(i, j, i + 1, j, true));
                    }
                } else if (i == n - 1) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        places.add(placeCreator(i, j, i, j + 1, false));

                    }
                } else if (i != n - 1 && j != m - 1) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        places.add(placeCreator(i, j, i, j + 1, false));
                    } else if (matrix[i][j] == matrix[i + 1][j]) {
                        places.add(placeCreator(i, j, i + 1, j, true));
                    }

                }

            }
        }

        row_positive = io.row_positive;
        row_negative = io.row_negative;
        column_positive = io.column_positive;
        column_negative = io.column_negative;
        update();
        makeThemFriend();
    }
    private void makeThemFriend(){
        for (int i =0;i< places.size();i++){
            for (int j=0;j< places.size();j++){
                if (i==j){
                    continue;
                }else{
                    if (border(places.get(i).first,places.get(j).first)){
                        places.get(i).addFriend(places.get(j));
                        continue;
                    }if (border(places.get(i).first,places.get(j).second)){
                        places.get(i).addFriend(places.get(j));
                        continue;
                    }if (border(places.get(i).second,places.get(j).first)){
                        places.get(i).addFriend(places.get(j));
                        continue;
                    }if (border(places.get(i).second,places.get(j).second)){
                        places.get(i).addFriend(places.get(j));
                        continue;
                    }
                }
            }
        }
    }

    private boolean border(Node me , Node neighbour){
        if (me.rowNum==neighbour.rowNum&&me.columnNum-1==neighbour.columnNum){
            return true;
        }if (me.rowNum==neighbour.rowNum&&me.columnNum+1==neighbour.columnNum){
            return true;
        }if (me.rowNum-1==neighbour.rowNum&&me.columnNum==neighbour.columnNum){
            return true;
        }if (me.rowNum+1==neighbour.rowNum&&me.columnNum==neighbour.columnNum){
            return true;
        }
        return false;
    }

    private Place placeCreator(int i1, int j1, int i2, int j2, boolean isVertical) {

        Node tempNode1;
        Node tempNode2;
        Place tempPlace;
        tempNode1 = new Node(i1, j1, true);
        nodes[i1][j1] = tempNode1;
        tempNode2 = new Node(i2, j2, false);
        nodes[i2][j2] = tempNode2;
        tempPlace = new Place(tempNode1, tempNode2, isVertical,i);
        i++;
        return tempPlace;
    }



    public void debug(){
        int c=0;
        /**
        for (Place p : places){
            System.out.println("this is place:");
            System.out.println(c);
            System.out.println(p.isVertical);
            System.out.println("this is place first node:");
            System.out.println(p.getFirstNode().getRowNum());
            System.out.println(p.getFirstNode().getColumnNum());
            System.out.println("this is place second node:");
            System.out.println(p.getSecondNode().getRowNum());
            System.out.println(p.getSecondNode().getColumnNum());
            c++;
        }**/
        System.out.println(row_positive[0]);


    }
    public void assign(Place place,Value value){
        place.setPlaceAssign(value);
        update();
    }
    public void undoAssign(Place place){

        place.setPlaceUndoAssign();
        update();
    }
    private void update(){
        // for all place call self updater.
        sumOFLegals=0;
        for (Place p : places){
            placeUpdater(p);
            sumOFLegals += p.legalValueNum;
        }
    }
    private void update_A(){
        // for all place call self updater.
        sumOFLegals=0;
        for (Place p : places){
            placeUpdater_A(p);
            sumOFLegals += p.legalValueNum;
        }
    }
    public boolean FC_alert(){
        // for all place call self updater.
        for (Place p : places){
            if (p.legalValueNum==0) return true;
        }
        return false;
    }
    private void placeUpdater(Place place){
        //System.out.println("old");
        place.legalValueNum=0;
        place.NoLegalValueLeft =false;
        /*place.legalValue.get(0).isLegal = false;
        place.legalValue.get(1).isLegal = false;
        place.legalValue.get(2).isLegal = false;*/
        for (int i =0;i<3;i++){
            if(constraint.isThisValueLegal(this,place,place.legalValue.get(i))&& !place.isAssign){
                place.legalValue.get(i).isLegal = true;
                place.legalValueNum++;
            }
        }
        if (place.legalValueNum==0)  place.NoLegalValueLeft =true;
    }
    private void placeUpdater_A(Place place){
        place.legalValueNum=0;
        place.NoLegalValueLeft =false;
        //System.out.println("a");
       /* place.legalValue.get(0).isLegal = false;
        place.legalValue.get(1).isLegal = false;
        place.legalValue.get(2).isLegal = false;*/
        for (int i =0;i<3;i++){
           /* System.out.println(place.legalValue.get(i).str);
            System.out.println(place.currentValue.str);
            System.out.println(place.isAssign);*/
            if (place.legalValue.get(i).str.equals(place.currentValue.str)&& place.isAssign){
               /* System.out.println("in the if");
                System.out.println(place.legalValue.get(i).str);
                System.out.println(place.isAssign);
                System.out.println(place.legalValue.get(i).isLegal);*/
                place.legalValue.get(i).isLegal = false;
                //System.out.println(place.legalValue.get(i).isLegal);
               // System.out.println("^^^^^");
            }else if(constraint.isThisValueLegal(this,place,place.legalValue.get(i))){
               /* System.out.println("second if");
                System.out.println(place.index);
                System.out.println(i);
                System.out.println(place.legalValue.get(i).isLegal);
                System.out.println("&&&&&");*/
                place.legalValue.get(i).isLegal = true;
                place.legalValueNum++;
            }
        }
        if (place.legalValueNum==0)  place.NoLegalValueLeft =true;
    }
    public void printer(){
        System.out.println("*********");
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nodes[i][j].isEmpty){
                    System.out.print("#  ");
                }else {
                    if(nodes[i][j].isPositive){
                        System.out.print("+  ");
                    }else {
                        System.out.print("-  ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("^^^^^^^^");
    }
}

///Forward checking logic
//temp ---> isAssaigned {
//        for (i iterates in all friendsList){
//          board.update
//        friend(i).ligalValues.update
//            if one of them empty backtrack
//        if (temp.fristIndex is +){
//        rowPositive[fristIndex]--
//        rowNegetive[secondIndex]--
//        columnPositive[firstIndex]--
//        columnNegative[secondIndex]--
//          board.upddate()
//        }else{
//        rowPositive[secondIndex]--
//        rowNegetive[firstIndex]--
//        columnPositive[secondIndex]--
//        columnNegative[firstIndex]--
//            board.upddate()
//        }
//        }
//}