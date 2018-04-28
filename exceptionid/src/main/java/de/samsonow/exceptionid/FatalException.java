package de.samsonow.exceptionid;

import java.util.List;

public class FatalException extends Exception {

    private static final long serialVersionUID = 1L;

    public FatalException(final List<Integer> componentesPath, String message) {
        super(ComponentHelper.build(FatalException.class, componentesPath, message));
    }

}
