private boolean queueCargo(Cargo cargo, boolean requireMatch, LogBuilder lb) {
    final Unit carrier = getUnit();
    final List<Cargo> ts = tCopy();
    int candidate = -1;
    if (ts.isEmpty() || (// Carrier here?
    Map.isSameLocation(carrier.getLocation(), cargo.getCarrierTarget()) && cargo.canQueueAt(carrier, 0, ts))) {
        candidate = 0;
    }
    if (candidate < 0) {
        for (int i = 0; i < ts.size(); i++) {
            Cargo tr = ts.get(i);
            if (Map.isSameLocation(tr.getCarrierTarget(), cargo.getCarrierTarget())) {
                if (!cargo.canQueueAt(carrier, i, ts))
                    continue;
                candidate = i;
                break;
            }
        }
    }
    if (candidate < 0) {
        if (requireMatch)
            return false;
        candidate = ts.size();
    }
    return addCargo(cargo, candidate, lb);
}