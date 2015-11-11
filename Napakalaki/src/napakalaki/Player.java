/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;


public class Player {
    private String name;
    private int level;
    private boolean dead = false;
    private boolean canlSteal = true;
    private Player enemy;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private BadConsequence badStuff;

    Player(String name){
    	this.name = name;
    	level = 1;
    }

    public String getName(){
    	return name;
    }

    private void bringToLife(){
    	dead = false;
    }

    public boolean isDead(){
    	return dead;
    }

    private int getCombatLevel(){
    	int lvl = this.level;

    	for(Treasure t : this.visibleTreasures){
    		lvl += t.getBonus();
    	}

    	return lvl;
    }

    private void incrementLevels(int i){
    	level += i;
    }

    private void decrementLevels(int i){
    	level -= i;
    }

    private void setPendingBadConsequence(BadConsequence b){
    	badStuff = b;
    }

    private void applyPrize(Monster m){
    	level += m.getPrice().getLevels();
    }

    private void applyBadConsequence(Monster m){
    	level -= m.getBc().getLevels();
    }


    private void dieIfNotreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()){
            dead = true;
        }
    }

    private boolean validState(){
        if(badStuff.isEmpty() && hiddenTreasures.size() <= 4){
            return true;
        }
        return false;
    }

    private int howManyVissibleTreasures(){
        return visibleTreasures.size();
    }



    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }

    private void haveStolen(){
        canlSteal = false;
    }

    private boolean canYouGiveMeATreasure(){
        if(!hiddenTreasures.isEmpty() || !visibleTreasures.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean canMakeTreasureVisible(Treasure t){
        return false;
    }

    public ArrayList<Treasure> getHiddenTreasures(){
        return null;
    }

    public ArrayList<Treasure> getVisibleTreasures(){
        return null;
    }

    public CombatResult combat(Monster m){
        return null;
    }

    public void makeTreasureVisible(Treasure t){

    }

    public void discardVisibleTreasure(Treasure t){

    }

    public void discardHiddenTreasure(Treasure t){

    }

    public void initTreasures(){

    }

    public int getLevel(){
        return level;
    }

    public Treasure stealTreasure(){
        return null;
    }

    private Treasure giveMeATreasure(){
        return null;
    }

    public boolean canISteal(){
        return false;
    }

    public void discardAllTreasures(){
        
    }
}









