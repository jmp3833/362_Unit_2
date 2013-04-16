/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * CopyCommand.java invokes a command to copy text
 */


package Command;

import Observers.RightClickObserver;

public class CopyCommand implements Command{

        private RightClickObserver rightClickObserver ;

        public CopyCommand(RightClickObserver newRightClickObserver){

                rightClickObserver = newRightClickObserver ;

        }

        public void execute(){
        	rightClickObserver.copy() ;
        }

}
