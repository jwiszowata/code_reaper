private static boolean setMetaServer(String arg) {
    String[] s = arg.split(":");
    int port = -1;
    try {
        port = (s.length == 2) ? Integer.parseInt(s[1]) : -1;
    } catch (NumberFormatException nfe) {
    }
    if (s.length != 2 || s[0] == null || "".equals(s[0]))
        return false;
    metaServerAddress = s[0];
    metaServerPort = port;
    return true;
}