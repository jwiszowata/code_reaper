private boolean atWar() {
    return this.is.getOwner().atWarWith(this.unit.getOwner());
}