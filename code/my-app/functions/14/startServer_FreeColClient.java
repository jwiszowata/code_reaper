public FreeColServer startServer(boolean publicServer, boolean singlePlayer, Specification spec, int port) {
    final FreeColServer fcs;
    try {
        fcs = new FreeColServer(publicServer, singlePlayer, spec, port, null);
    } catch (IOException ioe) {
        return failToMain(ioe, "server.initialize");
    }
    if (publicServer && fcs != null && !fcs.getPublicServer()) {
        return failToMain(null, "server.noRouteToServer");
    }
    setFreeColServer(fcs);
    setSinglePlayer(singlePlayer);
    return fcs;
}