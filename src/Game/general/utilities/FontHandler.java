package Game.general.utilities;

import java.awt.*;
import java.io.File;

/**
 * TODO document
 */
public class FontHandler {

    private final static String STANDARD_FONT = "Files/Fonts/BlackSmith.ttf"; //TODO kann er nicht lesen
    /**
     * This Method give you the StandardFont
     * With .derive(float f) you can manipulate the Size
     * @return the StandardFont
     */
    public static Font getStandardFont() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(STANDARD_FONT)));
            return Font.createFont(Font.TRUETYPE_FONT, new File(STANDARD_FONT));
        } catch (Exception e) {
            return null;
        }
    }
}
