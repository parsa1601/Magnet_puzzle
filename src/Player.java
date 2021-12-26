public class Player {

    public void play(){
        Board board = new Board();
        board.boardCreator();
        Constraint constraint = new Constraint();


/*
        System.out.println(board.places.get(0).getFirstNode().isEmpty);
        System.out.println(board.places.get(0).getFirstNode().isPositive);
        System.out.println(board.places.get(0).getSecondNode().isEmpty);
        System.out.println(board.places.get(0).getSecondNode().isPositive);
        System.out.println(board.places.get(1).getFirstNode().isEmpty);
        System.out.println(board.places.get(1).getFirstNode().isPositive);
        System.out.println(board.places.get(1).getSecondNode().isEmpty);
        System.out.println(board.places.get(1).getSecondNode().isPositive);
        System.out.println(board.places.get(2).getFirstNode().isEmpty);
        System.out.println(board.places.get(2).getFirstNode().isPositive);
        System.out.println(board.places.get(2).getSecondNode().isEmpty);
        System.out.println(board.places.get(2).getSecondNode().isPositive);*/
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.rowConstraintP(1,board));
        System.out.println(constraint.rowConstraintN(1,board));

        System.out.println(constraint.columnConstraintP(0,board));
        System.out.println(constraint.columnConstraintN(0,board));
        System.out.println(constraint.columnConstraintP(1,board));
        System.out.println(constraint.columnConstraintN(1,board));
        System.out.println(constraint.columnConstraintP(2,board));
        System.out.println(constraint.columnConstraintN(2,board));

        board.printer();
        board.setPiecePN(board.places.get(0));
        board.setPieceNP(board.places.get(1));
        board.setPieceNP(board.places.get(2));
        board.setPieceNP(board.places.get(3));
        board.setPiecePN(board.places.get(4));

        /*System.out.println(board.places.get(1).getFirstNode().getRowNum());
        System.out.println(board.places.get(1).getFirstNode().getColumnNum());
        System.out.println(board.places.get(1).getFirstNode().isEmpty);
        System.out.println(board.places.get(1).getFirstNode().isPositive);*/
        System.out.println("********************");
        /*System.out.println(board.places.get(0).getFirstNode().isEmpty);
        System.out.println(board.places.get(0).getFirstNode().isPositive);
        System.out.println(board.places.get(0).getSecondNode().isEmpty);
        System.out.println(board.places.get(0).getSecondNode().isPositive);
        System.out.println(board.places.get(1).getFirstNode().isEmpty);
        System.out.println(board.places.get(1).getFirstNode().isPositive);
        System.out.println(board.places.get(1).getSecondNode().isEmpty);
        System.out.println(board.places.get(1).getSecondNode().isPositive);
        System.out.println(board.places.get(2).getFirstNode().isEmpty);
        System.out.println(board.places.get(2).getFirstNode().isPositive);
        System.out.println(board.places.get(2).getSecondNode().isEmpty);
        System.out.println(board.places.get(2).getSecondNode().isPositive);*/
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.rowConstraintP(1,board));
        System.out.println(constraint.rowConstraintN(1,board));

        System.out.println(constraint.columnConstraintP(0,board));
        System.out.println(constraint.columnConstraintN(0,board));
        System.out.println(constraint.columnConstraintP(1,board));
        System.out.println(constraint.columnConstraintN(1,board));
        System.out.println(constraint.columnConstraintP(2,board));
        System.out.println(constraint.columnConstraintN(2,board));
        System.out.println(constraint.columnConstraintP(3,board));
        System.out.println(constraint.columnConstraintN(3,board));
        System.out.println(constraint.columnConstraintP(4,board));
        System.out.println(constraint.columnConstraintN(4,board));
        System.out.println(constraint.columnConstraintP(5,board));
        System.out.println(constraint.columnConstraintN(5,board));

        board.printer();




    }



}
