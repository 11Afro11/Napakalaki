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
public abstract class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTeasures;
    private boolean death;
    
    private ArrayList<TreasureKind>specificHiddenTreasure = new ArrayList();
    private ArrayList<TreasureKind>specificVisibleTreasure = new ArrayList();
    
    BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTeasures = nHidden;
    }
    
    BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
    }
    
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        specificVisibleTreasure = tVisible;
        specificHiddenTreasure = tHidden;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public void setnVisibleTreasures(int nVisibleTreasures) {
        this.nVisibleTreasures = nVisibleTreasures;
    }

    public void setnHiddenTeasures(int nHiddenTeasures) {
        this.nHiddenTeasures = nHiddenTeasures;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public void setSpecificHiddenTreasure(ArrayList<TreasureKind> specificHiddenTreasure) {
        this.specificHiddenTreasure = specificHiddenTreasure;
    }

    public void setSpecificVisibleTreasure(ArrayList<TreasureKind> specificVisibleTreasure) {
        this.specificVisibleTreasure = specificVisibleTreasure;
    }
       
    String getText(){
        return text;
    }
    
    ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasure;
    }
    
    ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasure;
    }
    
    int getLevels(){
        return levels;
    }
    
    int getVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    int getHiddenTreasures(){
        return nHiddenTeasures;
    }
    
    boolean getDeath(){
        return death;
    }
    
    boolean isEmpty(){
        if(nHiddenTeasures == 0 && nVisibleTreasures == 0 && specificHiddenTreasure.isEmpty() && specificVisibleTreasure.isEmpty()){
            return true;
        }
        return false;
    }
    
    void substractVisibleTreasure(Treasure t){
        
    }
    
    void substractHiddenTreasure(Treasure t){
        
    }
    
    public String toString(){
        return text +"levels="+ Integer.toString(levels)+"Visible="+Integer.toString(nVisibleTreasures)+"Hidden="+Integer.toString(nHiddenTeasures);
    } 

    BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> vt, ArrayList<Treasure> ht) {
        return this;
    }

    
}
