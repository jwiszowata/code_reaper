public boolean complete(ChangeSet cs) {
    boolean ret = super.complete(cs);
    if (this.nt.hasNotTraded()) {
        Unit unit = this.nt.getUnit();
        unit.setMovesLeft(this.movesLeft);
        cs.addPartial(See.only((ServerPlayer) unit.getOwner()), unit, "movesLeft", String.valueOf(unit.getMovesLeft()));
    }
    this.nt.setDone();
    return ret;
}