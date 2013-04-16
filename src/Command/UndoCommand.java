/** @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * UndoCommand.java is invoked when the user selects to undo an action from
 * the menu bar. It utilizes a memento pattern to restore the active text window
 * to a previous state.
 */


package Command;

import Observers.EditObserver;

public class UndoCommand implements Command{

        private EditObserver editObserver ;

        public UndoCommand(EditObserver newEditObserver){

                editObserver = newEditObserver ;

        }

        public void execute(){
        	editObserver.undoText();
        }

}