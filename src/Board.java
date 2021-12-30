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
    private void placeUpdater(Place place){
        place.legalValueNum=0;
        place.NoLegalValueLeft =false;
        for (int i =0;i<3;i++){
            if(constraint.isThisValueLegal(this,place,place.legalValue.get(i))){
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