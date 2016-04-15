package Game.general.window.startWindow;

import Game.general.utilities.FontHandler;

import javax.swing.*;
import java.awt.*;

/**
 * TODO document
 */
public class startWindowUI {

    private final int SIZE_WIDTH = 400;
    private final int SIZE_HEIGHT = 800;

    private Button[] _buttons;


    public void initializeWindow(){
        JPanel mainpanel = createMainpanel();
        mainpanel.setLayout(new BorderLayout());

        mainpanel.add(createCenter(), BorderLayout.CENTER);
        //mainpanel.add(createBottom(), BorderLayout.SOUTH); // TODO create Bottom
        createFrame(mainpanel);
    }

    private void createFrame(JPanel mainpanel) {
        JFrame frame = new JFrame("UnknowGame"); //TODO Change Title
        frame.add(mainpanel);
        frame.setSize(new Dimension(SIZE_WIDTH, SIZE_HEIGHT));
        frame.setResizable(false);
        frame.setVisible(true);
        //TODO set some other properties like resizeable
    }

    private JPanel createBottom() {
        return null;
    }

    private JPanel createCenter() {
        JPanel centerpanel = new JPanel();
        centerpanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Header
        constraints.gridx = 1; //TODO set X
        constraints.gridy = 0; //TODO set Y
        centerpanel.add(createHeader(), constraints);
        
        //TODO Create Buttons

        return centerpanel;
    }
    /**
     * This method create the Header for startWindow
     * @return then Header, Title.
     */
    private Component createHeader() {
        JLabel header = new JLabel("UnknowGame");
        header.setFont(getHeaderFont());
        return header;
    }
    /**
     * This method create the Font for the Header
     * @return the Font for the header
     */
    private Font getHeaderFont(){
    	Font customFont = FontHandler.getStandardFont();
    	customFont = customFont.deriveFont(80f);
    	return customFont;
    }

    private JPanel createMainpanel() {
        JPanel mainpanel = new JPanel();

        return mainpanel;
    }
}
