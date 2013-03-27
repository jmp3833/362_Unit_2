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
import Text_Windows.FileReader;
import Views.TextTabWindow;
import Command.Receiver ;

public class InsertObserver implements Receiver{

	FileReader fr;
	TextTabWindow mainWindow;
	public InsertObserver(FileReader fr, TextTabWindow mainWindow){
		this.mainWindow = mainWindow;
		this.fr = fr;
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
	
}
