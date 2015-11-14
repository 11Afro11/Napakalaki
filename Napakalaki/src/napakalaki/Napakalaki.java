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
public class Napakalaki {
    	private static Napakalaki instance = null;

	private Napakalaki(){

	}

	private void initPlayers(String[] names){

	}

	private Player nextPlayer(){
		return null;
	}

	private boolean nextTurnAllowed(){
		return false;
	}

	private void setenemies(){

	}

	public static Napakalaki getInstance(){
		if(instance == null){
			instance = new Napakalaki();
		}
		return instance;
	}

	public CombatResult developCombat(){
		return null;
	}

	public void discardVisibleTreasures(TreasureKind tesoro){
		
	}

	public void discardHiddenTreasures(TreasureKind tesoro){

        }

	public void makeTreasuresVisibles(TreasureKind tesoro){
		
	}

	public void initGame(String[] players){
		
	}

	public Player getCurrentPlayer(){
		return null;
	}

	public Monster getCurrentMonster(){
		return null;
	}

	public boolean nextTurn(){
		return false;
	}

	public boolean endOfGame(CombatResult result){
		return false;
	}
}

