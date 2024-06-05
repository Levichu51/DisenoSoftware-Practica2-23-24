package e1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void testClientePreferente() {
        ClientePreferente preferente = new ClientePreferente("987654321", "Preferente", 3, 5, 800, 300);
        assertEquals("987654321", preferente.getDNI());
        assertEquals("Preferente", preferente.getTipo());
        assertEquals(3, preferente.getComision());
        assertEquals(5, preferente.getMincom());
        assertEquals(800, preferente.getMinret());
        assertEquals(300, preferente.getMinIngreso());
    }

    @Test
    void testClienteVIP() {
        ClienteVIP vip = new ClienteVIP("111122223333", "VIP", 0, 0, 0, 0);
        assertEquals("111122223333", vip.getDNI());
        assertEquals("VIP", vip.getTipo());
        assertEquals(0, vip.getComision());
        assertEquals(0, vip.getMincom());
        assertEquals(0, vip.getMinret());
        assertEquals(0, vip.getMinIngreso());
    }

    @Test
    void testClienteNormal() {
        ClienteNormal normal = new ClienteNormal("444455556666", "Normal", 8, 15, 1500, 700);
        assertEquals("444455556666", normal.getDNI());
        assertEquals("Normal", normal.getTipo());
        assertEquals(8, normal.getComision());
        assertEquals(15, normal.getMincom());
        assertEquals(1500, normal.getMinret());
        assertEquals(700, normal.getMinIngreso());
    }



}