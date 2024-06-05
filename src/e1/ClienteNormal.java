package e1;

public class ClienteNormal extends Cliente {

    private long comision;
    public ClienteNormal(String DNI, String tipo, double comision, int mincom, int minret, int minIngreso){
        super (DNI, tipo, comision, mincom, minret, minIngreso);
    }

}
