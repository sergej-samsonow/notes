package de.samsonow.exceptionid;

import java.util.ArrayList;
import java.util.List;

public enum Component {
    
    CLI;

    public List<Integer> componentPath() {
        ArrayList<Integer> path= new ArrayList<>();
        path.add(ordinal());
        return path;
    }
}
