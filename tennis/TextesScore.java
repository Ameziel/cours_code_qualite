package tennis;

import java.util.Locale;
import java.util.ResourceBundle;

public class TextesScore {
    private ResourceBundle messages;

    public TextesScore(Locale locale) {
        messages = ResourceBundle.getBundle("tennis.localization.MessagesBundle", locale);
    }

    public String getString(String key) {
        return messages.getString(key);
    }
}
