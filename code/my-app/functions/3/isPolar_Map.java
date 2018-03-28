public boolean isPolar(Tile tile) {
    return tile.getY() <= POLAR_HEIGHT || tile.getY() >= getHeight() - POLAR_HEIGHT - 1;
}