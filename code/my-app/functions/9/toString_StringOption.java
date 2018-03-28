public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(getId()).append(" value=").append(value).append(" choices=[");
    if (choices != null) {
        for (String choice : choices) sb.append(' ').append(choice);
    }
    sb.append("]]");
    return sb.toString();
}