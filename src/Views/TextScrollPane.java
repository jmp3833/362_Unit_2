/**
 * @author Alex Bogart
 * Manage all the elements contained within the viewable section of the tab.
 */


package Views;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextScrollPane extends JScrollPane{
	
	JTextArea ta;
	
	public TextScrollPane(JTextArea jta){
		
		ta = jta;
	}
	
	public JTextArea getTextArea(){
		return ta;
	}
}