public FreeColServer startServer(boolean publicServer, boolean singlePlayer, File saveFile, int port, String name) {
    final FreeColSavegameFile fsg;
    try {
        fsg = new FreeColSavegameFile(saveFile);
    } catch (FileNotFoundException fnfe) {
        return failToMain(fnfe, FreeCol.badFile("error.couldNotFind", saveFile));
    } catch (IOException ioe) {
        return failToMain(ioe, "server.initialize");
    }
    final FreeColServer fcs;
    try {
        fcs = new FreeColServer(fsg, (Specification) null, port, name);
    } catch (XMLStreamException xse) {
        return failToMain(xse, FreeCol.badFile("error.couldNotLoad", saveFile));
    } catch (Exception ex) {
        return failToMain(ex, "server.initialize");
    }
    setFreeColServer(fcs);
    setSinglePlayer(singlePlayer);
    this.inGameController.setGameConnected();
    ResourceManager.setScenarioMapping(fsg.getResourceMapping());
    return fcs;
}