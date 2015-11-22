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
public class Prize {
    private int treasures;
    private int levels;
    
    Prize(int treasures, int levels){
        this.treasures = treasures;
        this.levels = levels;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }
    
    
    int getTreasures(){
        return treasures;
    }
    
    int getLevels(){
        return levels;
    }
    
    public String toString(){
        return "Treasures = " +Integer.toString(treasures)+"levels="+ Integer.toString(levels);
    } 
    
}
