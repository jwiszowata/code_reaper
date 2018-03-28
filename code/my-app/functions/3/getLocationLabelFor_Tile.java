public StringTemplate getLocationLabelFor(Player player) {
    return (settlement != null) ? settlement.getLocationLabelFor(player) : getDetailedLocationLabelFor(player);
}