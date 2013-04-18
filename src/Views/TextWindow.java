/**
 * @author:Alex Bogart, Justin Peterson
 * TextWindow.java represents the actual Swing window that will be kept in the
 * main focus of the HTML editor.  
 * 
 */


package Views;

import Command.Command;
import Command.CommandInvoker;
import Command.SaveTextCommand;
import Observers.EditObserver;
import Tag.TagCollection;
import Views.TextTabWindow;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.OutputUtil;

public class TextWindow extends JTextArea{
	
	private static final long serialVersionUID = 1L;

	CommandInvoker invoker;
	Command saveTextCommand;
	
	/**
	 * Constructs an individual window to add to the TextTabWindow. 
	 * @param tabWindow - the main TextTabWindow of the editor. 
	 */
	public TextWindow(String windowName, TextTabWindow tabWindow, TagCollection tabs, EditObserver e){
		invoker = new CommandInvoker();
		saveTextCommand = new SaveTextCommand(e);
		
		setLayout(new BorderLayout(5,10));
		new JTextArea();
		
		//allows line wrapping; defaults to by letter if wrapStyleWord is false
		setLineWrap(true);
		
		//will not work if lineWrap is false, true wraps by word
		setWrapStyleWord(true);
		
		//change the tab size; default is 8
		setTabSize(8);
		
		//opens the right-click menu
		addMouseListener(new RightClickMenu(this, tabs, e));
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				invoker.invokeCommand(saveTextCommand);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

	
		});
		
		//places text area inside a scrolling pane
		TextScrollPane scrollPane = new TextScrollPane(this);
		//scrollPane.getViewport().add(this);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout(3,3));
		OutlinePanel outlinepanel = new OutlinePanel();
		p.add(this, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		SourcesButton images = new SourcesButton(this);
		
		LinksButton links = new LinksButton(this);
		
		UpdateOutlineButton uob = new UpdateOutlineButton(outlinepanel);
		
		buttonPanel.add(images);
		buttonPanel.add(links);
		buttonPanel.add(uob);
		
		p.add(buttonPanel, BorderLayout.NORTH);
		
		p.add(outlinepanel, BorderLayout.SOUTH);
		
		scrollPane.getViewport().add(p);
		scrollPane.setBounds(10,60,780,500);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		tabWindow.addTab(windowName, scrollPane);
		setVisible(true);
		
		
		
		
		
	}
}
