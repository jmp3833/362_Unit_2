package Views;

import javax.swing.JButton;

public class ShowImageButton extends JButton {

	public ShowImageButton(String source){
		
		new ImagePanel(source);
	}
}
