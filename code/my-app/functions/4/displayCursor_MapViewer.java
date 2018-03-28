private void displayCursor(Graphics2D g) {
    BufferedImage cursorImage = lib.getMiscImage(ImageLibrary.UNIT_SELECT);
    g.drawImage(cursorImage, 0, 0, null);
}