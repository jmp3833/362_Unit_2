/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * InsertTagCommand.java
 */


package Command;

import Observers.InsertObserver;

/**
 * Command to insert a tag construct into the text body of the HTML editor. 
 */
public class InsertTagCommand implements Command {
	
	private InsertObserver insertObserver ;

    public InsertTagCommand(InsertObserver newInsertObserver){

            insertObserver = newInsertObserver ;

    }

    public void execute(){

            insertObserver.insertTag() ;

    }

}
