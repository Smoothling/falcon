package click.smoothling.falcon.listener;

import net.minestom.server.event.server.ServerListPingEvent;

import java.util.function.Consumer;

public class PingListener {

    public Consumer<ServerListPingEvent> onServerListPing() {
        return event -> {

        };
    }
}
