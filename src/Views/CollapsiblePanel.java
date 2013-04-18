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

	JButton b = new JButton("-");
	JTextPane cText = new JTextPane(); //collapsedText
	JPanel ePanel = new JPanel(); //expandedPanel
	JTextPane eText = new JTextPane(); //expandedText
	
	public CollapsiblePanel(String tag, String text){
		
		setLayout(new BorderLayout());
		ePanel.setLayout(new BorderLayout());
		
				
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ePanel.isVisible()) {
					b.setText("+");
					add(cText, BorderLayout.CENTER);
					add(ePanel, BorderLayout.EAST);
					ePanel.setVisible(false);
					cText.setVisible(true);
				} else {
					b.setText("-");
					add(cText, BorderLayout.EAST);
					add(ePanel, BorderLayout.CENTER);
					ePanel.setVisible(true);
					cText.setVisible(false);
				}
			}			
        });
		
		cText.setText(tag);
		cText.setVisible(false);
		
		eText.setText(text);
		
		
		
		add(b, BorderLayout.WEST);
		
		add(cText, BorderLayout.EAST);
		ePanel.add(eText, BorderLayout.NORTH);
		add(ePanel, BorderLayout.CENTER);
		
		
		
	}
	
	public JPanel getEPanel(){
		return ePanel;
	}
	
	
	
}
