/**
 * @author Alex Bogart
 * Create an ImagePanel
 */

package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ShowImageButton extends JButton {

	String filename;
	public ShowImageButton(String source){
		setText("Show");
		filename = source;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
		new ImagePanel(filename);
			}
		});
	}
}
