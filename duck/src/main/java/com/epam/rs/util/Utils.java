package com.epam.rs.util;

import com.epam.rs.logistics.Zone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman_Susla1 on 11/28/2015.
 */
public final class Utils {
    /**
     * duck on map
     */
    private static final char DUCK = 'D';

    private Utils() {
    }

    /**
     * read from file
     * @param pathToFile path
     * @return matrix
     * @throws IOException if can't find file
     */
    public static Zone[][] readAreaMap(String pathToFile) throws IOException {
        final List<String> linesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            reader.lines().forEach(line -> linesList.add(line.replaceAll("\\s*", "")));
        }
        if (linesList.isEmpty()) throw new RuntimeException("file is empty");

        final int height = linesList.size();
        int width = 0;

        for (String aLinesList : linesList) {
            int length = aLinesList.length();
            if (width < length) width = length;
        }

        if (width == 0) throw new RuntimeException("file is empty");

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

    /**
     * output area with duck
     * @param areaMap area
     * @param width width
     * @param height height
     * @param xDuck duck x
     * @param yDuck duck y
     */
    public static void outputAreaMap(Zone[][] areaMap, int width, int height, int xDuck, int yDuck) {
        final StringBuilder builder = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                builder.append(xDuck == x && yDuck == y ? DUCK : areaMap[x][y].getId());
            }
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }

    /**
     * format for advices
     * @param key key
     * @param advice advice
     */
    public static void printAdvice(char key, String advice) {
        System.out.println(String.format("'%c' - %s", key, advice));
    }

    /**
     * new line in console
     */
    public static void newLine() {
        System.out.println();
    }
}
