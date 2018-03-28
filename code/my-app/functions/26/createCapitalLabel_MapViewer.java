private static BufferedImage createCapitalLabel(int extent, int padding, Color backgroundColor) {
    double deg2rad = Math.PI / 180.0;
    double angle = -90.0 * deg2rad;
    double offset = extent * 0.5;
    double size1 = (extent - padding - padding) * 0.5;
    GeneralPath path = new GeneralPath();
    path.moveTo(Math.cos(angle) * size1 + offset, Math.sin(angle) * size1 + offset);
    for (int i = 0; i < 4; i++) {
        angle += 144 * deg2rad;
        path.lineTo(Math.cos(angle) * size1 + offset, Math.sin(angle) * size1 + offset);
    }
    path.closePath();
    BufferedImage bi = new BufferedImage(extent, extent, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = bi.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(backgroundColor);
    g.fill(new RoundRectangle2D.Float(0, 0, extent, extent, padding, padding));
    g.setColor(Color.BLACK);
    g.setStroke(new BasicStroke(2.4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g.draw(path);
    g.setColor(Color.WHITE);
    g.fill(path);
    g.dispose();
    return bi;
}