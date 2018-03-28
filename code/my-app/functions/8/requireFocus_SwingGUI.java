public boolean requireFocus(Tile tile) {
    boolean required = getClientOptions().getBoolean(ClientOptions.ALWAYS_CENTER);
    if ((required && tile != getFocus()) || !mapViewer.onScreen(tile)) {
        setFocusImmediately(tile);
        return true;
    }
    return false;
}