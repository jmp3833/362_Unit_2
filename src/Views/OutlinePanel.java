package Views;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class OutlinePanel extends JPanel{
	
	//TODO make a button in OutlinePanel
	//TODO get either open tag, close tag, text, or null string (end)
	public OutlinePanel(){
		update();
		setLayout(new FlowLayout());
	}
	
	private void update() {
		removeAll();
		JPanel p = recursiveConstructor();
		add(p);
	}
	
	private JPanel recursiveConstructor() {
		
		JPanel p = new JPanel();
		//for each
		//	p.add(createCPanel)
		//	if we go down a level, call recursiveC
		
		
		p.add(new CollapsiblePanel("h", "this is \nthe first \nhead text"));
		CollapsiblePanel q = new CollapsiblePanel("b", "b is \ndefinitely \nwhere it's at");
		p.add(q);
		
		JPanel qp = q.getEPanel();
		qp.add(new CollapsiblePanel("i1", "now we start\n to put text inside of text"));
		qp.add(new CollapsiblePanel("i2", "and here's another line that needs to be inside"));
		
		p.add(new CollapsiblePanel("end", "this is \nthe end \nof the show"));
		
		
		return p;		
	}

}
