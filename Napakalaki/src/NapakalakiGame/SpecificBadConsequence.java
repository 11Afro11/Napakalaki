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
public class SpecificBadConsequence extends BadConsequence{
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        super(text, levels, tVisible, tHidden);
    }
    
    
    BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> vt, ArrayList<Treasure> ht) {
        ArrayList<TreasureKind> tvisible = new ArrayList(vt);
        ArrayList<TreasureKind> thidden = new ArrayList(ht);
        
        ArrayList<TreasureKind> comparasionVisible = new ArrayList(super.getSpecificVisibleTreasures());
        ArrayList<TreasureKind> comparasionOculta = new ArrayList(super.getSpecificHiddenTreasures());

        int nHidden = super.getHiddenTreasures();
        int nVisible = super.getVisibleTreasures();
        
        int nv = 0; 
        int nh = 0;
        
        BadConsequence bd = new NumericBadConsequence("",0,0,0);
        
        if(nHidden != 0 || nVisible != 0){
            if(vt.size() <= nVisible){
                nv = vt.size();
            }
            else
                nv = nVisible;
            
            if(ht.size() <= nHidden){
                nh = ht.size();
            }
            else
                nh = nVisible;
            
            bd = new NumericBadConsequence(super.getText(), super.getLevels(), nv,nh);
        }
        
        else if(!comparasionVisible.isEmpty() || !comparasionOculta.isEmpty()){
            tvisible.retainAll(comparasionVisible);
            thidden.retainAll(comparasionOculta);
            bd = new SpecificBadConsequence(super.getText(), super.getLevels(), tvisible,thidden);
            
        }
        return bd;
    }
    
    void substractVisibleTreasure(Treasure t){
        ArrayList<TreasureKind> aux = super.getSpecificVisibleTreasures();
        aux.remove(t.getType());
        super.setSpecificVisibleTreasure(aux);
    }
    
    void substractHiddenTreasure(Treasure t){
        ArrayList<TreasureKind> aux = super.getSpecificHiddenTreasures();
        aux.remove(t.getType());
        super.setSpecificHiddenTreasure(aux);
    }
    
}
