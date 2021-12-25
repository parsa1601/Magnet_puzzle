public class Player {

    public void play(){
        Board board = new Board();
        board.boardCreator();
        Constraint constraint = new Constraint();

        System.out.println(constraint.rowConstraintP(0,board));


    }



}
