public final Player getOther(Player player) {
    return (player == this.source) ? this.destination : this.source;
}