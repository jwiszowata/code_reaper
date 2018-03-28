public void exitFullScreen() {
    GraphicsConfiguration GraphicsConf = getGraphicsConfiguration();
    GraphicsDevice gd = GraphicsConf.getDevice();
    gd.setFullScreenWindow(null);
}