package com.epam.university.java.core.task033;

public class LessExceptionImpl extends RuntimeException implements LessException {
    public LessExceptionImpl(String message, Throwable exception) {
        super(message, exception);
    }
}
