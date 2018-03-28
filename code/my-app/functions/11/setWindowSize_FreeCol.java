private static void setWindowSize(String arg) {
    String[] xy;
    if (arg != null && (xy = arg.split("[^0-9]")) != null && xy.length == 2) {
        try {
            windowSize = new Dimension(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
        } catch (NumberFormatException nfe) {
        }
    }
    if (windowSize == null)
        windowSize = new Dimension(-1, -1);
}