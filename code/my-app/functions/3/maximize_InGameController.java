public MoveMode maximize(MoveMode m) {
    return (this.ordinal() < m.ordinal()) ? m : this;
}