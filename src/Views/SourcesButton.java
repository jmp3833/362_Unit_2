package Views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Tag.ImageGrabber;
import Tag.Source;

public class SourcesButton extends JButton {

	ImageGrabber ig;
	JTextArea ta;

	public SourcesButton(JTextArea jta) {
		ig = new ImageGrabber();
		setText("Images");
		ta = jta;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = ta.getText();
				
				ArrayList<Source> sources = ig.search(text);
				
				
				JPanel imagePanel = new JPanel();
				imagePanel.setLayout(new GridLayout(0,1));
				for (Source source : sources){
					String s = source.getSource();
					String a = source.getAlt();
					JTextPane sourcePane = new JTextPane();
					sourcePane.setText(s);
					JTextPane altPane = new JTextPane();
					altPane.setText(a);
					
					ShowImageButton sib = new ShowImageButton(s);
					
					JPanel singlePanel = new JPanel();
					singlePanel.setLayout(new BorderLayout());
					singlePanel.add(sourcePane, BorderLayout.WEST);
					singlePanel.add(altPane, BorderLayout.CENTER);
					singlePanel.add(sib, BorderLayout.EAST);
					imagePanel.add(singlePanel);
					
				}
				
				JScrollPane imageScrollPane = new JScrollPane();
				imageScrollPane.getViewport().add(imagePanel);
				
				JFrame imageFrame = new JFrame();
				imageFrame.setVisible(true);
				imageFrame.add(imageScrollPane);
				
				imageFrame.pack();

			}
		});
	}

}
