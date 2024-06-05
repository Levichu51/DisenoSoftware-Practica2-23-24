package e2;

public class ObjAt implements ObjAtaque {
    private String codeName;
    private int damage;
    private int minMana;
    private int PP;

    public ObjAt(String codeName, int damage, int minMana, int PP){
        this.codeName = codeName;
        this.damage = damage;
        this.minMana = minMana;
        this.PP = PP;
    }

    public String getName(){
        return this.codeName;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getMinMana(){
        return this.minMana;
    }
    public int getPP(){
        return this.PP ;
    }

    @Override
    public void setDamage(int damage){
        this.damage = damage;
    }

    @Override
    public void setMana(int mana){
        this.minMana = mana;
    }

    @Override
    public void setPP(int PP){
        this.PP = PP;
    }










}
