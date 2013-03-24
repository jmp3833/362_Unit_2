/**
 * @author:Alex Bogart, Justin Peterson
 * TextWindow.java represents the actual Swing window that will be kept in the
 * main focus of the HTML editor.  
 * 
 */


package Views;

import Views.TextTabWindow;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextWindow extends JPanel{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an individual window to add to the TextTabWindow. 
	 * @param tabWindow - the main TextTabWindow of the editor. 
	 */
	public TextWindow(String windowName, TextTabWindow tabWindow){
		setLayout(new BorderLayout(5,10));
		JTextArea HTMLText = new JTextArea();
		add(HTMLText,BorderLayout.CENTER);
		
		tabWindow.addTab(windowName, this);
		setVisible(true);
	}

}