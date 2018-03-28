public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('[').append(getId()).append(" <");
    for (Option o : getOptions()) {
        sb.append(' ').append(o.toString());
    }
    sb.append(" >]");
    return sb.toString();
}