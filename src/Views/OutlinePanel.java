package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class OutlinePanel extends JPanel{
	
	//TODO make a button in OutlinePanel
	//TODO get either open tag, close tag, text, or null string (end)
	public OutlinePanel(){
		//setLayout(new GridBagLayout()
		update();
		removeAll();
		CollapsiblePanel p = new CollapsiblePanel("<h1>", "<h1> this is the first \nbit of text </h1>");
		CollapsiblePanel q = new CollapsiblePanel("<h2>", "<h2> h2 is \ndefinitely \nwhere it's at </h2>");
		p.add(q, BorderLayout.SOUTH);
		
		//JPanel qp = q.getEPanel();
		CollapsiblePanel q1 = new CollapsiblePanel("<b>", "<b> now we start\n to put text inside of text </b>");
		CollapsiblePanel q2 = new CollapsiblePanel("<b>", "<b> this tag's at the same level \nas the one above it </b>");
		
		CollapsiblePanel q21 = new CollapsiblePanel("<i>", "<i> but this one is on \nthe third level! </i>");
		
		q2.getEPanel().add(q21, BorderLayout.SOUTH);
		
		JPanel qe = q.getEPanel();
		
		qe.add(q1, BorderLayout.SOUTH);
		q1.add(q2, BorderLayout.SOUTH);
				
		CollapsiblePanel r = new CollapsiblePanel("<h3>", "<h3> this is \nthe end \nof the show </h3>");
		
		q.add(r, BorderLayout.SOUTH);
		
		
		
		add(p);		
		
	}
	
	public void update() {
		this.removeAll();
		JPanel p = recursiveConstructor();
		add(p);
		revalidate();
		repaint();
	}
	
	private JPanel recursiveConstructor() {
		
		CollapsiblePanel big = new CollapsiblePanel("<h1>", "<h1> That's all folks! </h1>");
		//for each
		//	p.add(createCPanel)
		//	if we go down a level, call recursiveC
		
		return big;
		
	}

}
