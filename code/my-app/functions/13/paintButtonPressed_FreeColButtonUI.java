protected void paintButtonPressed(Graphics g, AbstractButton c) {
    if (c.isContentAreaFilled()) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = c.getSize();
        Composite oldComposite = g2d.getComposite();
        Color oldColor = g2d.getColor();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, size.width, size.height);
        g2d.setComposite(oldComposite);
        g2d.setColor(oldColor);
    }
}