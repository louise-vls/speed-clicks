package speedcl;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author louis
 */
public class CelluleLumineuse {
    boolean etat;
    
    /**
     * On initialise une nouvelle cellule qui est eteinte
     */
    public CelluleLumineuse(){
        this.etat=false;
  
    }

    /**
     * Methode pour activer ou eteindre la cellule en inversant son etat
     */
    public void activerCellule(){
        etat =!etat;
    }
    
    /**
     * eteindre la cellule
     */
    public void eteindre(){
        etat=false;
    }
    
    
    /**
     * Verifier que la cellule est eteinte
     * @return 
     */
    public boolean estEteint(){
       return !etat;
    }
    
    /**
     * Obtenir l'etat actuel de la cellule
     * @return L'etat actuel
     */
    public boolean getEtat(){
       return etat;
    }
    
    
    /**
     * verifie si la cellule lumineuse est allumee
     * @return la cellule allume dans le cas ou elle est eteinte il retourne false
     */
    public boolean estAllumee(){
        return etat;
    }
    @Override
public String toString () {
    return (etat) ? "X" : "0";
    
}
  
}
