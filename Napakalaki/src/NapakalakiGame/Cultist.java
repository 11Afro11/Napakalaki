/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * 
 */
public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist (String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getBasicValue(){
        return this.gainedLevels;
    }

    public int getSpecialValue(){
        return this.getBasicValue()*CultistPlayer.getTotalCultistPlayer();
    }
    
}
