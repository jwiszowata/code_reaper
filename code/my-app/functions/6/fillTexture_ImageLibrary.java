public static void fillTexture(Graphics2D g2, BufferedImage img, int x, int y, int width, int height) {
    Rectangle anchor = new Rectangle(x, y, img.getWidth(), img.getHeight());
    TexturePaint paint = new TexturePaint(img, anchor);
    g2.setPaint(paint);
    g2.fillRect(x, y, width, height);
}