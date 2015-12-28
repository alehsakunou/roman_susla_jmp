package com.epam.rs;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * Created by catmo_000 on 12/29/2015.
 */
public class CLRunner {
    public static final Logger LOGGER = Logger.getLogger(CLRunner.class);

    public static void main(String[] args) throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        URL path = Thread.currentThread().getContextClassLoader().getResource("fake.jar");
        LOGGER.info("JarFile is:" + path);
        ClassLoader classloader = new ParentLastClassLoader(CLRunner.class.getClassLoader(),
                new String[]{path.getPath()});
        //first task
        try {

            Class classToLoad = Class.forName("com.epam.rs.CustomFunctionality", true, classloader
            );
            Method method = classToLoad.getDeclaredMethod("doSomething");
            Object instance = classToLoad.newInstance();
            Object result = method.invoke(instance);
        } catch (NoSuchMethodException e) {
            LOGGER.error(e);
        } catch (InvocationTargetException e) {
            LOGGER.error(e);
        }

        //second task
        SomeInterface explicitFunc = new ExplicitFunctionality();
        Class classToLoad = Class.forName("com.epam.rs.OverriddenFunctionality", true, classloader);
        SomeInterface instance = (SomeInterface)classToLoad.newInstance();
        instance.doSomethingOverride();
        explicitFunc.doSomethingOverride();
    }
}
