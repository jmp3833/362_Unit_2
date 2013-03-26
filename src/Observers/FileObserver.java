/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * FileObserver.java listens for all actions that are selected in the "File"
 * sub menu of the MenuBar
 */


package Observers;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileObserver {
	
  /**
   * Checks if the file has been saved, and sends a prompt to the user 
   * asking if they would like to quit upon saving. 
   */
  public void quit(boolean isSaved ){
	  if(isSaved){
		  System.exit(0);
	  }
	  else{
		  int response = JOptionPane.showConfirmDialog(null, "WARNING: Would you like \nto quit without saving?");
		  
		  
		  if(response == 0){ //Quit without saving
			  System.exit(0); 
		  }
		  else{
			  //TODO: open the save dialog, then quit
			  //System.exit(0);
		  }
	  }
	  	  
  }
  
  /**
   * 
   * @param paren: the parent frame that the open box will be based from.
   * @return the text of the selected HTML file.
   */
  public String open(JFrame parent){
	  
	  JFileChooser fc = new JFileChooser();
	  //Shows an open prompt for a user to select a desired HTML file
	  int returnVal = fc.showOpenDialog(parent);
	  
	  //Grab the selected file 
	  if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            fc.getSelectedFile().getName());
	  }
	  
	  
  }
}