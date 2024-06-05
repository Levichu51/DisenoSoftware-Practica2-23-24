package e2;

public class ObjDef implements ObjDefensa {
    private int protec;
    private int minFuerza;

    public ObjDef(int protec, int minFuerza){
        this.protec = protec;
        this.minFuerza = minFuerza;
    }

    public int getProtec() {
        return this.protec;
    }

    public int getMinFuerza(){
        return this.minFuerza;
    }

    @Override
    public void setProtec(int protec){
        this.protec = protec;
    }

    @Override
    public void setMinFuerza(int minFuerza){
        this.minFuerza = minFuerza;
    }

}
