public class Player {

    public void play(){
        Board board = new Board();
        board.boardCreator();
        Constraint constraint = new Constraint();
        Algorithms solver = new Algorithms(board);
        //System.out.println(board.places.size());
        /*for (int i=0;i<board.places.size();i++){
            System.out.println(board.places.get(i).index);
        }*/
        if(solver.backtrack()){
            System.out.println("problem solved");
            board.printer();
        }else {
            System.out.println("No answer!");
            board.printer();
        }


/*
        board.setPieceNP(board.places.get(1));
        board.setPiecePN(board.places.get(4));
        board.setPiecePN(board.places.get(5));
        board.setPiecePN(board.places.get(6));
        board.setPiecePN(board.places.get(8));
        board.setPiecePN(board.places.get(9));
        board.setPiecePN(board.places.get(11));
        board.setPiecePN(board.places.get(13));
        board.setPieceNP(board.places.get(14));
        board.setPieceNP(board.places.get(17));
        board.printer();
        System.out.println(constraint.isProblemSatisfied(board));*/


        /*
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
        board.printer();*/




    }




}
