public BufferedImage getGrayscaleImage(float scale) {
    final BufferedImage im = getImage();
    if (im == null)
        return null;
    return getGrayscaleImage(new Dimension(Math.round(im.getWidth() * scale), Math.round(im.getHeight() * scale)));
}