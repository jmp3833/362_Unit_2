/**
 * @author: Alex Bogart, Justin Peterson
 * TextTabWindow.java represents the Swing tab layout which stores 
 * individual JTextAreas. 
 */


package Views;

import javax.swing.JTabbedPane;

public class TextTabWindow extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs the JTabbedPane used to store JTextAreas
	 */
	public TextTabWindow(){
		new JTabbedPane();
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		setTabPlacement(JTabbedPane.BOTTOM);
	}
}
