package pkgBeatBox;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChangeLookNFeel{

	public ChangeLookNFeel() 
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		 catch(ClassNotFoundException e){}
         catch(IllegalAccessException e2){}
         catch(InstantiationException e3){}
         catch(UnsupportedLookAndFeelException e4){}

		
	}

}
