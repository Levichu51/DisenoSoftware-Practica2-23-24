package e2;

public class Armour implements ObjDefensa{
    ObjDef defensa;
    public Armour(ObjDef defensa){
        this.defensa = defensa;
    }


    public int getProtec() {
        return this.defensa.getProtec();
    }

    public int getMinFuerza(){
        return this.defensa.getMinFuerza();
    }

    @Override
    public void setMinFuerza(int minFuerza){

    }

    @Override
    public void setProtec(int protec){

    }




}
