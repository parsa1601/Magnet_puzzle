public class Player {

    public void play(){
        Board board = new Board();
        board.boardCreator();
        Constraint constraint = new Constraint();


        System.out.println(constraint.isProblemSatisfied(board));
        board.printer();
        board.setPiecePN(board.places.get(0));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(0)));
        board.setPieceNP(board.places.get(1));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(1)));
        board.setPiecePN(board.places.get(2));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(2)));
        board.setPiecePN(board.places.get(3));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(3)));
        board.setPiecePN(board.places.get(4));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(3)));




        System.out.println("********************");
        System.out.println(constraint.isProblemSatisfied(board));
        board.printer();


    }



}
