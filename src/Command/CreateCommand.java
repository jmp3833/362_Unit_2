package Command;

public class Create implements Command{

	private FileReader fileReader ; 	

	public Create(FileReader newFileReader){
		
		fileReader = newFileReader ;

	}
	public void execute(){

		fileReader.create() ;

	}

}
