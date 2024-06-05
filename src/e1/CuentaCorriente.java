package e1;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(String IBAN, long saldo, Cliente cliente) {
        super(IBAN, saldo, cliente);
    }

    @Override
    public void sacarSaldo(long saldo){
        if(saldo < 0){
            throw new IllegalArgumentException("No se puede retirar dinero negativo");
        }
        if (getSaldo() - saldo > -this.getCliente().getMinret()) {
            setSaldo((long) (getSaldo() - saldo));
        } else {
            throw new IllegalArgumentException("No se puede retirar dinero");
        }
    }

    @Override
    public void meterSaldo(long saldo){
        if(saldo < 0){
            throw new IllegalArgumentException("No se puede ingresar dinero negativo");
        }
        setSaldo((long) (saldo + getSaldo()));
    }



}