package Game.general.window.creditsWindow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.general.utilities.FileHandler;
import Game.general.utilities.FontHandler;

/**
 * TODO document
 */
public class CreditsWindowUI{
	
	private final int SIZE_HEIGHT = 300; //TODO Size passender wählen
	private final int SIZE_WIDTH = 200;
	
	JFrame _frame;
	JButton _backButton;

	public void initializeWindow(JFrame parentPanel) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(createEditorPanel(), BorderLayout.CENTER);
		mainPanel.add(createBackButtonPanel(), BorderLayout.SOUTH);
		createFrame(mainPanel, parentPanel);
	}
	
	private void createFrame(JPanel mainPanel, JFrame parentPanel){
		_frame = new JFrame("Credits");
		_frame.add(mainPanel);
		_frame.setLocation(getLocationRightToParent(parentPanel));
		_frame.setSize(SIZE_WIDTH, SIZE_HEIGHT);
		_frame.setResizable(false);
		_frame.pack();
		_frame.setVisible(true);
	}
	
	private Point getLocationRightToParent(JFrame parentPanel){
		int x =	(int) parentPanel.getLocation().getX() + parentPanel.getWidth()+ 10;
		return new Point(x, parentPanel.getHeight());
	}
	
	private JPanel createBackButtonPanel(){
		JPanel bottomPanel = new JPanel();
		_backButton = new JButton("Schließen");
		_backButton.setFont(getFont(10)); //TODO passe Size an
		bottomPanel.add(_backButton, BorderLayout.CENTER);
		return bottomPanel;
	}
	
	private JPanel createEditorPanel(){
		JPanel editorPanel = new JPanel();
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(getFont(14)); //TODO Passe Size an, hole text aus Text
		editorPane.setEditable(false);
		editorPane.setText(getCreditsText());
		editorPane.setPreferredSize(new Dimension(SIZE_WIDTH, SIZE_HEIGHT)); //TODO Passe Size an
		editorPanel.add(editorPane, BorderLayout.CENTER);
		return editorPanel;
	}
	
	public JButton getBackButton(){
		return _backButton;
	}
	
	private String getCreditsText(){
		try {
			return FileHandler.readWholeFile(new File("Files/credits.txt"));
		} catch (FileNotFoundException e) {
			return "Datei konnte nicht gefunden werden";
		}
	}
	
	private Font getFont(float size){
		return FontHandler.getStandardFont(size);
	}
	
	public void deleteWindow(){
		_frame.dispose();
	}
}
