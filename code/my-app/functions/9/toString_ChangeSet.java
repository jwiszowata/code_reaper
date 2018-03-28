public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append('[').append(getClass().getName()).append(' ').append(see);
    for (ServerPlayer sp : this.serverPlayers) {
        sb.append(' ').append(sp.getId());
    }
    sb.append(']');
    return sb.toString();
}