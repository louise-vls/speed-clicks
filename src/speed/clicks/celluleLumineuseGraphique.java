/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speed.clicks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author louis
 */
public class celluleLumineuseGraphique extends JButton {

    boolean statut = false;
    Intro iInstance;

    public celluleLumineuseGraphique() {
        super();
      
      
           
        try {
            
            // Vérifier les conditions et charger les images spécifiques
            if ("noel".equals(Intro.theme)) {
                img = ImageIO.read(getClass().getResource("/speed/clicks/rennedenoel.jpg"));
                image = ImageIO.read(getClass().getResource("/speed/clicks/cadeaux.jpg"));
            } else if ("pirate".equals(Intro.theme)) {
                img = ImageIO.read(getClass().getResource("/speed/clicks/bateau.jpg"));
                image = ImageIO.read(getClass().getResource("/speed/clicks/pirates.jpg"));
            }else {
                img = ImageIO.read(getClass().getResource("/speed/clicks/etoile noire.jpg"));
                image = ImageIO.read(getClass().getResource("/speed/clicks/etoile rouge.jpg"));
            }
        } catch (IOException ex) {
            Logger.getLogger(celluleLumineuseGraphique.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    BufferedImage img = null;
    BufferedImage image = null;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        if (statut == false) {
           g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);            
        }
        else {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

}
