/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * InsertObserver.java handles the logic nessescary to insert new HTML tags
 * into the active HTML window.
 */


package Observers;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Tag.Table;
import Tag.TagCollection;
import Text_Windows.FileReader;
import Views.TextTabWindow;
import Command.Receiver ;

public class InsertObserver implements Receiver{

	FileReader fr;
	TextTabWindow mainWindow;
	String insertString;
	TagCollection tags;
	
	public InsertObserver(FileReader fr, TextTabWindow mainWindow, 
			String insertString, TagCollection tags){
		this.mainWindow = mainWindow;
		this.insertString = insertString;
		this.fr = fr;
		this.tags = tags;
	}
	
	/**
	 * Inserts a Tag Table into the current HTML editor window.
	 * Actually creates a table object 
	 */
	public void insertTable(){
		
		String rows = JOptionPane.showInputDialog(null, "Number of rows : ", 
				"Enter desired number of rows", 1);
		String cols = JOptionPane.showInputDialog(null, "Number of columns : ", 
				"Enter desired number of columns", 1); 
		
		JTextArea activeWindow = fr.getSelectedTextArea(mainWindow);
		
		int numRows = Integer.parseInt(rows);
		int numCols = Integer.parseInt(cols);
		int tabSize = activeWindow.getTabSize();
		
		Table t = new Table(numRows,numCols,tabSize);
		activeWindow.append(t.print());
	}
	
	/**
	 * Inserts a tag construct into the active text window
	 */
	public void insertTag(){
		
		JTextArea tw = fr.getSelectedTextArea(mainWindow);
		
		String tagString = tags.getTag(insertString);
		int pos = tw.getCaretPosition();
		int displacement = tagString.length()/2;
		
		tw.insert(tagString, pos);
		tw.setCaretPosition(pos+displacement);
	}
	
	/**
	 * Allows the insertTag command to know what tag to insert.
	 * @param newString 
	 */
	public void changeInsertString(String newString){
		insertString = newString;
	}
	
}
