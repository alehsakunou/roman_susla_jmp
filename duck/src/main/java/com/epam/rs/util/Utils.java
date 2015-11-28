package com.epam.rs.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman_Susla1 on 11/28/2015.
 */
public final class Utils
{
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    private Utils() { }

    public static char[][] readAreaMap(String pathToFile) throws FileNotFoundException
    {
        final File file = new File(pathToFile);
        final FileReader fileReader = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fileReader);
        final List<String> linesList = new ArrayList<>();

        reader.lines().forEach(line -> linesList.add(line.replaceAll("\\s*", "")));
        if (linesList.isEmpty()) throw new RuntimeException("file is empty");

        final int height = linesList.size();
        int width = 0;

        for (int i = 0; i < height; i++)
        {
            int length = linesList.get(i).length();
            if (width < length) width = length;
        }

        char[][] buffer = new char[width][height];
        for (int y = 0; y < height; y++)
        {
            char[] line = linesList.get(y).toCharArray();
            final int length = line.length;
            int x = 0;
            for (; x < length; x++) buffer[x][y] = line[x];
            for (; x < width; x++)  buffer[x][y] = '0';
        }
        return buffer;
    }

    public static  void outputAreaMap(char[][] areaMap, int xDuck, int yDuck)
    {
        final int width = areaMap[0].length, height = areaMap[1].length;
        final StringBuilder builder = new StringBuilder();
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                char value = areaMap[x][y];
                switch (value)
                {
                    case 'w':
                        builder.append(BLUE);
                        break;
                    case '1':
                        builder.append(BLACK);
                        break;
                    case 'X':
                        builder.append(GREEN);
                        break;
                    case 'I':
                        builder.append(RED);
                        break;
                    default:
                        builder.append(WHITE);
                }
                builder.append(areaMap[x][y] + RESET);
            }
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }
}
