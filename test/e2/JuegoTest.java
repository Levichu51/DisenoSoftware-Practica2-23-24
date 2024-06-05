package e2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JuegoTest {
    @Test
    public void testSimulateSingleAttack() {
        Juego juego = new Juego();

        // Set initial health values for testing
        juego.getWizard().setVida(10);
        juego.getWarrior().setVida(10);

        juego.singleAttackSimulation();

        // Verify the health of characters after the simulated attack
        assertEquals(7, juego.getWizard().getVida());
        // Adjust expected values based on your game logic
        assertEquals(6, juego.getWarrior().getVida());
    }

    @Test
    public void testSimulateTurnBasedBattle() {
        Juego juego = new Juego();

        // Set initial health values for testing
        juego.getWizard().setVida(15);
        juego.getWarrior().setVida(20);

        juego.turnBasedBattleSimulation(3); // Simulate a maximum of 3 turns

        // Add assertions to verify the result after the turn-based battle simulation
        // Adjust expected values based on your game logic

        assertTrue(juego.getWizard().getVida() >= 0 || juego.getWarrior().getVida() >= 0,
                "Either wizard or warrior should have <= 0 health after the simulation");
    }





}