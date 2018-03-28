public boolean isShore() {
    return any(getSurroundingTiles(1, 1), t -> t.isLand() != this.isLand());
}