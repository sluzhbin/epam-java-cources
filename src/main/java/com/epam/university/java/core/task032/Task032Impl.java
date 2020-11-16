package com.epam.university.java.core.task032;

import java.lang.reflect.Proxy;

public class Task032Impl implements Task032 {

    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl();
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        Class<?>[] clazz = {SomeActionExecutor.class};
        ClassLoader classLoader = Task032Impl.class.getClassLoader();
        return (SomeActionExecutor) Proxy.newProxyInstance(classLoader, clazz, proxy);
    }
}
