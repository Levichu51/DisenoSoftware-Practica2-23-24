package e2;

public class FireBallSpell implements ObjAtaque {
    ObjAt ataque;

    public FireBallSpell(ObjAt ataque){
        this.ataque = ataque;
    }



    @Override
    public String getName(){
        return this.ataque.getName();
    }
    @Override
    public int getDamage(){
        if(getPP() == 1){
            return this.ataque.getDamage() - 1;
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

    @Override
    public void setDamage(int damage){
    }

    @Override
    public void setMana(int mana){

    }

    @Override
    public void setPP(int PP){

    }


}
