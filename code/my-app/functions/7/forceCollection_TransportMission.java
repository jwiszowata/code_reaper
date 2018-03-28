public boolean forceCollection(AIUnit aiu, LogBuilder lb) {
    for (Cargo c : tCopy()) {
        if (c.getMode().isCollection())
            removeCargo(c);
    }
    return queueTransportable(aiu, false, lb);
}