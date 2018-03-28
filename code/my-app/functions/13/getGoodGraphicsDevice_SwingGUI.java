private static GraphicsDevice getGoodGraphicsDevice() {
    try {
        return MouseInfo.getPointerInfo().getDevice();
    } catch (HeadlessException he) {
    }
    try {
        final GraphicsEnvironment lge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        return lge.getDefaultScreenDevice();
    } catch (HeadlessException he) {
    }
    FreeColClient.fatal("Could not find a GraphicsDevice!");
    return null;
}