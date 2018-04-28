package de.samsonow.exceptionid;

import static de.samsonow.exceptionid.component.cli.ParameterProcessing.DB_HOST;
import static de.samsonow.exceptionid.component.cli.ParameterProcessing.DB_NAME;
import static de.samsonow.exceptionid.component.cli.ParameterProcessing.DB_PASS;
import static de.samsonow.exceptionid.component.cli.ParameterProcessing.DB_PORT;
import static de.samsonow.exceptionid.component.cli.ParameterProcessing.DB_USER;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        String dbHost = "";
        String dbPort = "";
        String dbName = "";
        String dbUser = "";
        String dbPass = "";
        for (String arg : args) {
            if      (DB_HOST.found(arg)) dbHost = DB_HOST.extract(arg);
            else if (DB_PORT.found(arg)) dbPort = DB_PORT.extract(arg);
            else if (DB_NAME.found(arg)) dbName = DB_NAME.extract(arg);
            else if (DB_USER.found(arg)) dbUser = DB_USER.extract(arg);
            else if (DB_PASS.found(arg)) dbPass = DB_PASS.extract(arg);
        }
        List<String> invalid = new ArrayList<>();
        try {DB_HOST.check(dbHost);} catch (FatalException e) {invalid.add(e.getMessage());};
        try {DB_PORT.check(dbPort);} catch (FatalException e) {invalid.add(e.getMessage());};
        try {DB_NAME.check(dbName);} catch (FatalException e) {invalid.add(e.getMessage());};
        try {DB_USER.check(dbUser);} catch (FatalException e) {invalid.add(e.getMessage());};
        try {DB_PASS.check(dbPass);} catch (FatalException e) {invalid.add(e.getMessage());};
        for (String message : invalid) {
            System.out.println(message);
        }
    }

}
