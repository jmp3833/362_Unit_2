package Views;

import javax.swing.*; 
import javax.swing.text.Document; 
import javax.swing.text.BadLocationException; 
import java.awt.event.ActionEvent; 
 
/** 
 * @author Santhosh Kumar T 
 * @email santhosh@fiorano.com 
 */ 
public class AutoIndent extends AbstractAction { 
    public void actionPerformed(ActionEvent e) { 
        JTextArea area = (JTextArea) e.getSource(); 
        Document doc = area.getDocument(); 
 
        if(!area.isEditable()) 
            return; 
        try { 
            int lineOffset = area.getLineOfOffset(area.getCaretPosition()); 
 
            int startPos = area.getLineStartOffset(lineOffset); 
            int endPos = area.getLineEndOffset(lineOffset); 
            String text = doc.getText(startPos, endPos - startPos - 1); 
            String whiteSpace = getLeadingWhiteSpace(text); 
            doc.insertString(area.getCaretPosition(), '\n' + whiteSpace, null); 
        } catch(BadLocationException ex) { 
            try { 
                doc.insertString(area.getCaretPosition(), "\n", null); 
            } catch(BadLocationException ignore) { 
                // ignore 
            } 
        } 
    } 
 
    /** 
     *  Returns leading white space characters in the specified string. 
     */ 
    private String getLeadingWhiteSpace(String str) { 
        return str.substring(0, getLeadingWhiteSpaceWidth(str)); 
    } 
 
    /** 
     *  Returns the number of leading white space characters in the specified string. 
     */ 
    private int getLeadingWhiteSpaceWidth(String str) { 
        int whiteSpace = 0; 
        while(whiteSpace<str.length()) { 
            char chInWhiteSpace = str.charAt(whiteSpace); 
            if(chInWhiteSpace==' ' || chInWhiteSpace=='\t') 
                whiteSpace++; 
            else 
                break; 
        } 
        return whiteSpace; 
    } 
} 