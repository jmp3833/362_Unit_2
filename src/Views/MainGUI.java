/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * MainGUI.java is the main window of the HTML Editor's user interface. 
 * This window will interact with two components, the menu bars, and the 
 * text tab window. 
 */


package views;
import java.awt.*;

import views.MenuBar;

import javax.swing.*;

public class MainGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//launches the main user interface window of the system.
	public MainGUI() {
		
		
		//Separates the layout into components representing cardinal directions. 
		getContentPane().setLayout(new BorderLayout(5,10));
		setSize(600,800);
		setTitle("Simple HTML Editor");
		
		//Adds components to the layout
		add(new MenuBar().barCreator(this),BorderLayout.NORTH);
		
	    //set constraints of the main window. 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
			
		
	}
	

}
