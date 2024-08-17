package click.smoothling.falcon;

import click.smoothling.falcon.listener.PlayerConfigurationListener;
import de.eztxm.config.TomlConfig;
import de.eztxm.simplelogger.SimpleLogger;
import de.eztxm.simplelogger.color.LoggerColor;
import lombok.Getter;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.extras.MojangAuth;
import org.slf4j.LoggerFactory;

public class Falcon {
    @Getter private static SimpleLogger logger;
    @Getter private static TomlConfig config;

    public static void main(String[] args) {
        LoggerFactory.getLogger(Falcon.class);
        logger = new SimpleLogger();
        logger.custom(LoggerColor.ANSI_WHITE + "Initialized " + LoggerColor.ANSI_BLUE + "falcon-logger.");
        config = new TomlConfig("config", "falcon-config.toml");
        config.addDefault("Host", "0.0.0.0");
        config.addDefault("Port", 25565);
        logger.custom(LoggerColor.ANSI_WHITE + "Initialized " + LoggerColor.ANSI_BLUE + "falcon-config.");
        MinecraftServer.setCompressionThreshold(0);
        logger.custom(LoggerColor.ANSI_WHITE + "Set compression threshold.");
        MinecraftServer server = MinecraftServer.init();
        MinecraftServer.setBrandName("Falcon");
        logger.custom(LoggerColor.ANSI_WHITE + "Initialized " + LoggerColor.ANSI_BLUE + "minecraft server.");
        MojangAuth.init();
        logger.custom(LoggerColor.ANSI_WHITE + "Initialized " + LoggerColor.ANSI_BLUE + "mojang auth.");
        GlobalEventHandler eventHandler = MinecraftServer.getGlobalEventHandler();
        logger.custom(LoggerColor.ANSI_WHITE + "Initialized " + LoggerColor.ANSI_BLUE + "global eventhandler.");
        eventHandler.addListener(AsyncPlayerConfigurationEvent.class, new PlayerConfigurationListener().onPlayerConfiguration());
        logger.custom(LoggerColor.ANSI_WHITE + "Initialized " + LoggerColor.ANSI_BLUE + "global event listener.");
        CommandManager commandManager = MinecraftServer.getCommandManager();
        logger.custom(LoggerColor.ANSI_WHITE + "Initialized " + LoggerColor.ANSI_BLUE + "command manager.");
        server.start(config.get("Host").asString(), config.get("Port").asInteger());
        logger.custom(LoggerColor.ANSI_GREEN + "Started " + LoggerColor.ANSI_BLUE + "Falcon " + LoggerColor.ANSI_GREEN + "on " + config.get("Host").asString() + ":" + config.get("Port").asInteger() + ".");
    }
}
