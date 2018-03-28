void displayCenteredImage(Graphics2D g, BufferedImage image) {
    g.drawImage(image, (tileWidth - image.getWidth()) / 2, (tileHeight - image.getHeight()) / 2, null);
}