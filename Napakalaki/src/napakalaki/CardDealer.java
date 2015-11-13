/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class CardDealer {
    	private static CardDealer instance = null;

	private CardDealer(){

	}

	private void initTreasureCardDeck(){

	}

	private void initMonsrerCardDeck(){

	}

	private void shuffleTreasures(){
	
	}

	private void shuffleMonsters(){

	}

	private CardDealer getInstance(){
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

	}

	public void giveMonsterBack(Monster m){
		
	}

	public void initCards(){

	}
}
