/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * FileObserver.java listens for all actions that are selected in the "File"
 * sub menu of the MenuBar
 */


package Observers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Tag.TagCollection;
import Text_Windows.FileReader;
import Views.TextTabWindow;
import Views.TextWindow;

import Command.Receiver ;

public class FileObserver implements Receiver{
	
	TextTabWindow windows;
	
	public FileObserver(TextTabWindow windows){
		this.windows = windows;

	}
	
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
   
  public void load(){
	  
	  JFileChooser fc = new JFileChooser();
	  //Shows an open prompt for a user to select a desired HTML file
	  int returnVal = fc.showOpenDialog(null);
	  
	  //Grab the selected file 
	  if(returnVal == JFileChooser.APPROVE_OPTION) {
		  
		  
	      File file = fc.getSelectedFile();
	      TagCollection t = new TagCollection();
	    		  
	      TextWindow newWindow = new TextWindow(file.getName(),
	    		  windows,t);
	      try {
			Scanner reader = new Scanner(file);
		    while(reader.hasNextLine()){
		    	newWindow.append(reader.nextLine());
		    	newWindow.append("\n");
		    	
		    }
	      } catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found!");
		}
	  }
	  
  }
  
  public void create(){
	  
  }
  
  public void save(){
	  
  }
}
