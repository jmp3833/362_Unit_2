/**
 * @author: Alex Bogart
 * RightClickMenu.java represents the Swing context menu allowing the user to insert tags with the right-click
 * individual JTextAreas. 
 */

package Views;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.DefaultEditorKit;

import Tag.TagCollection;



public class RightClickMenu extends MouseAdapter{
	
	TextWindow tw;
	JPopupMenu menu;
	
	public RightClickMenu(TextWindow tw, TagCollection tabs) {
		
		//initialize the menu
		JPopupMenu menu = new JPopupMenu();
        JMenu insert = new JMenu("Insert");
        ArrayList<JMenuItem> tags = new ArrayList<JMenuItem>();
        
        for (ArrayList<String> al : tabs.getNames()){
        	int i = 0;
        	JMenu category = new JMenu();
        	insert.add(category);
        	for (String str : al){
        		if (i == 0){
        			category.setText(str);
        			i++;
        		} 
        		else {
        			JMenuItem tag = new JMenuItem(str);
        			tag.addActionListener(makeInsertListener(tabs.getTag(str)));
        			category.add(tag);
        		}
        			
        	}
        }
        
        
        
        
   
        
    
       
        menu.add(insert);
        JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
        JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        menu.add(cut);
        menu.add(copy);
        menu.add(paste);
        
        
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
    ActionListener makeInsertListener(final String str){
    	ActionListener insertAction = new ActionListener(){

    		//inserts the tag at the caret's position
			@Override
			public void actionPerformed(ActionEvent e) {
				int pos = tw.getCaretPosition();
				int displacement = str.length()/2;
				
				tw.insert(str, pos);
				tw.setCaretPosition(pos+displacement);
				
			}
    		
    	};
    	return insertAction;
    }
    
}
    
    
    
