private void displayTileImprovement(Graphics2D g, Tile tile, TileImprovement ti) {
    if (ti.isComplete()) {
        if (ti.isRoad()) {
            rp.displayRoad(g, tile);
        } else if (ti.isRiver()) {
            TileImprovementStyle style = ti.getStyle();
            g.drawImage(lib.getRiverImage(style), 0, 0, null);
        } else {
            String key = "image.tile." + ti.getType().getId();
            if (ResourceManager.hasImageResource(key)) {
                BufferedImage overlay = ResourceManager.getImage(key, lib.tileSize);
                g.drawImage(overlay, 0, 0, null);
            }
        }
    }
}