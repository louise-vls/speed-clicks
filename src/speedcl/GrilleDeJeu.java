package speedcl;


import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author louis
 */
public class GrilleDeJeu {
       CelluleLumineuse[][] matriceCellules;
    int nbLignes;
    int nbColonnes;
    
    
    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes){
        nbLignes= p_nbLignes;
        nbColonnes = p_nbColonnes;
        
        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
        for (int i=0; i<nbLignes; i++){
            for (int j=0; j<nbColonnes; j++){
                matriceCellules[i][j]= new CelluleLumineuse();
            
            }
        }
        eteindreToutesLesCellules();
        
        Random random = new Random();
        int randLi=random.nextInt(nbLignes);
        int randCo=random.nextInt(nbColonnes);
        matriceCellules[randLi][randCo].activerCellule();
    }
    
    public void  eteindreToutesLesCellules(){
        for (int i=0; i<nbLignes; i++){
            for (int j=0; j<nbColonnes; j++){
                matriceCellules[i][j].eteindre();
            
            }
        }
    }
    
    public void activerLigneColonneOuDiagonaleAleatoire(){
        Random random = new Random();
        int choice= random.nextInt(3);
        switch (choice){
            case 0:;
                activerLigneDeCellules(random.nextInt(nbLignes));
                break;
            case 1:
                activerColonneDeCellules(random.nextInt(nbColonnes));
                break;
            case 2 :
                    if (random.nextBoolean()){
                        activerDiagonaleMontante();
                    } else {
                        activerDiagonaleDescendante();
                    }
                    break;
            
        }
    }
     public void melangerMatriceAleatoirement(int nbTours){
             eteindreToutesLesCellules() ;
             Random random = new Random();
               for (int tr =0; tr<nbTours; tr++){
             activerLigneColonneOuDiagonaleAleatoire();
        }
    }
    
    public void  activerLigneDeCellules(int idLigne){
         for (int j=0; j<nbLignes; j++){
                matriceCellules[idLigne][j].activerCellule();
         }
    }
    public void activerColonneDeCellules(int idColonne){
         for (int i=0; i<nbColonnes; i++){
             matriceCellules[i][idColonne].activerCellule();
         }
    }
    public void activerDiagonaleDescendante(){
         for (int i=0 ; i < Math.min(nbLignes, nbColonnes); i++){
                matriceCellules[i][i].activerCellule();
         }
    }
    public void activerDiagonaleMontante(){
         for (int i=0; i<Math.min(nbLignes, nbColonnes); i++){
                matriceCellules[i][nbColonnes - i -1].activerCellule();
         }
    }
    
   
   
    public boolean  cellulesToutesEteintes(){
        for (int i=0; i<nbLignes; i++){
            for (int j=0; j<nbColonnes; j++){
                if (matriceCellules[i][j].estAllumee()){
                    return false;
                }
            }
        }
        return true;
    }
    

        @Override
public String toString () {
    StringBuilder gridString = new StringBuilder();
    
    gridString.append("  |");
            for (int j=0; j<nbColonnes; j++){
                gridString.append(" ").append(j).append("  |");
            }
            gridString.append("\n");
   
            gridString.append("-");
            for (int j=0; j<nbColonnes; j++){
                gridString.append("-----");
            }
                gridString.append("\n");
            
   for (int i=0; i<nbLignes; i++){
                gridString.append(i).append(" |");
                
             for (int j=0; j<nbColonnes; j++){
                CelluleLumineuse cellule = matriceCellules[i][j];
                String etat = cellule.estEteint()? "0" : "X";
             gridString.append(" ").append(etat).append("  |");
               
                }
             
             gridString.append("\n");
             
             
             gridString.append("-");
            for (int j=0; j<nbColonnes; j++){
                gridString.append("-----");
            }
            gridString.append("\n");
}
   
            
   return gridString.toString();
    
}
  public void afficherGrille() {
    System.out.println(this.toString());

    
}
  public CelluleLumineuse[][] getMatriceCellules(){
      return matriceCellules;
  }

    /*Object[][] getMatriceCellules() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}


