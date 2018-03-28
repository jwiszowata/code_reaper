public void paint(Graphics g, JComponent c) {
    Graphics2D g2d = (Graphics2D) g;
    Composite oldComposite = g2d.getComposite();
    Color oldColor = g2d.getColor();
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, c.getWidth(), c.getHeight());
    g2d.setComposite(oldComposite);
    g2d.setColor(oldColor);
}