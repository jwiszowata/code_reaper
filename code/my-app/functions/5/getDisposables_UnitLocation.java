public Stream<FreeColGameObject> getDisposables() {
    synchronized (this.units) {
        return concat(flatten(this.units, Unit::getDisposables), super.getDisposables());
    }
}