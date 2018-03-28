private void scaleMapTo(final int width, final int height) {
    final Game game = getGame();
    final Map oldMap = game.getMap();
    final int oldWidth = oldMap.getWidth();
    final int oldHeight = oldMap.getHeight();
    Map map = new Map(game, width, height);
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            final int oldX = (x * oldWidth) / width;
            final int oldY = (y * oldHeight) / height;
            Tile importTile = oldMap.getTile(oldX, oldY);
            Tile t = new Tile(game, importTile.getType(), x, y);
            if (importTile.getMoveToEurope() != null) {
                t.setMoveToEurope(importTile.getMoveToEurope());
            }
            if (t.getTileItemContainer() != null) {
                t.getTileItemContainer().copyFrom(importTile.getTileItemContainer(), Map.Layer.ALL);
            }
            map.setTile(t, x, y);
        }
    }
    game.setMap(map);
    getGUI().setSelectedTile(map.getTile(0, 0));
    getGUI().refresh();
}