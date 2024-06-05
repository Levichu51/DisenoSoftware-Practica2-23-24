package e2;

public class Sword implements ObjAtaque, ObjDefensa{
    ObjAt ataque;
    ObjDef defensa;
    public Sword(ObjAt ataque, ObjDef defensa) {
        this.ataque = ataque;
        this.defensa = defensa;
    }


    @Override
    public String getName(){
        return this.ataque.getName();
    }
    @Override
    public int getDamage(){
        return this.ataque.getDamage();
    }
    @Override
    public int getMinMana(){
        return this.ataque.getMinMana();
    }
    @Override
    public int getPP(){
        return this.ataque.getPP() ;
    }

    public int getProtec() {
        return this.defensa.getProtec();
    }

    public int getMinFuerza(){
        return this.defensa.getMinFuerza();
    }


    @Override
    public void setDamage(int damage){

    }

    @Override
    public void setMana(int mana){

    }

    @Override
    public void setPP(int PP){

    }

    @Override
    public void setMinFuerza(int minFuerza){

    }

    @Override
    public void setProtec(int protec){

    }







}
