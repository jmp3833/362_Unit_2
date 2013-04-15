/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * EditObserver.java provides functionality for all operations
 * stored under the "edit" submenu of the MenuBar
 */


package Observers;

import javax.swing.JMenuItem;

import Memento.Originator;
import Memento.UndoCaretaker;
import Text_Windows.FileReader;
import Views.TextTabWindow;

public class EditObserver {
	
	FileReader fr;
	Originator originator;
	UndoCaretaker caretaker;
	TextTabWindow mainWindow;
	JMenuItem undo;
	JMenuItem redo;
	int saveFiles = 0; //Number of mementos created
	int currentArticle = 0; //Currently selected Memento index
	
	
	/**
	 * Constructs necessary objects to do edit commands
	 * @param jTextArea
	 */
	public EditObserver(FileReader fr, JMenuItem undo, JMenuItem redo, TextTabWindow mainWindow){
		this.mainWindow = mainWindow;
		this.fr = fr;
		this.originator = new Originator();
		this.caretaker = new UndoCaretaker();
		this.undo = undo;
		this.redo = redo;
	}
	
	/**
	 * Saves the active text area when a command is performed.
	 * @param undo the menu item will be greyed out until an item is added.
	 */
	public void saveText(){
		String storedText =  fr.getTextFromTabWindow(mainWindow);
		originator.set(storedText);
		caretaker.addMemento(originator.store());
		saveFiles++;
		currentArticle++;
		undo.setEnabled(true);
	}
	
	/**
	 * Restores previous text to a window by using the most recent Memento
	 * @param redo the menu item will be greyed out until we have something to undo
	 */
	public void undoText(){
		
		if(currentArticle >= 1){
			currentArticle --;
			String restoreString = originator.restore
					(caretaker.getMemento(currentArticle));
			fr.getSelectedTextArea(mainWindow).setText(restoreString);
			redo.setEnabled(true);
		}
		else{
			undo.setEnabled(false);
		}
		
	}
	
	/**
	 * Restores a newly undone text to a window using memento
	 */
	public void redoText(){
		if((saveFiles-1) > currentArticle){
			currentArticle ++;
			
			String restoreString = originator.restore
					(caretaker.getMemento(currentArticle));
			fr.getSelectedTextArea(mainWindow).setText(restoreString);
			undo.setEnabled(true);
		}
		else{redo.setEnabled(false);}
		
	}
	
}
