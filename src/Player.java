import java.sql.SQLOutput;

public class Player {

    public void play(){
        Board board = new Board();
        board.boardCreator();
        Constraint constraint = new Constraint();
        Algorithms algorithms = new Algorithms(board);
        System.out.println(algorithms.backtrack());
        board.printer();

       /* for (Place p : board.places.get(0).friendList){
            System.out.println(p.index);
        }*/
       /* System.out.println(constraint.isAllOFMYFriendAssign(board.places.get(0)));
        board.assign(board.places.get(0),board.places.get(1).legalValue.get(1) );
        board.assign(board.places.get(1),board.places.get(1).legalValue.get(1) );
        board.assign(board.places.get(2),board.places.get(1).legalValue.get(1) );
        board.assign(board.places.get(3),board.places.get(1).legalValue.get(1) );
        board.assign(board.places.get(4),board.places.get(1).legalValue.get(1) );
        board.assign(board.places.get(5),board.places.get(1).legalValue.get(1) );
        board.assign(board.places.get(6),board.places.get(1).legalValue.get(1) );
        board.assign(board.places.get(13),board.places.get(1).legalValue.get(1) );
        System.out.println(constraint.isAllOFMYFriendAssign(board.places.get(0)));*/




        /*System.out.println(board.sumOFLegals);
        Value value3 = new Value();
        Value value2 = new Value();
        Value value1 = new Value();
        //*value1.setValueNP(board.places.get(0));
        value2.setValueNP(board.places.get(2));
        value3.setValueNP(board.places.get(3));
        System.out.println(constraint.isThisValueLegal(board,board.places.get(2),board.places.get(2).legalValue.get(0) ));
        System.out.println(constraint.isThisValueLegal(board,board.places.get(2),board.places.get(2).legalValue.get(1) ));
        System.out.println(constraint.isThisValueLegal(board,board.places.get(2),board.places.get(1).legalValue.get(2) ));
        System.out.println(board.places.get(2).legalValueNum);
        board.assign(board.places.get(1),board.places.get(1).legalValue.get(1));
        board.assign(board.places.get(5),board.places.get(5).legalValue.get(1));
        //board.assign(board.places.get(2),board.places.get(2).legalValue.get(0));
        System.out.println(board.places.get(2).legalValueNum);
        System.out.println(constraint.isThisValueLegal(board,board.places.get(2),board.places.get(2).legalValue.get(0) ));
        System.out.println(constraint.isThisValueLegal(board,board.places.get(2),board.places.get(2).legalValue.get(1) ));
        System.out.println(constraint.isThisValueLegal(board,board.places.get(2),board.places.get(2).legalValue.get(2) ));
        //System.out.println(constraint.isThisValueLegal(board,board.places.get(3),board.places.get(3).legalValue.get(0) ));
        //System.out.println(constraint.isThisValueLegal(board,board.places.get(2),value3 ));
        //board.undoAssign(board.places.get(1));
        //board.undoAssign(board.places.get(3));
        //System.out.println(constraint.isThisValueLegal(board,board.places.get(3),value3 ));
       // System.out.println(constraint.rowConstraintP(0,board));
        System.out.println(board.sumOFLegals);

        board.printer();
        System.out.println(algorithms.constraint.isProblemSatisfied(algorithms.board));
        //System.out.println(board.places.size());
        for (int i=0;i<board.places.size();i++){
            System.out.println(board.places.get(i).index);
        }

*/

        //board.setPiecePN(board.places.get(1));
        //board.setPiecePN(board.places.get(4));
        //board.setPieceNP(board.places.get(5));
        //board.setPiecePN(board.places.get(6));
       // board.setPieceNP(board.places.get(7));
        //board.setPiecePN(board.places.get(9));
        //board.setPieceNP(board.places.get(11));
        //board.setPiecePN(board.places.get(13));
        //board.setPieceNP(board.places.get(14));
        //board.setPieceNP(board.places.get(17));





/*

        System.out.println(board.row_positive[2]);
        System.out.println(board.row_negative[2]);
        System.out.println(constraint.rowConstraintP(2,board));
        System.out.println(constraint.rowConstraintN(2,board));


        System.out.println(board.places.get(6).getFirstNode().isPositive&&!board.places.get(6).getFirstNode().isEmpty);
        System.out.println(board.places.get(7).getFirstNode().isPositive&&!board.places.get(7).getFirstNode().isEmpty);
        System.out.println(board.places.get(7).getSecondNode().isPositive&&!board.places.get(7).getFirstNode().isEmpty);
        System.out.println(board.places.get(8).getFirstNode().isPositive&&!board.places.get(8).getFirstNode().isEmpty);
        System.out.println(board.places.get(8).getSecondNode().isPositive&&!board.places.get(8).getFirstNode().isEmpty);
        System.out.println(board.places.get(9).getFirstNode().isPositive&&!board.places.get(9).getFirstNode().isEmpty);

        System.out.println(constraint.isProblemSatisfied(board));
        board.printer();
*/

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
///Last commit