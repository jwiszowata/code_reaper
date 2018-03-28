public List<Unit> getUnitList() {
    synchronized (this.units) {
        return (this.units.isEmpty()) ? Collections.<Unit>emptyList() : new ArrayList<>(this.units);
    }
}