/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import NapakalakiGame.BadConsequence;
import NapakalakiGame.CombatResult;
import NapakalakiGame.Monster;
import NapakalakiGame.Treasure;
import NapakalakiGame.CardDealer;
import NapakalakiGame.Napakalaki;

public class Player {
    private String name;
    private int level;
    private boolean dead = false;
    private boolean canISteal = true;
    private Player enemy;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private BadConsequence badStuff;
    static int maxLevel = 10;

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
    	int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if(nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            Treasure treasure;
            for(int i = 0; i < nTreasures;i++){
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
            
        }
    }

    private void applyBadConsequence(BadConsequence b){
    	int nLevels = b.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = b.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }


    private void dieIfNotreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()){
            dead = true;
        }
    }

    public boolean validState(){
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
        canISteal = false;
    }

    private boolean canYouGiveMeATreasure(){
        if(!hiddenTreasures.isEmpty() || !visibleTreasures.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean canMakeTreasureVisible(Treasure t){
        boolean result = false;
 
        if (this.visibleTreasures.size() < 4) {
            TreasureKind type = t.getType();
            switch (type) {
 
                case ONEHAND:
 
                    if (isTreasureKindInUse(TreasureKind.BOTHHANDS)) {
                        result = false;
                    } else {
 
                        int i = 0;
                        for (Treasure tv : this.visibleTreasures) {
                            if (tv.getType().equals(TreasureKind.ONEHAND)) {
                                i++;
                            }
                        }
 
                        if (i == 2) {
                            result = false;
                        } else {
                            result = true;
                        }
                    }
                    break;
 
                default:
                    result = !isTreasureKindInUse(type);
                    break;
 
            }
 
        }
 
        return result;
    }
    
    private boolean isTreasureKindInUse(TreasureKind type) {
        boolean result = false;
        for (Treasure tv : this.visibleTreasures) {
 
            if (type.equals(tv.getType())) {
 
                result = true;
                break;
 
            }
 
        }
        return result;
    }

    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    private int getCombatLevel(){
    	int lvl = this.level;

    	for(Treasure t : this.visibleTreasures){
    		lvl += t.getBonus();
    	}

    	return lvl;
    }

    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        
        CombatResult combat;
        
        int monsterLevel = m.getCombatLevel();
        
        if(myLevel > monsterLevel){
            this.applyPrize(m);
            if(this.level >= 10){
                combat = CombatResult.WINGAME;
            }
            else{
                combat = CombatResult.WIN;
            }
        }
        else{
            combat = CombatResult.LOSE;
            
            boolean amIDead = m.getBc().getDeath();

            if(amIDead){
                this.dead = true;                    
            }
            else{
                BadConsequence bad = m.getBc();
                this.applyBadConsequence(bad);
            }
        }
        return combat;
    }

    public void makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }

    public void discardVisibleTreasure(Treasure treasures){
        visibleTreasures.remove(treasures);
        if(badStuff ==null && !badStuff.isEmpty()){
            badStuff.substractVisibleTreasure(treasures);
        }
        dieIfNotreasures();
    }

    public void discardHiddenTreasure(Treasure treasures){
        hiddenTreasures.remove(treasures);
        if(badStuff ==null && !badStuff.isEmpty()){
            badStuff.substractHiddenTreasure(treasures);
        }
        dieIfNotreasures();
    }

    public int getLevel(){
        return level;
    }

    public Treasure stealTreasure(){
        boolean canI = canISteal();
        Treasure treasure = null;
        if(canI){
            boolean canYou = enemy.canYouGiveMeATreasure();
            if(canYou){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
            }
        }
        return treasure;
    }

    private Treasure giveMeATreasure(){
        int randomNum = 1 + (int)(Math.random()*4);
        return hiddenTreasures.get(randomNum);
    }

    public boolean canISteal(){
        return canISteal;
    }

    public void discardAllTreasures(){
        for(Treasure t : visibleTreasures){
            discardVisibleTreasure(t);
        }
        for(Treasure t : hiddenTreasures){
            discardHiddenTreasure(t);
        }
        
    }
    
    public String toString(){
        return "Nombre = " +name+"levels="+ Integer.toString(level);
    }

    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        if(number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
}










