public boolean setNext(Unit unit) {
    if (this.predicate.test(unit)) {
        final Unit sentinel = first(this.units);
        while (!this.units.isEmpty()) {
            if (this.units.get(0) == unit)
                return true;
            this.units.remove(0);
        }
        update();
        while (!this.units.isEmpty() && this.units.get(0) != sentinel) {
            if (this.units.get(0) == unit)
                return true;
            this.units.remove(0);
        }
    }
    return false;
}