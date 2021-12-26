import java.util.ArrayList;
import java.util.List;

public class Board {
    int n, m;
    int[] row_positive;
    int[] row_negative;
    Node[][] nodes;
    int[][] matrix;
    int[] column_positive;
    int[] column_negative;
    ArrayList<Place> places = new ArrayList<>();

    public void boardCreator() {

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

    }




    private Place placeCreator(int i1, int j1, int i2, int j2, boolean isVertical) {
        Node tempNode1;
        Node tempNode2;
        Place tempPlace;
        tempNode1 = new Node(i1, j1, true);
        nodes[i1][j1] = tempNode1;
        tempNode2 = new Node(i2, j2, false);
        nodes[i2][j2] = tempNode2;
        tempPlace = new Place(tempNode1, tempNode2, isVertical);
        return tempPlace;
    }

    public void setPieceE(Place p){
        p.setPlacedPieceEmpty();
    }
    public void setPieceNP(Place p){
        p.setPlacedPieceNP();
    }
    public void setPiecePN(Place p){
        p.setPlacedPiecePN();
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
    public void printer(){
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
    }
}