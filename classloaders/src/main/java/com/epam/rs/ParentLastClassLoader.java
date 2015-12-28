package com.epam.rs;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by catmo_000 on 12/28/2015.
 */
public class ParentLastClassLoader extends ClassLoader {

    private String[] jarFiles;
    private Hashtable classes = new Hashtable();
    private final Logger logger = Logger.getLogger(ParentLastClassLoader.class);
    public ParentLastClassLoader(ClassLoader parent, String[] paths)
    {
        super(parent);
        this.jarFiles = paths;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException
    {
        logger.info("Trying to find");
        throw new ClassNotFoundException();
    }

    @Override
    protected synchronized Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException
    {
        logger.info("Trying to load");
        try
        {
            logger.info("Loading class in Child : " + className);
            byte classByte[];
            Class result = null;

            result = (Class) classes.get(className);
            if (result != null) {
                return result;
            }

            for(String jarFile: jarFiles){
                try {
                    JarFile jar = new JarFile(jarFile);
                    JarEntry entry = jar.getJarEntry(className.replace(".","/") + ".class");
                    InputStream is = jar.getInputStream(entry);
                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    int nextValue = is.read();
                    while (-1 != nextValue) {
                        byteStream.write(nextValue);
                        nextValue = is.read();
                    }

                    classByte = byteStream.toByteArray();
                    result = defineClass(className, classByte, 0, classByte.length, null);
                    classes.put(className, result);
                } catch (Exception e) {
                    continue;
                }
            }

            result = (Class) classes.get(className);
            if (result != null) {
                return result;
            }
            else{
                throw new ClassNotFoundException("Not found "+ className);
            }
        }
        catch( ClassNotFoundException e ){

            logger.error("Delegating to parent : " + className);
            return super.loadClass(className, resolve);
        }
    }
}