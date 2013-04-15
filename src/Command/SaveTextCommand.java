/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * SaveTextCommand.java saves text whenever a command is performed on the
 * active JTextArea
 */
 
package Command;

import Observers.EditObserver;

public class SaveTextCommand implements Command{

        private EditObserver editObserver ;

        public SaveTextCommand(EditObserver newEditObserver){

                editObserver = newEditObserver ;

        }

        public void execute(){

                editObserver.saveText();

        }

}

