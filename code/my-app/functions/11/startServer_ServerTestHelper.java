public static FreeColServer startServer(File file, boolean publicServer, boolean singlePlayer, int port, String name) {
    stopServer();
    try {
        server = new FreeColServer(new FreeColSavegameFile(file), null, port, name);
    } catch (Exception e) {
        fail(e.getMessage());
    }
    assertNotNull(server);
    assertEquals(FreeColServer.ServerState.LOAD_GAME, server.getServerState());
    return server;
}