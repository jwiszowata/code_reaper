public String toString() {
    StringBuilder sb = new StringBuilder(16);
    sb.append(number).append(' ').append(getId()).append(" (").append(roleId).append(')');
    return sb.toString();
}