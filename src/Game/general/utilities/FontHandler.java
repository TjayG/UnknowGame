package Game.general.utilities;

import java.awt.*;
import java.io.File;

/**
 * TODO document
 */
public class FontHandler {

    private final static String BLACKSMITH = "UGame\\Files\\Fonts\\BlackSmith.ttf"; //TODO kann er nicht lesen

    public static Font registerFontBlackSmith() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font blacksmith_font;
        try {
            blacksmith_font = Font.createFont(Font.TRUETYPE_FONT, new File(BLACKSMITH));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(BLACKSMITH)));
        } catch (Exception e) {
            return null;
        }
        return blacksmith_font;
    }
}
