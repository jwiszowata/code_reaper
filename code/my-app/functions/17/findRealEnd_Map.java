private Location findRealEnd(Unit unit, Location end) {
    while (true) {
        if (end == null) {
            throw new IllegalArgumentException("Null end.");
        } else if (end instanceof Europe) {
            return end;
        } else if (end instanceof Map) {
            end = unit.getEntryLocation();
        } else if (end.getTile() != null) {
            return end.getTile();
        } else if (unit != null) {
            return unit.resolveDestination();
        } else {
            throw new IllegalArgumentException("Invalid end: " + end);
        }
    }
}