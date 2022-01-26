
public class Constraint {

    public boolean isProblemSatisfied(Board board){
        boolean flag = true;
        //row p
        for (int i =0;i<board.n;i++){
            /*System.out.print("int row ");
            System.out.print(i);
            System.out.println(" : ");
            System.out.println(rowConstraintP(i,board));*/
            if ( OLDrowConstraintP(i,board)!=0){
                flag = false;
            }
        }
        //row n
        for (int i =0;i<board.n;i++){
            if ( OLDrowConstraintN(i,board)!=0){
                flag = false;
            }
        }
        //column p
        for (int j =0;j<board.m;j++){
            if ( OLDcolumnConstraintP(j,board)!=0){
                flag = false;
            }
        }
        //column n
        for (int j =0;j<board.m;j++){
            if ( OLDcolumnConstraintN(j,board)!=0){
                flag = false;
            }
        }
        return flag;
    }
    // mishe gozasht?
    public boolean isThisValueLegal(Board board,Place place,Value value){
            return magneticLegality(board,place,value)&&numericLegality(board,place,value);

    }

    public boolean isValueInDomain(Place place,Value value){
        if (value.isEmpty){
            if (!place.is_E_NotInDomain){
                return true;
            }else return false;
        }else {
            if (value.isPN){
                if (!place.is_PN_NotInDomain){
                    return true;
                }else return false;
            }else {
                if (!place.is_NP_NotInDomain){
                    return true;
                }else return false;
            }
        }
    }

    private boolean magneticLegality(Board board,Place place,Value value){
        /*int f_i = place.first.rowNum;
        int f_j = place.first.columnNum;
        int s_i = place.second.rowNum;
        int s_j = place.second.columnNum;
         */
        if(value.isEmpty) {
            return true;
        }else {
                if (place.isVertical){
                    if(!isUP_ok(board,place.first.rowNum,place.first.columnNum,value.isPN)) return false;
                    if(!isLeft_ok(board,place.first.rowNum,place.first.columnNum,value.isPN)) return false;
                    if(!isRight_ok(board,place.first.rowNum,place.first.columnNum,value.isPN)) return false;

                    if(!isDown_ok(board,place.second.rowNum,place.second.columnNum,!value.isPN)) return false;
                    if(!isLeft_ok(board,place.second.rowNum,place.second.columnNum,!value.isPN)) return false;
                    if(!isRight_ok(board,place.second.rowNum,place.second.columnNum,!value.isPN)) return false;
                }else {
                    if(!isUP_ok(board,place.first.rowNum,place.first.columnNum,value.isPN)) return false;
                    if(!isLeft_ok(board,place.first.rowNum,place.first.columnNum,value.isPN)) return false;
                    if(!isDown_ok(board,place.first.rowNum,place.first.columnNum,value.isPN)) return false;

                    if(!isUP_ok(board,place.second.rowNum,place.second.columnNum,!value.isPN)) return false;
                    if(!isDown_ok(board,place.second.rowNum,place.second.columnNum,!value.isPN)) return false;
                    if(!isRight_ok(board,place.second.rowNum,place.second.columnNum,!value.isPN)) return false;
                }

        }
        return true;
    }
    // if true: we can assign
    // if false : assign -> constraint fuc*ed!
    private boolean numericLegality(Board board,Place place,Value value){
        int f_P,f_N,s_P,s_N;
        if(value.isEmpty) {
            f_P = 0;
            f_N = 0;
            s_P = 0;
            s_N = 0;
        }else {
            if (value.isPN) {
                f_P = 1;
                f_N = 0;
                s_P = 0;
                s_N = 1;
            }
            else   {
                f_P = 0;
                f_N = 1;
                s_P = 1;
                s_N = 0;
            }
        }
        if (place.isVertical){
            // check column ,check row_f check row_s
           if (rowConstraintP(place.first.rowNum,board)+f_P>board.row_positive[place.first.rowNum]) return false;
           if (rowConstraintN(place.first.rowNum,board)+f_N>board.row_negative[place.first.rowNum]) return false;
           if (rowConstraintP(place.second.rowNum,board)+s_P>board.row_positive[place.second.rowNum]) return false;
           if (rowConstraintN(place.second.rowNum,board)+s_N>board.row_negative[place.second.rowNum]) return false;
           if (columnConstraintP(place.first.columnNum,board)+f_P+s_P>board.column_positive[place.first.columnNum]) return false;
           if (columnConstraintN(place.first.columnNum,board)+f_N+s_N>board.column_negative[place.first.columnNum]) return false;

        }else {
            if (columnConstraintP(place.first.columnNum,board)+f_P>board.column_positive[place.first.columnNum]) return false;
            if (columnConstraintN(place.first.columnNum,board)+f_N>board.column_negative[place.first.columnNum]) return false;
            if (columnConstraintP(place.second.columnNum,board)+s_P>board.column_positive[place.second.columnNum]) return false;
            if (columnConstraintN(place.second.columnNum,board)+s_N>board.column_negative[place.second.columnNum]) return false;
            if (rowConstraintP(place.first.rowNum,board)+f_P+s_P>board.row_positive[place.first.rowNum]) return false;
            if (rowConstraintN(place.first.rowNum,board)+f_N+s_N>board.row_negative[place.first.rowNum]) return false;
        }
        return true;
    }
/**  ML */
private boolean isUP_ok(Board board,int i,int j,boolean isPositive){
    // check if not exist
    if(i==0){
        return true;
    }else {
        if(board.nodes[i-1][j].isEmpty){
            return true;
        } else if (board.nodes[i-1][j].isPositive&&isPositive){
            return false;
        }else if(!board.nodes[i-1][j].isPositive&&!isPositive){
            return false;
        }else {
            return true;
        }
    }
}

