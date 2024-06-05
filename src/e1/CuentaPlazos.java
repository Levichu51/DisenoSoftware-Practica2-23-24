package e1;


public class CuentaPlazos extends Cuenta {

    public CuentaPlazos(String IBAN, long saldo, Cliente cliente) {
        super(IBAN, saldo, cliente);
    }

    @Override
    public void sacarSaldo(long saldo) {
        if (saldo <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva");
        }
        long comision = Math.max((long) (saldo * this.getCliente().getComision()), this.getCliente().getMincom());

        long totalDeductedAmount = saldo + comision;

        if (getSaldo() - totalDeductedAmount < -getCliente().getMinret()) {
            throw new IllegalArgumentException("No se puede retirar dinero debido al límite de saldo mínimo");
        } else {
            setSaldo((long) (getSaldo() - totalDeductedAmount));
        }
    }

    @Override
    public void meterSaldo(long saldo){
        if(saldo < this.getCliente().getMinIngreso()){
            throw new IllegalArgumentException("No se puede ingresar dinero");
        }
        else{
            setSaldo((long) (saldo + getSaldo()));
        }
    }

}