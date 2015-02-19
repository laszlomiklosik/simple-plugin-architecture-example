package com.plugins.api;

import java.security.AllPermission;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;

public class PluginPolicy extends Policy {

    public PermissionCollection getPermissions(CodeSource codeSource) {
        Permissions permissions = new Permissions();
        if (!codeSource.getLocation().toString().endsWith("2.jar")) {
            permissions.add(new AllPermission());
        }
        return permissions;
    }

    public void refresh() {
    }

}
