/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package speed.clicks;

/**
 *
 * @author louis
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;



/**
 *
 * @author louis
 */
public class SpeedClick extends javax.swing.JFrame {
   
   
    int score;
    JButton[][] boutons;    
    Timer chrono;
    JLabel scoreLab;
    int countdown;
    JLabel cdLab;
    int record=0;
    int tailleGrille =0;
    private static final int CONFIRME_NUM_BUTTONS = 4;
    Intro iInstance;
    
    
    List<Integer> boutonsAllumes;
    

    /**
     * Creates new form JeuSpeedClick
     */
    private static final int CONFIRME_NB_BOUTONS = 4;
  /*Icon etoile =new ImageIcon("\"C:\\Users\\louis\\OneDrive\\Bureau\\LOUSIE EPF\\algo\\algo\\Speed-Clicks\\src\\speed\\clicks\\resources\\back test.png\"");*/
    
    public SpeedClick(Intro iInstance) {
        this.iInstance = iInstance;
        
        
        setTitle("Speed Click Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        
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
        
       
        PanelGrille = new JPanel();
        infoPanel.add(PanelGrille, BorderLayout.CENTER);
        
        
      
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
    
    
    
               
startGame();
setVisible(true);
    }
  public void setPanelGrilleTaille(int taille){
          boutons = new JButton[taille][taille];
        PanelGrille.removeAll();
        JPanel panelGrille = new JPanel(new GridLayout(taille, taille));

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setBackground(Color.BLUE);
                boutons[i][j].addActionListener(new ButtonClickListener());
                panelGrille.add(boutons[i][j]);
            }
        }
        PanelGrille.setLayout(new BorderLayout());
        PanelGrille.add(panelGrille, BorderLayout.CENTER);
        revalidate();
        repaint();
        boutonsAllumes = new ArrayList<>(); // Réinitialiser le compteur des boutons allumés
    } 
               
   
    
    private class ButtonClickListener implements ActionListener {
       @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (isButtonClicked(clicked)) {
            score++;
            clicked.setBackground(Color.BLUE);
            updateScoreLabel();

            if (iInstance.isConfirmeSelected()) {
                if (areAllButtonsClicked()) {
                    changerBoutonAllume();
                }
            } else {
                changerBoutonAllume();
            }
        } else {
            score--;
            updateScoreLabel();
        }
    }

    private boolean isButtonClicked(JButton button) {
        int position = -1;
    for (int i = 0; i < boutons.length; i++) {
        for (int j = 0; j < boutons[0].length; j++) {
            if (boutons[i][j] == button) {
                position = i * boutons.length + j;
                break;
            }
        }
    }
    return boutonsAllumes.contains(position);
}
    private boolean areAllButtonsClicked() {
        for (int i = 0; i < boutons.length; i++) {
            for (int j = 0; j < boutons[0].length; j++) {
                if (boutons[i][j].getBackground().equals(Color.RED)) {
                    return false;
                }
            }
        }
        return true;
    }
}
    
                
      
   
    
    private void changerBoutonAllume(){
      Random rand = new Random();

    // First, turn off all buttons
    for (int i = 0; i < boutons.length; i++) {
        for (int j = 0; j < boutons[0].length; j++) {
            boutons[i][j].setBackground(Color.BLUE);
        }
    }

    if (iInstance != null && iInstance.isConfirmeSelected()) {
        // For "Confirme," turn on multiple buttons
        for (int count = 0; count < CONFIRME_NUM_BUTTONS; count++) {
            int lAllumee = rand.nextInt(boutons.length);
            int cAllumee = rand.nextInt(boutons[0].length);
            boutons[lAllumee][cAllumee].setBackground(Color.RED);
            boutonsAllumes.add(lAllumee * boutons.length + cAllumee); // Store the button position
        }
    }else if (iInstance.isAvanceSelected()){
            int lAllumee = rand.nextInt(boutons.length);
            int cAllumee = rand.nextInt(boutons[0].length);
            boutons[lAllumee][cAllumee].setBackground(Color.RED);
            Timer time= new Timer (800, new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                     
                     boutons[lAllumee][cAllumee].setBackground(Color.BLUE); 
                     changerBoutonAllume();
                    }
                    
            });
            time.setRepeats(false);
            time.start();
    } else {
        // For other levels, turn on only one button
        int lAllumee = rand.nextInt(boutons.length);
        int cAllumee = rand.nextInt(boutons[0].length);
        boutons[lAllumee][cAllumee].setBackground(Color.RED);
        boutonsAllumes.add(lAllumee * boutons.length + cAllumee);
    }
}
  private void updateCountdownLabel() {
        cdLab.setText("Countdown: " + countdown);
    }

  private void startGame() {
      score =0;
      updateScoreLabel();
      
          if (iInstance.isAvanceSelected()) {
            countdown =30;
            updateScoreLabel();
            chrono.start();
    }else{
            countdown =30;
            updateScoreLabel();
            chrono.start();
            }
          
       if (iInstance != null) {
            if (iInstance.isDebutantSelected()) {
                tailleGrille = 5;
                iInstance.setIntermediaireEnabled(false);
            } else if (iInstance.isIntermediaireSelected() || iInstance.isConfirmeSelected() || iInstance.isAvanceSelected()) {
                tailleGrille = 10;
                iInstance.setIntermediaireEnabled(true);
            } 
        }
    setPanelGrilleTaille(tailleGrille);
    intBoutons();
  }
    private void intBoutons() {
    Random rand = new Random();

    int numButtonsToLight = 1; // Par défaut, pour Debutant et Intermediaire

    if (iInstance != null && iInstance.isConfirmeSelected()) {
        numButtonsToLight = CONFIRME_NUM_BUTTONS;
    }

    for (int count = 0; count < numButtonsToLight; count++) {
        int lAllumee = rand.nextInt(boutons.length);
        int cAllumee = rand.nextInt(boutons[0].length);
        boutons[lAllumee][cAllumee].setBackground(Color.RED);
        boutonsAllumes.add(lAllumee * boutons.length + cAllumee);
    }
}
    private void stopGame(){
        chrono.stop();
        JFrame resultatFrame;
        String resultatMes;
        
        
       if (score>=30){
           resultatFrame = new victoire();
           resultatMes="Bravo! tu as gagné avec un score de "+score;
           
        }else{
            resultatFrame = new defaite();
            resultatMes="Bravo! tu as gagné avec un score de "+score;
        }
        
        /*if(score>record){
            record=score;
            JOptionPane.showMessageDialog(SpeedClick.this, "New record! : " + score);
        }else{
            JOptionPane.showMessageDialog(SpeedClick.this, "The Game Is Over! : " + score);
        }*/
       JOptionPane.showMessageDialog(SpeedClick.this, resultatMes); 
       resultatFrame.setVisible(true);
    resultatFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            // This code is executed when the resultFrame is closed
            startGame();
        }
    });
    }

private void updateScoreLabel(){
      scoreLab.setText("Score: "+score);
      
  }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelGrille = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelGrille.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout PanelGrilleLayout = new javax.swing.GroupLayout(PanelGrille);
        PanelGrille.setLayout(PanelGrilleLayout);
        PanelGrilleLayout.setHorizontalGroup(
            PanelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        PanelGrilleLayout.setVerticalGroup(
            PanelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        getContentPane().add(PanelGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 130, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(SpeedClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        Intro intro = new Intro();  // Créez une instance de Intro
        new SpeedClick(intro).setVisible(true);
    
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGrille;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
