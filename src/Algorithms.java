public class Algorithms {
    Constraint constraint = new Constraint();
    public boolean backtrack(Board board){
        return recursiveBacktrack(board);
    }
    private boolean recursiveBacktrack(Board board){
        if (constraint.isProblemSatisfied(board)) return true;

        for (int p=0;p<board.places.size();p++){
            for (int mood=0;mood<3;mood++){
                if (mood==0){

                }if(mood==1){

                }if(mood==2){

                }
            }
        }
        return false;
    }
}
