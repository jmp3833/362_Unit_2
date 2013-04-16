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
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.DefaultEditorKit;

import Command.Command;
import Command.CommandInvoker;
import Command.IndentAllTextCommand;
import Command.IndentTextCommand;
import Command.CutCommand;
import Command.CopyCommand;
import Command.PasteCommand;
import Command.SaveTextCommand;
import Observers.EditObserver;
import Observers.RightClickObserver;
import Tag.TagCollection;



public class RightClickMenu extends MouseAdapter{
	
	TextWindow tw;
	JPopupMenu menu;
	
	//Declares commands and their invoker.
	CommandInvoker invoker;
	Command indentTextCommand;
	Command indentAllTextCommand;
	Command cutCommand;
	Command copyCommand;
	Command pasteCommand;
	Command saveTextCommand;
	RightClickObserver r;
	EditObserver e;
	
	/**
	 * initialize the menu
	 */
	public RightClickMenu(TextWindow tw, TagCollection tags, EditObserver e) {
		
		//Commands for the right click menu
		this.invoker = new CommandInvoker();
		this.r = new RightClickObserver(tw);
		this.e = e;
		
		this.indentTextCommand = new IndentTextCommand(r);
		this.indentAllTextCommand = new IndentAllTextCommand(r);
		this.cutCommand = new CutCommand(r);
		this.copyCommand = new CopyCommand(r);
		this.pasteCommand = new PasteCommand(r);
		this.saveTextCommand = new SaveTextCommand(e);
				
		JPopupMenu menu = new JPopupMenu();
 
        //insert the different menu options
        JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
        cut.setText("Cut");
        cut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				invoker.invokeCommand(saveTextCommand);
				invoker.invokeCommand(cutCommand);
				
			}
        	
        });
        JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        copy.setText("Copy");
        copy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				invoker.invokeCommand(saveTextCommand);
				invoker.invokeCommand(copyCommand);
				
			}
        	
        });
        JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText("Paste");
        paste.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				invoker.invokeCommand(saveTextCommand);
				invoker.invokeCommand(pasteCommand);
				
			}
        	
        });
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
     * gets the selected lines and calls indentText()
     */
    ActionListener indentListener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			invoker.invokeCommand(indentTextCommand);
		}
    };
    
    /**
     * gets all the lines and calls indentText()
     */
    ActionListener indentAllListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			invoker.invokeCommand(indentAllTextCommand);
		}
	};
    
    
}
    
    
    
