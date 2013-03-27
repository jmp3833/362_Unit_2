/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * EnableTextWrapCommand.java feeds the command to select if the user would
 * like to enable/disable text wrapping. 
 */


package Command;

import Observers.SettingsObserver;

public class EnableTextWrapCommand implements Command{

        private SettingsObserver settingsObserver ;

        public EnableTextWrapCommand(SettingsObserver newSettingsObserver){

                settingsObserver = newSettingsObserver ;

        }

        public void execute(){

                settingsObserver.enableTextWrapping() ;

        }

}