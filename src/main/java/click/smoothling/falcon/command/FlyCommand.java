package click.smoothling.falcon.command;

import click.smoothling.falcon.message.Message;
import click.smoothling.falcon.permission.Permission;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;

public class FlyCommand extends Command {

    public FlyCommand() {
        super("fly");
        setDefaultExecutor((sender, context) -> {
            if (!(sender instanceof Player player)) {
                sender.sendMessage(Message.NOT_A_PLAYER.component());
                return;
            }
            if (!player.hasPermission(Permission.COMMAND_FLY.permission())) {
                sender.sendMessage(Message.NO_PERMISSION.component());
                return;
            }
            if (player.isAllowFlying()) {
                player.setAllowFlying(false);
                player.setFlying(false);
                sender.sendMessage(Message.COMMAND_FLY_DISABLED.component());
                return;
            }
            player.setAllowFlying(true);
            player.setFlying(false);
            sender.sendMessage(Message.COMMAND_FLY_ENABLED.component());
        });
    }
}
