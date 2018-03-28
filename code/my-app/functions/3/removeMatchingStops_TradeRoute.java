public boolean removeMatchingStops(Location loc) {
    return removeInPlace(stops, trs -> Map.isSameLocation(trs.getLocation(), loc));
}