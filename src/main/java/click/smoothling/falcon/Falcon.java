package click.smoothling.falcon;

import click.smoothling.falcon.command.FlyCommand;
import click.smoothling.falcon.listener.InventoryListener;
import click.smoothling.falcon.listener.PingListener;
import click.smoothling.falcon.listener.PlayerConfigurationListener;
import click.smoothling.falcon.listener.SpawnListener;
import de.eztxm.config.TomlConfig;
import de.eztxm.simplelogger.SimpleLogger;
import lombok.Getter;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.inventory.InventoryClickEvent;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.event.server.ServerListPingEvent;
import net.minestom.server.extras.MojangAuth;

public class Falcon {
    @Getter private static SimpleLogger logger;
    @Getter private static TomlConfig config;

    public static void main(String[] args) {
        logger = new SimpleLogger("falcon> ");
        logger.info("Initialized falcon-logger.");
        config = new TomlConfig("config", "falcon-config.toml");
        config.addDefault("Host", "0.0.0.0");
        config.addDefault("Port", 25565);
        logger.info("Initialized falcon-config.");
        MinecraftServer.setCompressionThreshold(0);
        logger.info("Set compression threshold.");
        MinecraftServer server = MinecraftServer.init();
        MinecraftServer.setBrandName("Falcon");
        logger.info("Initialized minecraft server.");
        MojangAuth.init();
        logger.info("Initialized mojang auth.");
        GlobalEventHandler eventHandler = MinecraftServer.getGlobalEventHandler();
        logger.info("Initialized global eventhandler.");
        eventHandler.addListener(ServerListPingEvent.class, new PingListener().onServerListPing());
        eventHandler.addListener(AsyncPlayerConfigurationEvent.class, new PlayerConfigurationListener().onPlayerConfiguration());
        eventHandler.addListener(PlayerSpawnEvent.class, new SpawnListener().onPlayerSpawn());
        eventHandler.addListener(InventoryClickEvent.class, new InventoryListener().onInventoryClick());
        logger.info("Initialized global event listener.");
        CommandManager commandManager = MinecraftServer.getCommandManager();
        commandManager.register(new FlyCommand());
        logger.info("Initialized command manager.");
        server.start(config.get("Host").asString(), config.get("Port").asInteger());
        logger.info("Started Falcon on " + config.get("Host").asString() + ":" + config.get("Port").asInteger() + ".");
    }
}
