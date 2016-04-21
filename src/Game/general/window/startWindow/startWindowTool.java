package Game.general.window.startWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO document
 */
public class startWindowTool {
    startWindowUI _ui = new startWindowUI();

    public void startWindow(){
        _ui.initializeWindow();
        registerListeners();
    }
    
    private void registerListeners(){
    	_ui.getButton(_ui.BUTTON_EXIT).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Add Yes/No Question
				System.exit(0);
			}
		});
    	
    	_ui.getButton(_ui.BUTTON_CREDITS).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO add CreditsWindow but you can also use startWindow
			}
		});
    	
    	_ui.getButton(_ui.BUTTON_NEWGAME).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Add MainWindow
				// TODO Later add NewGameWindow
				
			}
		});
    }
}
