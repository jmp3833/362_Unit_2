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
import Command.Receiver ;

public class FileObserver implements Receiver{
	
  /**
   * Checks if the file has been saved, and sends a prompt to the user 
   * asking if they would like to quit upon saving. 
   */
  public void quit(){
	  System.exit(0);
  }
	  
  /**
   * 
   * @param paren: the parent frame that the open box will be based from.
   * @return the text of the selected HTML file.
   */
   
  public String load(){
	  
	  JFileChooser fc = new JFileChooser();
	  //Shows an open prompt for a user to select a desired HTML file
	  int returnVal = fc.showOpenDialog(null);
	  
	  //Grab the selected file 
	  if(returnVal == JFileChooser.APPROVE_OPTION) {
	       //System.out.println("You chose to open this file: " +
	           //TODO fc.getSelectedFile();
	  }
	  
	  return "";
	  
	  
  }
  
  public void create(){
	  
  }
  
  public void save(){
	  
  }
}
