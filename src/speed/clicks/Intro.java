package speed.clicks;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author louis
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Intro extends javax.swing.JFrame {
 SpeedClick speedClickF;
 reglesDeJeu rdjFrame;
 static String theme;
 
    /**
     * Creates new form Intro
     */
    public Intro() {
        initComponents();
        /*Start.setEnabled(false);*/
    }
    
    public void update(){
        repaint();
    }
    /*private void startButtonEnabled() {
    boolean checkboxSelected = (Debutant.isSelected() || Intermediaire.isSelected() || Confirme.isSelected() || Avance.isSelected());
    Start.setEnabled(checkboxSelected);
}*/
    
    public boolean isDebutantSelected(){
        return Debutant.isSelected();
    }
    
    public JCheckBox getIntermediaireCheckBox(){
        return Intermediaire;
    }
    
    public void setIntermediaireEnabled(boolean enabled){
       Intermediaire.setEnabled(enabled);
    }
    public boolean isIntermediaireSelected(){
        return Intermediaire.isSelected();
    }
    public boolean isConfirmeSelected(){
        return Confirme.isSelected();
    }
     public boolean isAvanceSelected(){
        return Avance.isSelected();
    }
     public boolean isNoelSelected(){
        return Noel.isSelected();
    }
     public boolean isPirateSelected(){
        return Pirate.isSelected();
    }
     public boolean isEtoileSelected(){
        return Etoile.isSelected();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Debutant = new javax.swing.JCheckBox();
        Confirme = new javax.swing.JCheckBox();
        Intermediaire = new javax.swing.JCheckBox();
        Avance = new javax.swing.JCheckBox();
        Etoile = new javax.swing.JCheckBox();
        Noel = new javax.swing.JCheckBox();
        Pirate = new javax.swing.JCheckBox();
        Start = new javax.swing.JButton();
        rdjButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Harlow Solid Italic", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to our game Speed-Click");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 690, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CHOOSE THE MODE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CHOOSE THE LEVEL");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        Debutant.setForeground(new java.awt.Color(255, 255, 255));
        Debutant.setText("D�butant");
        Debutant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DebutantActionPerformed(evt);
            }
        });
        jPanel1.add(Debutant, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, 20));

        Confirme.setForeground(new java.awt.Color(255, 255, 255));
        Confirme.setText("Confirm�");
        Confirme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmeActionPerformed(evt);
            }
        });
        jPanel1.add(Confirme, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, 20));

        Intermediaire.setForeground(new java.awt.Color(255, 255, 255));
        Intermediaire.setText("Intermediaire");
        Intermediaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IntermediaireActionPerformed(evt);
            }
        });
        jPanel1.add(Intermediaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, 20));

        Avance.setForeground(new java.awt.Color(255, 255, 255));
        Avance.setText("Avanc�");
        jPanel1.add(Avance, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, 20));

        Etoile.setForeground(new java.awt.Color(255, 255, 255));
        Etoile.setText("Etoile");
        jPanel1.add(Etoile, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        Noel.setForeground(new java.awt.Color(255, 255, 255));
        Noel.setText("Noel");
        Noel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoelActionPerformed(evt);
            }
        });
        jPanel1.add(Noel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, 20));

        Pirate.setForeground(new java.awt.Color(255, 255, 255));
        Pirate.setText("Pirate");
        Pirate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PirateActionPerformed(evt);
            }
        });
        jPanel1.add(Pirate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, 20));

        Start.setBackground(new java.awt.Color(0, 0, 51));
        Start.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        Start.setForeground(new java.awt.Color(255, 255, 255));
        Start.setText("START");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        jPanel1.add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 140, 50));

        rdjButton.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        rdjButton.setForeground(new java.awt.Color(0, 0, 51));
        rdjButton.setText("( ;   REGLES DU JEU    ; )");
        rdjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdjButtonActionPerformed(evt);
            }
        });
        jPanel1.add(rdjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 190, 50));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("You have to choose a mode and a level before ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 250, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("you click on the start button");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speed/clicks/resources/Menu.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel4.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -130, 1110, 860));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 790, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
       speedClickF = new SpeedClick(this);
       speedClickF.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_StartActionPerformed
  
     
    private void ConfirmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmeActionPerformed
       if (speedClickF != null){
           speedClickF.setPanelGrilleTaille(10);
       }
       /*startButtonEnabled();*/
    }//GEN-LAST:event_ConfirmeActionPerformed

    private void AvanceActionPerformed(java.awt.event.ActionEvent evt) {                                         
       if (speedClickF != null){
           speedClickF.setPanelGrilleTaille(10);
       }
       /*startButtonEnabled();*/
    }     
    private void rdjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdjButtonActionPerformed
        rdjFrame= new reglesDeJeu();
        rdjFrame.setVisible(true);
    }//GEN-LAST:event_rdjButtonActionPerformed

    private void NoelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoelActionPerformed
theme = "noel";        // TODO add your handling code here:
    }//GEN-LAST:event_NoelActionPerformed

    private void PirateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PirateActionPerformed
theme= "pirate";        // TODO add your handling code here:
    }//GEN-LAST:event_PirateActionPerformed
     private void EtoileActionPerformed(java.awt.event.ActionEvent evt) {                                       
theme= "etoile";        // TODO add your handling code here:
    }                                   
    
    private void IntermediaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntermediaireActionPerformed
             if (speedClickF != null){
           speedClickF.setPanelGrilleTaille(10);
       }
 
    }//GEN-LAST:event_IntermediaireActionPerformed

    private void DebutantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DebutantActionPerformed
             if (speedClickF != null){
           speedClickF.setPanelGrilleTaille(5);
       }
  
    }//GEN-LAST:event_DebutantActionPerformed

    
    
      
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Intro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Avance;
    private javax.swing.JCheckBox Confirme;
    private javax.swing.JCheckBox Debutant;
    private javax.swing.JCheckBox Etoile;
    private javax.swing.JCheckBox Intermediaire;
    private javax.swing.JCheckBox Noel;
    private javax.swing.JCheckBox Pirate;
    private javax.swing.JButton Start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton rdjButton;
    // End of variables declaration//GEN-END:variables

    
}
