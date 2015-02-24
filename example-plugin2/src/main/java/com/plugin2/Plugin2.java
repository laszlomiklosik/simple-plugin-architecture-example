package com.plugin2;

import com.plugin1.api.SampleService;
import com.plugins.api.Plugin;
import com.plugins.api.ServiceRegistry;

public class Plugin2 implements Plugin {
    public void execute() {
        System.out.println(getClass().getName() + ": user.home: " + System.getProperty("user.home"));
        System.out.println("plugin2 system classloader: " + ClassLoader.getSystemClassLoader());
        System.out.println("plugin2 TCCL: " + Thread.currentThread().getContextClassLoader());
        System.out.println("plugin2 current classloader: " + Plugin2.class.getClassLoader());
        System.out.println("plugin2 getClass classloader: " + getClass().getClassLoader());
        System.out.println("plugin2 parent classloader: " + Thread.currentThread().getContextClassLoader().getParent());
        SampleService serviceFromPlugin1 = (SampleService) ServiceRegistry.get("sampleservice");
        serviceFromPlugin1.doSomething();
    }
}