    private boolean isDown_ok(Board board,int i,int j,boolean isPositive){
        // check if not exist
        if(i== board.n-1){
            return true;
        }else {
            if(board.nodes[i+1][j].isEmpty){
                return true;
            } else if (board.nodes[i+1][j].isPositive&&isPositive){
                return false;
            }else if(!board.nodes[i+1][j].isPositive&&!isPositive){
                return false;
            }else {
                return true;
            }
        }
    }

    private boolean isRight_ok(Board board,int i,int j,boolean isPositive){
        // check if not exist
        if(j== board.m-1){
            return true;
        }else {
            if(board.nodes[i][j+1].isEmpty){
                return true;
            } else if (board.nodes[i][j+1].isPositive&&isPositive){
                return false;
            }else if(!board.nodes[i][j+1].isPositive&&!isPositive){
                return false;
            }else {
                return true;
            }
        }
    }

    private boolean isLeft_ok(Board board,int i,int j,boolean isPositive){
        // check if not exist
        if(j== 0){
            return true;
        }else {
            if(board.nodes[i][j-1].isEmpty){
                return true;
            } else if (board.nodes[i][j-1].isPositive&&isPositive){
                return false;
            }else if(!board.nodes[i][j-1].isPositive&&!isPositive){
                return false;
            }else {
                return true;
            }
        }
    }
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
        /*if(board.row_positive[row]==count){
            return 0;
        }else if(board.row_positive[row]<=count){
            return 1;
        }else if(board.row_positive[row]>=count){
            return -1;
        }*/
        return count;
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
        /*if(board.row_negative[row]==count){
            return 0;
        }else if(board.row_negative[row]<=count){
            return 1;
        }else if(board.row_negative[row]>=count){
            return -1;
        }*/
        return count;
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
        /*if(board.column_positive[column]==count){
            return 0;
        }else if(board.column_positive[column]<=count){
            return 1;
        }else if(board.column_positive[column]>=count){
            return -1;
        }*/
        return count;
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
        /*if(board.column_negative[column]==count){
            return 0;
        }else if(board.column_positive[column]<=count){
            return 1;
        }else if(board.column_positive[column]>=count){
            return -1;
        }*/
        return count;
    }


    /**
     *
     *
     *
     *
     *
     *
     * ****************************************************
     *
     */
