private int destinationCount() {
    Location now = null;
    int ret = 0;
    for (Cargo cargo : tCopy()) {
        if (!Map.isSameLocation(now, cargo.getCarrierTarget())) {
            ret++;
            now = cargo.getCarrierTarget();
        }
    }
    return ret;
}