public String toShortString() {
    StringBuilder sb = new StringBuilder(16);
    TileType type = getType();
    sb.append(getX()).append(',').append(getY()).append('-').append((type == null) ? "?" : type.getSuffix());
    return sb.toString();
}