package com.plugin1;

import com.plugins.api.Plugin;
import com.plugins.api.ServiceRegistry;

public class Plugin1 implements Plugin {

    static {
        ServiceRegistry.register("sampleservice", new SampleServiceImpl());
    }
    public void execute() {
        System.out.println(getClass().getName() + ": user.home: " + System.getProperty("user.home"));
        System.out.println("plugin1 system classloader: " + ClassLoader.getSystemClassLoader());
        System.out.println("plugin1 TCCL: " + Thread.currentThread().getContextClassLoader());
        System.out.println("plugin1 current classloader: " + Plugin1.class.getClassLoader());
        System.out.println("plugin1 getClass classloader: " + getClass().getClassLoader());
        System.out.println("plugin1 parent classloader: " + Thread.currentThread().getContextClassLoader().getParent());
    }
}
