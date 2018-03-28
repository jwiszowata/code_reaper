public static BufferedImage createMirroredImage(Image image) {
    if (image == null)
        return null;
    final int width = image.getWidth(null);
    final int height = image.getHeight(null);
    BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = result.createGraphics();
    g.drawImage(image, width, 0, -width, height, null);
    g.dispose();
    return result;
}