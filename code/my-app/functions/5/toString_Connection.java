public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append("[Connection ").append(this.name).append(" (").append(getSocketName()).append(")]");
    return sb.toString();
}