/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author afro
 */
public class Monster {
    private String name;
    private int combatLevel;   
    private Prize price;
    private BadConsequence bc;
    
    public Monster(String name, int combatLevel){
        this.name = name;
        this.combatLevel = combatLevel;
    }

    public Monster(String name, int combatLevel, Prize price, BadConsequence bc) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.price = price;
        this.bc = bc;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }

    public void setPrice(Prize price) {
        this.price = price;
    }

    public void setBc(BadConsequence bc) {
        this.bc = bc;
    }

    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }
    
    @Override
    public String toString(){        
        return "Nombre = " +name+"Combat level="+ Integer.toString(combatLevel)+"Precio="+price+"Consecuence="+bc;
    } 

    public Prize getPrice() {
        return price;
    }

    public BadConsequence getBc() {
        return bc;
    } 
    
    public int getLevelsGained(){
        return price.getLevels();
    }
    
    public int getTreasuresGained(){
        return price.getTreasures();
    }
}
