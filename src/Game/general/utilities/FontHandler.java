package Game.general.utilities;

import java.awt.*;
import java.io.File;

/**
 * TODO document
 */
public class FontHandler {

	static boolean standardFontIsAlreadyRegister = false;
	
    private final static String STANDARD_FONT = "Files/Fonts/BlackSmith.ttf"; //TODO Change Font-Style with Numbers
    /**
     * This Method give you the needed Font
     */
    private static Font getFont(String fontPath) {
        try {
        	if(!standardFontIsAlreadyRegister){
        	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
        	}else{standardFontIsAlreadyRegister = true;}
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * This method give you the standard font
     * @param size the size of your font
     * @return return the font with the right size
     */
    public static Font getStandardFont(float size){
    	return new Font(Font.SANS_SERIF, Font.BOLD, (int)size);
    	//return getFont(STANDARD_FONT).deriveFont(size);
    }
}
