public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(getClass().getName()).append(' ').append(see).append(' ').append(message).append(']');
    return sb.toString();
}