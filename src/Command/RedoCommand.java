/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * edoCommand.java is invoked when the user selects to redo an action from
 * the menu bar. It utilizes a memento pattern to restore the active text window
 * to a previous state.
 */
 
package Command;

import Observers.EditObserver;

public class RedoCommand implements Command{

        private EditObserver editObserver ;

        public RedoCommand(EditObserver newEditObserver){

                editObserver = newEditObserver ;

        }

        public void execute(){

                editObserver.redoText();

        }

}
