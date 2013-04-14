/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * RightClickObserver.java handles the functionality for all functions that can
 * be selected from the right click UI menu. 
 */


package Observers;

import javax.swing.text.BadLocationException;

import Views.TextWindow;

public class RightClickObserver {
	
	TextWindow tw;
	
	public RightClickObserver(TextWindow tw){
		this.tw = tw;
	}
	
	//indents the given lines or line the caret is on
    public void indentText(int lineStart, int lineEnd){
    	try {
			
			
			for (int i=lineEnd; i>=lineStart; i--){
				int target = tw.getLineStartOffset(i);
				tw.insert("\t", target);
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
    }
    
    /**
     * indents all lines of text in the active editor window. 
     */
    public void indentAll(){
    	int lineEnd = tw.getLineCount()-1;
		indentText(0, lineEnd);
    }
	
	/**
	 * Controls the indentation of the active text window.
	 */
	public void indentSelectedText(){
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
}
