package com.randy.pkgCirco.Frame;

import javax.swing.UIManager;
	/**
	 *
	 * @author randy
	 */
	public class LookNFeel
	{

	    public LookNFeel()
	    {
	        try
	        {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }
	        catch(Exception e){
	        	//...
	        }
	    }
	}
