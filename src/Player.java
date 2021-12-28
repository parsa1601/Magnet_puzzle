public class Player {

    public void play(){
        Board board = new Board();
        board.boardCreator();
        Constraint constraint = new Constraint();




        board.setPiecePN(board.places.get(0));
        System.out.println(constraint.ifAnyRuleBroke(board,board.places.get(0)));
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(0)));
        board.printer();
        board.setPieceE(board.places.get(1));
        System.out.println(constraint.ifAnyRuleBroke(board,board.places.get(1)));
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(1)));
        board.printer();
        board.setPiecePN(board.places.get(2));
        System.out.println(constraint.ifAnyRuleBroke(board,board.places.get(2)));
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(2)));
        board.printer();
        board.setPiecePN(board.places.get(3));
        System.out.println(constraint.ifAnyRuleBroke(board,board.places.get(3)));
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(3)));
        board.printer();
        board.setPiecePN(board.places.get(4));
        System.out.println(constraint.ifAnyRuleBroke(board,board.places.get(4)));
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.isMagneticConstraintSatisfied(board,board.places.get(4)));
        board.printer();





        System.out.println("********************");
        System.out.println(constraint.isProblemSatisfied(board));



    }



}
