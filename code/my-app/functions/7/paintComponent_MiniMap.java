public void paintComponent(Graphics graphics) {
    if (freeColClient.getGame() == null || freeColClient.getGame().getMap() == null) {
        return;
    }
    graphics.drawImage(ResourceManager.getImage("image.background.MiniMap"), 0, 0, null);
    paintMap(graphics);
}