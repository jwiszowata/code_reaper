public String toString() {
    StringBuilder sb = new StringBuilder(16);
    sb.append('[').append(getId()).append(" value=").append((value == null) ? "null" : value.getName()).append(']');
    return sb.toString();
}