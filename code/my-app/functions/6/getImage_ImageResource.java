public BufferedImage getImage(float scale) {
    final BufferedImage im = getImage();
    if (scale == 1.0f || im == null)
        return im;
    return getImage(new Dimension(Math.round(im.getWidth() * scale), Math.round(im.getHeight() * scale)));
}