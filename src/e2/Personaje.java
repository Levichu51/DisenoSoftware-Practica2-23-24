package e2;

import java.util.ArrayList;


public abstract class Personaje {
    private String name;
    private int fuerza;
    private int vida;
    private int mana;

    private ArrayList<ObjAtaque> ataqueLista;
    private ArrayList<ObjDefensa> defensaLista;


    public Personaje(String name, int fuerza, int vida, int mana){
        if((vida < 0 || vida > 20) || (fuerza < 0 || fuerza > 10) || (mana < 0 || mana > 10)){
            throw new IllegalArgumentException("No se puede crear un personaje con esas caracteristicas");

        }else {
            this.name = name;
            this.fuerza = fuerza;
            this.vida = vida;
            this.mana = mana;
            this.ataqueLista = new ArrayList<ObjAtaque>();
            this.defensaLista = new ArrayList<ObjDefensa>();
        }

    }

    public String getName(){
        return this.name;
    }
    public int getFuerza(){
        return this.fuerza;
    }
    public int getVida(){
        return this.vida;
    }
    public int getMana(){
        return this.mana;
    }
    public ArrayList<ObjAtaque> getAtaqueLista(){
        return this.ataqueLista;
    }
    public ArrayList<ObjDefensa> getDefensaLista(){
        return this.defensaLista;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public void setFuerza(int fuerza){
        this.fuerza = fuerza;
    }
    public void setMana(int mana){
        this.mana = mana;
    }

    public void añadirAtaque(ObjAtaque ataque){
        if(ataqueLista.size() <= 5) {
            ataqueLista.add(ataque);
        }
        else{
            throw new IllegalArgumentException("Limite de 5 objetos");
        }
    }

    public void añadirDefensa(ObjDefensa defensa){

        if(defensaLista.size() <= 5 && this.fuerza >= defensa.getMinFuerza()) {
            defensaLista.add(defensa);
        }
        else{
            throw new IllegalArgumentException("Limite de 5 objetos");
        }
    }

    public void eliminarAtaque(ObjAtaque ataque){
        if(ataqueLista.size() == 0) {
            throw new IllegalStateException("Lista vacia");
        }
        else{
            ataqueLista.remove(ataque);
        }
    }

    public void eliminarDefensa(ObjDefensa defensa){
        if(defensaLista.size() == 0) {
            throw new IllegalStateException("Lista vacia");
        }
        else{
            defensaLista.remove(defensa);
        }
    }

    public void atacar(Personaje atacado) {
        if (!ataqueLista.isEmpty()) {
            ObjAtaque ataque = this.ataqueLista.get(0);

            int damage = ataque.getDamage();
            int PP = ataque.getPP();

            if (this.mana >= ataque.getMinMana() && PP > 0) {
                if (!atacado.defensaLista.isEmpty()) {
                    ObjDefensa defensa = atacado.defensaLista.get(0);

                    // Calcular el daño
                    if (defensa.getProtec() < damage) {
                        damage -= defensa.getProtec();
                    } else {
                        damage = 0;
                    }
                } else {
                    damage = ataque.getDamage();
                }

                atacado.vida -= damage;
                ataque.setPP(ataque.getPP() - 1);

                // Ver si el objeto no tiene PPs
                if (ataque.getPP() == 0) {
                    ataqueLista.remove(ataque);

                    if (!ataqueLista.isEmpty()) {
                        ObjAtaque nextAttack = ataqueLista.get(0);
                        System.out.println("Objeto de ataque sin PP. Se eliminó de la lista.");
                        System.out.println("Usando el siguiente objeto de ataque: " + nextAttack);
                    } else {
                        System.out.println("No hay más objetos de ataque disponibles.");
                    }
                }
            } else {
                ataqueLista.remove(ataque);

                if (!ataqueLista.isEmpty()) {
                    ObjAtaque nextAttack = ataqueLista.get(0);
                    System.out.println("No hay mana para atacar. Objeto de ataque eliminado.");
                    System.out.println("Usando el siguiente objeto de ataque: " + nextAttack);
                } else {
                    System.out.println("No hay mana para atacar. No hay más objetos de ataque disponibles.");
                }
            }
        } else {
            System.out.println("No hay objetos de ataque disponibles. No se puede realizar el ataque. Obtén un nuevo objeto.");
        }
    }


}
