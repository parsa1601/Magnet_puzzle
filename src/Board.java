import java.util.ArrayList;
import java.util.List;

public class Board {
    int n,m;
    ArrayList<Place> places = new ArrayList<>();

    public void boardCreator(){

        IO io = new IO();
        io.getInput();
        io.output();
        int[][] matrix = io.getMatrix();
        n=io.getN();
        m=io.getM();
        for (int i=0;i<n;i++){
            for (int j =0;j<m;j++){
                if(i==n-1&&j==m-1){
                    continue;
                }else if(j==m-1){
                    if(matrix[i][j]==matrix[i+1][j]){
                        places.add(placeCreator(i,j,i+1,j,true));
                    }
                }else if(i==n-1){
                    if(matrix[i][j]==matrix[i][j+1]){
                        places.add(placeCreator(i,j,i,j+1,false));

                    }
                }else if(i!=n-1&&j!=m-1){
                    if (matrix[i][j]==matrix[i][j+1]){

                    }else if (matrix[i][j]==matrix[i+1][j]){
                        places.add(placeCreator(i,j,i+1,j,true));
                    }

                }

            }
        }



    }
    private Place placeCreator(int i1,int j1,int i2,int j2,boolean isVertical){
        Node tempNode1;
        Node tempNode2;
        Place tempPlace;
        tempNode1 =new Node(i1,j1,true);
        tempNode2 =new Node(i2,j2,false);
        tempPlace = new Place(tempNode1,tempNode2,isVertical);
        return tempPlace;
    }

    /////Salam Bagher
    public void debug(){
        for (Place p : places){
            System.out.println(p.getFirstNode());
        }
    }
}
