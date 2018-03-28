public Location getTransportSource() {
    return (unit == null || unit.isDisposed()) ? null : unit.getLocation();
}