/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.view;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Splash extends JWindow{
    public Splash() {
        getContentPane().add(BorderLayout.CENTER, //adiciona
                            new JLabel(           //um JLabel contendo uma nova imagem 
                            new ImageIcon("img/RBS_SPLASH.png")));             
                            
        
        pack();
	setLocationRelativeTo(null);
        setVisible(true);
        try
        {
            Thread.sleep(500); //3500
        } catch (InterruptedException ex) {ex.printStackTrace();}
        new LoginWindow().setVisible(true);
        dispose();
    }
    
    public static void main(String[] args){
        new Splash();
    }
}
