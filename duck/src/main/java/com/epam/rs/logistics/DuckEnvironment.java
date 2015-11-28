package com.epam.rs.logistics;

import com.epam.rs.duck.Duck;
import com.epam.rs.duck.DuckFactory;
import com.epam.rs.duck.ISimpleDuck;
import com.epam.rs.util.Utils;

/**
 * Created by catmo_000 on 11/28/2015.
 */
public class DuckEnvironment {
    private final Zone[][] map;
    private final Duck duck;
    private final int width, height;
    private int xDuck = -1, yDuck = -1;

    public DuckEnvironment(Zone[][] map, DuckFactory duckFactory) {
        this.map = map;
        width = map[0].length;
        height = map[1].length;

        findStartDuckPosition();

        this.duck = duckFactory.createDuck(map[xDuck][yDuck]);

        drawMap();
    }

    /**
     * init start-point for a duck
     */
    private void findStartDuckPosition() {
        boolean foundStart = false;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (map[x][y] == Zone.START) {
                    foundStart = true;
                    xDuck = x;
                    yDuck = y;
                    break;
                }
            }
            if (foundStart) {
                break;
            }
        }
        if (!foundStart) {
            throw new RuntimeException("Area hasn't start point");
        }
    }

    /**
     * output map onto console
     */
    private void drawMap() {
        Utils.outputAreaMap(map, width, height, xDuck, yDuck);
    }

    /**
     * try move duck
     * @param direction new direction to move
     */
    public void move(Direction direction) {
        Reaction reaction = duck.tryAction(direction, getZoneForDirection(direction));
        if (Reaction.IMPOSSIBLE.equals(reaction)) return;
        if (Reaction.GO.equals(reaction)) {
            switch (direction) {
                case DOWN:
                    yDuck++;
                    break;
                case LEFT:
                    xDuck--;
                    break;
                case RIGHT:
                    xDuck++;
                    break;
                case UP:
                    yDuck--;
                    break;
            }
        }
        drawMap();
    }

    /**
     * new location by direction
     * @param direction  direction
     * @return location
     */
    public Zone getZoneForDirection(Direction direction) {
        switch (direction) {
            case DOWN:
                if (yDuck + 1 == height) break;
                return map[xDuck][yDuck + 1];
            case LEFT:
                if (xDuck == 0) break;
                return map[xDuck - 1][yDuck];
            case RIGHT:
                if (xDuck + 1 == width) break;
                return map[xDuck + 1][yDuck];
            case UP:
                if (yDuck == 0) break;
                return map[xDuck][yDuck - 1];
            default:
                throw new RuntimeException("Unavailable direction");
        }
        return Zone.WALL;
    }

    /**
     * check if X was riched
     * @return is duck on X
     */
    public boolean checkFinish() {
        return Zone.FINISH.equals(map[xDuck][yDuck]);
    }

    /**
     * get simple interface to work with a duck
     * @return duck
     */
    public ISimpleDuck getDuck() {
        return duck;
    }
}
