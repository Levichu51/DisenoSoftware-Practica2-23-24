package e1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CuentaTest {
    @Test
    void testClientePreferente() {
        ClientePreferente preferente = new ClientePreferente("987654321", "Preferente", 0.02, 1, 1000, 500);
        CuentaCorriente corriente = new CuentaCorriente("ES70 7777 7777 7777", 1000, preferente);
        CuentaPlazos plazos = new CuentaPlazos("ES80 8888 8888 8888", 1000, preferente);
        CuentaPlazos plazos2 = new CuentaPlazos("ES80 8888 8888 8889", 1000, preferente);


        //Cuenta corriente
        corriente.sacarSaldo(500);
        assertEquals(500, corriente.getSaldo());

        corriente.sacarSaldo(600);
        assertEquals(-100, corriente.getSaldo());

        assertThrows(IllegalArgumentException.class, () -> corriente.sacarSaldo(1600));

        corriente.meterSaldo(600);
        assertEquals(500, corriente.getSaldo());

        //Cuenta a plazos
        plazos.sacarSaldo(1200);
        assertEquals(-224, plazos.getSaldo());

        assertThrows(IllegalArgumentException.class, () -> plazos.meterSaldo(400));

        plazos.meterSaldo(1200);
        assertEquals(976, plazos.getSaldo());

        assertThrows(IllegalArgumentException.class, () -> plazos2.sacarSaldo(11000));

    }

    @Test
    void testClienteVIP() {
        ClienteVIP vip = new ClienteVIP("111122223333", "VIP", 0, 0, Long.MIN_VALUE, 0);
        CuentaCorriente corriente = new CuentaCorriente("ES40 4444 4444 4444", 1000, vip);
        CuentaPlazos plazos = new CuentaPlazos("ES30 2222 2222 2222", 1000, vip);
        CuentaPlazos plazos2 = new CuentaPlazos("ES30 2222 2222 2221", 1000, vip);


        //Cuenta corriente
        corriente.sacarSaldo(500);
        assertEquals(500, corriente.getSaldo());

        corriente.sacarSaldo(600);
        assertEquals(-100, corriente.getSaldo());

        corriente.meterSaldo(600);
        assertEquals(500, corriente.getSaldo());

        //Cuenta a plazos
        plazos.sacarSaldo(500);
        assertEquals(500, plazos.getSaldo());

        plazos.meterSaldo(600);
        assertEquals(1100, plazos.getSaldo());

        plazos2.sacarSaldo(20000);
        assertEquals(-19000, plazos2.getSaldo());

    }

    @Test
    void testClienteNormal() {
        ClienteNormal normal = new ClienteNormal("444455556666", "Normal", 0.04, 3, 0, 1000);
        CuentaCorriente corriente = new CuentaCorriente("ES60 8333 3333 3333", 1000, normal);
        CuentaPlazos plazos = new CuentaPlazos("ES50 3333 3333 3333", 1000, normal);

        //Cuenta corriente
        corriente.sacarSaldo(500);
        assertEquals(500, corriente.getSaldo());

        assertThrows(IllegalArgumentException.class, () -> corriente.sacarSaldo(600));

        corriente.meterSaldo(500);
        assertEquals(1000, corriente.getSaldo());

        //Cuenta a plazos
        plazos.sacarSaldo(500);
        assertEquals(480, plazos.getSaldo());

        assertThrows(IllegalArgumentException.class, () -> plazos.meterSaldo(600));


    }

}