package pkgBeatBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.*;
//-------.. M   E   N   U ..-------------------
@SuppressWarnings("serial")
class Menu extends JMenuBar
//classe interna
{
    //JMenuBar menu;
    JMenu mnuFile, mnuHelp, mnuF_Cara;
    JMenuItem mnuF_Sair, mnuH_Credito, mnuH_Sobre,
            mnuC_Sys, mnuC_Metal, mnuC_GDK;

    public Menu()
    {
      //  menu = new JMenuBar();
        mnuFile = new JMenu("Ficheiro");
        mnuF_Cara = new JMenu("Mudar Aparencia");
        mnuC_Sys = new JMenuItem("Sistema");
        mnuC_Metal = new JMenuItem("Metal");
        mnuC_GDK = new JMenuItem("GDK");
        mnuF_Sair = new JMenuItem("Sair");
        mnuHelp = new JMenu("Ajuda");
        mnuH_Credito = new JMenuItem("Creditos");
        mnuH_Sobre = new JMenuItem("Sobre a Aplicacao");

        //.....definindo o menu FILE
        mnuFile.add(mnuF_Cara);
        mnuFile.addSeparator();
        mnuFile.add(mnuF_Sair);

        //.....definindo menu APARENCIA
        mnuF_Cara.add(mnuC_Sys);
        mnuF_Cara.add(mnuC_Metal);
        mnuF_Cara.add(mnuC_GDK);

        //.....definindo o menu AJUDA
        mnuH_Sobre.addActionListener(new MySobreListener());
        mnuHelp.add(mnuH_Credito);
        mnuHelp.add(mnuH_Sobre);

        //....adicionando  os menus a barra de menus
        add(mnuFile);
        add(mnuHelp);
    }
    public JMenuBar getMenu()
    {
        return null;
    }
    
    class MySobreListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		JOptionPane.showMessageDialog(null,"Clicou em ajuda");
    	}
    }
}
