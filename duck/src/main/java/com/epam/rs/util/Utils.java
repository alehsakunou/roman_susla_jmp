package com.epam.rs.util;

import com.epam.rs.logistics.Zone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman_Susla1 on 11/28/2015.
 */
public final class Utils {
    private static final char DUCK = 'D';
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m\u001B[40m";
    public static final String RED = "\u001B[31m\u001B[41m";
    public static final String GREEN = "\u001B[32m\u001B[42m";
    public static final String YELLOW = "\u001B[33m\u001B[43m";
    public static final String BLUE = "\u001B[34m\u001B[44m";
    public static final String WHITE = "\u001B[37m\u001B[47m";


    private Utils() {
    }

    public static Zone[][] readAreaMap(String pathToFile) throws FileNotFoundException {
        final File file = new File(pathToFile);
        final FileReader fileReader = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fileReader);
        final List<String> linesList = new ArrayList<>();

        reader.lines().forEach(line -> linesList.add(line.replaceAll("\\s*", "")));
        if (linesList.isEmpty()) throw new RuntimeException("file is empty");

        final int height = linesList.size();
        int width = 0;

        for (String aLinesList : linesList) {
            int length = aLinesList.length();
            if (width < length) width = length;
        }

        Zone[][] map = new Zone[width][height];
        for (int y = 0; y < height; y++) {
            char[] line = linesList.get(y).toCharArray();
            final int length = line.length;
            int x = 0;
            for (; x < length; x++) map[x][y] = Zone.getZone(line[x]);
            for (; x < width; x++) map[x][y] = Zone.FLATLAND;
        }
        return map;
    }

    public static void outputAreaMap(Zone[][] areaMap, int xDuck, int yDuck) {
        final int width = areaMap[0].length, height = areaMap[1].length;
        final StringBuilder builder = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char value;
                if (xDuck == x && yDuck == y) {
                    builder.append(YELLOW);
                    value = DUCK;
                } else {
                    Zone zone = areaMap[x][y];
                    switch (zone) {
                        case WATER:
                            builder.append(BLUE);
                            break;
                        case WALL:
                            builder.append(BLACK);
                            break;
                        case FINISH:
                            builder.append(GREEN);
                            break;
                        case START:
                            builder.append(RED);
                            break;
                        default:
                            builder.append(WHITE);
                    }
                    value = zone.getId();
                }
                builder.append(value + RESET);
            }
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }
}
