package com.killpekeinside.exceptions;

/**
 * Created by Raman_Susla on 01.04.2015 0:33.
 */
public class ServiceException extends VException {
    public ServiceException(Exception cause) {
        super(cause);
    }
    public ServiceException(String message,Exception cause) {
        super(message,cause);
    }
}