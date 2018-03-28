private BufferedImage createChip(Graphics2D g, String text, Color border, Color background, Color foreground) {
    return createChip(g, text, border, background, 0, Color.black, foreground, true);
}