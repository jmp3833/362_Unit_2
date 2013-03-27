/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * ChangeTabLengthCommand.java feeds the command to change the user's desired tab length.
 */


package Command;

import Observers.SettingsObserver;

public class ChangeTabLengthCommand implements Command{

        private SettingsObserver settingsObserver ;

        public ChangeTabLengthCommand(SettingsObserver newSettingsObserver){

                settingsObserver = newSettingsObserver ;

        }

        public void execute(){

                settingsObserver.changeTabLength() ;

        }

}
