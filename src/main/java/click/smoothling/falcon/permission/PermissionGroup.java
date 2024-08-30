package click.smoothling.falcon.permission;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PermissionGroup {
    private final String name;
    private final String prefix;
    private final String suffix;
    private final int sortId;
    private final ArrayList<Permission> permissions;

    public PermissionGroup(String name) {
        this.name = name;
        this.prefix = null;
        this.suffix = null;
        this.sortId = 0;
        this.permissions = new ArrayList<>();
    }

    public PermissionGroup(String name, String prefix, String suffix, int sortId, ArrayList<Permission> permissions) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.sortId = sortId;
        this.permissions = permissions;
    }
}
