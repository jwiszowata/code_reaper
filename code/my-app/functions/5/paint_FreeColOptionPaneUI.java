public void paint(Graphics g, JComponent c) {
    if (c.isOpaque()) {
        ImageLibrary.drawTiledImage("image.background.FreeColOptionPane", g, c, null);
    }
}