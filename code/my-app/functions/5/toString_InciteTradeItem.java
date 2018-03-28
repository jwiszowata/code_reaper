public String toString() {
    StringBuilder sb = new StringBuilder(16);
    sb.append('[').append(getId()).append(' ').append(this.victim.getId()).append(']');
    return sb.toString();
}