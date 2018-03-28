private String initialize(Location destination, boolean allowFallback) {
    return this.plan.initialize(this.transportable, this.carrier, destination, allowFallback);
}