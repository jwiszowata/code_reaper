public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(root.getSuffix()).append(':');
    for (AbstractGoods ag : leafs) {
        sb.append(' ').append(ag.toString());
    }
    sb.append(" ]");
    return sb.toString();
}