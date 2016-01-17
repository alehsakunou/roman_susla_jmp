package com.epam.rs;

import javassist.CannotCompileException;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by catmo_000 on 1/17/2016.
 */
public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class);

    private static void stackOverFlow(long i) {
        try {
            stackOverFlow(++i);
        } catch (StackOverflowError e) {
            LOGGER.info("stackOverFlow on iteration:" + i);
            LOGGER.error(e.getMessage());
        }
    }


    private static void heepSpaceOutOfMemory() {
        class SomeObject {
            public long index;
            public SomeObject child;

        }
        long i = 0;
        try {
            SomeObject parent = new SomeObject();
            SomeObject prevChild = new SomeObject();
            parent.index = 0;
            prevChild.index = parent.index + 1;
            parent.child = prevChild;
            for (; ; i++) {
                SomeObject newChild = new SomeObject();
                prevChild.child = newChild;
                newChild.index = prevChild.index + 1;
                prevChild = newChild;
            }
        } catch (OutOfMemoryError e) {
            LOGGER.info("heepSpaceOutOfMemory on iteration:" + i);
            LOGGER.error(e.getMessage());
        }
    }


    public static void main(String[] args) throws CannotCompileException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(Main.class.getClassLoader().getResource("config.properties").getFile()));
        if (properties.getProperty("task").equals("1")) {
            stackOverFlow(0);
            heepSpaceOutOfMemory();
            permGenOutOfMemory();
            return;
        }
        if (properties.getProperty("task").equals("2")) {
            File dir = new File(properties.getProperty("path.img"));
            File[] files = dir.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(".jpg");
                }
            });
            int count = 0;
            try {
                List<BufferedImage> images = new ArrayList<BufferedImage>();
                for (File file : files) {
                    LOGGER.info(file);
                    images.add(ImageIO.read(file));
                    count++;
                }
            }
            catch (OutOfMemoryError e){
                LOGGER.info(count);
            }
            return;
        }

    }

    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    private static void permGenOutOfMemory() throws CannotCompileException {
        long i = 0;
        try {
            for (; ; ) {
                Class c = cp.makeClass("com.epam.mentoring.memorymanagement.Generated" + (i++)).toClass();
            }
        } catch (OutOfMemoryError e) {
            LOGGER.info("permSpaceOutOfMemory on iteration:" + i);
        } catch (CannotCompileException e) {
            LOGGER.info(e.getMessage());
        }
    }


}
