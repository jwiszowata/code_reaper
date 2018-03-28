public boolean isAtLocation(Location loc) {
    Location ourLoc = getLocation(), otherLoc = (loc instanceof Unit) ? ((Unit) loc).getLocation() : loc;
    if (ourLoc instanceof Unit)
        ourLoc = ((Unit) ourLoc).getLocation();
    return Map.isSameLocation(ourLoc, otherLoc);
}