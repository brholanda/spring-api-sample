package com.sample.exception;

public class EntityNotFoundException extends Exception {

    private static final String MESSAGE = "No %s found with the given parameters.";

    public EntityNotFoundException(final Class<? extends Object> clazz) {
        super(String.format(MESSAGE, clazz.getCanonicalName()));
    }

}
