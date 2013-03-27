package Command;
import Observers.InsertObserver;

/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * insertTableCommand.java invokes the command to check insert a tag table 
 * into the HTML window.
 */


public class InsertTableCommand implements Command{

        private InsertObserver insertObserver ;

        public InsertTableCommand(InsertObserver newInsertObserver){

                insertObserver = newInsertObserver ;

        }

        public void execute(){

                insertObserver.insertTable() ;

        }
}
