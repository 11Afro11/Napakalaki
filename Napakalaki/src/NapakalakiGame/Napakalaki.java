/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open theNtemplate in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Random;
import NapakalakiGame.CardDealer;


/**
 *
 * @author david
 */
public class Napakalaki{
    	private static Napakalaki instance = null;
    	private ArrayList<Player> players;
    	private Player currentPlayer;
    	private Monster currentMonster;
    	private dealer = CardDealer.getInstance();

	public Napakalaki(){

	}

	private void initPlayers(String[] names){
            players = new ArrayList();
            for(String s : names){
                players.add(new Player(s));
            }
	}

	private Player nextPlayer(){
            int total_p = players.size();
            int next_index = 0;
            if(currentPlayer == null){
                Random sig = new Random();
                next_index = sig.nextInt(total_p);
            }
            return players.get(next_index);
	}

	private boolean nextTurnAllowed(){
		boolean allowed;
		if(this.currentPlayer == null){
			allowed = true;
		}
		else{
			allowed = this.currentPlayer.validState();
		}
		return allowed;
	}

	private void setenemies(){
		int total_players = this.players.size();
                int index_enemy;
                Player enemy;
		do{
                    Random rnd = new Random();
                    index_enemy = rnd.nextInt(total_players);
                    enemy = players.get(index_enemy);
                }while(currentPlayer != enemy);
	}

	public static Napakalaki getInstance(){
		if(instance == null){
			instance = new Napakalaki();
		}
		return instance;
	}

	public CombatResult developCombat(){
		CombatResult combat;
		Monster m = this.currentMonster;
		int myLevel = this.currentPlayer.getCombatLevel();
		int monsterLevel = this.currentMonster.getCombatLevel();

		if(myLevel > monsterLevel){
			this.currentMonster.getPrize();
			combat = WIN;
		}
		else{
			this.currentMonster.getBc();
			combat = LOSE;
		}

		this.dealer.giveTreasureBack(m);
		return combat;
	}

	public void discardVisibleTreasures(ArrayList<Treasure> treasures){
		for(Treasure t : treasures){
			this.currentPlayer.discardVisibleTreasures(t);
			this.dealer.giveTreasureBack(t);
		}
	}

	public void discardHiddenTreasures(ArrayList<Treasure> treasures){
		for(Treasure t : treasures){
			this.currentPlayer.discardHiddenTreasures(t);
			this.dealer.giveTreasureBack(t);
		}
	}

	public void makeTreasuresVisibles(ArrayList<Treasure> treasures){
		for(Treasure t : treasures){
			this.currentPlayer.makeTreasuresVisibles(t);
			boolean canI = canMakeTreasureVisible(t);

			if(canI){
				this.dealer.giveTreasureBack(t);
			}
		}		
	}

	public void initGame(String[] players){
		this.initPlayers(players);
		this.setenemies();
		dealer.initCards();
		this.nextTurn();		
	}

	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}

	public Monster getCurrentMonster(){
		return this.currentMonster;
	}

	public boolean nextTurn(){
		boolean allowed = this.nextTurnAllowed();
		boolean dead;

		if(allowed){
			this.currentPlayer = this.nextPlayer();
			this.currentMonster = dealer.nextMonster();
			dead = this.currentPlayer.isDead();

			if(dead){
				this.currentPlayer.initTreasures();
			}
		}
		return allowed;
	}

	public boolean endOfGame(CombatResult result){
		return result == CombatResult.WINGAME;
	}

   /* public void initGame(ArrayList<String> names) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}

