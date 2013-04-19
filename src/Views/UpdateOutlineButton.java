/**
 * @author Alex Bogart
 * Refreshes and re-populates the OutlinePanel from the TextWindow
 */

package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UpdateOutlineButton extends JButton{
	
	OutlinePanel op;
	
	public UpdateOutlineButton(OutlinePanel opIn){
		setText("Refresh Outline View");
		op = opIn;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op.update();
			}
		});
			
	}

}
