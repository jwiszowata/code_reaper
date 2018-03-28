private static BufferedImage createLabel(Graphics2D g, TextSpecification[] textSpecs, Color backgroundColor) {
    int hPadding = 15;
    int vPadding = 10;
    int linePadding = 5;
    int width = 0;
    int height = vPadding;
    int i;
    TextSpecification spec;
    TextLayout[] labels = new TextLayout[textSpecs.length];
    TextLayout label;
    for (i = 0; i < textSpecs.length; i++) {
        spec = textSpecs[i];
        label = new TextLayout(spec.text, spec.font, g.getFontRenderContext());
        labels[i] = label;
        Rectangle textRectangle = label.getPixelBounds(null, 0, 0);
        width = Math.max(width, textRectangle.width + hPadding);
        if (i > 0)
            height += linePadding;
        height += (int) (label.getAscent() + label.getDescent());
    }
    int radius = Math.min(hPadding, vPadding);
    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = bi.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    g2.setColor(backgroundColor);
    g2.fill(new RoundRectangle2D.Float(0, 0, width, height, radius, radius));
    g2.setColor(ImageLibrary.getForegroundColor(backgroundColor));
    float y = vPadding / 2.0f;
    for (i = 0; i < labels.length; i++) {
        Rectangle textRectangle = labels[i].getPixelBounds(null, 0, 0);
        float x = (width - textRectangle.width) / 2.0f;
        y += labels[i].getAscent();
        labels[i].draw(g2, x, y);
        y += labels[i].getDescent() + linePadding;
    }
    g2.dispose();
    return bi;
}