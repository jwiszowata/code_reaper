public void paintComponent(Graphics g) {
    if (isOpaque()) {
        super.paintComponent(g);
    } else {
        ImageLibrary.drawTiledImage("image.background.FreeColMenuBar", g, this, getInsets());
    }
}