import java.util.Scanner;

public class IO {
    private int n ;
    private int m ;

    int[] row_positive;
    int[] row_negative;

    int[] column_positive;
    int[] column_negative;
    String str0;
    String[] arrOfStr0;
    String str1;
    String[] arrOfStr1;
    String str2;
    String[] arrOfStr2;
    String str3;
    String[] arrOfStr3;
    String str4;
    String[] arrOfStr4;
    int[][] matrix;
    Scanner scanner = new Scanner(System.in);
    public void getInput(){


        str0 = scanner.nextLine();
        str1 = scanner.nextLine();
        str2 = scanner.nextLine();
        str3 = scanner.nextLine();
        str4 = scanner.nextLine();
        arrOfStr0 = str0.split(" ");
        arrOfStr1 = str1.split(" ");
        arrOfStr2 = str2.split(" ");
        arrOfStr3 = str3.split(" ");
        arrOfStr4 = str4.split(" ");
        coordinate();
        setMatrix();

    }
    public  void output(){

        for (int j=0 ; j<n ; j++){

            for (int k=0;k<m;k++){
                System.out.print(matrix[j][k]+" ");
            }
            System.out.println();
        }
        //System.out.println(n);
        //System.out.println(m);
        /*System.out.println(row_negative[0]);
        System.out.println(row_positive[4]);
        System.out.println(row_negative[3]);
        System.out.println(column_negative[1]);
        System.out.println(column_positive[2]);
*/

    }
    private void coordinate(){
        n = Integer.parseInt(arrOfStr0[0]);
        m = Integer.parseInt(arrOfStr0[1]);
        row_positive = new int[n];
        row_negative = new int[n];
        column_positive = new int[m];
        column_negative = new int[m];
        matrix = new int[n][m];

        for (int i = 0 ; i <n ; i++ ){
            row_positive[i] = Integer.parseInt(arrOfStr1[i]);
        }
        for (int i = 0 ; i <n ; i++ ){
            row_negative[i] = Integer.parseInt(arrOfStr2[i]);
        }
        for (int i = 0 ; i <m ; i++ ){
            column_positive[i] = Integer.parseInt(arrOfStr3[i]);
        }
        for (int i = 0 ; i <m ; i++ ){
            column_negative[i] = Integer.parseInt(arrOfStr4[i]);
        }
    }

    private void setMatrix(){
        for (int j=0 ; j<n ; j++){
            String str = scanner.nextLine();
            String[] arrOfStr = str.split(" ");
            for (int k=0;k<m;k++){
                matrix[j][k] = Integer.parseInt(arrOfStr[k]);
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}


/*

6 6
1 2 3 1 2 1
1 2 1 3 1 2
2 1 2 2 2 1
2 1 2 2 1 2
1 2 2 3 4 4
1 5 5 3 6 6
7 8 8 9 9 10
7 11 12 12 13 10
14 11 15 15 13 16
14 17 17 18 18 16

*/