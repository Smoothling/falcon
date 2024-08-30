package click.smoothling.falcon.permission;

public enum Permission {

    COMMAND_FLY("falcon.command.fly");

    public final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String permission() {
        return this.permission;
    }
}
