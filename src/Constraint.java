public class Constraint {
    //row constraint
    //column constraint
    //magnetic constraint
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

    public int columnConstraintP(int column,Board board){
        // 1 : more
        // 0 : constraint satisfied
        // -1 : less
        int count =0;
        for (int i=0;i<board.n;i++){
            if ( !board.nodes[column][i].isEmpty){
                if ( board.nodes[column][i].isPositive){
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
            if ( !board.nodes[column][i].isEmpty){
                if (! board.nodes[column][i].isPositive){
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





}
