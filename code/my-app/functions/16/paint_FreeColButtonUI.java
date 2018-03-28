public void paint(Graphics g, JComponent c) {
    LAFUtilities.setProperties(g, c);
    if (c.isOpaque()) {
        ImageLibrary.drawTiledImage("image.background.FreeColButton", g, c, null);
    }
    super.paint(g, c);
    AbstractButton a = (AbstractButton) c;
    if (a.isRolloverEnabled()) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, c);
        boolean rollover = c.contains(p);
        if (rollover) {
            paintButtonPressed(g, (AbstractButton) c);
        }
    }
}