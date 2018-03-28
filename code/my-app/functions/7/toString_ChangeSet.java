public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Change c : this.changes) {
        sb.append(c).append('\n');
    }
    return sb.toString();
}