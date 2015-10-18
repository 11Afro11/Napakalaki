/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author afro
 */
public class PruebaNapakalaki {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Monster>monstruos = new ArrayList();
        //bonanza
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        
        monstruos.add(new Monster("Byakhees de bonanza", 8, prize, badConsequence));
        //Chibichulo
        badConsequence = new BadConsequence("Embobados con ellindo primigenio te descartas tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        
        monstruos.add(new Monster("Chibithulhu", 2, prize, badConsequence));
        
        
        
    }
    
}
