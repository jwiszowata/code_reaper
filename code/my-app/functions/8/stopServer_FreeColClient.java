public void stopServer() {
    final FreeColServer freeColServer = getFreeColServer();
    if (freeColServer != null) {
        freeColServer.getController().shutdown();
        setFreeColServer(null);
        ResourceManager.setScenarioMapping(null);
    }
}