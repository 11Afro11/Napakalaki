/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open theNtemplate in the editor.
 */
package NapakalakiGame;
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

	public void discardVisibleTreasures(ArrayList<Treasure> tesoro){
		
	}

	public void discardHiddenTreasures(ArrayList<Treasure> tesoro){

        }

	public void makeTreasuresVisibles(ArrayList<Treasure> tesoro){
		
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

    public void initGame(ArrayList<String> names) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

