/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * CutCommand.java cuts selected text and stores it in a memento object
 */


package Command;

import Observers.RightClickObserver;

public class CutCommand implements Command{

        private RightClickObserver rightClickObserver ;

        public CutCommand(RightClickObserver newRightClickObserver){

                rightClickObserver = newRightClickObserver ;

        }

        public void execute(){
        	rightClickObserver.cut() ;
        }

}
