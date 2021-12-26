import javax.xml.stream.FactoryConfigurationError;

public class Constraint {

    /**row constraint */

    public int rowConstraintP(int row,Board board){
        // 1 : more
        // 0 : constraint satisfied
        // -1 : less
        int count =0;
        for (int j=0;j<board.m;j++){
            if ( !board.nodes[row][j].isEmpty){
                if ( board.nodes[row][j].isPositive){
                    count++;

                }
            }
        }
        if(board.row_positive[row]==count){
            return 0;
        }else if(board.row_positive[row]<=count){
            return 1;
        }else if(board.row_positive[row]>=count){
            return -1;
        }
        return -1;
    }
    public int rowConstraintN(int row,Board board){
        // 1 : more
        // 0 : constraint satisfied
        // -1 : less
        int count =0;
        for (int j=0;j<board.m;j++){
            if ( !board.nodes[row][j].isEmpty){
                if ( !board.nodes[row][j].isPositive){
                    count++;

                }
            }
        }
        if(board.row_negative[row]==count){
            return 0;
        }else if(board.row_negative[row]<=count){
            return 1;
        }else if(board.row_negative[row]>=count){
            return -1;
        }
        return -1;
    }

    /**column constraint*/

    public int columnConstraintP(int column,Board board){
        // 1 : more
        // 0 : constraint satisfied
        // -1 : less
        int count =0;
        for (int i=0;i<board.n;i++){
            if ( !board.nodes[i][column].isEmpty){
                if ( board.nodes[i][column].isPositive){
                    count++;

                }
            }
        }
        if(board.column_positive[column]==count){
            return 0;
        }else if(board.column_positive[column]<=count){
            return 1;
        }else if(board.column_positive[column]>=count){
            return -1;
        }
        return -1;
    }

    public int columnConstraintN(int column,Board board){
        // 1 : more
        // 0 : constraint satisfied
        // -1 : less
        int count =0;
        for (int i=0;i<board.n;i++){
            if ( !board.nodes[i][column].isEmpty){
                if (! board.nodes[i][column].isPositive){
                    count++;

                }
            }
        }
        if(board.column_negative[column]==count){
            return 0;
        }else if(board.column_positive[column]<=count){
            return 1;
        }else if(board.column_positive[column]>=count){
            return -1;
        }
        return -1;
    }

    /**magnetic constraint */

    public boolean isMagneticConstraintSatisfied(Board board,Place place){
        if(checkFirst(board, place)&&checkSecond(board, place)){
            return true;
        }

        return false;
    }
    private boolean checkFirst(Board board,Place place){
        int i = place.getFirstNode().rowNum;
        int j = place.getFirstNode().columnNum;
        int d =0;
        if(place.isVertical) {
            // right , left , up
            if(isUP_ok(board,i,j)){
                d++;
            }
            if(isRight_ok(board,i,j)){
                d++;
            }
            if(isLeft_ok(board,i,j)){
                d++;
            }

        }else{
            //left , down , up
            if(isUP_ok(board,i,j)){
                d++;
            }
            if(isDown_ok(board,i,j)){
                d++;
            }
            if(isLeft_ok(board,i,j)){
                d++;
            }

        }
        if(d==3){
            return true;
        }else {
            return false;
        }
    }
    private boolean checkSecond(Board board,Place place){
        int i = place.getSecondNode().rowNum;
        int j = place.getSecondNode().columnNum;
        int d =0;

        if(place.isVertical) {
            // right , left , down
            if(isDown_ok(board,i,j)){
                d++;
            }
            if(isLeft_ok(board,i,j)){
                d++;
            }
            if(isRight_ok(board,i,j)){
                d++;
            }

        }else{
            //right , down , up
            if(isUP_ok(board,i,j)){
                d++;
            }
            if(isDown_ok(board,i,j)){
                d++;
            }
            if(isRight_ok(board,i,j)){
                d++;
            }

        }
        if(d==3){
            return true;
        }else {
            return false;
        }
    }

    private boolean isUP_ok(Board board,int i,int j){
            // check if not exist
        if(i==0){
            return true;
        }else {
            if(board.nodes[i-1][j].isEmpty||board.nodes[i][j].isEmpty){
                return true;
            } else if (board.nodes[i-1][j].isPositive&&board.nodes[i][j].isPositive){
                return false;
            }else if(!board.nodes[i-1][j].isPositive&&!board.nodes[i][j].isPositive){
                return false;
            }else {
                return true;
            }
        }
    }

    private boolean isDown_ok(Board board,int i,int j){
        // check if not exist
        if(i== board.n-1){
            return true;
        }else {
            if(board.nodes[i+1][j].isEmpty||board.nodes[i][j].isEmpty){
                return true;
            } else if (board.nodes[i+1][j].isPositive&&board.nodes[i][j].isPositive){
                return false;
            }else if(!board.nodes[i+1][j].isPositive&&!board.nodes[i][j].isPositive){
                return false;
            }else {
                return true;
            }
        }
    }

    private boolean isRight_ok(Board board,int i,int j){
        // check if not exist
        if(j== board.m-1){
            return true;
        }else {
            if(board.nodes[i][j+1].isEmpty||board.nodes[i][j].isEmpty){
                return true;
            } else if (board.nodes[i][j+1].isPositive&&board.nodes[i][j].isPositive){
                return false;
            }else if(!board.nodes[i][j+1].isPositive&&!board.nodes[i][j].isPositive){
                return false;
            }else {
                return true;
            }
        }
    }

    private boolean isLeft_ok(Board board,int i,int j){
        // check if not exist
        if(j== 0){
            return true;
        }else {
            if(board.nodes[i][j-1].isEmpty||board.nodes[i][j].isEmpty){
                return true;
            } else if (board.nodes[i][j-1].isPositive&&board.nodes[i][j].isPositive){
                return false;
            }else if(!board.nodes[i][j-1].isPositive&&!board.nodes[i][j].isPositive){
                return false;
            }else {
                return true;
            }
        }
    }

    public boolean isProblemSatisfied(Board board){
        boolean flag = true;
        //row p
        for (int i =0;i<board.n;i++){
            if ( rowConstraintP(i,board)!=0){
                flag = false;
            }
        }
        //row n
        for (int i =0;i<board.n;i++){
            if ( rowConstraintN(i,board)!=0){
                flag = false;
            }
        }
        //column p
        for (int j =0;j<board.m;j++){
            if ( columnConstraintP(j,board)!=0){
                flag = false;
            }
        }
        //column n
        for (int j =0;j<board.m;j++){
            if ( columnConstraintN(j,board)!=0){
                flag = false;
            }
        }
        return flag;
    }

}
