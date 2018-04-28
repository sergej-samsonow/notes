package de.samsonow.exceptionid;

import java.util.List;
import java.util.StringJoiner;

public class ComponentHelper {

    private static int MAX_COMPONENTEN_DEPTH = 8;
    
    private ComponentHelper() {
        super();
    }

    public static void setMaxComponentenDepth(int depth) {
        assert depth > 0 : "Illegal componenten depth value min value is 1";
        MAX_COMPONENTEN_DEPTH = depth;
    }

    public static <T extends Exception> String build(final Class<T> clazz, final List<Integer>path, String message) {
        return String.format("E%s - %s" , eventId(path), ucf(message));
    }

    private static String eventId(final List<Integer> path) {
        StringJoiner joiner = new StringJoiner("");
        for (Integer id : path) {
            Integer human = id + 1;
            joiner.add(human.toString());
        }
        int missing =  MAX_COMPONENTEN_DEPTH - path.size();
        for (int i = 0; i < missing; i++) {
            joiner.add("0");
        }
        String eventId = joiner.toString();
        return eventId;
    }

    private static String ucf(String message) {
        return message.substring(0, 1).toUpperCase() + message.substring(1);
    }
}
