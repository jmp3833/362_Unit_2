/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * PasteCommand.java invokes a command to paste text using a previous memento
 */


package Command;

import Observers.RightClickObserver;

public class PasteCommand implements Command{

        private RightClickObserver rightClickObserver ;

        public PasteCommand(RightClickObserver newRightClickObserver){

                rightClickObserver = newRightClickObserver ;

        }

        public void execute(){
        	rightClickObserver.paste() ;
        }

}
