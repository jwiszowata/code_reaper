public boolean hasNext() {
    while (!this.units.isEmpty()) {
        if (predicate.test(this.units.get(0))) {
            return true;
        }
        this.units.remove(0);
    }
    update();
    return !this.units.isEmpty();
}