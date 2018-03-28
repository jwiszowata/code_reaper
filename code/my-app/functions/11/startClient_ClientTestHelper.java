public static FreeColClient startClient(FreeColServer freeColServer) {
    System.setProperty("java.awt.headless", "true");
    FreeColClient client = new FreeColClient(null, null);
    client.startClient(null, null, false, false, null, null);
    ConnectController connectController = client.getConnectController();
    client.setFreeColServer(freeColServer);
    client.setSinglePlayer(true);
    assertTrue(connectController.requestLogin("test", freeColServer.getHost(), freeColServer.getPort()));
    client.getPreGameController().setReady(true);
    return client;
}