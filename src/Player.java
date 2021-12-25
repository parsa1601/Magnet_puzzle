public class Player {

    public void play(){
        Board board = new Board();
        board.boardCreator();
        Constraint constraint = new Constraint();


        System.out.println(board.nodes[0][0].isEmpty);
        System.out.println(board.nodes[0][0].isPositive);
        System.out.println(board.nodes[1][0].isEmpty);
        System.out.println(board.nodes[1][0].isPositive);
        System.out.println(board.places.get(0).getSecondNode().isEmpty);
        System.out.println(board.places.get(0).getSecondNode().isPositive);
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintP(1,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.rowConstraintN(1,board));
        board.setPiecePN(board.places.get(0));
        board.setPieceNP(board.places.get(1));
        board.setPieceNP(board.places.get(2));
        board.setPieceNP(board.places.get(3));
        board.setPiecePN(board.places.get(4));
        /*System.out.println(board.places.get(1).getFirstNode().getRowNum());
        System.out.println(board.places.get(1).getFirstNode().getColumnNum());
        System.out.println(board.places.get(1).getFirstNode().isEmpty);
        System.out.println(board.places.get(1).getFirstNode().isPositive);*/
        System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(constraint.rowConstraintP(1,board));
        System.out.println(constraint.rowConstraintN(0,board));
        System.out.println(constraint.rowConstraintN(1,board));
        System.out.println(board.nodes[0][0].isEmpty);
        System.out.println(board.nodes[0][0].isPositive);
        System.out.println(board.nodes[1][0].isEmpty);
        System.out.println(board.nodes[1][0].isPositive);
        System.out.println(board.places.get(0).getSecondNode().isEmpty);
        System.out.println(board.places.get(0).getSecondNode().isPositive);




    }



}
