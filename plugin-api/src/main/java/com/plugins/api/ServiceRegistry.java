package com.plugins.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by laci on 2/21/2015.
 */
public class ServiceRegistry {

    private static final Map<String, Object> SERVICES_BY_KEY = new HashMap<String, Object>();

    public static void register(String key, Object service) {
        SERVICES_BY_KEY.put(key, service);
    }

    public static Object get(String key) {
        return SERVICES_BY_KEY.get(key);
    }
}
