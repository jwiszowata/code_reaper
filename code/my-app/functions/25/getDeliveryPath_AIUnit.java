public PathNode getDeliveryPath(Unit carrier, Location dst) {
    if (dst == null) {
        dst = getTransportDestination();
        if (dst == null)
            return null;
    }
    dst = Location.upLoc(dst);
    PathNode path;
    if (unit.getLocation() == carrier) {
        path = unit.findPath(carrier.getLocation(), dst, carrier, null);
        if (path == null && dst.getTile() != null) {
            path = unit.findPathToNeighbour(carrier.getLocation(), dst.getTile(), carrier, null);
        }
    } else if (unit.getLocation() instanceof Unit) {
        return null;
    } else {
        path = unit.findPath(unit.getLocation(), dst, carrier, null);
        if (path == null && dst.getTile() != null) {
            path = unit.findPathToNeighbour(unit.getLocation(), dst.getTile(), carrier, null);
        }
    }
    if (path != null)
        path.ensureDisembark();
    return path;
}