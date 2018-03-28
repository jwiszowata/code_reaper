public static void setFreeColSeed(String arg) {
    try {
        FreeColSeed.freeColSeed = Long.parseLong(arg);
    } catch (NumberFormatException nfe) {
    }
}