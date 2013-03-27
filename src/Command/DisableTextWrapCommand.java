/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * DisableTextWrapCommand.java feeds the command to select if the user would
 * like to Disable/disable text wrapping. 
 */


package Command;

import Observers.SettingsObserver;

public class DisableTextWrapCommand implements Command{

        private SettingsObserver settingsObserver ;

        public DisableTextWrapCommand(SettingsObserver newSettingsObserver){

                settingsObserver = newSettingsObserver ;

        }

        public void execute(){

                settingsObserver.disableTextWrapping() ;

        }

}