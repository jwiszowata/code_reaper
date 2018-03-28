public BufferedImage getGrayscaleImage(Dimension d) {
    final BufferedImage cached = grayscaleImages.get(d);
    if (cached != null)
        return cached;
    final BufferedImage im = getImage(d);
    if (im == null)
        return null;
    int width = im.getWidth();
    int height = im.getHeight();
    BufferedImage srcImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = srcImage.createGraphics();
    g.drawImage(im, 0, 0, null);
    g.dispose();
    ColorConvertOp filter = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
    final BufferedImage grayscaleImage = filter.filter(srcImage, null);
    grayscaleImages.put(d, grayscaleImage);
    return grayscaleImage;
}