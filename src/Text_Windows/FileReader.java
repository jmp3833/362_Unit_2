/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * FileReader.java acts a proxy, storing text from the current active text 
 * window, and passing it to areas where it is necessary (Save and Checker)
 */


package Text_Windows;

import javax.swing.JTextPane;
import Views.TextTabWindow;

public class FileReader {
    /**
     * Grabs the text from the currently selected tab, then returns it. 
     * @param mainWindow the main textTabWindow of the editor
     * @return the text stored in the active window of the editor. 
     */
	public String getTextFromTabWindow(TextTabWindow mainWindow){
		//Grab the active text area 
		JTextPane activeTextPane = (JTextPane) mainWindow.getSelectedComponent();
		//pull the text out of the TextPane, then return it
		String activeText = activeTextPane.getText();
		return activeText;
	}
	
	/**
	 * grabs the TextPane component from the active tab, then returns it. 
	 * @param mainWindow the main textTabWindow of the editor
	 * @return the TextPane that is currently selected in the editor
	 */
	public JTextPane getSelectedTextPane(TextTabWindow mainWindow){
		//Grab the active text area 
		JTextPane activeTextPane = (JTextPane) mainWindow.getSelectedComponent();
		return activeTextPane;
	}

}
