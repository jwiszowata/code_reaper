public void moveToFront(Unit u) {
    synchronized (this.units) {
        if (this.units.remove(u))
            this.units.add(0, u);
    }
}