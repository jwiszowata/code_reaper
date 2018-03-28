private static BufferedImage createLabel(Graphics2D g, String text, Font font, Color backgroundColor) {
    TextSpecification[] specs = new TextSpecification[1];
    specs[0] = new TextSpecification(text, font);
    return createLabel(g, specs, backgroundColor);
}