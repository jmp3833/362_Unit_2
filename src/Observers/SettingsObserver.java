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

public class SettingsObserver {
	
	/**
	 * Requests a change in tab length via Integer input from the user
	 * @return the desired tab length, or -1 if there was incorrect input. 
	 */
	public int changeTabLength(JFrame parent){
		
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
				  JOptionPane.showMessageDialog(parent,"The tab length must be an\n " +
			 		"integer between 1 and 9.\nPlease try again.");
			  }
			
		 } catch (NumberFormatException e) {
			  // not an integer!
		 }
		 
		 //If there was incorrect user input, return default value.
		 return 5;
		 
	}
	
	/**
	 * Prompt the user if they would like to enable/keep enabled 
	 * auto wrapping of text in the editor.
	 * @return if text wrapping should be enabled
	 */
	public boolean autoWrap(boolean currentSelection) {
	
		int response = JOptionPane.showConfirmDialog(null, "Would you like " +
				"text wrapping to be enabled?");
		
		if (response == 0){
			return true;
		}
		else if (response == 1 ){
		    return false;
		}
		else
			return currentSelection;
	}
  
}
