package de.samsonow.exceptionid.component;

import java.util.List;

import de.samsonow.exceptionid.Component;

public enum Cli {

    PARAMETER_PROCESSING;

    private final Component component = Component.CLI;

    public List<Integer> componentPath() {
        List<Integer> path = component.componentPath();
        path.add(ordinal());
        return path;
    }
}
