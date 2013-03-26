package Command;

public class Paste implements Command{

	private TextTabWindow textTabWindow ;
	
	public Paste(TextTabWindow newTextTabWindow ){

		textTabWindow = newTextTabWindow ;

	}

        public void execute(TextTabWindow newTextTabWindow){

		textTabWindow.paste() ;

        }

}

