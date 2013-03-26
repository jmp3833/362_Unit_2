
package Command;

public class QuitCommand implements Command{

        private FileObserver fileObserver ;

        public QuitCommand(FileObserver newFileObserver){

                fileObserver = newFileObserver ;

        }

        public void execute(){

                fileObserver.quit() ;

        }

}

