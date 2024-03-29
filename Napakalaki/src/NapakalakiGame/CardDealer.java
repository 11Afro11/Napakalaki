/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


/**
 *
 * @author david
 */
public class CardDealer {
    	private static CardDealer instance = null;
        private ArrayList<Treasure> unusedTreasures= new ArrayList();
        private ArrayList<Monster> usedMonster= new ArrayList();
        private ArrayList<Treasure> usedTreasures= new ArrayList();
        private ArrayList<Monster> unusedMonster= new ArrayList();
        private ArrayList<Cultist> cultistDeck= new ArrayList();
        
        

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
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Byakhees de bonanza", 8, prize, badConsequence));
        
        //Chibichulo
        badConsequence = new SpecificBadConsequence("Embobados con ellindo primigenio te descartas tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);        
        unusedMonster.add(new Monster("Chibithulhu", 2, prize, badConsequence));
        
        //Dunwich
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(1, 1);        
        unusedMonster.add(new Monster("El sopor de Dunwitch", 2, prize, badConsequence));
        
        //Angeles de la noche ibicenca
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte a una fiesta y te dejan caer en mitad del vuelo. Descarta una mano visible y una mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);        
        unusedMonster.add(new Monster("Ángeles de la noche ibicenca", 14, prize, badConsequence));
        
        //El gorron en el umbral      Pendiente de revision
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, 5, 0);
        prize = new Prize(3, 1);
        unusedMonster.add(new Monster("El gorrón en el umbral", 10, prize, badConsequence));
        
        //munchcraft
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        //bichgooth
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("Bichgooth", 2, prize, badConsequence));
        
        //Rey de rosa
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4, 2);
        unusedMonster.add(new Monster("El rey de rosa", 13, prize, badConsequence));
        
        //La que redacta las tinieblas
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("La que redacta en las tinieblas",2 , prize, badConsequence));
        
        //Bicefalo
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("Bicéfalo", 20, prize, badConsequence));
        
        //Los Hondos
        badConsequence = new DeathBadConsequence("Estos unusedMonster resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Los hondos", 8, prize, badConsequence));
        
        //Semillas Cthulhu
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Semillas Cthulhu", 4, prize, badConsequence));
        
        //Dameargo
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano invisible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Dameargo", 1, prize, badConsequence));
        
        //Pollipolipo Volante
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("Pollipolipo volante", 3, prize, badConsequence));
        
        //Yskhtihussg-Goth
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        unusedMonster.add(new Monster("Yskhtihussg-Goth", 12, prize, badConsequence));
        
        //Familia Feliz
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize(4, 1);
        unusedMonster.add(new Monster("Familia feliz", 1, prize, badConsequence));
        
        //Roboggoth
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Roboggoth", 8, prize, badConsequence));
        
        //El Espia
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("El espia", 5, prize, badConsequence));
        
        //El Lenguas
        badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("El Lenguas", 20, prize, badConsequence));

                /**********************************************************Monstruos con Sectarios**********************************************************/

        badConsequence = new SpecificBadConsequence("Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);
        unusedMonster.add(new Monster("El mal indecible inpronunciable", 10, prize, badConsequence, -2));

        badConsequence = new NumericBadConsequence("Pierdes tus tesoreos visibles. Jajaja", 0, Integer.MAX_VALUE, 0);
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Testigos Oculares", 6, prize, badConsequence, +2));

        badConsequence = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres", true);
        prize = new Prize(2, 5);
        unusedMonster.add(new Monster("El gran Cthulhu", 20, prize, badConsequence, +4));

        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Serpiente Politico", 8, prize, badConsequence, -2));

        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, new ArrayList(Arrays.asList(
          TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind. ONEHAND)));
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("Felpugoth", 2, prize, badConsequence, +5));

        badConsequence = new NumericBadConsequence("Pierdes dos niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonster.add(new Monster("Shoggoth", 16, prize, badConsequence, -4));

        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes dos niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonster.add(new Monster("Lolitagooth", 2, prize, badConsequence, +3));
	}

        
        private void initCultistCardDeck(){

            cultistDeck.add( new Cultist("Sectario: +1 por cada sectario en juego. No puedes dejar de ser sectario", 1));

            cultistDeck.add( new Cultist("Sectario: +2 por cada sectario en juego. No puedes dejar de ser sectario", 2));

            cultistDeck.add( new Cultist("Sectario: +1 por cada sectario en juego. No puedes dejar de ser sectario", 1));

            cultistDeck.add( new Cultist("Sectario: +2 por cada sectario en juego. No puedes dejar de ser sectario", 2));

            cultistDeck.add( new Cultist("Sectario: +1 por cada sectario en juego. No puedes dejar de ser sectario", 1));

            cultistDeck.add( new Cultist("Sectario: +1 por cada sectario en juego. No puedes dejar de ser sectario", 1));

            shuffleCultist();
        }


	private void shuffleTreasures(){
            Collections.shuffle(this.unusedTreasures);
	}

	private void shuffleMonsters(){
            Collections.shuffle(this.unusedMonster);
	}
        
        private void shuffleCultist(){
            Collections.shuffle(this.cultistDeck);
        }

	public static CardDealer getInstance(){
		if(instance == null){
			instance = new CardDealer();
		}
		return instance;
	}

	public Treasure nextTreasure(){
            if(this.unusedTreasures == null){
              for(Treasure t: this.usedTreasures){
                this.unusedTreasures.add(t);
              }

              this.shuffleTreasures();
              this.usedTreasures.clear();
            }
            Treasure t = this.unusedTreasures.get(0);
            this.usedTreasures.add(t);
            this.unusedTreasures.remove(t);

            return t;

        }

        public Monster nextMonster(){
            if(this.unusedMonster == null){
                for(Monster m: this.usedMonster){
                    this.unusedMonster.add(m);
            }

            this.shuffleMonsters();
            this.usedMonster.clear();
            }
            Monster m = this.unusedMonster.get(0);
            this.usedMonster.add(m);
            this.unusedMonster.remove(m);
            return m;
        }
        
        public Cultist nextCultist(){
            Cultist c;
            c = cultistDeck.get(0);
            cultistDeck.remove(0);
            return c;
            
        }

        public void giveTreasureBack(Treasure t){
            this.usedTreasures.add(t);
        }

        public void giveMonsterBack(Monster m){
                this.usedMonster.add(m);
        }

        public void initCards(){            
            this.initTreasureCardDeck();
            this.initMonsterCardDeck();
            this.shuffleMonsters();
            this.shuffleTreasures();
            this.shuffleCultist();

        }

   
}
