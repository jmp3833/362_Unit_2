package Command;

import Observers.FileObserver;

public class CreateCommand implements Command{

	private FileObserver fileObserver ; 	

	public CreateCommand(FileObserver newFileObserver){
		
		fileObserver = newFileObserver ;

	}
	public void execute(){

		fileObserver.create() ;

	}

}
