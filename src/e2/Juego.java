package e2;


import java.util.ArrayList;

public class Juego{

    public static void main(String[] args) {
        Juego juego = new Juego();

        juego.singleAttackSimulation();

        juego.turnBasedBattleSimulation(10);
    }

    private Wizard wizard;
    private Warrior warrior;
    private ObjAt auxAt;
    private ObjDef auxDef;
    private ObjAt auxAtS;
    private ObjDef auxDefS;
    private ObjAt auxAtF;
    private ObjDef auxDefA;
    private Wand wand;
    private Sword sword;
    private Armour armour;
    private FireBallSpell fireBallSpell;

    public Personaje getWizard() {
        return wizard;
    }

    public Personaje getWarrior() {
        return warrior;
    }

    public Juego() {
        wizard = new Wizard("Merlin", 8, 6, 8);
        warrior = new Warrior("El Cid", 7, 10, 6);

        auxAt = new ObjAt("1", 4, 3, 3);
        auxDef = new ObjDef( 4, 6);

        auxAtS = new ObjAt("3", 3, 3, 5);
        auxDefS = new ObjDef( 5, 5);

        auxAtF = new ObjAt("4", 7, 4, 3);

        auxDefA = new ObjDef(5, 5);

        wand = new Wand(auxAt, auxDef);
        sword = new Sword(auxAtS, auxDefS);
        armour = new Armour(auxDefA);
        fireBallSpell = new FireBallSpell(auxAtF);

    }

    public void singleAttackSimulation() {
        System.out.println("Single Attack Simulation:\n");

        wizard.añadirAtaque(wand);
        //wizard.añadirDefensa(wand);
        warrior.añadirDefensa(wand);
        warrior.añadirAtaque(sword);

        printCharacterStatus(wizard, warrior);
        System.out.println("");

        // Wizard attacks Warrior
        System.out.println("Wizard attacks Warrior:");
        wizard.atacar(warrior);
        printCharacterStatus(wizard, warrior);

        System.out.println("");

        System.out.println("Warrior attacks Wizard:");
        warrior.atacar(wizard);
        printCharacterStatus(wizard, warrior);

        wizard.eliminarAtaque(wand);
        warrior.eliminarDefensa(wand);
        warrior.eliminarAtaque(sword);

    }

    public void turnBasedBattleSimulation(int maxTurns) {
        System.out.println("\nTurn-Based Battle Simulation:");

        wizard.setVida(6);
        warrior.setVida(10);

        int turn = 1;
        Personaje attacker;
        Personaje defender;

        wizard.añadirAtaque(fireBallSpell);
        warrior.añadirDefensa(armour);
        warrior.añadirAtaque(sword);

        printCharacterStatus(wizard, warrior);

        while (turn <= maxTurns) {
            if (turn % 2 != 0) {
                attacker = wizard;
                defender = warrior;
            } else {
                attacker = warrior;
                defender = wizard;
            }

            System.out.println("\nTurn " + turn + ": " + attacker.getName() + " attacks " + defender.getName());
            attacker.atacar(defender);
            printCharacterStatus(wizard, warrior);

            if (defender.getVida() <= 0) {
                System.out.println("\nGame Over! " + attacker.getName() + " wins!");
                return;
            }

            turn++;
        }

        System.out.println("\nGame Over! Maximum turns reached. No clear winner.");
    }

    public void printCharacterStatus(Personaje wizard, Personaje warrior) {
        System.out.println(wizard.getName() + " - Vida: " + wizard.getVida() + ", Mana: " + wizard.getMana());
        System.out.println(warrior.getName() + " - Vida: " + warrior.getVida() + ", Mana: " + warrior.getMana());
    }

}
