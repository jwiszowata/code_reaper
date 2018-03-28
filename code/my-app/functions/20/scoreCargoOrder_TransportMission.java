private float scoreCargoOrder(Location initialLocation, List<Cargo> order) {
    final Unit carrier = getUnit();
    final int maxHolds = carrier.getCargoCapacity();
    int holds = carrier.getCargoSpaceTaken();
    Location now = initialLocation;
    float totalHoldTurns = 0.0f;
    float totalTurns = 0.0f;
    float favourEarly = 1.0f;
    for (Cargo cargo : order) {
        int turns = carrier.getTurnsToReach(now, cargo.getCarrierTarget());
        totalTurns += turns;
        totalHoldTurns += holds * turns * favourEarly;
        holds += cargo.getNewSpace();
        if (holds < 0 || holds > maxHolds)
            return -1.0f;
        now = cargo.getCarrierTarget();
        favourEarly += 0.1f;
    }
    return totalTurns + 0.001f * totalHoldTurns;
}