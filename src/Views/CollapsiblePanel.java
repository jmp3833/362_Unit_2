package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
				
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ePanel.isVisible()) {
					b.setText("+");
					ePanel.setVisible(false);
					cText.setVisible(true);
				} else {
					b.setText("-");
					ePanel.setVisible(true);
					cText.setVisible(false);
				}
			}			
        });
		
		cText.setText(tag);
		cText.setVisible(false);
		
		eText.setText(text);
		
		add(b, BorderLayout.EAST);
		add(cText, BorderLayout.CENTER);
		ePanel.add(eText, BorderLayout.WEST);
		add(ePanel, BorderLayout.WEST);
		
	}
	
	public JPanel getEPanel(){
		return ePanel;
	}
	
	
	
}
