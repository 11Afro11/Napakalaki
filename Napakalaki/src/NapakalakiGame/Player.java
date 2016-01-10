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
import java.util.Random;
import NapakalakiGame.Napakalaki;

public class Player {
    private String name;
    private int level;
    private boolean dead = true;
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
    
    Player(Player otro){
        this.name = otro.name;
        this.level = otro.level;
        this.dead = otro.dead;
        this.canISteal = otro.canISteal;
        this.enemy = otro.enemy;
        this.visibleTreasures = otro.visibleTreasures;
        this.hiddenTreasures = otro.hiddenTreasures;
        this.badStuff = otro.badStuff;
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
        if(level > 10){
            level = 10;
        }
    }

    private void decrementLevels(int i){
    	level -= i;
        if(level < 1){
            level = 1;
        }
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
        return badStuff.isEmpty() && hiddenTreasures.size() <= 4;
    }

    private int howManyVissibleTreasures(){
        return visibleTreasures.size();
    }

    public void setEnemy(Player enemy){
        this.enemy = new Player("");
        this.enemy = enemy;
    }

    private void haveStolen(){
        canISteal = false;
    }

    boolean canYouGiveMeATreasure(){
        return !hiddenTreasures.isEmpty() || !visibleTreasures.isEmpty();
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
    
    public int getCombatLevel(){
    	int lvl = this.level;

    	for(Treasure t : this.visibleTreasures){
    		lvl += t.getBonus();
    	}

    	return lvl;
    }

    public CombatResult Combat(Monster m){
        int myLevel = this.getCombatLevel();
        
        CombatResult combat = null;
        
        int monsterLevel = this.getOponentLevel(m);
        
        if(myLevel > monsterLevel){
            this.applyPrize(m);
            if(this.level >= Player.maxLevel){
                combat = CombatResult.WINGAME;
            }
            else{
                combat = CombatResult.WIN;
            }
        }
        else{
            combat = CombatResult.LOSE;
            
            boolean amIDead = m.getBc().getDeath();
            
            if(this.shouldConvert()){
                combat = CombatResult.LOSEANDCONVERT;
            }

            else if(amIDead){
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
        if(badStuff !=null && !badStuff.isEmpty()){
            badStuff.substractVisibleTreasure(treasures);
        }
        dieIfNotreasures();
    }

    public void discardHiddenTreasure(Treasure treasures){
        hiddenTreasures.remove(treasures);
        if(badStuff !=null && !badStuff.isEmpty()){
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
            if(enemy.canYouGiveMeATreasure()){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
            }
        }
        return treasure;
    }

    Treasure giveMeATreasure(){
        Random randomNum = new Random();
        int num = randomNum.nextInt(hiddenTreasures.size());
        Treasure t= hiddenTreasures.get(num);
        this.hiddenTreasures.remove(num);
        return t;
        
    }

    public boolean canISteal(){
        return canISteal;
    }

    public void discardAllTreasures(){
        ArrayList<Treasure> aux = (ArrayList<Treasure>) visibleTreasures.clone();
        for(Treasure t : aux){
            discardVisibleTreasure(t);
        }
        ArrayList<Treasure> aux2 = (ArrayList<Treasure>) visibleTreasures.clone();
        for(Treasure t : aux2){
            discardHiddenTreasure(t);
        }
        
    }
    
    public String toString(){
        return "Nombre = " +name+" levels= "+ Integer.toString(level);
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

    public int computeGoldCoinsValue(ArrayList<Treasure> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        if(dice.nextNumber() == 1){
            return true;
        }
        else{
            return false;
        }
    } 
    
    protected Player getEnemy(){
        return enemy;
    }
}










