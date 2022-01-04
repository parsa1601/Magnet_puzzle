public class Value {

    /* Node first;
     Node second;*/
    boolean isLegal;
    boolean isEmpty;
    boolean isPN;
    String str;
    public Value(){
        isEmpty = true;
    }
    public void setValuePN(Place myOwner){
        isEmpty = false;
        isPN = true;
        str="PN";
        myOwner.first.changeMeP();
        myOwner.second.changeMeN();
    }
    public void setValueNP(Place myOwner){
        isEmpty = false;
        isPN = false;
        str="NP";
        myOwner.first.changeMeN();
        myOwner.second.changeMeP();
    }
    public void setValueE(Place myOwner){
        isEmpty = true;
        isPN = false;
        str ="E";
        myOwner.first.changeMeE();
        myOwner.second.changeMeE();
    }

}
