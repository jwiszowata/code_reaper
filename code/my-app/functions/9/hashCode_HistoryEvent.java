public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + this.turn.hashCode();
    hash = 31 * hash + this.eventType.ordinal();
    if (this.playerId != null)
        hash = 31 * hash + this.playerId.hashCode();
    hash = 31 * hash + this.score;
    return hash;
}