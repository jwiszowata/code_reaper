public Location getTransportDestination() {
    return (unit == null || unit.isDisposed() || !hasMission()) ? null : mission.getTransportDestination();
}