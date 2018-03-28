public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getClass()).append("moves=").append(this.movesLeft).append(' ').append(this.nt).append(']');
    return sb.toString();
}