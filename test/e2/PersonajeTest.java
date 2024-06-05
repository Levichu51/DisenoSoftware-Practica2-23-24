package e2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class PersonajeTest {
    @Test
    public void testAñadirAtaque() {
        Wizard wizard = new Wizard("WizardTest", 5, 15, 8); // Usar una implementación concreta para las pruebas
        ObjAt ataque = new ObjAt("AtaqueTest", 10, 5, 3);

        wizard.añadirAtaque(ataque);

        assertEquals(1, wizard.getAtaqueLista().size());
        assertEquals(ataque, wizard.getAtaqueLista().get(0));
    }

    @Test
    public void testAñadirDefensa() {
        Warrior warrior = new Warrior("WarriorTest", 5, 15, 8); // Usar una implementación concreta para las pruebas
        ObjDef defensa = new ObjDef(3, 2);

        warrior.añadirDefensa(defensa);

        assertEquals(1, warrior.getDefensaLista().size());
        assertEquals(defensa, warrior.getDefensaLista().get(0));
    }

    @Test
    public void testEliminarAtaque() {
        Wizard wizard = new Wizard("WizardTest", 5, 15, 8); // Usar una implementación concreta para las pruebas
        ObjAt ataque = new ObjAt("AtaqueTest", 10, 5, 3);
        wizard.añadirAtaque(ataque);

        wizard.eliminarAtaque(ataque);
        assertEquals(0, wizard.getAtaqueLista().size());
    }

    @Test
    public void testEliminarDefensa() {
        Warrior warrior = new Warrior("WarriorTest", 5, 15, 8); // Usar una implementación concreta para las pruebas
        ObjDef defensa = new ObjDef(3, 2);
        warrior.añadirDefensa(defensa);

        warrior.eliminarDefensa(defensa);
        assertEquals(0, warrior.getDefensaLista().size());
    }

    @Test
    public void testAtacar() {
        Warrior warrior = new Warrior("WarriorAtacante", 5, 15, 8); // Usar una implementación concreta para las pruebas
        Wizard wizard = new Wizard("WizardDefensor", 5, 15, 8); // Usar una implementación concreta para las pruebas

        ObjAt ataque = new ObjAt("AtaqueTest", 10, 5, 3);
        warrior.añadirAtaque(ataque);

        warrior.atacar(wizard);

        // Verificar el estado después del ataque
        assertEquals(5, wizard.getVida()); // Ajusta según la lógica específica del juego
        assertEquals(2, warrior.getAtaqueLista().get(0).getPP()); // Ajusta según la lógica específica del juego
    }


    @Test
    public void testSwordMethods() {
        ObjAt ataque = new ObjAt("AtaqueTest", 10, 5, 3);
        ObjDef defensa = new ObjDef(3, 2);

        Sword sword = new Sword(ataque, defensa);

        assertEquals("AtaqueTest", sword.getName());
        assertEquals(10, sword.getDamage());
        assertEquals(5, sword.getMinMana());
        assertEquals(3, sword.getPP());
        assertEquals(3, sword.getProtec());
        assertEquals(2, sword.getMinFuerza());
    }

    @Test
    public void testArmourMethods() {
        ObjDef defensa = new ObjDef(3, 2);

        Armour armour = new Armour(defensa);

        assertEquals(3, armour.getProtec());
        assertEquals(2, armour.getMinFuerza());
    }

    @Test
    public void testFireBallSpellMethods() {
        ObjAt ataque = new ObjAt("AtaqueTest", 10, 5, 1); // Power points set to 1 for testing
        FireBallSpell fireBallSpell = new FireBallSpell(ataque);

        assertEquals("AtaqueTest", fireBallSpell.getName());
        assertEquals(9, fireBallSpell.getDamage()); // Damage reduced by 1 for power points = 1
        assertEquals(5, fireBallSpell.getMinMana());
        assertEquals(1, fireBallSpell.getPP());
    }

    @Test
    public void testObjAtMethods() {
        ObjAt objAt = new ObjAt("TestObj", 15, 8, 3);

        assertEquals("TestObj", objAt.getName());
        assertEquals(15, objAt.getDamage());
        assertEquals(8, objAt.getMinMana());
        assertEquals(3, objAt.getPP());

        // Test setters
        objAt.setDamage(20);
        objAt.setMana(10);
        objAt.setPP(5);

        assertEquals(20, objAt.getDamage());
        assertEquals(10, objAt.getMinMana());
        assertEquals(5, objAt.getPP());
    }

    @Test
    public void testObjDefMethods() {
        ObjDef objDef = new ObjDef(5, 3);

        assertEquals(5, objDef.getProtec());
        assertEquals(3, objDef.getMinFuerza());

        // Test setters
        objDef.setProtec(8);
        objDef.setMinFuerza(4);

        assertEquals(8, objDef.getProtec());
        assertEquals(4, objDef.getMinFuerza());
    }





}