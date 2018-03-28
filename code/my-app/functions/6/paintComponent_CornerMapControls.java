public void paintComponent(Graphics graphics) {
    if (miniMapSkin != null) {
        graphics.drawImage(miniMapSkin, 0, 0, null);
    }
    super.paintComponent(graphics);
}