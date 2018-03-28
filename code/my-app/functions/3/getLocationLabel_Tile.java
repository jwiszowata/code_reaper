public StringTemplate getLocationLabel() {
    return (settlement != null) ? settlement.getLocationLabel() : getDetailedLocationLabel();
}