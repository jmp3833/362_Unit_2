package Command;

public class CommandInvoker{

	private Command aCommand ;

	public void invokeCommand(Command newCommand){
		aCommand = newCommand ; 
		aCommand.execute();

	}

}
