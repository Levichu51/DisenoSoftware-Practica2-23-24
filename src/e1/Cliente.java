package e1;

public abstract class Cliente {
    private String DNI;
    private String tipo;
    private final double comision; //porcentaje comision
    private final int mincom; //el minimo de una comision
    private final long minret; //la deuda que pueden dejar
    private final int minIngreso; //el minimo para ingresar


    public Cliente(String DNI, String tipo, double comision, int mincom, long minret, int minIngreso) {
        this.DNI = DNI;
        this.tipo = tipo;
        this.comision = comision;
        this.mincom = mincom;
        this.minret = minret;
        this.minIngreso = minIngreso;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setDNI(String DNI){
        this.DNI = DNI;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String getDNI(){
        return this.DNI;
    }
    public double getComision(){
        return this.comision;
    }
    public int getMincom(){
        return this.mincom;
    }
    public long getMinret(){
        return this.minret;
    }
    public int getMinIngreso(){
        return this.minIngreso;
    }

}