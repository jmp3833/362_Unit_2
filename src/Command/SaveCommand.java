package Command;

public class Save implements Command{

	FileReader = fileReader ;

	public Save(FileReader newFileReader){
	
		fileReader = newFileReader ;

	}
        public void execute(){

		fileReader.save() ;

        }

}

