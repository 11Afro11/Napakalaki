/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


/**
 *
 * @author david
 */
public class CardDealer {
    	private static CardDealer instance = null;
        private ArrayList<Treasure> unusedTreasures;
        private ArrayList<Monster> usedMonster;
        private ArrayList<Treasure> usedTreasures;
        private ArrayList<Monster> unusedMonster;
        
        

	private CardDealer(){

	}

	private void initTreasureCardDeck(){
           unusedTreasures = new ArrayList();
           
           unusedTreasures.add(new Treasure("Si mi amo", 4, TreasureKind.HELMET));
           unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
           unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
           unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
           unusedTreasures.add(new Treasure("Botas de lluvia acida", 1, TreasureKind.BOTHHANDS));
           unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
           unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
           unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
           unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("fez alopodo", 3, TreasureKind.HELMET));
           unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
           unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
           unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
           unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
           unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
           unusedTreasures.add(new Treasure("Necrocomicon", 1, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS));
           unusedTreasures.add(new Treasure("Linterna a dos manos", 3, TreasureKind.BOTHHANDS));
           unusedTreasures.add(new Treasure("Necrognomicon", 2, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
           unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("Necroplayboycon", 3, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
           unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
           unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
           unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
	}

	private void initMonsterCardDeck(){
                    //bonanza
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Byakhees de bonanza", 8, prize, badConsequence));
        
        //Chibichulo
        badConsequence = new BadConsequence("Embobados con ellindo primigenio te descartas tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);        
        unusedMonster.add(new Monster("Chibithulhu", 2, prize, badConsequence));
        
        //Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(1, 1);        
        unusedMonster.add(new Monster("El sopor de Dunwitch", 2, prize, badConsequence));
        
        //Angeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte a una fiesta y te dejan caer en mitad del vuelo. Descarta una mano visible y una mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);        
        unusedMonster.add(new Monster("Ángeles de la noche ibicenca", 14, prize, badConsequence));
        
        //El gorron en el umbral      Pendiente de revision
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 5, 0);
        prize = new Prize(3, 1);
        unusedMonster.add(new Monster("El gorrón en el umbral", 10, prize, badConsequence));
        
        //munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        //bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("Bichgooth", 2, prize, badConsequence));
        
        //Rey de rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        unusedMonster.add(new Monster("El rey de rosa", 13, prize, badConsequence));
        
        //La que redacta las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("La que redacta en las tinieblas",2 , prize, badConsequence));
        
        //Bicefalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("Bicéfalo", 20, prize, badConsequence));
        
        //Los Hondos
        badConsequence = new BadConsequence("Estos unusedMonster resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Los hondos", 8, prize, badConsequence));
        
        //Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Semillas Cthulhu", 4, prize, badConsequence));
        
        //Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano invisible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Dameargo", 1, prize, badConsequence));
        
        //Pollipolipo Volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("Pollipolipo volante", 3, prize, badConsequence));
        
        //Yskhtihussg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        unusedMonster.add(new Monster("Yskhtihussg-Goth", 12, prize, badConsequence));
        
        //Familia Feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize(4, 1);
        unusedMonster.add(new Monster("Familia feliz", 1, prize, badConsequence));
        
        //Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Roboggoth", 8, prize, badConsequence));
        
        //El Espia
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("El espia", 5, prize, badConsequence));
        
        //El Lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("El Lenguas", 20, prize, badConsequence));

	}

	private void shuffleTreasures(){
            Collections.shuffle(this.unusedTreasures);
	}

	private void shuffleMonsters(){
            Collections.shuffle(this.unusedMonster);
	}

	public CardDealer getInstance(){
		if(instance == null){
			instance = new CardDealer();
		}
		return instance;
	}

	public Treasure nextTreasure(){
		return null;
	}

	public Monster nextMonster(){
		return null;
	}

	public void giveTreasureBack(Treasure t){
            this.usedTreasures.add(t);
	}

	public void giveMonsterBack(Monster m){
		this.usedMonster.add(m);
	}

	public void initCards(){
            this.shuffleMonsters();
            this.shuffleTreasures();
            this.initTreasureCardDeck();
            this.initMonsterCardDeck();
            
	}
}
