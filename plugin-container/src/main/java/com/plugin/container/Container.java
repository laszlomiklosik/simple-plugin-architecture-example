package com.plugin.container;

import com.plugins.api.Plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Container {

    public static void main(String[] arguments) throws Throwable {
        new Container().start();
    }

    private void start() throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {

        System.out.println(getClass().getName() + ": user.home: " + System.getProperty("user.home"));
        System.out.println("container system classloader: " + ClassLoader.getSystemClassLoader());
        System.out.println("container TCCL: " + Thread.currentThread().getContextClassLoader());
        System.out.println("container current classloader: " + Container.class.getClassLoader());
        System.out.println("container getClass classloader: " + getClass().getClassLoader());
        System.out.println("container parent classloader: " + Thread.currentThread().getContextClassLoader().getParent());

        File firstJarPlugin = new File("../example-plugin1/build/libs/example-plugin1.jar");
        ClassLoader firstPluginLoader = URLClassLoader.newInstance(new URL[]{firstJarPlugin.toURI().toURL()});
        Plugin firstPlugin = (Plugin) firstPluginLoader.loadClass("com.plugin1.Plugin1").newInstance();
        firstPlugin.execute();

        File secondJarPlugin = new File("../example-plugin2/build/libs/example-plugin2.jar");
        ClassLoader secondPluginLoader = URLClassLoader.newInstance(new URL[]{secondJarPlugin.toURI().toURL()});
        Plugin secondPlugin = (Plugin) secondPluginLoader.loadClass("com.plugin2.Plugin2").newInstance();
        secondPlugin.execute();
    }
}
