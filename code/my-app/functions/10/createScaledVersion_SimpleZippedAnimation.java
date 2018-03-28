private AnimationEvent createScaledVersion(float scale) {
    final int width = (int) (getWidth() * scale);
    final int height = (int) (getHeight() * scale);
    BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = scaled.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g.drawImage(this.image, 0, 0, width, height, null);
    g.dispose();
    return new ImageAnimationEventImpl(scaled, this.durationInMs);
}