public void update(Tile tile) {
    if (this.tileInfoPanel.getTile() != tile) {
        this.tileInfoPanel.update(tile);
    }
    update();
}