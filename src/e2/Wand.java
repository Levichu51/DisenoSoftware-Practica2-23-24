package e2;

public class Wand implements ObjAtaque, ObjDefensa{
    private ObjAt ataque;
    private ObjDef defensa;

    public Wand(ObjAt ataque, ObjDef defensa){
        this.ataque = ataque;
        this.defensa = defensa;
    }


    @Override
    public String getName(){
        return this.ataque.getName();
    }
    @Override
    public int getDamage(){
        if(getPP() == 3){ //solo se meteran como maximo 3 usos de Wand en principio
            return this.ataque.getDamage() * 2;
        }
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
