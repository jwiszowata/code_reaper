public Unit next() {
    return (hasNext()) ? this.units.remove(0) : null;
}