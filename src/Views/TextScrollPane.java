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