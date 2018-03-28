public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(getId()).append(' ').append(eventType).append(" (").append(turn.getYear()).append(')');
    if (playerId != null) {
        sb.append(" playerId=").append(playerId).append(" score=").append(score);
    }
    sb.append(' ').append(super.toString()).append(']');
    return sb.toString();
}