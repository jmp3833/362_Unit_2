/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * InsertHrefTagCommand.java provides a command to 
 * insert an href tag into the editor
 */


package Command;

import Observers.InsertObserver;

/**
 * Command to insert a tag construct into the text body of the HTML editor. 
 */
public class InsertHrefTagCommand implements Command {
	
	private InsertObserver insertObserver ;

    public InsertHrefTagCommand(InsertObserver newInsertObserver){

            insertObserver = newInsertObserver ;

    }

    public void execute(){

            insertObserver.insertHrefTag() ;

    }

}
