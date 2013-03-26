
package Command;

public class SaveCommand implements Command{

        private FileObserver fileObserver ;

        public SaveCommand(FileObserver newFileObserver){

                fileObserver = newFileObserver ;

        }

        public void execute(){

                fileObserver.load() ;

        }

}

