private void createFrame(JMenuBar menuBar, Rectangle windowBounds) {
    frame = new FreeColFrame(freeColClient, graphicsDevice, menuBar, this, windowed, windowBounds);
    updateSizes();
    frame.setVisible(true);
}