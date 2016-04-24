package Game.general.window.creditsWindow;

import javax.swing.JFrame;

/**
 * TODO document
 */
public class CreditsWindowTool {
	
	CreditsWindowUI _ui;
	
	public void startWindow(JFrame panel){
		_ui = new CreditsWindowUI();
		_ui.initializeWindow(panel);
	}
}
