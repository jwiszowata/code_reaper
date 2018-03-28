public void paintComponent(Graphics g) {
    if (points == null || points.length == 0) {
        return;
    }
    if (isOpaque()) {
        super.paintComponent(g);
    }
    g.setColor(Color.BLACK);
    ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
    for (int i = 0; i < counter - 1; i++) {
        Point p1 = points[i];
        Point p2 = points[i + 1];
        g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
    }
}