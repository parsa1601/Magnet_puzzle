import java.util.ArrayList;

public class Place {

    boolean NoLegalValueLeft ;
    int legalValueNum;
    Node first;
    Node second;
    int index =-1;
    boolean isVertical;
    boolean isAssign;
    ArrayList<Value> legalValue = new ArrayList<>();
    Value currentValue = new Value();
    Value lastValue= new Value();

    public Place(Node f, Node s,boolean isVertical,int i){
        first =f;
        second = s;
        isAssign = false;
        currentValue.setValueE(this);
        lastValue.setValueE(this);
        this.isVertical = isVertical;
        legalValue.add(new Value());
        legalValue.add(new Value());
        legalValue.add(new Value());
        legalValue.get(0).setValuePN(this);
        legalValue.get(1).setValueNP(this);
        legalValue.get(2).setValueE(this);
        index = 0;
        legalValueNum=3;
    }
    public void setPlaceUndoAssign(){
        if(lastValue.isEmpty){
            currentValue.setValueE(this);
        }else {
            if (lastValue.isPN){
                currentValue.setValuePN(this);
            }else {
                currentValue.setValueNP(this);
            }
        }
    }
    public void setPlaceAssign(Value value){

        isAssign = true;
        if (value.str.equals("PN")){
            if(currentValue.isEmpty){
                lastValue.setValueE(this);
            }else {
                if (currentValue.isPN){
                    lastValue.setValuePN(this);
                }else {
                    lastValue.setValueNP(this);
                }
            }
            currentValue.setValuePN(this);

          return;
        }
        else if(value.str.equals("NP")){
            if(currentValue.isEmpty){
                lastValue.setValueE(this);
            }else {
                if (currentValue.isPN){

                    lastValue.setValuePN(this);
                }else {

                    lastValue.setValueNP(this);
                }
            }
            currentValue.setValueNP(this);
            return;
        }else if(value.str.equals("E")){
            if(currentValue.isEmpty){
                lastValue.setValueE(this);
            }else {
                if (currentValue.isPN){

                    lastValue.setValuePN(this);
                }else {

                    lastValue.setValueNP(this);
                }
            }
            currentValue.setValueE(this);
            return;
        }
    }

    //public void updateLegalList(){}


}
