/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.BadConsequence;
import NapakalakiGame.Treasure;
import NapakalakiGame.TreasureKind;
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
        
        BCvisibleTreasures.setText("Tesoros totales: " +Integer.toString(this.badConsequenceModel.getVisibleTreasures()));
        BCHiddenTreasures.setText("Tesoros totales: " + Integer.toString(this.badConsequenceModel.getHiddenTreasures()));
        
        for(TreasureKind t : this.badConsequenceModel.getSpecificVisibleTreasures()){
            BCvisibleTreasures.append(t+"");
        }
        
        for(TreasureKind t : this.badConsequenceModel.getSpecificHiddenTreasures()){
            BCvisibleTreasures.append(t+"");
        }
        
        
 


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
        text = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        death = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BCvisibleTreasures = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        BCHiddenTreasures = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setText("Niveles: ");

        jLabel1.setText("Nombre:");

        text.setText("jLabel5");

        levels.setText("jLabel6");

        jLabel7.setText("Muerto:");

        death.setText("jLabel8");

        BCvisibleTreasures.setColumns(20);
        BCvisibleTreasures.setRows(5);
        jScrollPane1.setViewportView(BCvisibleTreasures);

        BCHiddenTreasures.setColumns(20);
        BCHiddenTreasures.setRows(5);
        jScrollPane2.setViewportView(BCHiddenTreasures);

        jLabel5.setText("Tesoros Visibles:");

        jLabel6.setText("Tesoros Invisibles:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(death, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(181, 181, 181))))
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
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BCHiddenTreasures;
    private javax.swing.JTextArea BCvisibleTreasures;
    private javax.swing.JLabel death;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel levels;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
