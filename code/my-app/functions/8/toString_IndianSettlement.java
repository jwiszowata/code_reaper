public String toString() {
    StringBuilder sb = new StringBuilder(64);
    Tile tile = getTile();
    sb.append(getName());
    if (tile != null)
        sb.append(" at (").append(tile.getX()).append(',').append(tile.getY()).append(')');
    return sb.toString();
}