package com.plugin1;

import com.plugin1.api.SampleService;

/**
 * Created by laci on 2/23/2015.
 */
public class SampleServiceImpl implements SampleService {
    @Override
    public void doSomething() {
        System.out.println("Hello from plugin 1");
    }
}
