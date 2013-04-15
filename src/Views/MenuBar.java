/**
 * @author: Justin Peterson, Dan Hernandez
 * @email: Jmp3833@rit.edu
 * MenuBar.java creates the main Menu Bar that is on the top of the main window.
 * This bar contains functions to open,close, and create files, as well as to
 * command the program to check for HTML errors. 
 */


package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Memento.Originator;
import Memento.UndoCaretaker;
import Observers.CheckObserver;
import Observers.EditObserver;
import Observers.FileObserver;
import Observers.InsertObserver;
import Observers.SettingsObserver;
import Tag.Buffer;
import Tag.TagCollection;
import Text_Windows.FileReader;
import Command.*;
import javax.swing.*;

public class MenuBar {
  boolean autoWrap;
  FileReader tabProxy; //Grabs active window text
  TextTabWindow mainWindow;
  Buffer activeTextBuffer = new Buffer(); //buffer to check & store active text
  
  FileObserver o;
  SettingsObserver s;
  CheckObserver c;
  InsertObserver i;
  EditObserver e;
  
  TagCollection tags;
  
  Command saveCommand ;
  Command createCommand ;
  Command loadCommand ;
  Command quitCommand ;
  Command changeTabLengthCommand ;
  Command enableTextWrapCommand ;
  Command disableTextWrapCommand ;
  Command checkCommand;
  Command InsertTagCommand ;
  Command InsertTableCommand ;
  Command undoCommand;
  Command redoCommand;
  Command saveTextCommand;
  CommandInvoker invoker; 
  
  String tagString = "";
  
  //Memento setup for undo/redo operations
  UndoCaretaker caretaker = new UndoCaretaker();
  Originator originator = new Originator();
  
