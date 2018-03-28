public void paintBackground(java.awt.Graphics g) {
    JComponent c = getComponent();
    if (c.isOpaque()) {
        ImageLibrary.drawTiledImage("image.background.FreeColTextArea", g, c, null);
    }
}