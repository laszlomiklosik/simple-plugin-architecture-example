package com.plugin2;

import com.plugins.api.Plugin;

public class Plugin2 implements Plugin {
    public void execute() {
        System.out.println(getClass().getName() + ": user.home: " + System.getProperty("user.home"));
        System.out.println("Plugin2 classloader:" + Thread.currentThread().getContextClassLoader());
        System.out.println("Plugin2 getClass classloader: " + getClass().getClassLoader());
        System.out.println("Plugin2 parent classloader:" + Thread.currentThread().getContextClassLoader().getParent());
        System.out.println("Plugin2 parent parent classloader:" + Thread.currentThread().getContextClassLoader().getParent().getParent());
    }
}
