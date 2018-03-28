public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getType().getId());
    if (turnsToComplete > 0) {
        sb.append(" (").append(turnsToComplete).append(" turns left)");
    }
    if (style != null)
        sb.append(' ').append(style.getString());
    sb.append(']');
    return sb.toString();
}