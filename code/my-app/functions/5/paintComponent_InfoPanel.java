public void paintComponent(Graphics graphics) {
    if (this.skin != null)
        graphics.drawImage(this.skin, 0, 0, null);
    super.paintComponent(graphics);
}