  int saveFiles = 0; //number of mementos 
  int currentArticle = 0; //Currently selected article
  
		  
  
  
  public MenuBar(TextTabWindow mainWindow){
	  this.autoWrap = true; //Program begins with autoWrap on by default.
	  this.tabProxy = new FileReader(); //FileReader proxy instantiated here
	  this.mainWindow = mainWindow;//Gets the textTabWindow passed from MainGUI
	  this.activeTextBuffer = new Buffer();//Buffer gets instantiated here. 
	  this.tags = new TagCollection(); //Instantiates a new TagCollection here
	  
	  invoker = new CommandInvoker();
	  
	  this.o = new FileObserver(mainWindow,tabProxy);
	  this.s = new SettingsObserver(tabProxy, mainWindow);
	  this.c = new CheckObserver(mainWindow,activeTextBuffer,tags);
	  this.i = new InsertObserver(tabProxy, mainWindow, "", tags);
	  
	  //File commands
      this.saveCommand = new SaveCommand(o) ;
 	  this.createCommand = new CreateCommand(o) ;
 	  this.loadCommand = new LoadCommand(o) ;
 	  this.quitCommand = new QuitCommand(o) ;
 	  
 	  
 	  //Settings commands 
 	  this.changeTabLengthCommand = new ChangeTabLengthCommand(s);
 	  this.enableTextWrapCommand = new EnableTextWrapCommand(s);
 	  this.disableTextWrapCommand = new DisableTextWrapCommand(s);
 	  
 	  //Insert commands 
 	  this.InsertTableCommand = new InsertTableCommand(i);
 	  this.InsertTagCommand = new InsertTagCommand(i);
 	  
 	  //Checker command(s)
 	  this.checkCommand = new CheckCommand(c);
 	 
  }
  
  
  public JMenuBar barCreator(final JFrame parent){

	  //Main menu bar at the top of the screen
	  JMenuBar menuBar;
	  //Main menus that an be accessed from the menu bar
	  JMenu file, settings, check, insert, edit;
	  //Items that can be selected through menus
	  JMenuItem save, quit, open, tabSize, textWrapping, newFile,
	  checkPrompt, insertTagTable;
	  
	  //Creates each menu of the menubar
	  menuBar = new JMenuBar();
	  file = new JMenu("File");
	  
	  edit = new JMenu("Edit");
	  insert = new JMenu("Insert");
	  settings = new JMenu("Settings");
	  check = new JMenu("Check");
	  
      
      //get the list of tabs
      for (ArrayList<String> al : tags.getNames()){
      	int iterator = 0;
      	JMenu category = new JMenu();
      	insert.add(category);
      	for (String str : al){
      		if (iterator == 0){
      			category.setText(str);
      			iterator++;
      		} 
      		else {
      			JMenuItem tag = new JMenuItem(str);
      			tag.addActionListener(makeInsertListener(str));
      			category.add(tag);
      		}
      			
      	}
      }
	  
	  
	  //Adds menu items to their respective menu bars 
	  save = new JMenuItem("Save");
	  save.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			//Command Pattern Implementation
			invoker.invokeCommand(saveCommand) ;
		}
		  
	  });
	  quit = new JMenuItem("Quit");
	  quit.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int response = JOptionPane.showConfirmDialog(null, "WARNING: " +
					"Would you like \nto save before quitting?");
			if (response == 0){ //Quit and save 
				invoker.invokeCommand(saveCommand);
				invoker.invokeCommand(quitCommand);
				
			}
			else if (response == 1){ //Save, then exit. 
				invoker.invokeCommand(quitCommand);
			}
			
		}
		  
	  });
	  open = new JMenuItem("Open");
          open.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			//Command Pattern Used
			invoker.invokeCommand(loadCommand) ;
			invoker.invokeCommand(saveTextCommand);
		}
	  });
	  newFile = new JMenuItem("New");
	  newFile.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
			//Command Pattern Used 
                        invoker.invokeCommand(createCommand) ;
                        invoker.invokeCommand(saveTextCommand);
                }
          });

	  
	  insertTagTable = new JMenuItem("Table Construct");
	  insertTagTable.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			invoker.invokeCommand(InsertTableCommand);
			invoker.invokeCommand(saveTextCommand);
			
			
		}
		  
	  });
	  
	   
	  tabSize = new JMenuItem("Edit tab length");
	  tabSize.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			invoker.invokeCommand(changeTabLengthCommand); 
		}
		  
	  });
	  textWrapping = new JMenuItem("Enable/disable text wrapping");
	  textWrapping.addActionListener(new ActionListener(){

		
		@Override
		public void actionPerformed(ActionEvent e) {
			int response = JOptionPane.showConfirmDialog(null, "Would you like " +
					"text wrapping to be enabled?");
			
			if (response == 0){
				invoker.invokeCommand(enableTextWrapCommand);
			}
			else if (response == 1 ){
				invoker.invokeCommand(disableTextWrapCommand);
			}
			
			//Else, do nothing. 
			
		}
		  
	  });
	  checkPrompt = new JMenuItem("Check for HTML errors");
	  
	  checkPrompt.addActionListener(new ActionListener(){

		  /**
		   * Grabs the text from the active tab window, then runs the 
		   * Buffer's validation method on that text.
		   */
		  public void actionPerformed(ActionEvent arg0) {
				invoker.invokeCommand(checkCommand);
			}
			  
		  });
	  
	  JMenuItem undo = new JMenuItem("Undo");
	  undo.setEnabled(false);
	  undo.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			invoker.invokeCommand(undoCommand);
			
		}
		  
	  });
	  
	  JMenuItem redo = new JMenuItem("Redo");
	  redo.setEnabled(false);
	  redo.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			invoker.invokeCommand(redoCommand);
			
		}
		  
	  });
	  
	  //Creates an EditObserver for undo and redo
	  this.e = new EditObserver
			  (tabProxy,undo,redo,mainWindow);
	  
	  //Edit comamnds
 	  this.saveTextCommand = new SaveTextCommand(e);
	  this.undoCommand = new UndoCommand(e);
	  this.redoCommand = new RedoCommand(e);
	  
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
	  
	  //Populates the "Insert" sub menu 
	  insert.add(insertTagTable);
	  
	  //Populates the edit sub menu
	  edit.add(undo);
	  edit.add(redo);
	  
	  //Adds the menus to the bar
	  menuBar.add(file);
	  menuBar.add(edit);
	  menuBar.add(settings);
	  menuBar.add(insert);
	  menuBar.add(check);
	  
	  
	  return menuBar;
	  
  }
  
  
  /**
   * create the listener to add to the insert menu items
   * @param str
   * @return
   */
  ActionListener makeInsertListener(final String str){
  	ActionListener insertAction = new ActionListener(){

  		//inserts the tag at the caret's position
			@Override
			public void actionPerformed(ActionEvent e) {
				i.changeInsertString(str);
				invoker.invokeCommand(InsertTagCommand);
				invoker.invokeCommand(saveTextCommand);
				
			}
  		
  	};
  	return insertAction;
  }
}