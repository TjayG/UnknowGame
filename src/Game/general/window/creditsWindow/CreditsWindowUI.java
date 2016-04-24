package Game.general.window.creditsWindow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.general.utilities.FontHandler;

/**
 * TODO document
 */
public class CreditsWindowUI{
	
	private final int SIZE_HEIGHT = 300; //TODO Size passender wählen
	private final int SIZE_WEIGHT = 200;
	
	JButton _backButton;

	public void initializeWindow(JFrame parentPanel) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(createEditorPanel(), BorderLayout.CENTER);
		mainPanel.add(createBackButtonPanel(), BorderLayout.SOUTH);
		createFrame(mainPanel, parentPanel);
	}
	
	private void createFrame(JPanel mainPanel, JFrame parentPanel){
		JFrame frame = new JFrame("Credits");
		frame.add(mainPanel);
		frame.setLocationRelativeTo(parentPanel); //TODO set resizeable etc.
		frame.pack();
		frame.setVisible(true);
	}
	
	private JPanel createBackButtonPanel(){
		JPanel bottomPanel = new JPanel();
		_backButton = new JButton("Schließen");
		_backButton.setFont(getFont(16)); //TODO passe Size an
		bottomPanel.add(_backButton, BorderLayout.CENTER);
		return bottomPanel;
	}
	
	private JPanel createEditorPanel(){
		JPanel editorPanel = new JPanel();
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(getFont(14)); //TODO Passe Size an, hole text aus Text
		editorPane.setEditable(false);
		editorPane.setPreferredSize(new Dimension(SIZE_WEIGHT, SIZE_HEIGHT)); //TODO Passe Size an
		editorPanel.add(editorPane, BorderLayout.CENTER);
		return editorPanel;
	}
	
	private Font getFont(float size){
		return FontHandler.getStandardFont(size);
	}
}
