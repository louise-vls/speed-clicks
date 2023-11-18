/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedcl;

import java.util.Scanner;

/**
 *
 * @author louis
 */
public class PartieDeJeu {
  GrilleDeJeu grid;
        int nbCoups;
    
        
        
        public PartieDeJeu(int nbLignes, int nbColonnes){
            grid = new GrilleDeJeu(nbLignes,nbColonnes  );
            nbCoups = 0;
                   
        }
        
        public void demaragePartie(){
            
            System.out.println("Bienvenue dans le jeu Speed Click! ");
            Scanner scan= new Scanner (System.in);
            /*grid.eteindreToutesLesCellules();
            grid.melangerMatriceAleatoirement(10);*/
        
            
            while(!grid.cellulesToutesEteintes()){
             grid.afficherGrille();
            int ClickLigne = demanderClicK("cliquez sur la ligne correspondant au boutton allumee");  
            int ClickColonne = demanderClicK("cliquez sur la colonne correspondant au boutton allumee"); 
            
            
               if (grid.getMatriceCellules()[ClickLigne][ClickColonne].estAllumee())){
                nbCoups++;
                 System.out.println("Bravo§ votre score pour le moment est de : "+nbCoups);
                grid. activerLigneColonneOuDiagonaleAleatoire();
            }else{ 
                    
                 nbCoups--;
                grid. eteindreToutesLesCellules();
                grid. activerLigneColonneOuDiagonaleAleatoire();
                    }
            }
           System.out.println("Bravo vous avez eteint toutes les celules en : "+ nbCoups+ " coups.");
        }
int demanderClick(String message){
    System.out.print(message);
    Scanner scan= new Scanner (System.in);
}
        

