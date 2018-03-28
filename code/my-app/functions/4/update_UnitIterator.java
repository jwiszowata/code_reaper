private final void update() {
    this.units.clear();
    this.units.addAll(transform(owner.getUnits(), u -> predicate.test(u), Function.identity(), Unit.locComparator));
}