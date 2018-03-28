public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append("[ServerPlayer ").append(getId()).append(' ').append(getName()).append(']');
    return sb.toString();
}