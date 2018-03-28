private void optimizeCargoes(LogBuilder lb) {
    lb.add(", optimize");
    Location oldTarget = getTarget();
    List<Cargo> ts = wrapCargoes();
    List<Cargo> best = null;
    if (1 < ts.size() && ts.size() <= DESTINATION_UPPER_BOUND) {
        final Location current = getUnit().getLocation();
        float bestValue = INFINITY;
        for (List<Cargo> tl : getPermutations(ts)) {
            float value = scoreCargoOrder(current, tl);
            if (value > 0.0f && bestValue > value) {
                bestValue = value;
                best = tl;
            }
        }
    }
    if (best != null) {
        tSet(unwrapCargoes(best), true);
        if (oldTarget != getTarget())
            lb.add("->", getTarget());
    } else {
        tSet(unwrapCargoes(ts), false);
    }
}