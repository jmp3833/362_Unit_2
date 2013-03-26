/**
 * @author: Alex Bogart
 * RightClickMenu.java represents the Swing context menu allowing the user to insert tags with the right-click
 * individual JTextAreas. 
 */

package Views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;



public class RightClickMenu extends MouseAdapter{
	
	TextWindow tw;
	JPopupMenu menu;
	
	public RightClickMenu(TextWindow tw) {
		
		//initialize the menu
		JPopupMenu menu = new JPopupMenu();
        JMenu insert = new JMenu("Insert");
        ArrayList<JMenuItem> tags = new ArrayList<JMenuItem>();
        JMenuItem h1Open = new JMenuItem("<h1>");
        tags.add(h1Open);
        JMenuItem h1End = new JMenuItem("</h1>");
        tags.add(h1End);
        
        for (JMenuItem i : tags){
        	i.addActionListener(makeInsertListener());
        	insert.add(i);
        }
       
        menu.add(insert);
        
        this.tw = tw;
        this.menu = menu;
        
	}

	public void mousePressed(MouseEvent e){
		if (e.isPopupTrigger())
			popUp(e);
	}
	
	public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            popUp(e);
    }

    private void popUp(MouseEvent e){
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
    
   
    //create the listener to add to the insert menu items
    ActionListener makeInsertListener(){
    	ActionListener insertAction = new ActionListener(){

    		//inserts the tag at the caret's position
			@Override
			public void actionPerformed(ActionEvent e) {
				tw.insert(e.getActionCommand(), tw.getCaretPosition());
			}
    		
    	};
    	return insertAction;
    }
    
}
    
    
    
