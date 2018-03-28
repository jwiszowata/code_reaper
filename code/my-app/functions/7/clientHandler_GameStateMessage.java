public void clientHandler(FreeColClient freeColClient) throws FreeColException {
    final ServerState state = getState();
    if (state == null) {
        throw new FreeColException("Invalid state: " + getStringAttribute(STATE_TAG));
    }
    freeColClient.setServerState(state);
}