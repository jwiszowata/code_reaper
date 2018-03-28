public PathNode findPath(Location start, Location end, Unit carrier, CostDecider costDecider) {
    return getGame().getMap().findPath(this, start, end, carrier, costDecider, null);
}