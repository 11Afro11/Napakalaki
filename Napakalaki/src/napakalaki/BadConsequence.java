/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author afro
 */
public class BadConsequence {
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
    
    String getText(){
        return text;
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
    
    public String toString(){
        return text +"levels="+ Integer.toString(levels)+"Visible="+Integer.toString(nVisibleTreasures)+"Hidden="+Integer.toString(nHiddenTeasures);
    } 
}
