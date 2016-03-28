package com.killpekeinside.exceptions;

/**
 * Created by Raman_Susla1 on 10/2/2015.
 */
public class ConfigurationException extends VException
{
    public ConfigurationException(String message)
    {
        super(message);
    }

    public ConfigurationException(String message, Exception cause)
    {
        super(message, cause);
    }

    public ConfigurationException(Exception cause)
    {
        super(cause);
    }
}
