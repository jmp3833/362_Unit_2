/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * IndentAllTextCommand.java invokes the logic to indent
 * all text in the active text window. 
 */

package Command;

import Observers.RightClickObserver;

public class IndentAllTextCommand implements Command{

        private RightClickObserver rightClickObserver ;

        public IndentAllTextCommand(RightClickObserver newRightClickObserver){

                rightClickObserver = newRightClickObserver ;

        }

        public void execute(){
        	rightClickObserver.indentAll() ;
        }

}
