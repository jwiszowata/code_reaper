public static void drawTiledImage(String resource, Graphics g, JComponent c, Insets insets) {
    int width = c.getWidth();
    int height = c.getHeight();
    int xmin, ymin;
    if (insets == null) {
        xmin = 0;
        ymin = 0;
    } else {
        xmin = insets.left;
        ymin = insets.top;
        width -= insets.left + insets.right;
        height -= insets.top + insets.bottom;
    }
    if (ResourceManager.hasImageResource(resource)) {
        BufferedImage image = ResourceManager.getImage(resource);
        int dx = image.getWidth();
        int dy = image.getHeight();
        int xmax = xmin + width;
        int ymax = ymin + height;
        for (int x = xmin; x < xmax; x += dx) {
            for (int y = ymin; y < ymax; y += dy) {
                g.drawImage(image, x, y, null);
            }
        }
    } else {
        g.setColor(c.getBackground());
        g.fillRect(xmin, ymin, width, height);
    }
}