/**row constraint */


    public int OLDrowConstraintP(int row,Board board){
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
    public int OLDrowConstraintN(int row,Board board){
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


    public int OLDcolumnConstraintP(int column,Board board){
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

    public int OLDcolumnConstraintN(int column,Board board){
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
        // age true bud bayad backtrack konim
    public boolean wontSatisfy(Board board,Place place){
        if (isAllOFMYFriendAssign(place)&& place.isAssign){
            boolean flag = true;
            if (place.isVertical){
                if (OLDrowConstraintP(place.first.rowNum,board)!=0){
                    flag = false;
                }
                if (OLDrowConstraintN(place.first.rowNum,board)!=0){
                    flag = false;
                }
                if (OLDrowConstraintP(place.second.rowNum,board)!=0){
                    flag = false;
                }
                if (OLDrowConstraintN(place.second.rowNum,board)!=0){
                    flag = false;
                }
                if (OLDcolumnConstraintP(place.first.columnNum,board)!=0){
                    flag = false;
                }
                if (OLDcolumnConstraintN(place.first.columnNum,board)!=0){
                    flag = false;
                }

            }else {
                if (OLDrowConstraintP(place.first.rowNum,board)!=0){
                    flag = false;
                }
                if (OLDrowConstraintN(place.first.rowNum,board)!=0){
                    flag = false;
                }
                if (OLDcolumnConstraintP(place.first.columnNum, board)!=0){
                    flag = false;
                }
                if (OLDcolumnConstraintN(place.first.columnNum, board)!=0){
                    flag = false;
                }
                if (OLDcolumnConstraintP(place.second.columnNum,board)!=0){
                    flag = false;
                }
                if (OLDcolumnConstraintN(place.second.columnNum,board)!=0){
                    flag = false;
                }

            }
            return flag;
        }else {
            return false;
        }
    }
    // in niazi nist albate
    public boolean isAllOFMYFriendAssign(Place place){
        boolean flag = true;
        for (Place f : place.friendList){
            if (!f.isAssign) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
/*
import javax.xml.stream.FactoryConfigurationError;

public class Constraint {


    */
/** all constraints *//*

    // in tabe manteqi nist velesh kon
    */
/*public boolean isMoveLegal(Board board,Place place){
        if(isNumericConstraintSatisfied(board,place)
        &&isMagneticConstraintSatisfied(board,place)){
            return true;
        } else return false;
    }*/
/*

    // age false bashe backtrack mikhaym
    public boolean valueSatisfaction(Place place,Board board) {
        if(ifAnyRuleBroke(board,place)||!isMagneticConstraintSatisfied(board,place)){
            return false;
        }else {
            // yani mishe edame dad
            return true;
        }
    }
    */
/**rules of game constraint *//*

    // inam niaz nist
    */
/*public boolean isNumericConstraintSatisfied(Board board,Place place){
        if(place.isVertical){
            if(rowConstraintP(place.getFirstNode().rowNum,board)==0
            &&rowConstraintN(place.getFirstNode().rowNum,board)==0
            &&rowConstraintP(place.getSecondNode().rowNum,board)==0
            &&rowConstraintN(place.getSecondNode().rowNum,board)==0
            &&columnConstraintP(place.getFirstNode().columnNum,board)==0
            &&columnConstraintN(place.getFirstNode().columnNum,board)==0){
                return true;
            }else return false;

        }else {
            if(rowConstraintP(place.getFirstNode().rowNum,board)==0
                    &&rowConstraintN(place.getFirstNode().rowNum,board)==0
                    &&columnConstraintP(place.getSecondNode().columnNum,board)==0
                    &&columnConstraintN(place.getSecondNode().columnNum,board)==0
                    &&columnConstraintP(place.getFirstNode().columnNum,board)==0
                    &&columnConstraintN(place.getFirstNode().columnNum,board)==0){
                return true;
            }else return false;
        }

    }*/
/*

    // if return true : need to backtrack
    public boolean ifAnyRuleBroke(Board board,Place place){
        if(place.isVertical){
            if(rowConstraintP(place.getFirstNode().rowNum,board)==1
                    ||rowConstraintN(place.getFirstNode().rowNum,board)==1
                    ||rowConstraintP(place.getSecondNode().rowNum,board)==1
                    ||rowConstraintN(place.getSecondNode().rowNum,board)==1
                    ||columnConstraintP(place.getFirstNode().columnNum,board)==1
                    ||columnConstraintN(place.getFirstNode().columnNum,board)==1){
                return true;
            }else return false;

        }else {
            if(rowConstraintP(place.getFirstNode().rowNum,board)==1
                    ||rowConstraintN(place.getFirstNode().rowNum,board)==1
                    ||columnConstraintP(place.getSecondNode().columnNum,board)==1
                    ||columnConstraintN(place.getSecondNode().columnNum,board)==1
                    ||columnConstraintP(place.getFirstNode().columnNum,board)==1
                    ||columnConstraintN(place.getFirstNode().columnNum,board)==1){
                return true;
            }else return false;
        }

    }


    */
/**row constraint *//*


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

    */
/**column constraint*//*


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

    */
/**magnetic constraint *//*

    // if return false : need backtrack
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
            System.out.print("int row ");
            System.out.print(i);
            System.out.println(" : ");
            System.out.println(rowConstraintP(i,board));
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
*/
