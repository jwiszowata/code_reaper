public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(getId()).append(" probability=").append(probability).append('%');
    for (Scope scope : getScopeList()) sb.append(' ').append(scope);
    sb.append(']');
    return sb.toString();
}