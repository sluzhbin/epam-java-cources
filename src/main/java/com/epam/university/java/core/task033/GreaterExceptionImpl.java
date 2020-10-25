package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends RuntimeException implements GreaterException {
    public GreaterExceptionImpl(String message, Throwable exception) {
        super(message, exception);
    }
}
