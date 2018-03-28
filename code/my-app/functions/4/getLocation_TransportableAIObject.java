public Location getLocation() {
    Locatable l = getTransportLocatable();
    return (l == null) ? null : l.getLocation();
}