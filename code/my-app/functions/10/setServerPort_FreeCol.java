public static boolean setServerPort(String arg) {
    if (arg == null)
        return false;
    try {
        serverPort = Integer.parseInt(arg);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}