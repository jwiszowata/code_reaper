public void paintComponent(Graphics g) {
    final Colony colony = getColony();
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());
    if (colony == null)
        return;
    getGUI().displayColonyTiles((Graphics2D) g, tiles, colony);
}