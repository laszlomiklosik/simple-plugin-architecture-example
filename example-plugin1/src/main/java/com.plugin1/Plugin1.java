package com.plugin1;

import com.plugins.api.Plugin;

public class Plugin1 implements Plugin {
    public void execute() {
        System.out.println(getClass().getName() + ": user.home: " + System.getProperty("user.home"));
        System.out.println("Plugin1 classloader:" + Thread.currentThread().getContextClassLoader());
        System.out.println("Plugin1 getClass classloader: " + getClass().getClassLoader());
        System.out.println("Plugin1 parent classloader:" + Thread.currentThread().getContextClassLoader().getParent());
        System.out.println("Plugin1 parent parent classloader:" + Thread.currentThread().getContextClassLoader().getParent().getParent());
    }
}
