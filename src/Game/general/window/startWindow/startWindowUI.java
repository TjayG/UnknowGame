package Game.general.window.startWindow;

import Game.general.utilities.FontHandler;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * TODO document
 */
public class startWindowUI {

    private final int SIZE_WIDTH = 400;
    private final int SIZE_HEIGHT = 600;
    final int BUTTON_NEWGAME = 0;
    final int BUTTON_LOADGAME = 1;
    final int BUTTON_SETTINGS = 2;
    final int BUTTON_CREDITS = 3;
    final int BUTTON_EXIT = 4;
    
    private JLabel _timeLabel;
    
    private boolean isRunningTimeThread = false;

    private JButton[] _buttons;


    public void initializeWindow(){
        JPanel mainpanel = createMainpanel();
        mainpanel.setLayout(new BorderLayout());

        mainpanel.add(createCenter(), BorderLayout.CENTER);
        mainpanel.add(createBottom(), BorderLayout.SOUTH); // TODO create Bottom
        createFrame(mainpanel);
    }
    
    // --- Create Mainpanel ---
    
    private JPanel createMainpanel() {
        JPanel mainpanel = new JPanel();

        return mainpanel;
    }
    
    // --- Create Frame ---

    private void createFrame(JPanel mainpanel) {
        JFrame frame = new JFrame("UnknowGame"); //TODO Change Title
        frame.add(mainpanel);
        frame.setSize(new Dimension(SIZE_WIDTH, SIZE_HEIGHT));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        //TODO set some other properties like resizeable
    }

    // --- Create Bottom ---
    private JPanel createBottom() {
    	JPanel bottomPanel = new JPanel();
    	bottomPanel.setLayout(new BorderLayout());
    	bottomPanel.add(createVersionLabel(), BorderLayout.WEST);
    	bottomPanel.add(createTimeLabel(), BorderLayout.EAST);
    	bottomPanel.setBorder(new EmptyBorder(5, 15, 5, 15));
    	startTimeThread();
        return bottomPanel;
    }
    
    private Component createVersionLabel(){
    	JLabel versionLabel = new JLabel("0.0.0.0");
    	versionLabel.setFont(getFont(10f));
    	return versionLabel;
    }
    
    private Component createTimeLabel(){
    	_timeLabel = new JLabel("ERROR NO TIME");
    	_timeLabel.setFont(getFont(10f));
    	_timeLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	return _timeLabel;
    }
    
    private void startTimeThread(){
    	Thread TimeThread = new Thread(){
    		public void run() {
    			isRunningTimeThread = true;
    			while(isRunningTimeThread){
    			Date systemTime = new Date(System.currentTimeMillis());
    			setTimeLabel(systemTime);
    			try{
    				sleep(1000);
    			}catch(InterruptedException e){
    				e.printStackTrace(); // TODO Set Better Catch
    			}
    		}
    		};
    	};
    	
    	TimeThread.start();
    }
    
    private void setTimeLabel(Date time){
    	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    	_timeLabel.setText(formatter.format(time));
    }
    
    // --- Create Center ---
    
    private JPanel createCenter() {
        JPanel centerpanel = new JPanel();
        centerpanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Header
        constraints.gridx = 1; //TODO set X
        constraints.gridy = 0; //TODO set Y
        centerpanel.add(createHeader(), constraints);
        
        _buttons = createButtons();
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(10,0,0,0);
        
        for(JButton button : _buttons){
        	button.setFont(FontHandler.getStandardFont(10f));
        	centerpanel.add(button, constraints);
        	constraints.gridy += 2;
        }
        
        //TODO Create Buttons

        return centerpanel;
    }
    
    private JButton[] createButtons(){
    	JButton[] buttonArray = new JButton[5];
    	
    	buttonArray[0] = new JButton("Neues Spiel");
    	buttonArray[1] = new JButton("Spiel laden");
    	buttonArray[2] = new JButton("Einstellungen");
    	buttonArray[3] = new JButton("Credits");
    	buttonArray[4] = new JButton("Beenden");
    	
    	return buttonArray;
    }
    
    /**
     * This method create the Header for startWindow
     * @return then Header, Title.
     */
    private Component createHeader() {
        JLabel header = new JLabel("UnknowGame");
        header.setFont(getFont(40f));
        return header;
    }
    
    public JButton getButton(int button){
    	return _buttons[button];
    }
    
    // --- Utils ---
    /**
     * This method create the Font for the Header
     * @param size the size that you need
     * @return the Font for the header
     */
    
    private Font getFont(float size){
    	return FontHandler.getStandardFont(size);	
    }
}
