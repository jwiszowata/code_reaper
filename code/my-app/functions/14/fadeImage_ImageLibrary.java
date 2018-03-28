public static BufferedImage fadeImage(Image img, float fade, float target) {
    int w = img.getWidth(null);
    int h = img.getHeight(null);
    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = bi.createGraphics();
    g.drawImage(img, 0, 0, null);
    float offset = target * (1.0f - fade);
    float[] scales = { fade, fade, fade, 1.0f };
    float[] offsets = { offset, offset, offset, 0.0f };
    RescaleOp rop = new RescaleOp(scales, offsets, null);
    g.drawImage(bi, rop, 0, 0);
    g.dispose();
    return bi;
}