package click.smoothling.falcon.message;

import net.kyori.adventure.text.Component;

public enum Message {

    PREFIX(new Text("<gradient:#FBA408:#E37209>Falcon</gradient> <dark_gray>| <gray>").format()),
    NOT_A_PLAYER(PREFIX.component.append(new Text("You are not a player.").format())),
    NO_PERMISSION(PREFIX.component.append(new Text("You do not have the needed permission to perform this.").format())),
    INVALID_ARGUMENT_LENGTH(PREFIX.component.append(new Text("The current argument length is invalid.").format())),
    COMMAND_FLY_ENABLED(PREFIX.component.append(new Text("You can fly now.").format())),
    COMMAND_FLY_DISABLED(PREFIX.component.append(new Text("You can no longer fly now.").format()));

    private final Component component;

    Message(Component component) {
        this.component = component;
    }

    public Component component() {
        return this.component;
    }
}
