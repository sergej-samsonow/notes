public static class StackTraceSearcher {
    public static StackTraceElement firstAfterLastOccurencyOf(String searchFor, Exception exception) {
        StackTraceElement[] trace = exception.getStackTrace();
        int lastFound = -1;
        for (int index = 0; index < trace.length; index++) {
            StackTraceElement element = trace[index];
            if (element.getClassName().startsWith(searchFor)) {
                lastFound = index;
            }
        }
        return trace[lastFound + 1];
    }
}
