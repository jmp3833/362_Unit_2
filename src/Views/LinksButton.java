package Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JTextArea ta;
	
	public LinksButton(JTextArea jta) {
		lg = new LinkGrabber();
		ta = jta;
		setText("Links");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = ta.getText();
				ArrayList<Link> links = lg.search(text);

				JTextPane linkPane = new JTextPane();

				String linkText = "";
				for (Link link : links) {
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

				linkFrame.pack();
			}
		});

	}
}
