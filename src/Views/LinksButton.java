package Views;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Tag.Link;
import Tag.LinkGrabber;

public class LinksButton extends JButton {

	LinkGrabber lg;
	
	public LinksButton(JTextArea ta){
		String text = ta.getText();
		ArrayList<Link> links = lg.search(text);
		
		JTextPane linkPane = new JTextPane();
		
		String linkText = "";
		for (Link link : links){
			String l = link.getLink();
			int n = link.getNumber();
			linkText = linkText + "\n" + l + " : " + n;
		}
		
		linkPane.setText(linkText);
		JScrollPane sp = new JScrollPane();
		sp.getViewport().add(linkPane);
		
		JFrame linkFrame = new JFrame();
		linkFrame.setVisible(true);
		linkFrame.add(sp);
		
		linkFrame.setSize(600,750);
	}
}
