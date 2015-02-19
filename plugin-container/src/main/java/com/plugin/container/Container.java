package com.plugin.container;

import com.plugins.api.Plugin;
import com.plugins.api.PluginPolicy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Policy;

public class Container {

    public static void main(String[] arguments) throws Throwable {
        new Container().start();
    }

    private void start() throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {

        Policy.setPolicy(new PluginPolicy());
        System.setSecurityManager(new SecurityManager());

        System.out.println("main classloader: " + Thread.currentThread().getContextClassLoader());
        System.out.println("main getClass classloader: " + getClass().getClassLoader());
        System.out.println("main parent classloader: " + Thread.currentThread().getContextClassLoader().getParent());
        System.out.println("main parent parent classloader: " + Thread.currentThread().getContextClassLoader().getParent().getParent());

        File firstJarPlugin = new File("example-plugin1/build/libs/example-plugin1.jar");
        ClassLoader firstPluginLoader = URLClassLoader.newInstance(new URL[]{firstJarPlugin.toURI().toURL()});
        Plugin firstPlugin = (Plugin) firstPluginLoader.loadClass("com.plugin1.Plugin1").newInstance();
        firstPlugin.execute();

        File secondJarPlugin = new File("example-plugin2/build/libs/example-plugin2.jar");
        ClassLoader secondPluginLoader = URLClassLoader.newInstance(new URL[]{secondJarPlugin.toURI().toURL()});
        Plugin secondPlugin = (Plugin) secondPluginLoader.loadClass("com.plugin2.Plugin2").newInstance();
        secondPlugin.execute();
    }
}
