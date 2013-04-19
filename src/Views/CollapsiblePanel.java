/**
 * @author: Alex Bogart
 * A construct for an individual section of the OutlinePanel.
 */

package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;


public class CollapsiblePanel extends JPanel{

	//initialize constructs
	JButton b = new JButton("-");
	JTextPane cText = new JTextPane(); //collapsedText
	JPanel ePanel = new JPanel(); //expandedPanel
	JPanel originalE = new JPanel(); 
	JPanel returnThisPanel = ePanel;
	
	public CollapsiblePanel(String tag){
		
		setLayout(new BorderLayout());
		ePanel.setLayout(new BorderLayout());
		originalE.add(ePanel);
		
		/**
		 * collapse/expand the ePanel/cText (also replace positions)
		 */
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (originalE.isVisible()) {
					b.setText("+");
					add(cText, BorderLayout.CENTER);
					add(originalE, BorderLayout.EAST);
					originalE.setVisible(false);
					cText.setVisible(true);
				} else {
					b.setText("-");
					add(cText, BorderLayout.EAST);
					add(originalE, BorderLayout.CENTER);
					originalE.setVisible(true);
					cText.setVisible(false);
				}
			}			
        });
		
		cText.setText(tag);
		cText.setVisible(false);
		
		//eText.setText(text);
		
		
		
		add(b, BorderLayout.WEST);
		
		add(cText, BorderLayout.EAST);
		//ePanel.add(eText, BorderLayout.NORTH);
		add(originalE, BorderLayout.CENTER);
		
		
		
	}
	
	/**
	 * @return the lowermost ePanel
	 */
	public JPanel getEPanel(){
		return returnThisPanel;
	}

	
	/**
	 * @return the tag for the collapsible section
	 */
	public String getTag(){
		return cText.getText();
	}

	/**
	 * set the lowermost ePanel
	 * @param newEPanel
	 */
	public void setEPanel(JPanel newEPanel) {
		returnThisPanel = newEPanel;
		
	}
	
	
}
