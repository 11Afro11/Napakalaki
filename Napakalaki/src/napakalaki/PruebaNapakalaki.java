/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
        String nombre = "Hydra";
        int combat = 7;
        Monster premio= new Monster(nombre, combat);
        
        System.out.println("Su monstruo es "+ premio.getName());
    }
    
}
