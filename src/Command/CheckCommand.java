package Command;
import Observers.CheckObserver;

/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * CheckCommand.java invokes the command to check whether the JTextArea
 * contains valid HTML.
 */


public class CheckCommand implements Command{

        private CheckObserver checkObserver ;

        public CheckCommand(CheckObserver newCheckObserver){

                checkObserver = newCheckObserver ;

        }

        public void execute(){

                checkObserver.validateHTML() ;

        }

}