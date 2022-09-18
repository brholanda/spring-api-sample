package com.sample.exception;

import javax.persistence.PersistenceException;
import java.util.NoSuchElementException;

public class EntityNotFoundException extends NoSuchElementException {

    private static final String MESSAGE = "No %s found with the given parameters.";

    public EntityNotFoundException(final Class<? extends Object> clazz) {
        super(String.format(MESSAGE, clazz.getSimpleName()));
    }

}
