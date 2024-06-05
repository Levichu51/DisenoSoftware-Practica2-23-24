package e1;

public abstract class Cuenta {
    private String IBAN;
    private long saldo;
    private Cliente cliente;

    public Cuenta(String IBAN, long saldo, Cliente cliente) {
        this.IBAN = IBAN;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public void setIBAN(String IBAN){
        this.IBAN = IBAN;
    }
    public void setSaldo(long saldo){
        this.saldo = saldo;
    }
    public String getIban() {
        return this.IBAN;
    }

    public double getSaldo() {
        return this.saldo;
    }
    public Cliente getCliente(){
        return this.cliente;
    }

    public void meterSaldo(long saldo) {
        this.saldo += saldo;
    }

    public abstract void sacarSaldo(long saldo);

}