public static BufferedImage createBufferedImage(Image image) {
    if (image == null)
        return null;
    BufferedImage result = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = result.createGraphics();
    g.drawImage(image, 0, 0, null);
    g.dispose();
    return result;
}