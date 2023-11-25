package speed.clicks;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;



/**
 *
 * @author louis
 */
public class JeuSpeedClick extends javax.swing.JFrame {
   
   
    int score;
    JButton[][] boutons;    
    Timer chrono;
    JLabel scoreLab;
    int countdown;
    JLabel cdLab;
    int record=0;
    /**
     * Creates new form JeuSpeedClick
     */
    
  Icon etoile =new ImageIcon("\"C:\\Users\\louis\\OneDrive\\Bureau\\LOUSIE EPF\\algo\\algo\\Speed-Clicks\\src\\speed\\clicks\\resources\\back test.png\"");
    
    public JeuSpeedClick() {
        
        
        setTitle("Speed Click Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        
        /*Icon etoile =new ImageIcon("resources/starwhite.png");*/
        
         JPanel infoPanel = new JPanel (new BorderLayout());
         setContentPane(infoPanel);
        
         scoreLab = new JLabel("Score: 0",SwingConstants.CENTER);
         cdLab = new JLabel ("Countdown: 30", SwingConstants.CENTER);
        cdLab.setFont(new Font("SanSerif", Font.PLAIN, 12));
         
        JPanel scoreEtCdPanel = new JPanel (new GridLayout(1,2));
        scoreEtCdPanel.add(scoreLab);
        scoreEtCdPanel.add(cdLab);
        infoPanel.add(scoreEtCdPanel, BorderLayout.NORTH);
        
       
        
        /*boutons= new JButton[10][10];
        JPanel PanelGrille = new JPanel (new GridLayout (10,10));
        infoPanel.add(PanelGrille, BorderLayout.CENTER);*/
        
        
      
        chrono= new Timer(1000, new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
               countdown--;
               updateCountdownLabel();
               if (countdown ==0){
                stopGame();
           
            startGame();
               }
             }       
        });
    
    
    
   
        /*JPanel panel = new JPanel (new GridLayout(TailleGrille, TailleGrille));*/
        for (int i = 0; i< 10; i++){
           for (int j = 0; j< 10; j++) {
            boutons[i][j]= new JButton();
           /*if (i == 4 || j == 4 || i + j == 4 || i - j == 4) {
            
            */
             boutons[i][j].setBackground(Color.BLUE);
           /*}else{
             boutons[i][j].setBackground(Color.WHITE);      
           } */
           
           /*boutons[i][j].setContentAreaFilled(false);
           boutons[i][j].setBorderPainted(false);*/
             boutons[i][j].addActionListener( new ButtonClickListener());
            
               
            PanelGrille.add(boutons[i][j]);
           }
        }
        
       /* scoreLab = new JLabel ("Score: 0", SwingConstants.CENTER);
        infoPanel.add(scoreLab, BorderLayout.NORTH);*/
        
        
        
startGame();


setVisible(true);
    }
 
               
 
    private void updateCountdownLabel(){
        cdLab.setText("Countdown: "+countdown);
    }      
    
   
    
    
    
    private class ButtonClickListener implements ActionListener {
        @Override
                public void actionPerformed (ActionEvent e){
        JButton clicked = (JButton) e.getSource();
        if (clicked.getBackground() == Color.RED){
            score++;
            clicked.setBackground(Color.BLUE);
            changerBoutonAllume();
            updateScoreLabel();
        }else{
            
            score--;
            updateScoreLabel();
            
        }
        }
        
    }
    private void changerBoutonAllume(){
        Random rand = new Random();
        int lAllumee = rand.nextInt(10);
        int cAllumee = rand.nextInt(10);
        
        for (int i = 0; i< 10; i++){
           for (int j = 0; j< 10; j++) {
              /* boutons [i][j].setBackground(Color.BLUE);*/
              boutons[i][j].setBackground(Color.BLUE);
           }
    }
        boutons[lAllumee][cAllumee].setBackground(Color.RED);
        
    }
  private void startGame() {
      score =0;
      countdown =30;
      updateScoreLabel();
      updateCountdownLabel();
      changerBoutonAllume();
      chrono.start();
    
        
    }

   
   
    private void stopGame(){
        chrono.stop();
        if(score>record){
            record=score;
            JOptionPane.showMessageDialog(JeuSpeedClick.this, "New record! : "+score);
        }else{
            JOptionPane.showMessageDialog(JeuSpeedClick.this, "The Game Is Over! : "+score);
        }
    }
  private void updateScoreLabel(){
      scoreLab.setText("Score: "+score);
      
  }
   
    
        /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelGrille = new javax.swing.JPanel();
        profilLabel = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textField1 = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelGrille.setBackground(new java.awt.Color(255, 204, 204));
        PanelGrille.setForeground(new java.awt.Color(255, 204, 204));
        PanelGrille.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout PanelGrilleLayout = new javax.swing.GroupLayout(PanelGrille);
        PanelGrille.setLayout(PanelGrilleLayout);
        PanelGrilleLayout.setHorizontalGroup(
            PanelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        PanelGrilleLayout.setVerticalGroup(
            PanelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        getContentPane().add(PanelGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 390, 370));

        profilLabel.setBackground(new java.awt.Color(255, 102, 102));
        profilLabel.setMaximumSize(new java.awt.Dimension(200, 200));
        profilLabel.setMinimumSize(new java.awt.Dimension(200, 200));
        profilLabel.setPreferredSize(new java.awt.Dimension(200, 200));
        profilLabel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPasswordField1.setText("jPasswordField1");
        profilLabel.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel1.setText("Login");
        profilLabel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel2.setText("Password");
        profilLabel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 60, -1));

        textField1.setText("textField1");
        profilLabel.add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 90, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("INFO PROFIL");
        profilLabel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 120, 30));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Britannic Bold", 2, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 102));
        jButton1.setText("START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        profilLabel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speed/clicks/resources/back test.png"))); // NOI18N
        jLabel5.setText("Login");
        profilLabel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 210));

        getContentPane().add(profilLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 220, 210));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.setText("Avance");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 130, -1));

        jCheckBox3.setText("Affirme");
        jPanel1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, -1));

        jCheckBox2.setText("Intermediaire");
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, -1));

        jCheckBox4.setText("debutant");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("NIVEAU");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 220, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void PanelGrilleActionPerformed(java.awt.event.ActionEvent evt) {                                           
         JPanel infoPanel = new JPanel (new BorderLayout());
         setContentPane(infoPanel);
         boutons= new JButton[10][10];
        JPanel PanelGrille = new JPanel (new GridLayout (10,10));
        infoPanel.add(PanelGrille, BorderLayout.CENTER);
/*JPanel panel = new JPanel (new GridLayout(TailleGrille, TailleGrille));*/
        for (int i = 0; i< 10; i++){
           for (int j = 0; j< 10; j++) {
            boutons[i][j]= new JButton();
           /*if (i == 4 || j == 4 || i + j == 4 || i - j == 4) {
            
            */
             boutons[i][j].setBackground(Color.BLUE);
           /*}else{
             boutons[i][j].setBackground(Color.WHITE);      
           } */
           
           /*boutons[i][j].setContentAreaFilled(false);
           boutons[i][j].setBorderPainted(false);*/
             boutons[i][j].addActionListener( new ButtonClickListener());
            
               
            PanelGrille.add(boutons[i][j]);
           }
        }// TODO add your handling code here:
    }  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(JeuSpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuSpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuSpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuSpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JeuSpeedClick().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGrille;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPanel profilLabel;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
