package Command;

public class LoadCommand implements Command{

	private FileObserver fileObserver ;
	
	public LoadCommand(FileObserver newFileObserver){

		fileObserver = newFileObserver ; 

	}

        public void execute(){

		fileObserver.load() ;

        }

}

