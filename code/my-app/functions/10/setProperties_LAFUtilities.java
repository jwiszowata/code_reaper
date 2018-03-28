public static void setProperties(Graphics g, JComponent c) {
    Graphics2D g2 = (Graphics2D) g;
    if (c.getFont().getSize() >= AA_TEXT_SIZE) {
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
    Object textAA = c.getClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING);
    if (textAA != null) {
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, textAA);
    }
}