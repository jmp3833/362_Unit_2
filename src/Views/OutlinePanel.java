/**
 * @author: Alex Bogart
 * Constructs a panel to display the text in the TextWindow as collapsible elements.
 * Contains an iterative algorithm "update()" to populate itself.
 */

package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Tag.Buffer;
import Tag.CompositeTag;
import Tag.TagCollection;


public class OutlinePanel extends JPanel{
	
	//initialize constructs
	CompositeTag ct;
	JTextArea ta;
	Buffer buff;
	TagCollection tc;
	
	
	/**
	 * construct the main panel
	 * @param TextWindow
	 */
	public OutlinePanel(JTextArea taIn){
		
		ta = taIn;
		tc = new TagCollection();
		buff = new Buffer();
		update();
		
		
	}
	
	/**
	 * repopulate the outlinePanel
	 */
	public void update() {
		
		this.removeAll();
		String text = ta.getText();
		
		if(buff.validate(text, tc).compareTo("Valid HTML") != 0){
			JTextPane tp = new JTextPane();
			tp.setText("Malformed HTML");
			add(tp);
		}
		
		else {
		if(text.compareTo("")!=0){
		ct = new CompositeTag(text, 0);
		//get either open tag, close tag, text, or null string (end)
		ArrayList<String> composites = ct.getComposite();
		CollapsiblePanel p = recursiveConstructor(composites);
		add(p);
		}
		
		}
		revalidate();
		repaint();
	}
	
	/**
	 * iterates over the tags to construct the CollapsiblePanels and add them to themselves accordingly
	 * @param composites
	 * @return
	 */
	private CollapsiblePanel recursiveConstructor(ArrayList<String> composites) {
		CollapsiblePanel p = new CollapsiblePanel("");
		//p.setLayout(new BorderLayout());
		ArrayList<CollapsiblePanel> list = new ArrayList<CollapsiblePanel>();
		int i = 0;
		list.add(i, p);
		int decision;
		
		
		
		/**
		 * composites consists of open tags, end tags, and/or text.
		 */
		for (String str : composites) {

			
			str = str.trim();
			//System.out.println("+"+str+"-");
			
			if (str.length()>=2) {
				if (tc.checkTag(str)) {
					if (str.charAt(1) != '/') {  //if open tag
						decision = 1;
					} else {				//if close tag
						decision = 2;
					}
				} else {		//if text
					decision = 3;
				}	
			} else {  //malformed text -> ignore (\n, empty, null, etc)
				decision = 4;
			}
			
			
			switch(decision){
			/**
			 * create another collapsiblepanel and make that one the one that you add concurrent-level
			 * panels to. This is indicated by i.
			 */
			case 1:
				i++;
				CollapsiblePanel next = new CollapsiblePanel(str);
				list.add(i, next);
				list.get(i - 1).getEPanel().add(next, BorderLayout.NORTH);
				JPanel newEPanel = new JPanel();
				newEPanel.setLayout(new BorderLayout());
				list.get(i - 1).getEPanel().add(newEPanel, BorderLayout.SOUTH);
				list.get(i-1).setEPanel(newEPanel);  
				/**
				* the north section of ePanel contains the text/CollapsiblePanel.
				* the south section links to the next ePanel
				*/								
				break;
			
			case 2:
				i--;
				break;
			
			/**
			 * like in case 1, but no new level in the hierarchy
			 */
			case 3:
				JTextPane tp = new JTextPane();
				tp.setText(str);
				list.get(i).getEPanel().add(tp, BorderLayout.NORTH);
				JPanel newEPanel1 = new JPanel();
				newEPanel1.setLayout(new BorderLayout());
				list.get(i).getEPanel().add(newEPanel1, BorderLayout.SOUTH);
				list.get(i).setEPanel(newEPanel1);

				break;
				
			default:
				break;
			}
			
		}
		return p;
	}

}
