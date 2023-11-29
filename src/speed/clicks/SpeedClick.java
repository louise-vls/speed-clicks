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
         boutons= new JButton[taille][taille];
         PanelGrille.removeAll();
        JPanel panelGrille = new JPanel (new GridLayout (taille,taille));
        
        /*JPanel panel = new JPanel (new GridLayout(TailleGrille, TailleGrille));*/
        for (int i = 0; i< taille; i++){
           for (int j = 0; j< taille; j++) {
            boutons[i][j]= new JButton();
            boutons[i][j].setBackground(Color.BLUE);
            boutons[i][j].addActionListener( new ButtonClickListener());  
            panelGrille.add(boutons[i][j]);
           }
        }
        PanelGrille.setLayout(new BorderLayout());
        PanelGrille.add(panelGrille, BorderLayout.CENTER);
        revalidate();
        repaint();
        boutonsAllumes = new ArrayList<>();
        }  
               
 
    private void updateCountdownLabel(){
        cdLab.setText("Countdown: "+countdown);
    }      
    
   
    
    
    
    private class ButtonClickListener implements ActionListener {
        @Override
                public void actionPerformed (ActionEvent e){
        JButton clicked = (JButton) e.getSource();
        if (isButtonClicked(clicked)){
            score++;
            clicked.setBackground(Color.BLUE);
            updateScoreLabel();
            if (iInstance.isConfirmeSelected()){
                if (areAllButtonsClicked()){
                   changerBoutonAllume(); 
                }
            
        }else{
            changerBoutonAllume();
            }
        }else{
            
            score--;
            updateScoreLabel();
            
        }
        }
       private boolean isButtonClicked(JButton button){
           return button.getBackground().equals(Color.RED);
    }
       private boolean areAllButtonsClicked(){
           for (int i = 0; i < boutons.length; i++){
           for (int j = 0; j < boutons[0].length; j++){
              if(boutons[i][j].getBackground().equals(Color.RED)){
                  return false;
              }
           } 
           }
           return true;
           }
       }
    private void changerBoutonAllume(){
        Random rand = new Random();
        for (int i = 0; i < boutons.length; i++){
           for (int j = 0; j < boutons[0].length; j++){
               boutons[i][j].setBackground(Color.BLUE);
           } 
        }
        if (iInstance != null){
           if (iInstance.isConfirmeSelected()){
              for (int count = 0; count < CONFIRME_NB_BOUTONS; count ++){ 
           
                 int lAllumee = rand.nextInt(boutons.length);
                 int cAllumee = rand.nextInt(boutons[0].length);
              
        boutons[lAllumee][cAllumee].setBackground(Color.RED);
        }
        
        
           }else{
           int lAllumee = rand.nextInt(boutons.length);
                 int cAllumee = rand.nextInt(boutons[0].length);
              
        boutons[lAllumee][cAllumee].setBackground(Color.RED);
        }  
        }
    }
  private void startGame() {
      score =0;
      countdown =30;
      updateScoreLabel();
      updateCountdownLabel();
      
              
      if (iInstance != null){ 
              if(iInstance.isDebutantSelected()){
                tailleGrille =5;
                iInstance.setIntermediaireEnabled(false);
              }else if (iInstance.isIntermediaireSelected() || iInstance.isConfirmeSelected()){
          tailleGrille=10;
          iInstance.setIntermediaireEnabled(true);
              } 
  }
      setPanelGrilleTaille(tailleGrille);
      changerBoutonAllume();
      chrono.start();
    
        
    }

   
   
    private void stopGame(){
        chrono.stop();
        if(score>record){
            record=score;
            JOptionPane.showMessageDialog(SpeedClick.this, "New record! : "+score);
        }else{
            JOptionPane.showMessageDialog(SpeedClick.this, "The Game Is Over! : "+score);
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelGrilleLayout = new javax.swing.GroupLayout(PanelGrille);
        PanelGrille.setLayout(PanelGrilleLayout);
        PanelGrilleLayout.setHorizontalGroup(
            PanelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
        PanelGrilleLayout.setVerticalGroup(
            PanelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(PanelGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(PanelGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

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
    // End of variables declaration//GEN-END:variables
}
