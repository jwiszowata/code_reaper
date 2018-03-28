public static BufferedImage createResizedImage(Image image, int width, int height) {
    BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = scaled.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g.drawImage(image, 0, 0, width, height, null);
    g.dispose();
    return scaled;
}