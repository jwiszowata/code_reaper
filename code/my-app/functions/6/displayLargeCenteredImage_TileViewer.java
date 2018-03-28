void displayLargeCenteredImage(Graphics2D g, BufferedImage image) {
    int y = tileHeight - image.getHeight();
    if (y > 0)
        y /= 2;
    g.drawImage(image, (tileWidth - image.getWidth()) / 2, y, null);
}