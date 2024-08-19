package click.smoothling.falcon.command;

import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;

public class FlyCommand extends Command {

    public FlyCommand() {
        super("fly");
        setDefaultExecutor((sender, context) -> {
            if (!(sender instanceof Player player)) {
                // TODO: no player message
                return;
            }
            if (!player.hasPermission("falcon.command.fly")) {
                // TODO: no permission message
                return;
            }
            if (player.isAllowFlying()) {
                player.setAllowFlying(false);
                player.setFlying(false);
                // TODO: no more fly message
                return;
            }
            player.setAllowFlying(true);
            player.setFlying(false);
            // TODO: fly message
        });
    }
}
