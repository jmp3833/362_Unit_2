/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * IndentTextCommand.java directs the UI to functionality in RightClickObserver
 * to indent text.
 */


package Command;

import Observers.RightClickObserver;

public class IndentTextCommand implements Command{

        private RightClickObserver rightClickObserver ;

        public IndentTextCommand(RightClickObserver newRightClickObserver){

                rightClickObserver = newRightClickObserver ;

        }

        public void execute(){

               rightClickObserver.indentSelectedText() ;

        }

}
