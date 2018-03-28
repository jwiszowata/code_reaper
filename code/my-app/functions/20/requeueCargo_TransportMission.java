public boolean requeueCargo(Cargo cargo, LogBuilder lb) {
    final TransportableAIObject t = cargo.getTransportable();
    boolean ret = false;
    assert tFind(t) == cargo;
    String reason = cargo.update();
    if (reason != null) {
        lb.add(" requeue/update fail(", reason, ") ", cargo.toShortString());
        dumpCargo(cargo, lb);
    } else if (!tRemove(cargo)) {
        lb.add(" requeue/remove fail ", cargo.toShortString());
    } else if (!queueCargo(cargo, false, lb)) {
        lb.add(" requeue/queue fail ", cargo.toShortString());
        dropTransportable(t);
    } else {
        lb.add(" requeued(", cargo.getTransportTarget(), ") ", cargo.toShortString());
        takeTransportable(t);
        ret = true;
    }
    return ret;
}