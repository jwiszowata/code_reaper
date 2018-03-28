protected void copyFrom(Feature other) {
    setId(other.getId());
    setSpecification(other.getSpecification());
    this.source = other.source;
    this.firstTurn = other.firstTurn;
    this.lastTurn = other.lastTurn;
    this.duration = other.duration;
    this.temporary = other.temporary;
    setScopes(other.getScopeList());
}