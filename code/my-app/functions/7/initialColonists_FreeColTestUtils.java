public ColonyBuilder initialColonists(int colonists) {
    if (colonists <= 0) {
        throw new IllegalArgumentException("Number of colonists must be positive");
    }
    this.initialColonists = colonists;
    return this;
}