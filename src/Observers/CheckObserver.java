/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * CheckObserver.java handles the checking of the currently selected 
 * JTextArea for valid HTML formatting. 
 */


package Observers;
import javax.swing.JOptionPane;

import Checker.Buffer;
import Tag.TagCollection;
import Text_Windows.FileReader;
import Views.TextTabWindow;

public class CheckObserver {
	
	FileReader f;
	TextTabWindow mainWindow;
	Buffer b;
	TagCollection t;
	public CheckObserver(TextTabWindow mainWindow, Buffer b, TagCollection t){
		this.f = new FileReader();
		this.mainWindow = mainWindow;
		this.b = b;
		this.t = t;
	}
	
	/**
	 * Calls a method to check for valid HTML
	 * @return the message gotten from the check method. 
	 * tells the user if they  have valid HTMl or not.
	 */
	public void validateHTML(){
		String stringToCheck = f.getTextFromTabWindow(mainWindow);
		JOptionPane.showMessageDialog(null,b.validate(stringToCheck, t));
		
	}

}
