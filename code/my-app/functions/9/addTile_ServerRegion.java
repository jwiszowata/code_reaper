public void addTile(Tile tile) {
    tile.setRegion(this);
    size++;
    if (bounds.x == 0 && bounds.width == 0 || bounds.y == 0 && bounds.height == 0) {
        bounds.setBounds(tile.getX(), tile.getY(), 0, 0);
    } else {
        bounds.add(tile.getX(), tile.getY());
    }
}