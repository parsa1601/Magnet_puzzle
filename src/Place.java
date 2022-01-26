import java.util.ArrayList;

public class Place {

    boolean NoLegalValueLeft ;
    int legalValueNum;
    Node first;
    Node second;
    int index =-1;
    boolean isVertical;
    boolean isAssign;
    boolean is_PN_NotInDomain;
    boolean is_NP_NotInDomain;
    boolean is_E_NotInDomain;
    int tried = 0;
    ArrayList<Value> legalValue = new ArrayList<>();
    Value currentValue = new Value();
    Value lastValue= new Value();
    ArrayList<Place> friendList = new ArrayList<>();
    public Place(){}
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
        index = i;
        legalValueNum=3;
        is_PN_NotInDomain = false;
        is_NP_NotInDomain = false;
        is_E_NotInDomain = false;
    }
    public void setPlaceUndoAssign(){
        isAssign = false;
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


        if (value.str.equals("PN")){
            //System.out.println("done PPPP");
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
            isAssign = true;
          return;
        }
        else if(value.str.equals("NP")){
            //System.out.println("done NNNN");
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
            isAssign = true;
            return;
        }else if(value.str.equals("E")){
            //System.out.println("done EEEE");
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
            isAssign = true;
            return;
        }
    }

    //public void updateLegalList(){}

    public void addFriend(Place myFriend){
        friendList.add(myFriend);
    }
}


///Last commit