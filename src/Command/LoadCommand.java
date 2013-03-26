package Command;

public class Load implements Command{

	private FileReader fileReader ;
	
	public Load(FileReader newFileReader){

		fileReader = newFileReader ; 

	}

        public void execute(){

		fileReader.load() ;

        }

}

