package click.smoothling.falcon.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Text {
    private final String input;

    public Text(String input) {
        this.input = input;
    }

    public Component format() {
        return MiniMessage.miniMessage().deserialize(input);
    }
}
