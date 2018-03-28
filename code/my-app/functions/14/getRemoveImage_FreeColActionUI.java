public static ImageIcon getRemoveImage() {
    BufferedImage bi = new BufferedImage(9, 9, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = bi.createGraphics();
    g.setColor(Color.BLACK);
    g.drawLine(1, 0, 8, 7);
    g.drawLine(0, 1, 7, 8);
    g.drawLine(7, 0, 0, 7);
    g.drawLine(9, 0, 0, 9);
    g.setColor(Color.RED);
    g.drawLine(0, 0, 8, 8);
    g.drawLine(8, 0, 0, 8);
    g.dispose();
    return new ImageIcon(bi);
}