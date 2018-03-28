public BufferedImage createMiniMapThumbNail() {
    MiniMap miniMap = new MiniMap(getFreeColClient());
    miniMap.setTileSize(MiniMap.MAX_TILE_SIZE);
    Game game = getGame();
    int width = game.getMap().getWidth() * MiniMap.MAX_TILE_SIZE + MiniMap.MAX_TILE_SIZE / 2;
    int height = game.getMap().getHeight() * MiniMap.MAX_TILE_SIZE / 4;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g1 = image.createGraphics();
    miniMap.paintMap(g1);
    g1.dispose();
    int scaledWidth = Math.min((int) ((64 * width) / (float) height), 128);
    BufferedImage scaledImage = new BufferedImage(scaledWidth, 64, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = scaledImage.createGraphics();
    g2.drawImage(image, 0, 0, scaledWidth, 64, null);
    g2.dispose();
    return scaledImage;
}