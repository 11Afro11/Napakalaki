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
     * @paramargs the command line arguments
     */
    static ArrayList<Monster> level10(ArrayList<Monster> monstruo){
        ArrayList<Monster> level10= new ArrayList(); 
        for(Monster m : monstruo){
            if(m.getCombatLevel() == 10){
                level10.add(m);
            }
        }
        return level10;
    }
    
    static ArrayList<Monster> pierdeNivel(ArrayList<Monster> monstruo){
        ArrayList<Monster> pierdeNivel= new ArrayList(); 
        for(Monster m : monstruo){
            if(m.getBc().getLevels() > 0){
                pierdeNivel.add(m);
            }
        }
        return pierdeNivel;
    }
    
    static ArrayList<Monster> buenRollo(ArrayList<Monster> monstruo){
        ArrayList<Monster> buenRollo= new ArrayList(); 
        for(Monster m : monstruo){
            if(m.getPrice().getLevels() > 0){
                buenRollo.add(m);
            }
        }
        return buenRollo;
    }
    
    static ArrayList<Monster> pierdeTesoro(ArrayList<Monster> monstruo){
        ArrayList<Monster> pierdeTesoro= new ArrayList(); 
        for(Monster m : monstruo){
            if(m.getBc().getHiddenTreasures() != 0 || m.getBc().getVisibleTreasures() != 0){
                pierdeTesoro.add(m);
            }
        }
        return pierdeTesoro;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Monster>monstruos = new ArrayList();
        //bonanza
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        monstruos.add(new Monster("Byakhees de bonanza", 8, prize, badConsequence));
        
        //Chibichulo
        badConsequence = new BadConsequence("Embobados con ellindo primigenio te descartas tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);        
        monstruos.add(new Monster("Chibithulhu", 2, prize, badConsequence));
        
        //Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(1, 1);        
        monstruos.add(new Monster("El sopor de Dunwitch", 2, prize, badConsequence));
        
        //Angeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte a una fiesta y te dejan caer en mitad del vuelo. Descarta una mano visible y una mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);        
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, prize, badConsequence));
        
        //El gorron en el umbral      Pendiente de revision
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 5, 0);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, prize, badConsequence));
        
        //munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        //bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bichgooth", 2, prize, badConsequence));
        
        //Rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        monstruos.add(new Monster("El rey de rosa", 13, prize, badConsequence));
        
        //La que redacta las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("La que redacta en las tinieblas",2 , prize, badConsequence));
        
        //Bicefalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Bicéfalo", 20, prize, badConsequence));
        
        //Los Hondos
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Los hondos", 8, prize, badConsequence));
        
        //Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, prize, badConsequence));
        
        //Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano invisible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Dameargo", 1, prize, badConsequence));
        
        //Pollipolipo Volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Pollipolipo volante", 3, prize, badConsequence));
        
        //Yskhtihussg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Yskhtihussg-Goth", 12, prize, badConsequence));
        
        //Familia Feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Familia feliz", 1, prize, badConsequence));
        
        //Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Roboggoth", 8, prize, badConsequence));
        
        //El Espia
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El espia", 5, prize, badConsequence));
        
        //El Lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El Lenguas", 20, prize, badConsequence));
        
        
        System.out.println("Monstruos con niveles superioes a 10: \n\n");
        System.out.println(level10(monstruos));
        
        System.out.println("Monstruos mal rollo de perdida de niveles: \n\n");
        System.out.println(pierdeNivel(monstruos));
        
        System.out.println("Monstruos buen rollo superior a 1 nivel: \n\n");
        System.out.println(buenRollo(monstruos));
        
        System.out.println("Monstruos mal rollo perdida de tesoros: \n\n");
        System.out.println(pierdeTesoro(monstruos));
        
        
        
    }
    
}
