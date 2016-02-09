/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.BadConsequence;
import NapakalakiGame.Treasure;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 *
 * @author david
 */
public class BadConsequenceView extends javax.swing.JPanel {
    
    private BadConsequence badConsequenceModel;
    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
        initComponents();
    }
    
    private void fillBadConsequencePanel (JPanel aPanel, ArrayList<Treasure> aList) {
    aPanel.removeAll();
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
    public void setBadConsequence(BadConsequence bc){
        badConsequenceModel = bc;
        
        text.setText(this.badConsequenceModel.getText());
        levels.setText(Integer.toString(this.badConsequenceModel.getLevels()));
        if(this.badConsequenceModel.getDeath()){
            death.setText("Yes");
        }
        else{
            death.setText("No");
        }
        this.fillBadConsequencePanel(BCnVisibleTreasures, badConsequenceModel.getVisibleTreasures());
        this.fillBadConsequencePanel(BCnHiddenreasures, badConsequenceModel.getHiddenTreasures());
        this.fillBadConsequencePanel(BCspecificHiddenTreasures, badConsequenceModel.getSpecificHiddenTreasures());
        this.fillBadConsequencePanel(BCspecificVisibleTreasures, badConsequenceModel.getSpecificVisibleTreasures());

        repaint();
        revalidate();

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BCspecificHiddenTreasures = new javax.swing.JPanel();
        BCspecificVisibleTreasures = new javax.swing.JPanel();
        text = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        death = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BCnHiddenreasures = new javax.swing.JPanel();
        BCnVisibleTreasures = new javax.swing.JPanel();

        jLabel2.setText("Niveles: ");

        jLabel1.setText("Nombre:");

        jLabel3.setText("specificHiddenTreasure: ");

        jLabel4.setText("specificVisibleTreasure:");

        BCspecificHiddenTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BCspecificVisibleTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        text.setText("jLabel5");

        levels.setText("jLabel6");

        jLabel7.setText("Muerto:");

        death.setText("jLabel8");

        jLabel9.setText("nVisibleTreasures:");

        jLabel10.setText("nHiddenTreasures: ");

        BCnHiddenreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout BCnHiddenreasuresLayout = new javax.swing.GroupLayout(BCnHiddenreasures);
        BCnHiddenreasures.setLayout(BCnHiddenreasuresLayout);
        BCnHiddenreasuresLayout.setHorizontalGroup(
            BCnHiddenreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BCnHiddenreasuresLayout.setVerticalGroup(
            BCnHiddenreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        BCnVisibleTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout BCnVisibleTreasuresLayout = new javax.swing.GroupLayout(BCnVisibleTreasures);
        BCnVisibleTreasures.setLayout(BCnVisibleTreasuresLayout);
        BCnVisibleTreasuresLayout.setHorizontalGroup(
            BCnVisibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        BCnVisibleTreasuresLayout.setVerticalGroup(
            BCnVisibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(levels))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(141, 141, 141)
                                .addComponent(text)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(death, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(181, 181, 181))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(213, 213, 213))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(246, 246, 246)
                                .addComponent(jLabel10))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(BCspecificVisibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BCnHiddenreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(BCspecificHiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(BCnVisibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(levels)
                    .addComponent(death))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BCspecificHiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BCspecificVisibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(BCnHiddenreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(BCnVisibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BCnHiddenreasures;
    private javax.swing.JPanel BCnVisibleTreasures;
    private javax.swing.JPanel BCspecificHiddenTreasures;
    private javax.swing.JPanel BCspecificVisibleTreasures;
    private javax.swing.JLabel death;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel levels;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
