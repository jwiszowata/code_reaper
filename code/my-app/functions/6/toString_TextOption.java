public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(getId()).append(" value=").append(value);
    sb.append(']');
    return sb.toString();
}