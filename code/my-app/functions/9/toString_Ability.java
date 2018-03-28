public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append("[ ").append(getId());
    if (getSource() != null) {
        sb.append(" (").append(getSource().getId()).append(')');
    }
    sb.append(" = ").append(value).append(" ]");
    return sb.toString();
}