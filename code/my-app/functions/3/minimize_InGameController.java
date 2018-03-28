public MoveMode minimize(MoveMode m) {
    return (this.ordinal() > m.ordinal()) ? m : this;
}