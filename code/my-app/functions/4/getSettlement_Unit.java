public Settlement getSettlement() {
    Location loc = getLocation();
    return (loc != null) ? loc.getSettlement() : null;
}