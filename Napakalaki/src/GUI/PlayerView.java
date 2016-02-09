/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author david
 */

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import NapakalakiGame.BadConsequence;

public class PlayerView extends javax.swing.JPanel {
    
    private Player playerModel;
    private Napakalaki napakalakiModel;
    
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public Player getPlayer(){
        return this.playerModel;
    }
    
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua, si la hubiera
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        //
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    public void setPlayer (Player p) {
        playerModel = p;
        name.setText(this.playerModel.getName());
        enemy.setText(this.playerModel.getEnemy().getName());
        level.setText(Integer.toString(this.playerModel.getLevel()));
        combatLevel.setText(Integer.toString(this.playerModel.getCombatLevel()));
        if(this.playerModel.isDead())
            dead.setText("Yes");
        else
            dead.setText("No");
        // Incluir instrucciones para actualizar su nombre, nivel, etc.
        // A continuación se actualizan sus tesoros
        this.fillTreasurePanel(visibleTreasures,playerModel.getVisibleTreasures());
        this.fillTreasurePanel(hiddenTreasures,playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }
    
    public void setNapakalaki(Napakalaki n){
        this.napakalakiModel = n;
    }
    
    
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel){
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellosque están seleccionados.
        // Finalmente se devuelve dicho vector
        
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for(Component c:aPanel.getComponents()){
            tv = (TreasureView)c;
            if(tv.isSelected())
                output.add(tv.getTreasure());
        }
        
        return output;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        stealTreasure = new javax.swing.JButton();
        makeVisible = new javax.swing.JButton();
        discardTreasures = new javax.swing.JButton();
        discardAllTreasures = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dead = new javax.swing.JLabel();
        pendingBadConsequenceView2 = new GUI.PendingBadConsequenceView();
        hiddenTreasures = new javax.swing.JPanel();
        visibleTreasures = new javax.swing.JPanel();

        jLabel1.setText("Nombre");

        jLabel2.setText("Nivel");

        jLabel3.setText("Nivel de Combate");

        jLabel4.setText("Nombre de Enemigo");

        stealTreasure.setText("Steal Treasure");
        stealTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealTreasureActionPerformed(evt);
            }
        });

        makeVisible.setText("Make Visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discardTreasures.setText("Discard Treasures");
        discardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresActionPerformed(evt);
            }
        });

        discardAllTreasures.setText("Discard All Treasures");
        discardAllTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllTreasuresActionPerformed(evt);
            }
        });

        jLabel5.setText("Tesoros visibles");

        jLabel6.setText("Tesoros ocultos");

        name.setText("jLabel7");

        level.setText("jLabel8");

        combatLevel.setText("jLabel9");

        enemy.setText("jLabel10");

        jLabel11.setText("Muerto");

        dead.setText("jLabel12");

        hiddenTreasures.setBorder(new javax.swing.border.MatteBorder(null));

        visibleTreasures.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout visibleTreasuresLayout = new javax.swing.GroupLayout(visibleTreasures);
        visibleTreasures.setLayout(visibleTreasuresLayout);
        visibleTreasuresLayout.setHorizontalGroup(
            visibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        visibleTreasuresLayout.setVerticalGroup(
            visibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stealTreasure)
                        .addGap(18, 18, 18)
                        .addComponent(makeVisible)
                        .addGap(18, 18, 18)
                        .addComponent(discardTreasures)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(discardAllTreasures))
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addGap(35, 35, 35)
                                        .addComponent(dead, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(160, 160, 160)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(enemy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combatLevel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pendingBadConsequenceView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel6))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(name)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(dead, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(level))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(combatLevel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(enemy)))
                    .addComponent(pendingBadConsequenceView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stealTreasure)
                    .addComponent(makeVisible)
                    .addComponent(discardTreasures)
                    .addComponent(discardAllTreasures))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisibles(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void stealTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealTreasureActionPerformed
        // TODO add your handling code here:
        napakalakiModel.getCurrentPlayer().stealTreasure();
        setPlayer(napakalakiModel.getCurrentPlayer());
        repaint();
    }//GEN-LAST:event_stealTreasureActionPerformed

    private void discardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        for(Treasure t:selHidden){
            this.playerModel.discardHiddenTreasure(t);
        }
        for(Treasure t:selVisible){
            this.playerModel.discardVisibleTreasure(t);
        }
        this.setPlayer(napakalakiModel.getCurrentPlayer());
        repaint();
    }//GEN-LAST:event_discardTreasuresActionPerformed

    private void discardAllTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllTreasuresActionPerformed
        // TODO add your handling code here:
        napakalakiModel.getCurrentPlayer().discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
        repaint();
    }//GEN-LAST:event_discardAllTreasuresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel combatLevel;
    private javax.swing.JLabel dead;
    private javax.swing.JButton discardAllTreasures;
    private javax.swing.JButton discardTreasures;
    private javax.swing.JLabel enemy;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel level;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel name;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView2;
    private javax.swing.JButton stealTreasure;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
