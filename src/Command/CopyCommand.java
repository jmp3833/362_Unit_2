package Command;

public class Copy implements Command{

        private TextTabWindow textTabWindow ;

        public Copy(TextTabWindow newTextTabWindow ){

                textTabWindow = newTextTabWindow ;

        }

        public void execute(TextTabWindow newTextTabWindow){

                textTabWindow.copy() ;

        }

}


