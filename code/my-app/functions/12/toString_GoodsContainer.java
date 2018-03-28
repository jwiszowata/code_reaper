public String toString() {
    final String sep = ", ";
    StringBuilder sb = new StringBuilder(128);
    sb.append('[').append(getId()).append(" [");
    forEachMapEntry(storedGoods, e -> sb.append(e.getKey()).append('=').append(e.getValue()).append(sep));
    sb.setLength(sb.length() - sep.length());
    sb.append("][");
    forEachMapEntry(oldStoredGoods, e -> sb.append(e.getKey()).append('=').append(e.getValue()).append(sep));
    sb.setLength(sb.length() - sep.length());
    sb.append("]]");
    return sb.toString();
}