package de.samsonow.exceptionid.component.cli;

import java.util.List;

import de.samsonow.exceptionid.FatalException;
import de.samsonow.exceptionid.component.Cli;

public enum ParameterProcessing {

    DB_HOST("--dbHost"),
    DB_PORT("--dbPort"),
    DB_NAME("--dbName"),
    DB_USER("--dbUser"),
    DB_PASS("--dbPass");

    private final Cli parent = Cli.PARAMETER_PROCESSING;
    
    public boolean found(String argv) {
        return argv.startsWith(parameter);
    }

    public String extract(String argv) {
        return argv.replace(parameter + "=", "");
    }
    
    public void check(String value) throws FatalException {
        if (value.isEmpty()) exception();
    }
    
    
    private String parameter;
    private ParameterProcessing(String parameter) {
        this.parameter = parameter;
    }
    
    public List<Integer> componentPath() {
        List<Integer> path = parent.componentPath();
        path.add(ordinal());
        return path;
    }
    
    public void exception() throws FatalException {
        throw new FatalException(componentPath(), String.format("parameter %s is missing", parameter));
    }
}
