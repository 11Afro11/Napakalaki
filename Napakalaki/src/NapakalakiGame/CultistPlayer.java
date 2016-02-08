/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author afro
 */
public class CultistPlayer extends Player{
    
    private static int totalCultistPlayer = 0;
    static int getTotalCultistPlayer() {
        return totalCultistPlayer;
    }
    private Cultist myCultistCard;
    public CultistPlayer(Player name, Cultist n) {
        super(name);
        myCultistCard = n;
        totalCultistPlayer++;
    }
    public Cultist getCultist(){
        return this.myCultistCard;
    }
    @Override
    public int getCombatLevel(){
    	int lvl = super.getCombatLevel();
        
        int suma = myCultistCard.getBasicValue();
        lvl = lvl + ((lvl*20)/100) + suma*totalCultistPlayer;
        
        return lvl;
    }
    @Override
    protected boolean shouldConvert(){
        return false;
    }    
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultist();
    }
    @Override
    public Player getEnemy(){
        return super.getEnemy();
    }
    
    protected Treasure giveMeATreasure(){
        return super.giveMeATreasure();
    }
    
    protected boolean canYouGiveMeATreasure(){
        return super.canYouGiveMeATreasure();
    }
}
