public void paint(Graphics g, JComponent c) {
    ImageLibrary.drawTiledImage("image.background.FreeColList", g, c, null);
    LAFUtilities.setProperties(g, c);
    super.paint(g, c);
}