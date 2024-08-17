package click.smoothling.falcon.listener;

import net.minestom.server.entity.Player;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;

import java.util.function.Consumer;

public class PlayerConfigurationListener {

    public Consumer<AsyncPlayerConfigurationEvent> onPlayerConfiguration() {
        return event -> {
            final Player player = event.getPlayer();

        };
    }
}
