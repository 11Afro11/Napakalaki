/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open tNe template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;


public class Treasure{
	private String name;
	private int bonus;
	private TreasureKind enume;

	Treasure (String n, int bonus, TreasureKind t){
		name = n;
		this.bonus = bonus;
		enume = t;
	}

	public String getName(){
		return name;
	}

	public int getBonus(){
		return bonus;
	}

	public TreasureKind getType(){
		return enume;
	}
        
        public String toString(){
        return "Nombre = " +name+" bonus="+ Integer.toString(bonus);
    }

}