public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append(super.toString());
    sb.setLength(sb.length() - 1);
    sb.append(' ').append(size).append(' ').append(bounds).append(']');
    return sb.toString();
}