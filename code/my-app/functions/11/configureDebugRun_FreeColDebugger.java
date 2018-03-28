public static void configureDebugRun(String option) {
    int comma = option.indexOf(',');
    String turns = option.substring(0, (comma < 0) ? option.length() : comma);
    try {
        setDebugRunTurns(Integer.parseInt(turns));
    } catch (NumberFormatException e) {
        setDebugRunTurns(-1);
    }
    if (comma > 0)
        setDebugRunSave(option.substring(comma + 1));
}