package com.epam.rs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public class AppUtils {
    private static final Properties PROPERTIES = new Properties();
    private static final ClassLoader CLASS_LOADER;
    static {
        try {
            CLASS_LOADER = AppUtils.class.getClassLoader();
            PROPERTIES.load(new FileInputStream(CLASS_LOADER.getResource("config.properties").getFile()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }

    public static String getProperty(String name)
    {
        return PROPERTIES.getProperty(name);
    }

    public static String getResource(String name)
    {
        return CLASS_LOADER.getResource(name).getFile();
    }
}
