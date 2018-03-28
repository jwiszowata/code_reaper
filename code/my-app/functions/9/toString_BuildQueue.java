public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append("[BuildQueue (").append(this.colony.getName()).append(')');
    for (BuildableType item : this.queue) {
        sb.append(' ').append(item.getId());
    }
    sb.append(']');
    return sb.toString();
}