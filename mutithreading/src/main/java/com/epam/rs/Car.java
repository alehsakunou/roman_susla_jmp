package com.epam.rs;

import org.apache.log4j.Logger;

import java.util.Random;


/**
 * Created by Raman_Susla1 on 1/29/2016.
 */
public class Car implements Runnable
{
    static final Logger LOGGER = Logger.getLogger(Car.class);

    private static final long MAX_DISTANCE = 10000;
    Logger log = Logger.getLogger(getClass());
    private long friction;
    private long distance;
    private String name;
    static boolean hasWinner=false;
    static String winner;

    public Car(String name, long friction)
    {
        this.name = name;
        this.friction = friction;
    }


    public void run()
    {
        boolean isDisqualified = false;
        try
        {
            while (distance < MAX_DISTANCE)
            {
                Thread.sleep(friction);
                distance += 100;
                log.info(name + " " + distance);
                if (Thread.currentThread().isInterrupted())
                {
                    isDisqualified = true;
                    return;
                }
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            isDisqualified = true;
        }
        finally
        {
            if (isDisqualified)
            {
                log.info("Disqualified car is " + name);
            }
            else
            {
                synchronized (Car.class)
                {
                    if(!hasWinner){
                        hasWinner=true;
                        winner = name;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        final int CARS_COUNT = 7;
        Thread[] carRoutes = new Thread[CARS_COUNT];
        Random random = new Random();
        for (int i = 0; i < CARS_COUNT; i++)
        {
            carRoutes[i] = new Thread(new Car("Car_" + i, random.nextInt(900) + 100));
        }
        for (int i = 0; i < CARS_COUNT; i++)
        {
            carRoutes[i].start();
        }
        Thread.sleep(5000);
        final int disqualifiedIndex = random.nextInt(CARS_COUNT);
        carRoutes[disqualifiedIndex].interrupt();
        for (Thread route : carRoutes) {
            route.join();
        }
        LOGGER.info("Winner is "+winner);
    }
}