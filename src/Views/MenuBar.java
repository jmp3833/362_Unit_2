/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * MenuBar.java creates the main Menu Bar that is on the top of the main window.
 * This bar contains functions to open,close, and create files, as well as to
 * command the program to check for HTML errors. 
 */


package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Observers.FileObserver;

import javax.swing.*;

public class MenuBar {
  public MenuBar(){
  }
  
  
  public JMenuBar barCreator(){
	  
	  final FileObserver o = new FileObserver(); //Listens to commands from the "File" menu
	  final boolean isSaved = false; //Used for quit prompts
	  
	  //Main menu bar at the top of the screen
	  JMenuBar menuBar;
	  //Main menus that an be accessed from the menu bar
	  JMenu file, settings, check;
	  //Items that can be selected through menus
	  JMenuItem save, quit, open, tabSize, textWrapping, newFile,checkPrompt;
	  
	  //Creates each menu of the menubar
	  menuBar = new JMenuBar();
	  file = new JMenu("File");
	  /*
	   * edit = new JMenu("Edit");
	   */
	  settings = new JMenu("Settings");
	  check = new JMenu("Check");
	  
	  //Adds menu items to their respective menu bars 
	  save = new JMenuItem("Save");
	  quit = new JMenuItem("Quit");
	  quit.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			o.quit(isSaved);
		}
		  
	  });
	  open = new JMenuItem("Open");
	  newFile = new JMenuItem("New");
	  tabSize = new JMenuItem("Edit tab size");
	  textWrapping = new JMenuItem("Enable/disable text wrapping");
	  checkPrompt = new JMenuItem("Check for HTML errors");
	  
	  //Populates the "File" sub menu
	  file.add(newFile);
	  file.add(open);
	  file.add(save);
	  file.add(quit);
	  
	  //Populates the "Settings" sub menu
	  settings.add(tabSize);
	  settings.add(textWrapping);
	  
	  //Populates the "Check" sub menu
	  check.add(checkPrompt);
	  
	  //Adds the menus to the bar
	  menuBar.add(file);
	  /*
	   * TODO: Add undo/redo functionality to an edit sub menu.
	   *  menuBar.add(edit);
	   */
	  menuBar.add(settings);
	  menuBar.add(check);
	  
	  return menuBar;
	  
  }
}
