/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * CaretHolder.java Provides logic to make sure the
 * caret listens only when multiple characters are entered (i.e. a command
 * is invoked or a user changes caret position via mouse.)
 */


package Views;

import Text_Windows.FileReader;

public class CaretHolder {
	//Declares necessary variables
	String textBefore;
	String textAfter;
	FileReader tabProxy;
	boolean isUndo;
	boolean isTagInsert;
	
	/**
	 * Constructs necessary elements to check for valid caret constraints
	 * @param tabProxy
	 */
	public CaretHolder(FileReader tabProxy, TextTabWindow mainWindow){
		this.tabProxy = tabProxy;
		this.textBefore = "";
		this.textAfter = "";
		this.isUndo = false;
		this.isTagInsert = false;
	}
	
	/**
	 * Allows the current text window text to be stored in this object
	 * @param newText
	 */
	public void updateAfterText(String newText){
		textAfter = newText;
	}
	
	/**
	 * Returns true if the change in caret position is not equal to 1
	 * @return
	 */
	public boolean updateText(){
		
		if (((textAfter.length()-1) == textBefore.length()) ||
				(textAfter.length()+1) == textBefore.length() || isUndo
				|| isTagInsert){
			textBefore = textAfter;
			return false;
		}
		else{
			textBefore = textAfter;
			return true;
		}
	}
	
	public void isUndo(){
		isUndo = true;
	}
	
	public void isTagInsert(){
		isTagInsert = true;
	}
}
