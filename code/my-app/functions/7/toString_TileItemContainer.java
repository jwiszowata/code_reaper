public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getId());
    for (TileItem item : getTileItems()) sb.append(' ').append(item);
    sb.append(']');
    return sb.toString();
}