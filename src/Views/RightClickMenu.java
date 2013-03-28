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
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;

import Tag.TagCollection;



public class RightClickMenu extends MouseAdapter{
	
	TextWindow tw;
	JPopupMenu menu;
	
	/**
	 * initialize the menu
	 */
	public RightClickMenu(TextWindow tw, TagCollection tags) {
		
		
		JPopupMenu menu = new JPopupMenu();
        JMenu insert = new JMenu("Insert");
        
        //get the list of tabs
        for (ArrayList<String> al : tags.getNames()){
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
        			tag.addActionListener(makeInsertListener(tags.getTag(str)));
        			category.add(tag);
        		}
        			
        	}
        }
        
        //insert the different menu options
        menu.add(insert);
        JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
        cut.setText("Cut");
        JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        copy.setText("Copy");
        JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText("Paste");
        menu.add(cut);
        menu.add(copy);
        menu.add(paste);
        
        JMenuItem indent = new JMenuItem("Indent Line(s)");
        indent.addActionListener(indentListener);
        menu.add(indent);
        
        JMenuItem indentAll = new JMenuItem("Indent All");
        indentAll.addActionListener(indentAllListener);
        menu.add(indentAll);
        
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
    
   
    /**
     * create the listener to add to the insert menu items
     * @param str
     * @return
     */
    ActionListener makeInsertListener(final String str){
    	ActionListener insertAction = new ActionListener(){

    		//inserts the tag at the caret's position
			@Override
			public void actionPerformed(ActionEvent e) {
				//moves the caret to inbetween the cursors
				int pos = tw.getCaretPosition();
				int displacement = str.length()/2;
				
				tw.insert(str, pos);
				tw.setCaretPosition(pos+displacement);
				
			}
    		
    	};
    	return insertAction;
    }
    
    /**
     * gets the selected lines and calls indentText()
     */
    ActionListener indentListener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int start = tw.getSelectionStart();
			int end = tw.getSelectionEnd();
			int lineStart = 0;
			int lineEnd = 0;
			
			try {
				lineStart = tw.getLineOfOffset(start);
				lineEnd = tw.getLineOfOffset(end);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
			
			indentText(lineStart, lineEnd);
		}
    };
    
    /**
     * gets all the lines and calls indentText()
     */
    ActionListener indentAllListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int lineEnd = tw.getLineCount()-1;
			indentText(0, lineEnd);
		}
	};
    
	//indents the given lines or line the caret is on
    void indentText(int lineStart, int lineEnd){
    	try {
			
			
			for (int i=lineEnd; i>=lineStart; i--){
				int target = tw.getLineStartOffset(i);
				tw.insert("\t", target);
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
    }
    
    
    
}
    
    
    
