public static File createRandomSaveGame() {
    FreeColServer serv = startServer(false, true);
    try {
        serv.startGame();
    } catch (FreeColException e) {
        fail(e.getMessage());
    }
    assertEquals(FreeColServer.ServerState.IN_GAME, serv.getServerState());
    assertNotNull(serv.getGame());
    assertNotNull(serv.getGame().getMap());
    File file = new File(TEST_FILE);
    try {
        serv.saveGame(file, null, null);
    } catch (IOException e) {
        e.printStackTrace();
        fail(e.toString());
    }
    assertTrue(file.exists());
    stopServer();
    return file;
}