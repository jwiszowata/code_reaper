public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(getId()).append(" when=").append(when).append(" price=").append(price).append(']');
    return sb.toString();
}