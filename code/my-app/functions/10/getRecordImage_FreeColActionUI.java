public static ImageIcon getRecordImage() {
    BufferedImage bi = new BufferedImage(9, 9, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = bi.createGraphics();
    g.setColor(Color.RED);
    g.fillOval(0, 0, 9, 9);
    g.setColor(Color.BLACK);
    g.drawOval(0, 0, 9, 9);
    g.dispose();
    return new ImageIcon(bi);
}