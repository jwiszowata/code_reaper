public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(getId());
    if (value != null) {
        sb.append(" [");
        for (AbstractOption<T> ao : value) {
            sb.append(' ').append(ao);
        }
        sb.append(" ]");
    }
    sb.append(']');
    return sb.toString();
}