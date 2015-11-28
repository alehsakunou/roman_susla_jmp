package com.epam.rs;

import com.epam.rs.duck.DuckFactory;
import com.epam.rs.logistics.Direction;
import com.epam.rs.logistics.DuckEnvironment;
import com.epam.rs.logistics.Zone;
import com.epam.rs.util.Utils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Raman_Susla1 on 11/28/2015.
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);
    public static final char UP_KEY = 'w';
    public static final char LEFT_KEY = 'a';
    public static final char DOWN_KEY = 's';
    public static final char RIGHT_KEY = 'd';
    public static final char CHARGE_KEY = 'c';
    public static final char QUACK_KEY = 'q';
    public static final char QUIT_KEY = '/';

    public static final char USE_DEFAULT_FILE_KEY = '1';
    public static final char USE_CUSTOM_FILE_KEY = '2';

    public static final char LIVE_DUCK_KEY = '1';
    public static final char TOY_DUCK_KEY = '2';

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Zone[][] map = loadMap(scanner);
            if (map == null) return;
            DuckFactory duckFactory = chooseDuck(scanner);
            if (duckFactory == null) return;
            DuckEnvironment duckEnvironment = new DuckEnvironment(map, duckFactory);
            long steps = 0;
            while (!duckEnvironment.checkFinish()) {
                useDuck(scanner, duckEnvironment);
                steps++;
            }
            LOGGER.info("Duck finished!");
            LOGGER.info("Steps:" + steps);
        } catch (Throwable e) {
            LOGGER.error(e);

        }

    }

    private static void useDuck(Scanner scanner, DuckEnvironment duckEnvironment) {
        char action = scanner.next().charAt(0);
        switch (action) {
            case UP_KEY:
                duckEnvironment.move(Direction.UP);
                break;
            case LEFT_KEY:
                duckEnvironment.move(Direction.LEFT);
                break;
            case DOWN_KEY:
                duckEnvironment.move(Direction.DOWN);
                break;
            case RIGHT_KEY:
                duckEnvironment.move(Direction.RIGHT);
                break;
            case CHARGE_KEY:
                duckEnvironment.getDuck().tryCharge();
                break;
            case QUACK_KEY:
                duckEnvironment.getDuck().quack();
                break;
            case QUIT_KEY:
                return;
            default:
                Utils.newLine();
                Utils.printAdvice(UP_KEY, "Move up");
                Utils.printAdvice(LEFT_KEY, "Move left");
                Utils.printAdvice(DOWN_KEY, "Move down");
                Utils.printAdvice(RIGHT_KEY, "Move right");
                Utils.printAdvice(CHARGE_KEY, "Charge the duck");
                Utils.printAdvice(QUACK_KEY, "QUACK");
                Utils.printAdvice(QUIT_KEY, "Quit");
        }
    }

    private static Zone[][] loadMap(Scanner scanner) {
        char action;
        do {
            Utils.newLine();
            Utils.printAdvice(USE_DEFAULT_FILE_KEY, "load map from default.map");
            Utils.printAdvice(USE_CUSTOM_FILE_KEY, "load from your own file");
            Utils.printAdvice(QUIT_KEY, "quit");
            action = scanner.next().charAt(0);
            try {
                switch (action) {
                    case USE_DEFAULT_FILE_KEY:
                        return Utils.readAreaMap(Main.class.getClassLoader().getResource("default.map").getFile());
                    case USE_CUSTOM_FILE_KEY:
                        System.out.print("Input path to file:");
                        return Utils.readAreaMap(scanner.next());
                    case QUIT_KEY:
                        return null;
                }
            } catch (IOException e) {
                LOGGER.error(e);
            } catch (RuntimeException e) {
                LOGGER.error(e);
            }
        } while (true);
    }

    private static DuckFactory chooseDuck(Scanner scanner) {
        char action;
        do {
            Utils.newLine();
            Utils.printAdvice(USE_DEFAULT_FILE_KEY, "choose live duck");
            Utils.printAdvice(USE_CUSTOM_FILE_KEY, "choose toy duck");
            Utils.printAdvice(QUIT_KEY, "quit");
            action = scanner.next().charAt(0);
            switch (action) {
                case LIVE_DUCK_KEY:
                    return DuckFactory.LIVE;
                case TOY_DUCK_KEY:
                    return DuckFactory.TOY;
                case '/':
                    return null;
            }
        } while (true);
    }
}
