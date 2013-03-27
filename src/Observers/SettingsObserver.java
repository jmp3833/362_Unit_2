/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * SettingsObserver.java Will listen to invoked commands from the settings
 * portion of the menu bar. These functionalities have been grouped
 * into a single class since they are rather simple. 
 */


package Observers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Command.Receiver ;

public class SettingsObserver implements Receiver{
	
	/**
	 * Requests a change in tab length via Integer input from the user
	 * @return the desired tab length, or -1 if there was incorrect input. 
	 */
	public int changeTabLength(){
		
		 //Opens a dialog box for the user to select tab length. 
		 String str = JOptionPane.showInputDialog(null, "Input desired tab length: ", 
				 "Tab Length", 1);
		 
		 
		 try{
			  int tabLength = Integer.parseInt(str);
			  // is an integer!
			  if (tabLength > 0 && tabLength < 10 ){
					 return tabLength;
			  }
			  else{
				  JOptionPane.showMessageDialog(null,"The tab length must be an\n " +
			 		"integer between 1 and 9.\nPlease try again.");
			  }
			
		 } catch (NumberFormatException e) {
			  // not an integer!
		 }
		 
		 //If there was incorrect user input, return default value.
		 return 5;
		 
	}
	/**
	 * Enables text wrapping in the HTML editor.
	 */
	public void enableTextWrapping(){
		//TODO: Alex put your stuff here
	}
	
	/**
	 * Disables text wrapping in the HTML editor.
	 */
	public void disableTextWrapping(){
		//TODO: Alex put your stuff here
	}
  
}
