/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import Test.GameTester;
import java.util.ArrayList;

public class EjemploMain {

    public static void main(String[] args) {
      Napakalaki game = Napakalaki.getInstance();
      ArrayList<String> names = new ArrayList<String>();
      NapakalakiView napakalakiView = new NapakalakiView();
      Dice.createInstance(napakalakiView);
      napakalakiView.setNapakalaki(game);
      
      PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
      names = namesCapture.getNames();
      game.initGame(names);
      
      napakalakiView.setVisible(true);
      
//      GameTester test = GameTester.getInstance();
//      
//      // Poner el numero de jugadores con el que se quiera probar
//      test.play(game, 2); 
//              
    }
}
