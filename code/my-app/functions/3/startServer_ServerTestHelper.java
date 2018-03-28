public static FreeColServer startServer(File file, boolean publicServer, boolean singlePlayer) {
    return startServer(file, publicServer, singlePlayer, SERVER_PORT, SERVER_NAME);
}