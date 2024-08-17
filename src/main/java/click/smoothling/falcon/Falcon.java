package click.smoothling.falcon;

import click.smoothling.falcon.listener.PlayerConfigurationListener;
import de.eztxm.config.TomlConfig;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.extras.MojangAuth;

public class Falcon {

    public static void main(String[] args) {
        TomlConfig config = new TomlConfig("config", "falcon-config.toml");
        config.addDefault("Host", "0.0.0.0");
        config.addDefault("Port", 25565);
        MinecraftServer.setCompressionThreshold(0);
        MinecraftServer server = MinecraftServer.init();
        MojangAuth.init();
        MinecraftServer.setBrandName("Falcon");
        GlobalEventHandler eventHandler = MinecraftServer.getGlobalEventHandler();
        CommandManager commandManager = MinecraftServer.getCommandManager();
        eventHandler.addListener(AsyncPlayerConfigurationEvent.class, new PlayerConfigurationListener().onPlayerConfiguration());
        server.start(config.get("Host").asString(), config.get("Port").asInteger());
    }
}
