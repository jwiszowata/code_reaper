public boolean atStop(TradeRouteStop stop) {
    return Map.isSameLocation(getLocation(), stop.getLocation());
}