package Game.general.window.creditsWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * TODO document
 */
public class CreditsWindowTool {
	
	CreditsWindowUI _ui;
	
	public void startWindow(JFrame panel){
		_ui = new CreditsWindowUI();
		_ui.initializeWindow(panel);
		registerListener();
	}
	
	private void registerListener(){
		_ui.getBackButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				_ui.deleteWindow();
			}
		});
	}
}
