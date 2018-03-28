public String toString() {
    StringBuilder sb = new StringBuilder(16);
    sb.append('[').append(getId()).append(' ').append(stance).append(']');
    return sb.toString();
}