public Location getTransportDestination() {
    if (!isValid())
        return null;
    Location loc = (transportTarget != null) ? transportTarget : target;
    return (getUnit().shouldTakeTransportTo(loc)) ? loc : null;
}