/**
 * @author: Justin Peterson, Alex Bogart
 * @email: Jmp3833@rit.edu
 * FileReader.java acts a proxy, storing text from the current active text 
 * window, and passing it to areas where it is necessary (Save and Checker)
 */


package Text_Windows;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Views.TextScrollPane;
import Views.TextTabWindow;

public class FileReader {
    /**
     * Grabs the text from the currently selected tab, then returns it. 
     * @param mainWindow the main textTabWindow of the editor
     * @return the text stored in the active window of the editor. 
     */
	public String getTextFromTabWindow(TextTabWindow mainWindow){
		//Grab the active text area 
		JTextArea activeTextArea = getSelectedTextArea(mainWindow);
		//pull the text out of the TextArea, then return it
		String activeText = activeTextArea.getText();
		return activeText;
	}
	
	/**
	 * grabs the TextArea component from the active tab, then returns it. 
	 * @param mainWindow the main textTabWindow of the editor
	 * @return the TextArea that is currently selected in the editor
	 */
	public JTextArea getSelectedTextArea(TextTabWindow mainWindow){
		//Grab the active text area 
		TextScrollPane jsp = (TextScrollPane) mainWindow.getSelectedComponent();
		if (jsp != null){
			JTextArea activeTextArea = jsp.getTextArea();
			return activeTextArea;
		}
		else
			return null;
	}

}
